package mecanismosDoJogo;

import java.util.Random;

public class Tabuleiro implements InterfaceTabuleiro{
	
	Celula[][] tabuleiro;
	
	Random random = new Random();
	
	private int larguraDasCasas = 5;
	private int alturaDasCasas = 5;
	private int numeroDeMinas = 4;
	
	public void setLarguraDasCasas(int larguraDasCasas) {
		this.larguraDasCasas = larguraDasCasas;
	}
	public int getLarguraDasCasas() {
		return larguraDasCasas;
	}
	
	public void setAlturaDasCasas(int alturaDasCasas) {
		this.alturaDasCasas = alturaDasCasas;
	}
	public int getAlturaDasCasas() {
		return alturaDasCasas;
	}
	
	public void setNumeroDeMinas(int numeroDeMinas) {
		this.numeroDeMinas = numeroDeMinas;
	}
	public int getNumeroDeMinas() {
		return numeroDeMinas;
	}	
	
	public Tabuleiro(){
		tabuleiro = new Celula [larguraDasCasas][alturaDasCasas];
		for (int i = 0; i < larguraDasCasas; i++) {
			for (int j = 0; j < alturaDasCasas ; j++) {
				tabuleiro[i][j] = new Celula();
				
			}
		}
		
		for (int i = 0; i < larguraDasCasas ; i++) {
            for (int j = 0; j < alturaDasCasas; j++) {
                if (i > 0) {
                    if (j > 0) tabuleiro[i][j].adicionarVizinhas(tabuleiro[i-1][j-1]);
                    tabuleiro[i][j].adicionarVizinhas(tabuleiro[i-1][j]);
                    if (j < alturaDasCasas-1) tabuleiro[i][j].adicionarVizinhas(tabuleiro[i-1][j+1]);
                }
                
                if (j > 0) tabuleiro[i][j].adicionarVizinhas(tabuleiro[i][j-1]);                
                if (j < alturaDasCasas-1)tabuleiro[i][j].adicionarVizinhas(tabuleiro[i][j+1]);
                
                if(i < larguraDasCasas -1){
                    if (j > 0)tabuleiro[i][j].adicionarVizinhas(tabuleiro[i+1][j-1]);
                    tabuleiro[i][j].adicionarVizinhas(tabuleiro[i+1][j]);
                    if (j < alturaDasCasas-1)tabuleiro[i][j].adicionarVizinhas(tabuleiro[i+1][j+1]);
                }
            }
        }
	}
	
	
	public void adicionarMinas(){
        int n = numeroDeMinas;
        Random rand = new Random();
        while (n > 0){            
            int l = rand.nextInt(larguraDasCasas); 
            int a = rand.nextInt(alturaDasCasas);             
            if (tabuleiro[l][a].minar()){
                n--;
            }            
        }
        //System.out.println(this);  
    }
	
	public int clicar(int linha,int coluna ){
        return tabuleiro[linha][coluna].clicar();
    }
	public boolean perdeu(){        
        for (int i = 0; i < larguraDasCasas; i++) {
            for (int j = 0; j < alturaDasCasas; j++) {
                if (tabuleiro[i][j].getClicada() && tabuleiro[i][j].getMinada()) return true;
            }            
        }
        return false;
    }

	public boolean venceu(){        
        for (int i = 0; i < larguraDasCasas; i++) {
            for (int j = 0; j < alturaDasCasas ; j++) {
                if (!tabuleiro[i][j].finalizado()) return false;
            }            
        }
        return true;
    }
	
	
	
	public Celula getCelula(int linha, int coluna){
        return tabuleiro[linha][coluna];
    }
    
	
	public String toString() {
        String string = "";
        
        for (int i = 0; i < larguraDasCasas; i++) {
            for (int j = 0; j < alturaDasCasas; j++) {
                string += tabuleiro[i][j] + " ";
            }
            string += "\n";
        }
        return string;        
    }
	
}
