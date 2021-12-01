package mecanismosDoJogo;

import java.util.ArrayList;

public class Celula {

	private boolean minada;
	private boolean clicada;
	private boolean abertaEVazia;
	private boolean marcada;
	private boolean celulaMaluca;
	
	private boolean abriuProximas;
	private boolean ehBomba;
	static private int[] minaSemProxX = new int[8];
	static private int[] minaSemProxY = new int[8];
	static private int cliqueXY;
	static private int numeroAbertas;
	
	
	
	ArrayList<Celula> vizinhas;
	
	//esse método vai adicionar as vizinhas de uma celula
	public void adicionarVizinhas(Celula c){
		
        this.vizinhas.add(c);
        
    }
	
	public Celula() {
		
		this.setMinada(false);
		this.setClicada(false);
		this.abertaEVazia =  false;
		this.marcada =  false;
		this.vizinhas = new ArrayList<Celula>();
		
	}
	
	public void setClicada(boolean clicada) {
		this.clicada = clicada;
	}
	public boolean getClicada() {
		return clicada;
	}

	public void setMinada(boolean minada) {
		this.minada = minada;
	}

	public boolean getMinada() {
		return minada;
	}

	//método para minar, se não tiver minada ele mina e retorna true, caso já tenha mina retorna false
	public boolean minar() {
		
        if (!this.getMinada()) {
        	
            this.setMinada(true);
            return true;
            
        } else{
        	
            return false;  
        }
    }
	
	//permite que ele marque e desmarque a bandeira
	public boolean marcar(){
	    this.marcada = !this.marcada;
        return this.marcada;
    }
	public int numMinasNasVizinhas(){
		
        int n = 0;
        
        //esse for percorre as vizinhas de uma celula,
        //verificando se ela tem minas ao redor, e conta quantas minas e retorna o numero de minas ao redor que essa celula tem
        for (Celula vizinha : this.vizinhas) {
        	
            if(vizinha.getMinada()) n++;
            
        }
        return n;
    }
	//esse metodo é para clicar, caso ele clique e tenha uma mina retorna -1 (bom para fazermos o teste no console)
		// e caso ele clique e não tenha uma mina ele retorna o numero de minas que tem ao seu redor (que são os números, as dicas que aparecem no jogo)
	public int clicar() {
		this.setClicada(true);
        if(this.getMinada()){
            return -1;
        }
        else{
            return numMinasNasVizinhas();
        }
	}
	
	//Método percorre as minas próximas e checa se elas não tem uma bomba próxima, caso não tenha é salvo a posX e posY da célula em um array e enviado para o método clique
	public void abreMinasProximas() {
		
		int contador = 0;
		
		if(clicar(0,0) == 0) {
			
			cliqueXY = mecanismosDoJogo.InteracaoUsuario.getPosicao();
			
			for(int i = 0; i < 3; i++) {
				
				for(int j = 0; i < 3; j++) {
					
					if(i == 3 && j == 3) {
						
						continue;
						
					} else if(numMinasNasVizinhas() == 0){
						
						this.setMinada(true);
						this.abriuProximas= true;				
						minaSemProxX[contador] = i;
						minaSemProxY[contador] = j;
						numeroAbertas++;
						contador++;
					}
				}
			}
		}
		
		for(contador = 0; contador < numeroAbertas; contador++) {
			
			clicar(minaSemProxX[contador], minaSemProxY[contador]);
			
		}
		
	}
	
	public void reset() {
        this.setMinada(false);
        this.abertaEVazia = false;
        this.marcada = false;
        this.setClicada(false);
    }
	
	public boolean finalizado() {
        if(this.getMinada() && this.marcada) return true;
        if(!this.getMinada() && !this.marcada && this.getClicada()) return true;
        return false;
    }	
	
	 public String toString() {
	       if (this.minada)
	            return "-1";
	       return "+" + this.numMinasNasVizinhas();
	    }
}
