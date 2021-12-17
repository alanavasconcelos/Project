package mecanismosDoJogo;

import interfaceGrafica.*;
import usuario.*;
import java.io.Serializable;

public class Jogo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dificuldade, linha, coluna;
	private double maluquice;
	private boolean ehMaluco;
	private int tempo = 0;
	public long tempoInicial;
	private Tabuleiro tabuleiro;
	private TelaTabuleiro telaTabuleiro;
	private InteracaoUsuario usuario;
	private String nome;
	private Ranking ranking = new Ranking();
	private Pessoa jogadorAtual;

	public Jogo(boolean vazio) throws AtributoInvalidoException {

		this.ranking = Serializacao.carregaRanking();
		this.usuario = new InteracaoUsuario();

		if (!vazio) {

			this.usuario.setNomeDoJogador();
			this.nome = this.usuario.getNomeDoJogador();
			this.usuario.setJogoInterfaceGrafica();

			if (!this.usuario.getJogoInterfaceGrafica()) {

				this.usuario.setDificuldade();
				this.dificuldade = usuario.getDificuldade();
				this.usuario.setTipoDoJogo();
				this.ehMaluco = usuario.getTipoDoJogo();

				if (this.ehMaluco) {

					this.maluquice = usuario.getMaluquice();

				} else {

					this.maluquice = 0;

				}

			}

			this.construirJogo();

		}

	}

	private void construirJogo() {

		int coluna = 0;
		int linha = 0;
		int bombas = 0;

		if (this.usuario.getJogoInterfaceGrafica()) {

			this.tabuleiro = new Tabuleiro(Constante.getAlturaDasCasas(), Constante.getLarguraDasCasas(),
					Constante.getNumeroDeMinas(), 0);
			this.telaTabuleiro = new TelaTabuleiro(this.tabuleiro);
			this.telaTabuleiro.retirarAviso();

		} else {

			if (this.dificuldade == 1) {

				coluna = 9;
				linha = 9;
				bombas = 10;

			} else if (this.dificuldade == 2) {

				coluna = 16;
				linha = 16;
				bombas = 40;

			} else if (this.dificuldade == 3) {

				coluna = 30;
				linha = 16;
				bombas = 100;

			}

			this.tabuleiro = new Tabuleiro(linha, coluna, bombas, this.maluquice);
		}

	}

	private int checarMovimento() {

		if (this.tabuleiro.clicar(this.linha, this.coluna) == -1) {

			return -1;

		}

		if (!this.tabuleiro.venceu()) {

			return 0;

		} else {

			return 1;

		}

	}

	private void proximoMovimento() throws AtributoInvalidoException {

		this.coluna = this.usuario.setColuna(this.dificuldade);
		this.linha = this.usuario.setLinha(this.dificuldade);

	}

	public boolean iniciarJogo(boolean jogoCarregado) throws AtributoInvalidoException {

		boolean jogando = true;
		int vaiMarcar = 0;
		int venceu = 0;

		this.tempoInicial = System.currentTimeMillis();

		if (jogoCarregado) {

			this.usuario = new InteracaoUsuario();

		}

		do {

			this.usuario.imprimeEnter(3);
			this.usuario.imprimeTabuleiroAtual(this.tabuleiro);
			vaiMarcar = this.usuario.vaiMarcar(tabuleiro.getNumeroDeBandeiras());

			// if(vaiMarcar) está separado porque o método this.proximoMovimento() estava
			// necessitando de 2 jogadas para registrar quando colocado após a comparação,
			// como apenas o número 3 não espera um proximo movimento ele foi o único
			// colocado antes

			if (vaiMarcar == 3) {

				finalizaContador(this.tempoInicial);
				return true;

			}

			this.proximoMovimento();

			if (vaiMarcar == 1) {

				venceu = this.checarMovimento();

			} else if (vaiMarcar == 2) {

				this.tabuleiro.colocaBandeira(this.linha, this.coluna);

			} else {

				System.exit(0);

			}

			if (venceu == -1) {

				this.usuario.imprimeEnter(3);
				this.tabuleiro.exibeMinas();
				this.usuario.imprimeTabuleiroAtual(this.tabuleiro);
				this.usuario.imprimeMensagem("Você perdeu");
				jogando = false;

			} else if (venceu == 1) {

				this.usuario.imprimeEnter(3);
				this.usuario.imprimeTabuleiroAtual(this.tabuleiro);
				this.usuario.imprimeMensagem("Você venceu");

				finalizaContador(this.tempoInicial);
				jogadorAtual = new Pessoa(this.nome, this.tempo);
				atualizaRanking(this.jogadorAtual);

				jogando = false;

			}

		} while (jogando);

		if (this.usuario.verRanking()) {

			mostraRanking();

		}

		return false;

	}

	public void finalizaContador(long tempo) {

		long tempoTotal = System.currentTimeMillis() - tempo;
		tempoTotal /= 1000;

		this.setTempo((int) tempoTotal);

	}

	public void atualizaRanking(Pessoa jogador) {

		this.ranking.adicionaPessoa(jogador);
		this.ranking.organizaFila();
		Serializacao.salvaRanking(this.ranking);

	}

	public void mostraRanking() {

		this.usuario.imprimeRanking(this.ranking);

	}

	public void setTempo(int tempo) {

		this.tempo += tempo;

	}

	public Ranking getRanking() {

		return this.ranking;

	}

	public String getNome() {

		return this.nome;

	}

}
