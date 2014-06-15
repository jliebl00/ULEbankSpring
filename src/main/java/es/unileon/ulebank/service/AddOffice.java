package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AddOffice {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private String officeID;
    private String bankID;
	private String address;
    private double balance;
    private double localCost;
    private double utilitiesCost;
	private double employeeCost;
	private String city;
    private String postCode;
    private String telephone;
    
	public String getOfficeID() {
		return officeID;
	}
	
	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}
	
	public String getBankID() {
		return bankID;
	}
	
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLocalCost() {
		return localCost;
	}

	public void setLocalCost(double localCost) {
		this.localCost = localCost;
	}

	public double getUtilitiesCost() {
		return utilitiesCost;
	}

	public void setUtilitiesCost(double utilitiesCost) {
		this.utilitiesCost = utilitiesCost;
	}

	public double getEmployeeCost() {
		return employeeCost;
	}

	public void setEmployeeCost(double employeeCost) {
		this.employeeCost = employeeCost;
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
	
}