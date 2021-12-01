package mecanismosDoJogo;

public abstract class Jogo {
	
	private String nomeDoJogador;
	private int dificuldade;
	private int tipoDoJogo;
	
	public Jogo(String nomeDoJogador, int dificuldade,int tipoDoJogo) {
		this.nomeDoJogador = nomeDoJogador;
		this.dificuldade = dificuldade;
		this.tipoDoJogo = tipoDoJogo;
	}

	public void setNome(String nomeDoJogador) {
		this.nomeDoJogador = nomeDoJogador;
	}
	
	public String getNome() {
		return this.nomeDoJogador;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	public int getDificuldade(int dificuldade) {
		return dificuldade;
	}
	public  void settipoDoJogo(int tipoDoJogo) {
		this.tipoDoJogo = tipoDoJogo;
	}
	public int gettipoDoJogo(int tipoDoJogo) {
		return tipoDoJogo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	










	//Utilizar o tempo em segundos
	private int timer;
	

	public void setTempoMaximo(int segundosTotais) {

		this.timer = segundosTotais;

	}

	public int getTempoSobrando() {

		return this.timer;

   }

}
