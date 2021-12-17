package principalMain;

import mecanismosDoJogo.Jogo;
import mecanismosDoJogo.AtributoInvalidoException;
import usuario.*;

public class Principal {

	public static void main(String[] args) throws AtributoInvalidoException {

		InteracaoUsuario usuario = new InteracaoUsuario();
		Jogo jogoAtual = new Jogo(true);
		int escolha;
		long tempo;
		boolean salvarJogo = false;

		usuario.setIniciarNovoJogo();
		escolha = usuario.getIniciarNovoJogo();

		if (escolha == 1) {

			jogoAtual = new Jogo(false);
			salvarJogo = jogoAtual.iniciarJogo(false);

		} else if (escolha == 2) {

			jogoAtual = Serializacao.carregaJogo();
			salvarJogo = jogoAtual.iniciarJogo(true);

		} else {

			jogoAtual = new Jogo(true);
			jogoAtual.mostraRanking();

		}

		if (salvarJogo) {

			tempo = System.currentTimeMillis() / 1000;
			jogoAtual.setTempo((int) tempo);

			Serializacao.salvaJogo(jogoAtual);
			usuario.imprimeMensagem("Jogo salvo com sucesso");

		}
		
	}

}