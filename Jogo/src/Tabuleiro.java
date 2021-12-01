
import java.util.Random;

public class Tabuleiro extends Celula{
	
	Celula[][] tabuleiro;
	
	Random random = new Random();
	
	private int larguraDasCasas;
	private int alturaDasCasas;
	private int numeroDeMinas;
	
	//Utilizar o tempo em segundos
	private int timer;
	
	public boolean ganhou(){
		return false;
		
	}
	public void abrirVizinhas(){
		
	}
	public void Dicas(){
		
	}
	public void iniciaMinas(){
		
	}
	public void sorteiaMinas(){
		
	}
	public int clicar(int linha, int coluna){
        return tabuleiro[linha][coluna].clicar();
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

