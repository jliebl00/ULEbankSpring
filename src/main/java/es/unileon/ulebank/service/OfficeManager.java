package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.domain.handler.Handler;

/**
 * 
 * @author Patricia
 *
 */
public interface OfficeManager extends Serializable {

	/**
	 * Searchs an office
	 * 
	 * @param id
	 * @return office
	 */
	public Office searchOffice(String id);

	/**
	 * Returns the list of offices
	 * 
	 * @return the list of offices
	 */
	public List<Office> getOffices();

	/**
	 * Modifies the employeeCost
	 * 
	 * @param amount
	 * @throws OfficeNotFoundException 
	 */
	public void employeeCostModify(double amount) throws OfficeNotFoundException;

	/**
	 * Returns an office
	 * 
	 * @return office
	 */
	public Office getOffice();

	/**
	 * Returns the account list of an office
	 * 
	 * @param officeID
	 * @return the list of accounts
	 */
	public List<Account> getAccountList(Handler officeID);

	/**
	 * Finds an office
	 * 
	 * @param id
	 * @return office
	 */
	public Office findOffice(Handler id);
	
	/**
	 * Sets new address to an office
	 * @param address
	 * @throws OfficeNotFoundException 
	 */
	public void addressChange(String address) throws OfficeNotFoundException;
}
