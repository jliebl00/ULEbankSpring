package es.unileon.ulebank.domain.exceptions;

public class OfficeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * 
	 * @param message
	 */
	public OfficeNotFoundException(String message) {
		super(message);
	}

}
