package principalMain;

import interfaceGrafica.TelaTabuleiro;
import mecanismosDoJogo.Tabuleiro;

public class Principal {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.adicionarMinas();
		TelaTabuleiro f = new TelaTabuleiro(tabuleiro);
		
	}
	
}