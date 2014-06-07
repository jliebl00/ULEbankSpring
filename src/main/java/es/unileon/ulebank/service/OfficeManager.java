package es.unileon.ulebank.service;

import java.io.Serializable;
import java.util.List;

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.handler.Handler;



public interface OfficeManager extends Serializable {

	public Office searchOffice(String id);

	public List<Office> getOffices();
	
	public void employeeCostModify(double amount);	
	
	public Office getOffice();
	
	public List<Account> getAccountList(Handler officeID);
	
	public Office findOffice(Handler id);

	

}
