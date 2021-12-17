package usuario;

import java.util.Scanner;

import mecanismosDoJogo.AtributoInvalidoException;
import mecanismosDoJogo.Tabuleiro;
import java.io.Serializable;

public class InteracaoUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Scanner entrada;
	private String nomeDoJogador;
	private int dificuldade, iniciarNovoJogo;
	private double maluquice;
	private boolean ehMaluco, jogoInterfaceGrafica;

	public InteracaoUsuario() {

		InteracaoUsuario.entrada = new Scanner(System.in);

	}

	public int vaiMarcar(int numeroDeBandeirasAtuais) throws AtributoInvalidoException {

		int escolha = 0;

		System.out.println("Escolha sua jogada:\n1- Abrir célula     2- Colocar ou retirar bandeira("
				+ numeroDeBandeirasAtuais + " bandeiras disponíveis)     3- Salvar e encerrar jogo atual");

		try {

			escolha = entrada.nextInt();

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis\n\n");

		}

		if (escolha < 0 || escolha > 3) {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		} else {

			return escolha;

		}

	}

	public void imprimeMensagem(String mensagem) {

		System.out.println(mensagem);

	}

	public void imprimeEnter(int enter) {

		for (int i = 0; i < enter; i++) {

			System.out.println("");

		}

	}

	public void imprimeTabuleiroAtual(Tabuleiro tabuleiroAtual) {

		tabuleiroAtual.getNumeroDeBandeiras();
		System.out.println(tabuleiroAtual);

	}

	public void imprimeRanking(Ranking ranking) {

		System.out.print(ranking);

	}

	public void setIniciarNovoJogo() throws AtributoInvalidoException {

		int escolha = 0;

		System.out.println("Deseja iniciar um novo jogo ou continuar um já em andamento?\n1- Iniciar novo jogo     "
				+ "2- Continuar jogo em andamento     3- Abrir o ranking de tempos");

		try {

			escolha = InteracaoUsuario.entrada.nextInt();

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis\n\n");

		}

		if (escolha > 0 && escolha < 4) {

			this.iniciarNovoJogo = escolha;

		} else {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

	}

	public void setNomeDoJogador() throws AtributoInvalidoException {

		String nomeDoJogador = "a";

		System.out.println("Digite seu nome: ");
		this.nomeDoJogador = InteracaoUsuario.entrada.nextLine();
		nomeDoJogador = this.nomeDoJogador.trim();

		if (nomeDoJogador.isEmpty()) {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira um nome ou apelido");
			throw e;

		}

	}

	public void setJogoInterfaceGrafica() throws AtributoInvalidoException {

		int escolha = 0;

		System.out.println("Deseja jogar no console ou na interface gráfica? \n1- Console     2- Interface Gráfica");

		try {

			escolha = InteracaoUsuario.entrada.nextInt();

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis\n\n");

		}

		if (escolha == 1) {

			this.jogoInterfaceGrafica = false;

		} else if (escolha == 2) {

			this.jogoInterfaceGrafica = true;

		} else {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

	}

	public void setDificuldade() throws AtributoInvalidoException {

		System.out.println("Escolha a dificuldade: \n1- Fácil     2- Médio     3- Difícil");

		try {

			this.dificuldade = entrada.nextInt();

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis\n\n");

		}

		if (this.dificuldade <= 0 || this.dificuldade > 3) {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

	}

	public void setTipoDoJogo() throws AtributoInvalidoException {

		int tipoDoJogo = 0;

		System.out.println("Escolha o tipo de jogo: \n1- Campo Minado Normal     2- Campo Minado Maluco");

		try {

			tipoDoJogo = entrada.nextInt();

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis");

		}

		if (tipoDoJogo == 1) {

			this.ehMaluco = false;

		} else if (tipoDoJogo == 2) {

			this.ehMaluco = true;

			setMaluquice();

		} else {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

	}

	public void setMaluquice() throws AtributoInvalidoException {

		int maluquiceUsuario = 0;

		System.out.println(
				"Escolha o nivel de maluquice do jogo:\n1- 10%     2- 20%     3- 40%     4- 50%     5- 60%     6- 80%     7- 100%");

		try {

			maluquiceUsuario = entrada.nextInt();

		} catch (Exception e) {

			System.err.println("");

		}

		switch (maluquiceUsuario) {

		case 1:

			this.maluquice = 0.1;
			break;

		case 2:

			this.maluquice = 0.2;
			break;

		case 3:

			this.maluquice = 0.4;
			break;

		case 4:

			this.maluquice = 0.5;
			break;

		case 5:

			this.maluquice = 0.6;
			break;

		case 6:

			this.maluquice = 0.8;
			break;

		case 7:

			this.maluquice = 1;
			break;

		default:

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

	}

	public int setLinha(int dificuldade) throws AtributoInvalidoException {

		int linhaMax;
		int linha = 0;

		if (dificuldade == 1) {

			linhaMax = 9;

		} else if (dificuldade == 2) {

			linhaMax = 16;

		} else {

			linhaMax = 16;

		}

		System.out.println("Escolha a linha (1 - " + linhaMax + ")");

		try {

			linha = InteracaoUsuario.entrada.nextInt() - 1;

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis");

		}

		if (linha > linhaMax || linha < 0) {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

		return linha;

	}

	public int setColuna(int dificuldade) throws AtributoInvalidoException {

		int colunaMax;
		int coluna = 0;

		if (dificuldade == 1) {

			colunaMax = 9;

		} else if (dificuldade == 2) {

			colunaMax = 16;

		} else {

			colunaMax = 30;

		}

		System.out.println("Escolha a coluna (1 - " + colunaMax + ")");

		try {

			coluna = InteracaoUsuario.entrada.nextInt() - 1;

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis");

		}

		if (coluna > colunaMax || coluna < 0) {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

		return coluna;

	}

	public boolean verRanking() throws AtributoInvalidoException {

		int escolha = 0;

		System.out.println("Deseja ver o ranking\n1- Sim     2- Não?");

		try {

			escolha = entrada.nextInt();

		} catch (Exception e) {

			System.err.println("Digite um inteiro entre os disponíveis\n\n");

		}

		if (escolha <= 0 || escolha > 2) {

			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;

		}

		if (escolha == 1) {

			return true;

		} else {

			return false;

		}

	}

	public int getIniciarNovoJogo() {

		return this.iniciarNovoJogo;

	}

	public String getNomeDoJogador() {

		return this.nomeDoJogador;

	}

	public boolean getJogoInterfaceGrafica() {

		return this.jogoInterfaceGrafica;

	}

	public int getDificuldade() {

		return this.dificuldade;

	}

	public boolean getTipoDoJogo() {

		return this.ehMaluco;

	}

	public double getMaluquice() {

		return this.maluquice;

	}

}
