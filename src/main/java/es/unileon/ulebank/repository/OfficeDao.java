package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.employee.Employee;
import es.unileon.ulebank.domain.office.Office;

public interface OfficeDao {
	
	/**
	 * Returns the office list
	 * 
	 * @return the office list
	 */
	public List<Office> getOfficeList();

	/**
	 * Saves an office in the database
	 * 
	 * @param off
	 */
	public void saveOffice(Office off);

	/**
	 * Sets an office
	 * 
	 * @param off
	 */
	public void setOffice(Office off);

	/**
	 * Returns an office
	 * 
	 * @return office
	 */
	public Office getOffice();

	/**
	 * Finds an office
	 * 
	 * @param id
	 * @return
	 */
	public Office findOffice(String id);

	/**
	 * Returns the list of accounts of an office
	 * 
	 * @param officeID
	 * @return the list of accounts
	 */
	public List<Account> getAccountListOfOffice(String officeID);
	
	/**
	 * Returns the employee list
	 * 
	 * @return the employee list
	 */
	public List<Employee> getEmployeeList(String officeID);

}