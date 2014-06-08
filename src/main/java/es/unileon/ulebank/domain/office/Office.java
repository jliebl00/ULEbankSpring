package es.unileon.ulebank.domain.office;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author patricia
 *
 */
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

	@Column(name = "bankID")
	private String bankID;

	/**
	 * The address of the office
	 */

	private String address;
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
	private String city;
	private String postCode;
	private String telephone;

	public String getIdOffice() {
		return officeID;
	}

	public void setIdOffice(String idOffice) {
		this.officeID = idOffice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getUtilitiesCost() {
		return utilitiesCost;
	}

	public void setUtilitiesCost(Double utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	public Double getLocalCost() {
		return localCost;
	}

	public void setLocalCost(Double localCost) {
		this.localCost = localCost;
	}

	public Double getEmployeeCost() {
		return employeeCost;
	}

	/**
	 * Sets the cost of employees
	 * 
	 * @param employeeCost
	 *            the amount to set
	 */
	public void setEmployeeCost(double employeeCost) {
		this.employeeCost = round(employeeCost, 4);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
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
