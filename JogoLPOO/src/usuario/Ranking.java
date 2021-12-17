package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Ranking  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int tempo = 1;
	int tamanhoMaximo = 15;
	private ArrayList<Pessoa> ranking = new ArrayList<Pessoa>();
	
	public void converte() {
		
		for(int i = 0; i < this.ranking.size(); i++) {
			
			this.ranking.get(i).converteTempo();
			
		}
		
	}
	
	public void limpaRanking() {
		
		this.ranking.clear();
		
	}
	
	public void adicionaPessoa(Pessoa pessoa) {

		this.ranking.add(pessoa);

	}
	
	public void organizaFila() {

		Pessoa pessoaAtual;

		Collections.sort(this.ranking);

		if (this.ranking.size() > this.tamanhoMaximo) {

			pessoaAtual = this.ranking.get(this.tamanhoMaximo);
			this.ranking.remove(pessoaAtual);

		}

	}

	public ArrayList<Pessoa> getRanking() {

		return this.ranking;

	}
	
	public String toString() {
		
		String a = "";
		
		for(int i = 0; i < this.ranking.size(); i++) {
			
			a += this.ranking.get(i);
			
		}
		
		return "\n" + a;
		
	}
	
}
