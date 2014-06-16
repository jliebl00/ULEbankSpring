package es.unileon.ulebank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.domain.employee.Employee;
import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.EmployeeDao;
import es.unileon.ulebank.repository.OfficeDao;

@Component
public class SimpleOfficeManager implements OfficeManager {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Offices list
	 */
	private List<Office> offices = new ArrayList<Office>();

	/**
	 * OfficeDao
	 */
	@Autowired
	private OfficeDao officeDao;
	
	/**
	 * EmployeeDao
	 */
	@Autowired
	private EmployeeDao employeeDao;
	    

	/**
	 * Returns the offices list
	 */
	public List<Office> getOffices() {
		return officeDao.getOfficeList();
	}

	/**
	 * Sets the officeDao
	 * 
	 * @param officeDao
	 */
	public void setOfficeDao(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	/**
	 * Searches the office with that id
	 * 
	 * @param id
	 */
	public Office searchOffice(String id) {
		offices = officeDao.getOfficeList();
		Office office = null;
		int i = 0;
		boolean found = false;

		if (!offices.isEmpty()) {
			while (found == false && i < offices.size()) {

				if (offices.get(i).getOfficeID().compareTo(id) == 0) {
					found = true;
					office = offices.get(i);
				}
				i++;
			}
		}
		officeDao.setOffice(office);
		return office;
	}

	/**
	 * Modifies the employee cost of a office
	 * 
	 * @param amount
	 *            the amount
	 * @throws OfficeNotFoundException
	 */
	public void employeeCostModify(double amount)
			throws OfficeNotFoundException {

		Office office = officeDao.getOffice();
		if (office != null) {
			office.setEmployeeCost(amount);
			officeDao.saveOffice(office);
		} else
			throw new OfficeNotFoundException("Cannot find the office");
	}

	/**
	 * Returns an office
	 */
	public Office getOffice() {
		return officeDao.getOffice();
	}

	/**
	 * Changes address of an office
	 * 
	 * @param address
	 * @throws OfficeNotFoundException
	 */
	public void addressChange(String address) throws OfficeNotFoundException {
		Office office = officeDao.getOffice();
		if (office != null) {

			office.setAddress(address);
			officeDao.saveOffice(office);
		} else
			throw new OfficeNotFoundException("Cannot find the office");

	}

	/**
	 * Searches an office in the officeDao with the officeId
	 * 
	 * @param officeId
	 */
	public Office findOffice(Handler officeId) {
		return officeDao.findOffice(officeId.toString());
	}

	/**
	 * Sets the employeeDao
	 * 
	 * @param employeeDao
	 */
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/**
	 * Sets new office to an office
	 * 
	 * @param office
	 *
	 */
	public void addOffice(Office office) {
		officeDao.saveOffice(office);	
	}
	
	/**
	 * Sets new employee to an office
	 * 
	 * @param employee
	 * @throws OfficeNotFoundException 
	 * 
	 */
	public void addEmployee(Employee employee) throws OfficeNotFoundException {
		if(officeDao.findOffice(employee.getOfficeID()) != null) {
			employeeDao.saveEmployee(employee);
		} else
			throw new OfficeNotFoundException("Cannot find the office");
	}

	/**
	 * @return the list of the offices.
	 */
	public List<Employee> getAllEmployees() {
		return officeDao.getAllEmployees();
	}

	/**
	 * Modify the office of the employee
	 * 
	 * @param employeeID
	 * 			Employee to reallocate.
	 * @param newOfficeID
	 */
	public void reallocate(String employeeID, String newOfficeID) {
		Employee employee = employeeDao.getEmployee(employeeID);
		employee.setOfficeID(newOfficeID);
		employeeDao.saveEmployee(employee);
	}

}
