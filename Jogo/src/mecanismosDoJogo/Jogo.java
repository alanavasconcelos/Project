package mecanismosDoJogo;

public class Jogo {
	
	private boolean ganhou = false;
	private int[] jogada;
	private int rodada = 0;
	private Tabuleiro board;
	private int numeroDeBandeirasTotais;
	private int numeroDeBandeirasAtivas;
	private int dificuldade;
	
	public Jogo(){
		
	}
	
	public void jogar(Tabuleiro board){
		
	}
	
	public void setNumeroDeBandeirasTotais(int numeroDeBandeirasTotais) {

		this.numeroDeBandeirasTotais = numeroDeBandeirasTotais;

	}

	public int getNumeroDeBandeirasSobrando() {

		return this.numeroDeBandeirasTotais - this.numeroDeBandeirasAtivas;

	}

	public int getDificuldade() {

		return this.dificuldade;

	}

}
