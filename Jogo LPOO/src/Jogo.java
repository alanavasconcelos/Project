
public class Jogo {
	
	private int dificuldade;
	private int numeroDeBandeirasTotais;
	private int numeroDeBandeirasAtivas;
	private String nomeDoJogador;
	private boolean perdeuJogo;
	
	public int getDificuldade() {
		
		return this.dificuldade;
		
	}

	public void setNumeroDeBandeirasTotais(int numeroDeBandeirasTotais) {
		
		this.numeroDeBandeirasTotais = numeroDeBandeirasTotais;
		
	}
	
	public int getNumeroDeBandeirasSobrando() {
		
		return this.numeroDeBandeirasTotais - this.numeroDeBandeirasAtivas;
		
	}
	
	public void setNomeDoJogador(String nomeDoJogador) {
		
		this.nomeDoJogador = nomeDoJogador;
		
	}
	
	public String getNomeDoJogador() {
		
		return this.nomeDoJogador;
		
	}
	
}