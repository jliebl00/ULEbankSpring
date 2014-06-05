package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.domain.office.*;
/**
 * 
 * @author patricia
 *
 */
@Repository(value = "officeDao")
public class JPAOfficeDao implements OfficeDao {

    private EntityManager em = null;
    private Office office;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Office> getOfficeList() {
        return em.createQuery("select p from Office p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveOffice(Office off) {
        em.merge(off);
    }

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
    
    

}