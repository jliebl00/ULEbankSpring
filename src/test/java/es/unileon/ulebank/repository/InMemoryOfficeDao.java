package es.unileon.ulebank.repository;

import java.util.ArrayList;
import java.util.List;

import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.employee.Employee;
import es.unileon.ulebank.domain.office.Office;

public class InMemoryOfficeDao implements OfficeDao {

	private List<Office> officeList;
	private List<Account> accountList;
	private Office office;

	public InMemoryOfficeDao(List<Office> productList, List<Account> accountList) {
		this.officeList = productList;
		this.accountList = accountList;
	}

	public InMemoryOfficeDao(List<Office> offices) {
	}

	public List<Office> getOfficeList() {
		return officeList;
	}

	public void saveOffice(Office off) {
	}

	public void setOffice(Office off) {
		this.office = off;
	}

	public Office getOffice() {
		return this.office;
	}

	public Office findOffice(String id) {
		Office office = null;
		int count = 0;
		while(count < this.getOfficeList().size()){
			if(this.getOfficeList().get(count).getOfficeID().compareTo(id)==0){
				office = this.getOfficeList().get(0);
			}
			count++;
		}
		return office;
	}

	public List<Account> getAccountList() {
		return this.accountList;
	}

	public void setOfficeList(List<Office> officeList) {
		this.officeList = officeList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public List<Account> getAccountListOfOffice(String officeID) {
		System.out.println("el id: "+officeID);
		ArrayList<Account> accounts = new ArrayList<Account>();
		int count = 0;
		while(count < this.getAccountList().size()){
			if(this.getAccountList().get(count).getOfficeID().compareTo(officeID)==0){
				accounts.add(this.getAccountList().get(count));
			}
			count++;
		}
		return accounts;
	}

	public List<Employee> getEmployeeList(String officeID) {
		// TODO Auto-generated method stub
		return null;
	}
}