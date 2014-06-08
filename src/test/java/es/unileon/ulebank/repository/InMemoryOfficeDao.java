package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.office.Office;

public class InMemoryOfficeDao implements OfficeDao {

	private List<Office> officeList;

	public InMemoryOfficeDao(List<Office> productList, List<Account> accountList) {
		this.officeList = productList;
	}

	public InMemoryOfficeDao(List<Office> offices) {
		// TODO Auto-generated constructor stub
	}

	public List<Office> getOfficeList() {
		return officeList;
	}

	public void saveOffice(Office off) {
	}

	public void setOffice(Office off) {
		// TODO Auto-generated method stub
		
	}

	public Office getOffice() {
		// TODO Auto-generated method stub
		return null;
	}

	public Office findOffice(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Account> getAccountList(String officeID) {
		// TODO Auto-generated method stub
		return null;
	}
}
