package mecanismosDoJogo;


public interface InterfaceTabuleiro {
	
	public void adicionarMinas();
	public int clicar(int linha,int coluna );
	public boolean perdeu();
    public boolean venceu();
		
}
