package principalMain;

import mecanismosDoJogo.Jogo;
import mecanismosDoJogo.AtributoInvalidoException;
import usuario.*;

public class Principal {

	public static void main(String[] args) throws AtributoInvalidoException {

		InteracaoUsuario usuario = new InteracaoUsuario();
		Jogo jogoAtual = new Jogo(true);
		int escolha;
		boolean salvarJogo;
		long startTime;

		startTime = System.currentTimeMillis();

		usuario.setIniciarNovoJogo();
		escolha = usuario.getIniciarNovoJogo();

		if (escolha == 1) {

			jogoAtual = new Jogo(false);
			salvarJogo = jogoAtual.iniciarJogo(false);

			if (salvarJogo) {

				jogoAtual.finalizaContador(startTime);

				Serializacao.salvaJogo(jogoAtual);
				usuario.imprimeMensagem("Jogo salvo com sucesso");

			}

		} else if (escolha == 2) {

			jogoAtual = Serializacao.carregaJogo();
			jogoAtual.iniciarJogo(true);

		} else {

		}

		jogoAtual.finalizaContador(startTime);

	}

}