package exceptions;

public class ReferenciaCiclicaException extends ColoreGrafoException {

	private static final long serialVersionUID = 1L;

	public ReferenciaCiclicaException(String mensagem) {
		super(mensagem);
	}

}
