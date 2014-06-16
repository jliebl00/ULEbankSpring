package es.unileon.ulebank.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChangeOffice {
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    private String officeID;
    private String employeeID;
    
	public String getOfficeID() {
		return officeID;
	}
	
	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}    
    
}
