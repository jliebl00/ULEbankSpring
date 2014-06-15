package es.unileon.ulebank.domain.exceptions;

public class ClientNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public ClientNotFoundException(String message) {
		super(message);
	}
}
