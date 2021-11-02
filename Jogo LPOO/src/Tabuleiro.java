
public class Tabuleiro {
	
	private int larguraDasCasas;
	private int alturaDasCasas;
	private int numeroDeBombas;
	private	int bombasProximas;
	//Utilizar o tempo em segundos
	private int timer;
	
	public void setLargura(int largura) {
		
		this.larguraDasCasas = largura;
		
	}
	
	public void setAltura(int altura) {
		
		this.alturaDasCasas = altura;
		
	}
	
	public void setNumeroDeBombas(int numeroDeBombas) {
		
		this.numeroDeBombas = numeroDeBombas;
		
	}
	
	public int getNumeroDeBombasProximas() {
		int proximas = 0;
		
		return proximas;
		
	}
	
	public void setTempoMaximo(int segundosTotais) {
		
		this.timer = segundosTotais;
		
	}
	
	public int getTempoSobrando() {
		
		return this.timer;
		
	}
	
}