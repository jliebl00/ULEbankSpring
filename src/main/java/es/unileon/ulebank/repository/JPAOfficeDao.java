package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.employee.Employee;
import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.office.Office;

@Repository(value = "officeDao")
public class JPAOfficeDao implements OfficeDao {

	/**
	 * EntityManager
	 */
	private EntityManager entityManager = null;
	/**
	 * Office
	 */
	private Office office;

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
	 * Returns the list of offices in the database
	 * 
	 * @return list of offices
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Office> getOfficeList() {
		return entityManager.createQuery(
				"select p from Office p order by p.officeID").getResultList();
	}

	/**
	 * Saves an office in the database
	 * 
	 * @param off
	 */
	@Transactional(readOnly = false)
	public void saveOffice(Office off) {
		entityManager.merge(off);
	}

	/**
	 * Returns an office
	 * 
	 * @return office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * Sets an office
	 * 
	 * @param office
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * Finds the office
	 * 
	 * @param id
	 * @return office
	 */
	@Transactional(readOnly = true)
	public Office findOffice(String id) {

		return (Office) entityManager
				.createQuery("select o from Office o where o.officeID=" + id)
				.getResultList().get(0);
	}

	/**
	 * Returns the list of accounts of an office
	 * 
	 * @param officeID
	 * @return the list of accounts
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Account> getAccountListOfOffice(String officeID) {

		return entityManager.createQuery(
				"select a from Account a where a.officeID=" + officeID)
				.getResultList();
	}
	
	/**
	 * Returns the list of employees of an office
	 * 
	 * @param officeID
	 * @return the list of employees
	 */
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployeeList(String officeID) {
        return entityManager.createQuery("select e from Employee e where e.officeID=" + officeID).getResultList();
    }

    /**
     * 
     * @return the list of all employees in the database.
     */
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees(){
		return entityManager.createQuery("select e from Employee e order by e.officeID").getResultList();
	}

}