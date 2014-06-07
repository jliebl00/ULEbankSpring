package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.office.Office;


public interface OfficeDao {

    public List<Office> getOfficeList();

    public void saveOffice(Office off);	
    
    public void setOffice(Office off);
    
    public Office getOffice();
    
    public Office findOffice(String id);
	
	public List<Account> getAccountList(String officeID);

}