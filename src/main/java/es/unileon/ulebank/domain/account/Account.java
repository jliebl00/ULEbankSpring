package es.unileon.ulebank.domain.account;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import es.unileon.ulebank.domain.handler.AccountHandler;
import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.domain.exceptions.MalformedHandlerException;
import es.unileon.ulebank.domain.bank.Bank;

import org.apache.log4j.Logger;

/**
 *
 * @author runix
 */

@Entity
@Table(name="Accounts")
public class Account {

    /**
     * The logger of the class
     */
	private static final long serialVersionUID = 1L;
	
    private static final Logger LOG = Logger.getLogger(Account.class.getName());

    @Id
    @Column(name= "accountID")
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
