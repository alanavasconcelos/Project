package principalMain;

import mecanismosDoJogo.*;
import interfaceGrafica.*;

public class Principal {
	
	public static void main(String[] args) throws AtributoInvalidoException {
		
		Jogo jogoAtual = new Jogo();
		
		jogoAtual.iniciarJogo();
		
	}

}