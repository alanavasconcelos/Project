package mecanismosDoJogo;

public class AtributoInvalidoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AtributoInvalidoException(String mensagem) {
		
		super();	
		System.err.println(mensagem + "\n\n");

		
	}
	
}

