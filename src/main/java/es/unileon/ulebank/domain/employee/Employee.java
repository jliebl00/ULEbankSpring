package es.unileon.ulebank.domain.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import es.unileon.ulebank.domain.handler.DNIHandler;
import es.unileon.ulebank.domain.handler.Handler;

@Entity
@Table(name="employee") 
public class Employee {

	/**
	 * Name of the employee
	 */
	private String name;
	/**
	 * Surname of the employee
	 */
	private String surname;
	/**
	 * Surname of the employee
	 */
	private String address;
	/**
	 * Salary of the employee
	 */
	private float salary;
	/**
	 * Office which belong
	 */
	private String officeID;
	/**
	 * Identifier of the employee
	 */
	@Id
    @Column(name = "employeeID")
	private String employeeID;
	
	
	public Employee(){
		
	}

	/**
	 * Create a new employee with all data
	 * 
	 * @param name
	 *            his/her name
	 * @param surname
	 *            his/her surname
	 * @param officeID
	 *            the office, can be null
	 * @param dniEmployee
	 *            the identifier of the employee
	 */
	public Employee(String name, String surname, String address, float salary,
			String officeID, String dniEmployee) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.salary = salary;
		this.officeID = officeID;
		Handler idEmployee = new DNIHandler(dniEmployee);
		this.employeeID = dniEmployee;
	}

	/**
	 * Create a new employee without office
	 * 
	 * @param name
	 *            his/her name
	 * @param surname
	 *            his/her surname
	 * @param salary
	 *            his/her salary
	 * @param idEmployee
	 *            the identifier of the employee
	 */
	public Employee(String name, String surname, String address, float salary,
			String idEmployee) {
		this(name, surname, address, salary, null, idEmployee);
	}

	/**
	 * Get the identifier(NIF) of the employee
	 * 
	 * @return the employee's identifier
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * change the identifier(NIF) of the employee
	 * 
	 * @param name
	 *            the new identifier(NIF)
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * Get the name of the employee
	 * 
	 * @return the employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * change the name of the employee
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		if (name != null) {
			if (name.length() > 0) {
				this.name = name;
			}
		}
	}

	/**
	 * Get the surname of the employee
	 * 
	 * @return the employee's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Change the surname of the employee
	 * 
	 * @param surname
	 *            the new surname
	 */
	public void setSurname(String surname) {
		if (surname != null) {
			if (surname.length() > 0) {
				this.surname = surname;
			}
		}
	}

	/**
	 * Returns the address of the employee
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address of the employee
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get the salary of the employee
	 * 
	 * @return the employee's salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * Change the salary of the employee
	 * 
	 * @param salary
	 *            the new salary
	 */
	public void setSalary(float salary) {
		if (salary > 0) {
			this.salary = salary;
		}
	}

	/**
	 * Get the the office where the employee works
	 * 
	 * @return the office or null if not exists
	 */
	public String getOfficeID() {
		return officeID;
	}

	/**
	 * Set the office
	 * 
	 * @param idOffice
	 */
	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}

	/**
	 * Tell if this employee is an admin
	 * 
	 * @return true if is an admin
	 */
	public boolean isAdmin() {
		return false;
	}


}
