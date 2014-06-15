package es.unileon.ulebank.domain.office;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Offices")
public class Office implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Id of the office
	 */
	@Id
	@Column(name = "officeID")
	private String officeID;
	/**
	 * Id of the bank
	 */
	@Column(name = "bankID")
	private String bankID;

	/**
	 * The account of the office
	 */
	private String account;

	/**
	 * The address of the office
	 */
	private String address;
	/**
	 * The balance of the office
	 */
	private Double balance;
	/**
	 * The costs of the local of the office
	 */
	private double localCost;
	/**
	 * The costs of the light, water and gas of the office
	 */
	private double utilitiesCost;
	/**
	 * The expenses in the salaries of the employees
	 */
	private double employeeCost;
	/**
	 * The city of the office
	 */
	private String city;
	/**
	 * The postcode of the office
	 */
	private String postCode;
	/**
	 * The telephone of the office
	 */
	private String telephone;

	/**
	 * Constructor of the class
	 * 
	 * @param id
	 * @param bank
	 */
	public Office(String officeID, String bank) {
		this.officeID = officeID;
		this.bankID = bank;
	}

	/**
	 * Constructor for the class with this parameters
	 * 
	 * @param name
	 * @param street
	 * @param phone
	 * @param zip
	 * @param idOffice
	 */
	public Office(String address, String telephone, String postCode,
			String idOffice) {
		this.address = address;
		this.telephone = telephone;
		this.postCode = postCode;
		this.officeID = idOffice;
	}

	/**
	 * Default constructor
	 */
	public Office() {
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

	/**
	 * Returns the bankID
	 * 
	 * @return bankID
	 */
	public String getBankID() {
		return this.bankID;
	}

	/**
	 * Sets the bankID
	 * 
	 * @param bankID
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	/**
	 * Returns the account of the office
	 * 
	 * @return account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * Sets the account of the office
	 * 
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * Returns the address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Returns the balance
	 * 
	 * @return balance
	 */
	public Double getBalance() {
		return balance;
	}

	/**
	 * Sets the balance
	 * 
	 * @param balance
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * Returns the utilitiesCost
	 * 
	 * @return utilitiesCost
	 */
	public Double getUtilitiesCost() {
		return utilitiesCost;
	}

	/**
	 * Sets the utilitiesCost
	 * 
	 * @param utilitiesCost
	 */
	public void setUtilitiesCost(Double utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	/**
	 * Returns the localCost
	 * 
	 * @return localCost
	 */
	public Double getLocalCost() {
		return localCost;
	}

	/**
	 * Sets the localCost
	 * 
	 * @param localCost
	 */
	public void setLocalCost(Double localCost) {
		this.localCost = localCost;
	}

	/**
	 * Returns the employeeCost
	 * 
	 * @return employeeCost
	 */
	public Double getEmployeeCost() {
		return employeeCost;
	}

	/**
	 * Sets the employeeCost
	 * 
	 * @param employeeCost
	 */
	public void setEmployeeCost(double employeeCost) {
		this.employeeCost = round(employeeCost, 4);
	}

	/**
	 * Returns the city
	 * 
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Sets the city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Returns the postCode
	 * 
	 * @return postCode
	 */
	public String getPostCode() {
		return this.postCode;
	}

	/**
	 * Sets the postCode
	 * 
	 * @param postCode
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * Returns the telephone
	 * 
	 * @return telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Sets the telephone
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Returns the total expenses
	 * 
	 * @return total expenses
	 */
	public double getTotalExpenses() {
		double total = this.localCost + this.utilitiesCost + this.employeeCost;
		total = round(total, 4);
		return total;
	}

	/**
	 * Rounds a number to any decimals
	 * 
	 * @param number
	 *            the number to be rounded
	 * @param decimals
	 *            the number of decimal digits we want to round
	 * @return the rounded number
	 */
	public double round(double number, int decimals) {
		return Math.round(number * Math.pow(10, decimals))
				/ Math.pow(10, decimals);
	}

	/**
	 * toString method
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Address: " + address + ";");
		buffer.append("Balance: " + this.getBalance());
		buffer.append("Utilities costs: " + this.getUtilitiesCost());
		buffer.append("Local costs: " + this.getLocalCost());
		buffer.append("Employee costs: " + this.getEmployeeCost());
		return buffer.toString();
	}

}
