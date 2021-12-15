package mecanismosDoJogo;

public class Jogo {
	
	private int dificuldade, linha, coluna;
	private double maluquice;
	private boolean ehMaluco;
	private Tabuleiro tabuleiro;
	private InteracaoUsuario usuario;
	
	
	
	public Jogo() throws AtributoInvalidoException {
		
		this.usuario  = new InteracaoUsuario();
		
		usuario.setNomeDoJogador();
		usuario.setDificuldade();
		this.dificuldade = usuario.getDificuldade();
		usuario.setTipoDoJogo();
		this.ehMaluco = usuario.getTipoDoJogo();
		
		if(this.ehMaluco) {
			
			this.maluquice = usuario.getMaluquice();
			
		}else {
			
			this.maluquice = 0;
			
		}

		this.construirJogo();
		
	}
	
	private void construirJogo() {
		
		int coluna = 0;
		int linha = 0;
		int bombas = 0;
		
		if(this.dificuldade == 1) {
			
			coluna = 9;
			linha = 9;
			bombas = 10;
			
		}else if(this.dificuldade == 2) {
			
			coluna = 16;
			linha = 16;
			bombas = 40;
			
		}else if(this.dificuldade == 3) {
			
			coluna = 30;
			linha = 16;
			bombas = 100;
			
		}
			
		this.tabuleiro = new Tabuleiro(linha, coluna, bombas, this.maluquice);
			
	}
	
	private int checarMovimento() {
			
		if(this.tabuleiro.clicar(this.linha, this.coluna) == -1) {
				
			return -1;
			
		}
		
		if(!this.tabuleiro.venceu()) {
			
			return 0;
			
		}else {
			
			return 1;
			
		}
		
	}
	
	private void proximoMovimento() throws AtributoInvalidoException {
		
		this.coluna = this.usuario.pegarColuna(this.dificuldade);
		this.linha = this.usuario.pegarLinha(this.dificuldade);
		
	}
	
	public void iniciarJogo() throws AtributoInvalidoException {
		
		boolean jogando = true;
		boolean vaiMarcar = false;
		int venceu = 0;
		
		do {
			
			this.usuario.imprimeEnter(3);
			this.usuario.imprimeTabuleiroAtual(this.tabuleiro);
			vaiMarcar = this.usuario.vaiMarcar(tabuleiro.getNumeroDeBandeiras());
			this.proximoMovimento();			

			if(vaiMarcar) {
				
				this.tabuleiro.colocaBandeira(this.linha, this.coluna);
				
			}else {
				
				venceu = this.checarMovimento();				
				
			}

			if(venceu == -1) {
				
				this.usuario.imprimeEnter(3);
				this.tabuleiro.exibeMinas();
				this.usuario.imprimeTabuleiroAtual(this.tabuleiro);
				this.usuario.imprimeMensagem("Você perdeu");
				jogando = false;
				
			}else if(venceu == 1) {
				
				this.usuario.imprimeEnter(3);
				this.usuario.imprimeTabuleiroAtual(this.tabuleiro);
				this.usuario.imprimeMensagem("Você venceu");
				jogando = false;
				
			}
			

		}while(jogando);
		
	}

}
