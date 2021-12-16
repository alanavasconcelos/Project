package mecanismosDoJogo;

import java.util.Scanner;

public class InteracaoUsuario {
	
	private Scanner entrada;
	private String nomeDoJogador;
	private int dificuldade;
	double maluquice;
	private boolean ehMaluco;
	
	
	public InteracaoUsuario() {
		
		this.entrada = new Scanner(System.in);
		
	}
	
	public boolean vaiMarcar(int numeroDeBandeirasAtuais) throws AtributoInvalidoException{
		
		int entrou = 0;
		
		System.out.println("Escolha sua jogada:\n1- Abrir célula     2- Colocar ou retirar bandeira(" + numeroDeBandeirasAtuais + " bandeiras disponíveis)");
		
			try {
					
				entrou = entrada.nextInt();
			
			} catch(Exception e) {
								
				System.err.println("Digite um inteiro entre os disponíveis\n\n");
				
			}
			
			if(entrou < 0 || entrou > 2) {
				
				AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
				throw e;
				
			}else if(entrou == 1){
				
				return false;
				
			}else {
				
				return true;
				
			}
		
	}
	public void imprimeMensagem(String mensagem) {
		
		System.out.println(mensagem);
		
	}
	
	public void imprimeTabuleiroAtual(Tabuleiro tabuleiroAtual) {
		
		tabuleiroAtual.getNumeroDeBandeiras();
		System.out.println(tabuleiroAtual);
		
	}
	
	public void setNomeDoJogador() throws AtributoInvalidoException{
		
		System.out.println("Digite seu nome: ");
		this.nomeDoJogador = entrada.nextLine();
		nomeDoJogador = this.nomeDoJogador.trim();
		
		if(nomeDoJogador.isEmpty()) {
			
			AtributoInvalidoException e = new AtributoInvalidoException("Insira um nome ou apelido");
			throw e;
			
		}
		
	}

	public void setDificuldade() throws AtributoInvalidoException {
		
		System.out.println("Escolha a dificuldade: \n1- Fácil     2- Médio     3- Difícil");
		
		try {
			
			this.dificuldade = entrada.nextInt();
			
		}catch(Exception e) {
			
			System.err.println("Digite um inteiro entre os disponíveis\n\n");
			
		}
		
		if(this.dificuldade <= 0 || this.dificuldade > 3) {
			
			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;
			
		}
		
	}
	
	public void setTipoDoJogo() throws AtributoInvalidoException {
		
		int tipoDoJogo = 0;
		
		System.out.println("Escolha o tipo de jogo: \n1- Campo Minado Normal     2- Campo Minado Maluco");
		
		try {
		
			tipoDoJogo = entrada.nextInt();
			
		} catch(Exception e) {
			
			System.err.println("Digite um inteiro entre os disponíveis");
			
		}
			
		if(tipoDoJogo == 1) {
				
			this.ehMaluco = false;
				
		}else if(tipoDoJogo == 2) {
				
			this.ehMaluco = true;
				
			setMaluquice();
				
		}else {
				
			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;
				
			
		}
		
	}
	
	public void setMaluquice() throws AtributoInvalidoException{
		
		int maluquiceUsuario = 0;
		
		System.out.println("Escolha o nivel de maluquice do jogo:\n1- 10%     2- 20%     3- 40%     4- 50%     5- 60%     6- 80%     7- 100%");
		
		try {
			
			maluquiceUsuario = entrada.nextInt();
			
		} catch(Exception e) {
			
			System.err.println("");
			
		}
		
		
        switch(maluquiceUsuario) {
    	
    		case 1:
    		
    			this.maluquice = 0.1;
    			break;
    		
    		case 2:
    		
    			this.maluquice = 0.2;
    			break;
    			
    		case 3:
    		
    			this.maluquice = 0.4;
    			break;
    			
    		case 4:
    			
    			this.maluquice = 0.5;
    			break;
    			
    		case 5:
    		
    			this.maluquice = 0.6;
    			break;
    			
    		case 6:
    		
    			this.maluquice = 0.8;
    			break;
    			
    		case 7:
    		
    			this.maluquice = 1;
    			break;
    	
    		default:
    			
    			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
    			throw e;
    			
        }
		
	}
	
    public int pegarLinha(int dificuldade) throws AtributoInvalidoException {
    	
    	int linhaMax;
    	int linha = 0;
    	
    	if(dificuldade == 1) {
    		
    		linhaMax = 9;
    		
    	}else if(dificuldade == 2) {
    		
    		linhaMax = 16;
    		
    	}else {
    		
    		linhaMax = 16;
    		
    	}
    	

		System.out.println("Escolha a linha (1 - " + linhaMax + ")");
		
		try {
			
			linha = this.entrada.nextInt() - 1;
			
		} catch(Exception e) {
			
			System.err.println("Digite um inteiro entre os disponíveis");
			
		}
		
		
		if(linha > linhaMax || linha < 0 ) {
				
			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;
				
		}

		return linha;	
    	
	}
    
    public int pegarColuna(int dificuldade) throws AtributoInvalidoException {
    
    	int colunaMax;
    	int coluna = 0;
    	
    	if(dificuldade == 1) {
    		
    		colunaMax = 9;
    		
    	}else if(dificuldade == 2) {
    		
    		colunaMax = 16;
    		
    	}else {
    		
    		colunaMax = 30;
    		
    	}
    	
		System.out.println("Escolha a coluna (1 - " + colunaMax + ")");   
		
    	try {

    		coluna = this.entrada.nextInt() - 1;
			
    	} catch(Exception e) {
    		
    		System.err.println("Digite um inteiro entre os disponíveis");
    		
    	}	
    	
		if(coluna > colunaMax || coluna < 0 ) {
				
			AtributoInvalidoException e = new AtributoInvalidoException("Insira o inteiro que acompanha sua escolha");
			throw e;
				
		}

		return coluna;	
    	
	}
    
    public void imprimeEnter(int enter) {
    	
    	for(int i = 0; i < enter; i++) {
    		
    		System.out.println("");
    		
    	}
    	
    }
    
    public double getMaluquice() {
    	
    	return this.maluquice;
    	
    }
    
	public String getNomeDoJogador() {
		
		return this.nomeDoJogador;
		
	}

	public int getDificuldade() {
		
		return this.dificuldade;
		
	}
	
	public boolean getTipoDoJogo() {
		
		return this.ehMaluco;
		
	}
    
}
