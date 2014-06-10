package es.unileon.ulebank.domain.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import es.unileon.ulebank.domain.handler.AccountHandler;
import es.unileon.ulebank.domain.handler.Handler;

/**
 *
 * @author runix
 */

@Entity
@Table(name = "Accounts")
public class Account {

	/**
	 * Id of the account
	 */
	@Id
	@Column(name = "accountID")
	private String accountID;
	/**
	 * Id of the office
	 */
	private String officeID;

	/**
	 * Constructor of the class
	 * 
	 * @param accountID
	 */
	public Account(String accountID) {
		Handler idaccount = new AccountHandler(accountID);
		this.accountID = idaccount.toString();
	}

	/**
	 * Default constructor
	 */
	public Account() {
	}

	/**
	 * Returns the accountID
	 * 
	 * @return accountID
	 */
	public String getAccountID() {
		return accountID;
	}

	/**
	 * Sets the accountID
	 * 
	 * @param accountID
	 */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	/**
	 * Returns the officeID
	 * 
	 * @return officeID
	 */
	public String getOfficeID() {
		return officeID;
	}

	/**
	 * Sets the officeID
	 * 
	 * @param officeID
	 */
	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}
}
