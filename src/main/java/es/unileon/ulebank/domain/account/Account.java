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
	 * The logger of the class
	 */

	@Id
	@Column(name = "accountID")
	private String accountID;

	public String officeID;

	public String getOfficeID() {
		return officeID;
	}

	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public Account() {

	}

	public Account(String accountID) {
		Handler idaccount = new AccountHandler(accountID);

		this.accountID = idaccount.toString();
	}
}
