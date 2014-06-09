package es.unileon.ulebank.domain.handler;

import es.unileon.ulebank.domain.exceptions.MalformedHandlerException;

/**
 *
 * @author runix
 */
public class AccountHandler implements Handler {

	@Override
	public String toString() {
		return numberAccount;
	}

	private String numberAccount;

	public AccountHandler(String number) throws MalformedHandlerException {
		if (number.length() >= 0) {

			if (number.length() == 4) {
				this.numberAccount = number;
			} else {
				if (number.length() < 4) {
					this.numberAccount = number;
					while (numberAccount.length() <= 4) {
						numberAccount = 0 + numberAccount;
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
	 * Create a new AccountHandler
	 *
	 * @param office
	 *            ( the office id )
	 * @param bank
	 *            ( the bank id )
	 * @param accountNumber
	 *            ( the account number )
	 * @author runix
	 * @throws MalformedHandlerException
	 *             ( If the account number, office handler, or bank handler
	 *             aren't correct )
	 */
	public int compareTo(Handler another) {
		return this.toString().compareTo(another.toString());
	}

}
