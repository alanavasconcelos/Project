package mecanismosDoJogo;

public abstract class CelulaAbstrata {
	
	private boolean temMina;
	private boolean clicada;
	private boolean temBandeira;
	private boolean ehMaluca;
	
	public CelulaAbstrata() {
		
		this.temMina = false;
		this.clicada = false;
		this.temBandeira =  false;
		this.ehMaluca = false;
		
	}
	
	//método para minar, se não tiver minada ele mina e retorna true, caso já tenha mina retorna false
	public boolean colorcarMina() {
			
		if (!this.getTemMina()) {
	        	
			this.setTemMina(true);
			return true;
	            
		} else {
	        	
			return false;  
			
		}
		
	}
		
	//permite que ele marque e desmarque a bandeira
	public abstract int marcar();	
		
	//esse for percorre as vizinhas de uma celula,
	//verificando se ela tem minas ao redor, e conta quantas minas e retorna o numero de minas ao redor que essa celula tem
	public abstract int numMinasNasVizinhas();
		
	//esse metodo é para clicar, caso ele clique e tenha uma mina retorna -1 (bom para fazermos o teste no console)
	// e caso ele clique e não tenha uma mina ele retorna o numero de minas que tem ao seu redor (que são os números, as dicas que aparecem no jogo)
	public abstract int clicar() ;
	
	public abstract void limparVizinhas();
		
	public void reset() {
			
		this.setTemMina(false);
		this.temBandeira = false;
		this.setClicada(false);
	        
	}
		
	public boolean finalizado() {
			
		if(this.getTemMina() && this.temBandeira || this.getTemMina() && !this.getClicada()) { 
	        	
			return true;
	        
		}
	        
		if(!this.getTemMina() && !this.temBandeira && this.getClicada()) {
	        
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
			 
		if(this.temBandeira){
		      		
			return "T";
		      		
		}
			 
		if(this.clicada) {
				 
			if (this.temMina) {
		    	   
				return "B";
		            
			}else {
				
				return "" + this.numMinasNasVizinhas();
				
			}
		       
		       
		} else {
		    	
			return "C";
		    	
		}
			 
	}
	 
}
