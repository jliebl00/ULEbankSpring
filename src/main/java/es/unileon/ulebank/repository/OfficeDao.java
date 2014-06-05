package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.office.*;
/**
 * 
 * @author patricia
 *
 */
public interface OfficeDao {

    public List<Office> getOfficeList();

    public void saveOffice(Office off);	
    
    public void setOffice(Office off);
    
    public Office getOffice();

}