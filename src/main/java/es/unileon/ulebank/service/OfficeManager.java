package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.employee.Employee;
import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.EmployeeDao;

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
	public void employeeCostModify(double amount)
			throws OfficeNotFoundException;

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
	 * @return office
	 */
	public Office findOffice(Handler id);

	/**
	 * Sets new address to an office
	 * 
	 * @param address
	 * @throws OfficeNotFoundException
	 */
	public void addressChange(String address) throws OfficeNotFoundException;

	/**
	 * Sets the employeeDao
	 * 
	 * @param employeeDao
	 */
	public void setEmployeeDao(EmployeeDao employeeDao);

	/**
	 * Add employee
	 * 
	 * @param employee
	 * @throws OfficeNotFoundException 
	 */
	public void addEmployee(Employee employee) throws OfficeNotFoundException;
	
	/**
	 * 
	 * @return a list with all employees in the database.
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * Reallocate a employee into the new office.
	 * 
	 * @param employee employee to reallocate
	 * @param newOfficeID
	 */
	public void reallocate(String employee, String newOfficeID);

}
