package mecanismosDoJogo;

import java.io.Serializable;

public abstract class CelulaAbstrata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean temMina;
	private boolean clicada;
	private boolean temBandeira;
	private boolean ehMaluca;

	public CelulaAbstrata() {

		this.temMina = false;
		this.clicada = false;
		this.temBandeira = false;
		this.ehMaluca = false;

	}

	// Métodos relacionados as vizinhas precisam ser passados para a subclasse
	public abstract int numMinasNasVizinhas();

	public abstract int clicar();

	public abstract void limparVizinhas();

	public abstract int clicarAlternativo();

	public boolean colorcarMina() {

		if (!this.getTemMina()) {

			this.setTemMina(true);
			return true;

		} else {

			return false;

		}

	}

	// Método para colocar e retirar bandeiras
	public int marcar() {

		if (!this.getClicada()) {

			boolean temBandeira = this.getTemBandeira();

			if (temBandeira == true) {

				this.setTemBandeira(!temBandeira);
				return 1;

			} else {

				this.setTemBandeira(!temBandeira);
				return -1;

			}

		}

		return 0;

	};

	public void reset() {

		this.setTemMina(false);
		this.temBandeira = false;
		this.setClicada(false);

	}

	public boolean finalizado() {

		if (this.getTemMina() && this.getTemBandeira() || this.getTemMina() && !this.getClicada()) {

			return true;

		}

		if (!this.getTemMina() && !this.getTemBandeira() && this.getClicada()) {

			return true;

		}

		return false;

	}

	public void setClicada(boolean clicada) {

		this.clicada = clicada;

	}

	public boolean getClicada() {

		return clicada;

	}

	public void setTemMina(boolean temMina) {

		this.temMina = temMina;

	}

	public boolean getTemMina() {

		return temMina;

	}

	public void setTemBandeira(boolean temBandeira) {

		this.temBandeira = temBandeira;

	}

	public boolean getTemBandeira() {

		return this.temBandeira;

	}

	public void setEhMaluca(boolean ehMaluca) {

		this.ehMaluca = ehMaluca;

	}

	public boolean getEhMaluca() {

		return this.ehMaluca;

	}

	public String toString() {

		if (this.temBandeira) {

			return "T";

		}

		if (this.clicada) {

			if (this.temMina) {

				return "B";

			} else {

				return "" + this.numMinasNasVizinhas();

			}

		} else {

			return "C";

		}

	}

}
