import java.util.ArrayList;

public class Celula {

	private boolean minada;
	private boolean clicada;
	private boolean abertaevazia;
	private boolean marcada;
	
	ArrayList<Celula> vizinhas;
	
	//esse método vai adicionar as vizinhas de uma celula
	public void adicionarVizinhas(Celula c){
        this.vizinhas.add(c);
    }
	
	public Celula() {
		this.minada = false;
		this.clicada = false;
		this.abertaevazia =  false;
		this.marcada =  false;
		this.vizinhas = new ArrayList<Celula>();
	}
	//método para minar, se não tiver minada ele mina e retorna true, caso já tenha mina retorna false
	public boolean minar() {
        if (!this.minada) {
            this.minada = true;
            return true;
        } 
        else {
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
        //verificando se ela tem minas ao redor, e conta quantas minas e retorna o numero de minas ao redor que essa celula tem.
        for (Celula vizinha : this.vizinhas) {
            if(vizinha.minada) n++;
        }
        return n;
    }
	//esse metodo é para clicar, caso ele clique e tenha uma mina retorna -1 (bom para fazermos o teste no console)
	// e caso ele clique e não tenha uma mina ele retorna o numero de minas que tem ao seu redor (que são os números, as dicas que aparecem no jogo)
	public int clicar(){
        this.clicada = true;
        if(this.minada){
            return -1;
        }
        else{
            return numMinasNasVizinhas();
        }
    }
	
}
