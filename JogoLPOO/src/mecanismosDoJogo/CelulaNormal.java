package mecanismosDoJogo;

import java.util.ArrayList;
import interfaceGrafica.ButtonCelula;
import java.io.Serializable;

public class CelulaNormal extends CelulaAbstrata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<CelulaNormal> vizinhas;
	private ButtonCelula button;

	public CelulaNormal() {

		super();

		this.vizinhas = new ArrayList<CelulaNormal>();

	}

	public void adicionarVizinhas(CelulaNormal c) {

		this.vizinhas.add(c);

	}

	public int numMinasNasVizinhas() {

		int n = 0;

		for (CelulaNormal vizinha : this.vizinhas) {

			if (vizinha.getTemMina()) {

				n++;

			}

		}

		return n;
	}

	// Necessário para atualizar as células já abertas no tabuleiro maluco
	public void limparVizinhas() {

		this.vizinhas.clear();

	}

	public int clicar() {

		// Preferi não colocar exeção para clicar em uma já clicada, já que com a
		// utilização do console fica dificil a
		// visualização do tabuleiro, e com a grande possibilidade de ocorrer
		// acidetalmente, preferi não
		// encerrar o jogo com a mensagem de erro.

		// Checagem para abrir as vizinhas da celúla com nenhuma bomba ao redor

		CelulaNormal celulaAtual;
		boolean temBandeira = super.getTemBandeira();
		boolean clicada = super.getClicada();

		if (!temBandeira && !clicada) {

			this.setClicada(true);

			if (this.getTemMina()) {

				return -1;

			} else if (this.numMinasNasVizinhas() == 0) {

				for (int i = 0; i < this.vizinhas.size(); i++) {

					celulaAtual = this.vizinhas.get(i);

					if (this.getTemMina() == false) {

						celulaAtual.clicar();

					}
				}

			} else {

				return this.numMinasNasVizinhas();

			}

		} else {

			return 0;

		}

		return 0;

	}

	// Método de clicar utilizado pelo jogo rodando na interface gráfica
	public int clicarAlternativo() {

		this.setClicada(true);

		if (this.getTemMina()) {

			return -1;

		} else {

			return numMinasNasVizinhas();

		}

	}

	public void setVizinhas(ArrayList<CelulaNormal> vizinhas) {

		this.vizinhas = vizinhas;

	}

	public void setButton(ButtonCelula button) {

		this.button = button;

	}

	public ButtonCelula getButton() {

		return button;

	}

	public ArrayList<CelulaNormal> getVizinhas() {

		return this.vizinhas;

	}

}