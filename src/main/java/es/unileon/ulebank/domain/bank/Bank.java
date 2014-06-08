/* Application developed for AW subject, belonging to passive operations
 group.*/
package es.unileon.ulebank.domain.bank;

import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.exceptions.MalformedHandlerException;
import es.unileon.ulebank.domain.office.Office;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author runix
 */

@Entity
@Table(name="Bank")
public class Bank {

    //private static final Logger LOG = Logger.getLogger(Bank.class.getName());
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bankID")
    
    private String bankID;

    public Bank() {
    	
    }
    
    public Bank(String bankID){
    	this.bankID = bankID;
    }

    public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}   
}
