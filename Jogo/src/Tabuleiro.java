
import java.util.Scanner;
import java.util.Random;

public class Tabuleiro {
	
	private int minas[][];
	private char tabuleiro[][];
	
	Random random = new Random();
	Scanner entrada = new Scanner(System.in);
	
	private int larguraDasCasas;
	private int alturaDasCasas;
	private int numeroDeMinas;
	private	int minasProximas;
	
	//Utilizar o tempo em segundos
	private int timer;
	
	public boolean ganhou(){
		return false;
		
	}
	public void abrirVizinhas(){
		
	}
	public void setPosicao(int linha,int coluna){
		
		
	}
	public int getPosicao(){
		return 0;
		
	}
	//Para teste com o system.out
	public void exibe(){
		
	}
	public void preencheDicas(){
		
	}
	public void exibeMinas(){
		
	}
	public void iniciaMinas(){
		
	}
	public void sorteiaMinas(){
		
	}
	

	public void setLargura(int largura) {

		this.larguraDasCasas = largura;

	}

	public void setAltura(int altura) {

		this.alturaDasCasas = altura;

	}

	public void setNumeroDeMinas(int numeroDeMinas) {

		this.numeroDeMinas = numeroDeMinas;

	}

	public int getNumeroDeMinasProximas() {
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