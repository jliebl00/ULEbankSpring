package es.unileon.ulebank.domain.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Bank")
public class Bank {

	@Id
	@Column(name = "bankID")
	private String bankID;

	/**
	 * Default constructor
	 */
	public Bank() {

	}

	/**
	 * Constructor of the class
	 * 
	 * @param bankID
	 */
	public Bank(String bankID) {
		this.bankID = bankID;
	}

	/**
	 * Returns the bankID
	 * 
	 * @return bankID
	 */
	public String getBankID() {
		return bankID;
	}

	/**
	 * Sets the bankID
	 * 
	 * @param bankID
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
}
