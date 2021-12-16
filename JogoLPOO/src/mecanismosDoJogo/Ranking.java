package mecanismosDoJogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

//Um dos modelos testados para um ranking, não finalizado nem implementado

public class Ranking implements Serializable, Comparable<Ranking> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int tempo;

	ArrayList<Ranking> ranking = new ArrayList<Ranking>();

	public Ranking(String nome, int tempo, boolean vazio) {

		if (!vazio) {

			this.nome = nome;
			this.tempo = tempo;

		}

	}

	public void adicionaPessoa(Ranking pessoa) {

		ranking.add(pessoa);

	}

	public void organizaRanking() {

		Ranking pessoaAtual;

		Collections.sort(this.ranking);

		if (this.ranking.size() > 15) {

			pessoaAtual = this.ranking.get(15);
			this.ranking.remove(pessoaAtual);

		}

	}

	public String getNome() {

		return this.nome;

	}

	public int getTempo() {

		return this.tempo;

	}

	public ArrayList<Ranking> getRanking() {

		return this.ranking;

	}

	public int compareTo(Ranking pessoa) {

		return pessoa.getTempo() - this.tempo;

	}

	public String toString() {

		return "Nome: " + this.nome + " Tempo: " + this.tempo + "s\n";

	}

}
