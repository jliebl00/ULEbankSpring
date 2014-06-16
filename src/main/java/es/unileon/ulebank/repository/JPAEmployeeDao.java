package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.employee.Employee;

@Repository(value = "employeeDao")
public class JPAEmployeeDao implements EmployeeDao {

	/**
	 * EntityManager
	 */
    private EntityManager entityManager = null;

    /**
	 * Sets the entity manager
	 * 
	 * @param em
	 */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.entityManager = em;
    }

    /**
	 * Returns the list of employees in the database
	 * 
	 * @return list of employees
	 */
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployeeList() {
        return entityManager.createQuery("select e from Employee e order by e.employeeID").getResultList();
    }

    /**
	 * Saves an employee in the database
	 * 
	 * @param employee
	 */
    @Transactional(readOnly = false)
    public void saveEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    /**
     * 
     * @param employeeID
     * @return the employee who have this NIF
     */
    @Transactional(readOnly = true)
    public Employee getEmployee(String employeeID) {
		employeeID = employeeID.trim();
		return (Employee) entityManager.createQuery("select e from Employee e where e.employeeID='"+employeeID+"'").getResultList().get(0);
	}

}