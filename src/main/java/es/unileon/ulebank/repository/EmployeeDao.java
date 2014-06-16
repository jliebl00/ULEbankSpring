package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.employee.Employee;

public interface EmployeeDao {

	/**
	 * Returns the employee list
	 * 
	 * @return the employee list
	 */
    public List<Employee> getEmployeeList();

    /**
	 * Saves an employee in the database
	 * 
	 * @param employee
	 */
    public void saveEmployee(Employee employee);
    
    /**
     * 
     * @param employeeID
     * @return the employee who have this NIF
     */
    public Employee getEmployee(String employeeID);
	
}

