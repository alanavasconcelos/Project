package usuario;

import java.util.Scanner;

//classe para teste com o system.out (no console)
public class InteracaoUsuario {
	
	private String nomeDoJogador;
	
	Scanner entrada = new Scanner(System.in);
	

	public void setNomeDoJogador(String nomeDoJogador) {

		this.nomeDoJogador = nomeDoJogador;

	}

	public String getNomeDoJogador() {

		return this.nomeDoJogador;

	}
	
	public void exibe(){
		
	}
	
    public void setPosicao(int linha,int coluna){
		
	}
    
	static public int getPosicao(){
		
		return 0;
		
	}
	  	
	public void exibeMinas(){
			
		}
	
}
