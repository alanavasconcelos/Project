package mecanismosDoJogo;

import java.util.ArrayList;

public class Celula {

	private boolean minada;
	private boolean clicada;
	private boolean abertaEVazia;
	private boolean marcada;
	private boolean abriuProximas;
	private boolean ehBomba;
	static private int[] minaSemProxX = new int[8];
	static private int[] minaSemProxY = new int[8];
	static private int cliqueXY;
	static private int numeroAbertas;
	private int xTeste, yTeste;
	
	ArrayList<Celula> vizinhas;
	
	//esse método vai adicionar as vizinhas de uma celula
	public void adicionarVizinhas(Celula c){
		
        this.vizinhas.add(c);
        
    }
	
	public Celula() {
		
		this.minada = false;
		this.clicada = false;
		this.abertaEVazia =  false;
		this.marcada =  false;
		this.vizinhas = new ArrayList<Celula>();
		
	}
	
	//método para minar, se não tiver minada ele mina e retorna true, caso já tenha mina retorna false
	public boolean minar() {
		
        if (!this.minada) {
        	
            this.minada = true;
            return true;
            
        }else {
        	
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
        	
            if(vizinha.minada) n++;
            
        }
        return n;
    }
	
	//esse metodo é para clicar, caso ele clique e tenha uma mina retorna -1 (bom para fazermos o teste no console)
	// e caso ele clique e não tenha uma mina ele retorna o numero de minas que tem ao seu redor (que são os números, as dicas que aparecem no jogo)
	public int clicar(int x, int y){
		
		int numMinasVizinhas = numMinasNasVizinhas();
		
        this.clicada = true;
        
        if(numMinasVizinhas == 0) {
        	
        	if(this.ehBomba) {
        		
        		return -1;
        		
        	} else {
        		
        		abreMinasProximas();
        		
        	}
        	
        }else if(numMinasVizinhas > 0) {
        	
         	minar();       	
        	return numMinasVizinhas;
        	
        } else {
        	
        	return -1;
        	
        }
        
        return numMinasVizinhas;
        
    }
	
	//Método percorre as minas próximas e checa se elas não tem uma bomba próxima, caso não tenha é salvo a posX e posY da célula em um array e enviado para o método clique
	public void abreMinasProximas() {
		
		int contador = 0;
		
		if(clicar(0,0) == 0) {
			
			cliqueXY = usuario.InteracaoUsuario.getPosicao();
			
			for(int i = 0; i < 3; i++) {
				
				for(int j = 0; i < 3; j++) {
					
					if(i == 3 && j == 3) {
						
						continue;
						
					} else if(numMinasNasVizinhas() == 0){
						
						this.minada = true;
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
	
}
