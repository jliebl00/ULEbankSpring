package es.unileon.ulebank.domain.handler;

import es.unileon.ulebank.domain.exceptions.MalformedHandlerException;
import es.unileon.ulebank.domain.handler.Handler;

public class OfficeHandler implements Handler {

	/**
	 * Number of the office
	 */
	private String numberOffice;

	/**
	 * Creates the office's handler with an int
	 * 
	 * @param number
	 * @throws MalformedHandlerException
	 */
	public OfficeHandler(int number) throws MalformedHandlerException {

		if (number >= 0) {

			if (Integer.toString(number).length() == 4) {
				this.numberOffice = Integer.toString(number);
			} else {
				if (Integer.toString(number).length() < 4) {
					this.numberOffice = Integer.toString(number);
					while (numberOffice.length() <= 4) {
						numberOffice = 0 + numberOffice;
					}
				} else {
					throw new MalformedHandlerException(
							"The idOffice is malformed");
				}
			}
		} else {
			throw new MalformedHandlerException(
					"The idOffice has to be a positive number");
		}
	}

	/**
	 * Creates the office's handler with a string
	 * 
	 * @param numberOffice
	 * @throws MalformedHandlerException
	 */
	public OfficeHandler(String numberOffice) throws MalformedHandlerException {
		try {
			Integer.parseInt(numberOffice);
		} catch (NumberFormatException e) {
			throw new MalformedHandlerException(
					"The idOffice has to be a number");
		}

		if (Integer.parseInt(numberOffice) >= 0) {
			if (numberOffice.length() == 4) {
				this.numberOffice = numberOffice;
			} else {
				if (numberOffice.length() < 4) {
					while (numberOffice.length() <= 4) {
						numberOffice = 0 + numberOffice;
					}
				} else {
					throw new MalformedHandlerException(
							"The idOffice is malformed");
				}
			}
		} else {
			throw new MalformedHandlerException(
					"The idOffice has to be a positive number");
		}
	}

	/**
	 * Returns the idOffice
	 * 
	 * @return numberOffice
	 */
	public int getIdOffice() {
		return Integer.parseInt(numberOffice);
	}

	public int compareTo(Handler another) {
		return this.numberOffice.compareTo(another.toString());
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return this.numberOffice;
	}

}
