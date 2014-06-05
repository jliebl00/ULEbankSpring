package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;
import es.unileon.ulebank.domain.office.*;
/**
 * 
 * @author patricia
 *
 */
public interface OfficeManager extends Serializable {

	public Office searchOffice(String id);

	public List<Office> getOffices();
	
	public void employeeCostModify(double amount);	
	
	public Office getOffice();
}
