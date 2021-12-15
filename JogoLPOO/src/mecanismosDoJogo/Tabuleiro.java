package mecanismosDoJogo;

import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro implements InterfaceTabuleiro{
	
	Random random = new Random();
	private CelulaNormal[][] tabuleiro;
	private int larguraDasCasas; //largura = linha
	private int alturaDasCasas; // altura = coluna
	private int numeroDeMinas;
	private int numeroDeBandeiras;
	private double maluquice;
	private ArrayList<CelulaNormal> minas;
	
 Tabuleiro(int larguraDasCasas, int alturaDasCasas, int numeroDeMinas, double maluquice){
		
		this.larguraDasCasas = larguraDasCasas;
		this.alturaDasCasas = alturaDasCasas;
		this.numeroDeMinas = numeroDeMinas;
		this.numeroDeBandeiras = numeroDeMinas;
		this.maluquice = maluquice;
		
		this.tabuleiro = new CelulaNormal[larguraDasCasas][alturaDasCasas];
		this.minas = new ArrayList<CelulaNormal>();
			
		for (int i = 0; i < larguraDasCasas; i++) {
				
			for (int j = 0; j < alturaDasCasas ; j++) {
					
						
					this.tabuleiro[i][j] = new CelulaNormal();
						
			}
		}
		
		adicionarVizinhas();
		adicionarMinas();
		
		if(this.maluquice > 0) {
			
			adicionarMalucas();
			
		}
		
	}
 
 	public void adicionarVizinhas() {
 		
		for (int i = 0; i < larguraDasCasas; i++) {
					
			for (int j = 0; j < alturaDasCasas; j++) {
		            	
				if (i > 0) {
		                	
					if (j > 0) {
		                    	
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i-1][j-1]);
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i-1][j]);
		                    
					}
		                    
					if (j < alturaDasCasas - 1) {
		                    	
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i-1][j+1]);
		                    	
					}
		                    
					if(j == 0 && i < larguraDasCasas - 1) {
		                    	
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i + 1][j]);
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i - 1][j]);
		                    	
					}
		                    
				}
		                
				if (j > 0) { 
		                	
					this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i][j-1]);
		                
				}
		                
				if (j < alturaDasCasas - 1) {
		                	
					this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i][j+1]);
		                	
				}
		                
				if(i < larguraDasCasas - 1){
		                	
					if (j > 0) {
		                    	
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i+1][j-1]);
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i+1][j]);
		                    	
					}
		                    
					if (j < alturaDasCasas - 1) {
		                    	
						this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i+1][j+1]);
		                    
					}
				}
		                
				if(i == 0 && j == 0) {
		                	
					this.tabuleiro[i][j].adicionarVizinhas(this.tabuleiro[i + 1][j]);
		                	
				}
				
			}
			
		}
		
 	}
	
	public void exibeMinas() {
		
		for(int i = 0; i < this.larguraDasCasas; i++) {
			
			for(int j = 0; j < this.alturaDasCasas; j++) {
				
				if(this.tabuleiro[i][j].getTemMina()) {
					
					this.tabuleiro[i][j].setTemBandeira(false);
					this.tabuleiro[i][j].setClicada(true);
					
				}
				
			}
			
		}
		
	}
	
	public void adicionarMinas(){
		
        int numeroDeMinas = this.numeroDeMinas;
        int largura, altura;
        
        Random rand = new Random();
        
        while (numeroDeMinas > 0){  
        	
        	largura = rand.nextInt(this.larguraDasCasas); 
            altura = rand.nextInt(this.alturaDasCasas); 
            
            if (this.tabuleiro[largura][altura].colorcarMina()){
            	
            	this.minas.add(this.tabuleiro[largura][altura]);
                numeroDeMinas--;
                
            }
            
        }
        
    }
	
	public void adicionarMalucas() {
		
		int numeroDeMinasFaltando = this.numeroDeMinas;
		double numeroDeMalucas = this.numeroDeMinas * this.maluquice;
		int malucaAtual;
		CelulaNormal celulaAtual = new CelulaNormal();
		Random rand = new Random();
		
		while(numeroDeMalucas > 0) {
			
			malucaAtual = rand.nextInt(numeroDeMinasFaltando);
			celulaAtual = this.minas.get(malucaAtual);
			celulaAtual.setEhMaluca(true);			
			this.minas.remove(malucaAtual);

			numeroDeMalucas--;
			numeroDeMinasFaltando--;
			
		}
		
	}
	
	public int clicar(int linha, int coluna){
		
		int clique = this.tabuleiro[linha][coluna].clicar();;
		
        if(clique == -1) {
        	
        	return -1;
        	
        }else {

        	return 0;
        	
        }
        
    }
	
	public void colocaBandeira(int linha, int coluna) {
		
		Random rand = new Random();
		double probabilidade = this.maluquice * 10;
		int aleatorio, largura, altura, bandeira;
		
		if(this.numeroDeBandeiras > 0) {
			
			bandeira = this.tabuleiro[linha][coluna].marcar();
			this.numeroDeBandeiras = this.numeroDeBandeiras + bandeira;
		
		}
		
		if(this.tabuleiro[linha][coluna].getEhMaluca()) {
			
			aleatorio = rand.nextInt(10);
			
			if(probabilidade > aleatorio) {
				
				this.tabuleiro[linha][coluna].setTemMina(false);
				this.tabuleiro[linha][coluna].setEhMaluca(false);
				
	        	largura = rand.nextInt(this.larguraDasCasas);
	            altura = rand.nextInt(this.alturaDasCasas);
	            
	            while(!this.tabuleiro[largura][altura].getTemMina() && !this.tabuleiro[linha][coluna].getClicada()){
	            	
	            	this.minas.add(this.tabuleiro[largura][altura]);
	            	this.tabuleiro[largura][altura].setTemMina(true);
	            	this.tabuleiro[largura][altura].setEhMaluca(true);
	            	
	            }
	            
	            for(int i = 0; i < this.alturaDasCasas; i++) {
	            	
	            	for(int j = 0; j < this.larguraDasCasas; j++) {
	            		
	            		this.tabuleiro[i][j].limparVizinhas();
	            		
	            	}
	            	
	            }
	            
	            adicionarVizinhas();
			
			}
		}	
		
	}


	public boolean venceu(){        
		
        for (int i = 0; i < this.larguraDasCasas; i++) {
        	
            for (int j = 0; j < this.alturaDasCasas ; j++) {
            	
                if (!this.tabuleiro[i][j].finalizado()) { 
                	
                	return false;
                	
                }
                
            }
        }
        
        return true;
        
    }
	
	public CelulaNormal getCelula(int linha, int coluna){
		
        return this.tabuleiro[linha][coluna];
        
    }
	
	public int getNumeroDeMinas() {
		
		return this.numeroDeMinas;
		
	}
	
	public int getNumeroDeBandeiras() {
		
		return this.numeroDeBandeiras;
		
	}
	
	public String toString() {
		
        String string = "";
        
        for (int i = 0; i < this.larguraDasCasas; i++) {
        	
            for (int j = 0; j < this.alturaDasCasas; j++) {
            	
                string += this.tabuleiro[i][j] + " ";
                
            }
            
            string += "\n";
            
        }
        
        return string;    
        
    }
	
}
