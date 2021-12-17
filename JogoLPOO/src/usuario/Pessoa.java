package usuario;

import java.io.Serializable;

public class Pessoa implements Serializable, Comparable<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int tempo;
	private int minutos, segundos;

	public Pessoa(String nome, int tempo) {

		this.nome = nome;
		this.tempo = tempo;
		converteTempo();
		
	}
	
	public void converteTempo() {
		
		int tempoTotal = this.tempo;
		
		while(tempoTotal > 60) {
			
			tempoTotal = tempoTotal - 60;
			this.minutos++;
			
		}
		
		this.segundos = tempoTotal;
		
	}

	public int compareTo(Pessoa pessoa) {

		return this.tempo - pessoa.getTempo();

	}

	public String getNome() {

		return this.nome;

	}

	public int getTempo() {

		return this.tempo;

	}

	public String toString() {

		if(minutos > 0) {
			
			return this.nome + " - " + this.minutos + "min e " + this.segundos + "s\n";
			
		}else {
			
			return this.nome + " - " + this.segundos + "s\n";
			
		}
	}

}
