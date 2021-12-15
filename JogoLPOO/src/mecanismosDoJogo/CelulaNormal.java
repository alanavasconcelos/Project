package mecanismosDoJogo;

import java.util.ArrayList;

public class CelulaNormal extends CelulaAbstrata {
	
	private ArrayList<CelulaNormal> vizinhas;
	
	public CelulaNormal() {
		
		super();
		
		this.vizinhas = new ArrayList<CelulaNormal>();
		
	}
	
	public void adicionarVizinhas(CelulaNormal c){
		
        this.vizinhas.add(c);
        
    }
	
	public int numMinasNasVizinhas(){
		
        int n = 0;
        
        for (CelulaNormal vizinha : this.vizinhas) {
        	
            if(vizinha.getTemMina()) n++;
            
        }
        
        return n;
    }
	
	public void limparVizinhas() {
		
		this.vizinhas.clear();
		
	}
	
	public int clicar() {
		
		//Preferi não colocar exeção para clicar em uma já clicada, já que com a utilização do console fica dificil a 
		//visualização do tabuleiro, podendo ocorrer acidetalmente, não querendo encerrar o jogo com uma mensagem de erro.
		
		CelulaNormal celulaAtual;
		boolean temBandeira = super.getTemBandeira();
		boolean clicada = super.getClicada();
		
		if(!temBandeira && !clicada) {
			
			this.setClicada(true);
        	if(this.getTemMina()){
        	
        		return -1;
        	
        	}else if(this.numMinasNasVizinhas() == 0) {
        		
        		for(int i = 0; i < this.vizinhas.size(); i++) {
            		
            		celulaAtual = this.vizinhas.get(i);
            		
            		if(this.getTemMina() == false) {
            			
            			celulaAtual.clicar();
            			
            		}
        		}		
		
		}else {
        	
        		return this.numMinasNasVizinhas();
        	
        	}
        
		}else {
			
			return 0;
			//colocar exceção para clicar em casa já clicada
			
		}
		
		return 0;
		
	}
	
	public int marcar(){
		
		if(!super.getClicada()) {
			
			boolean temBandeira = super.getTemBandeira();
			
			if(temBandeira == true) {
				
				super.setTemBandeira(!temBandeira);
				return 1;
				
			}else {
				
				super.setTemBandeira(!temBandeira);
				return -1;
				
			}
			
			
		}
		
		return 0;
		
    }	
	
	 
}