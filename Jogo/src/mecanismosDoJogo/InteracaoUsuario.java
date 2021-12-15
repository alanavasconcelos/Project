package mecanismosDoJogo;

import java.util.Scanner;

public class InteracaoUsuario extends Jogo {
	
	public InteracaoUsuario(String nomeDoJogador, int dificuldade,int tipoDoJogo) {
		super(nomeDoJogador, dificuldade,tipoDoJogo);
	}

	Scanner entrada = new Scanner(System.in);


	public String getNomeDoJogador(String nomeDoJogador) {
		System.out.println("Digite seu nome: ");
		nomeDoJogador = entrada.nextLine();
		return nomeDoJogador;
	}

	public int getDificuldade(int dificuldade) {
		System.out.println("1-Fácil 2-Médio 3-Difícil");
		dificuldade = entrada.nextInt();
		return dificuldade;
	}
	public int gettipoDoJogo(int tipoDoJogo) {
		System.out.println("4-Campo Minado Normal 5-Campo Minado Maluco");
		tipoDoJogo = entrada.nextInt();
		return tipoDoJogo;
	}
	

	
	public void exibe(){
		
	}
	
    public boolean setPosicao(int linha,int coluna){
    	System.out.print("\nLinha: "); 
        linha = entrada.nextInt();
        System.out.print("Coluna: "); 
        coluna = entrada.nextInt();
		
	}
    
    public int getPosicao(int linha, int coluna){
        return tabuleiro[linha][coluna];
    }
	  	
	public void exibeMinas(){
			
		}

	
}