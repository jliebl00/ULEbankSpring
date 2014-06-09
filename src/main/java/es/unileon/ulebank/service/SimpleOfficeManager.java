package es.unileon.ulebank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.OfficeDao;

@Component
public class SimpleOfficeManager implements OfficeManager {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Offices list
	 */
	private List<Office> offices = new ArrayList<Office>();

	/**
	 * OfficeDao
	 */
	@Autowired
	private OfficeDao officeDao;

	/**
	 * Returns the offices list
	 */
	public List<Office> getOffices() {
		return officeDao.getOfficeList();
	}

	/**
	 * Sets the officeDao
	 * 
	 * @param officeDao
	 */
	public void setOfficeDao(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	/**
	 * Searches the office with that id
	 * 
	 * @param id
	 */
	public Office searchOffice(String id) {
		offices = officeDao.getOfficeList();
		Office office = null;
		int i = 0;
		boolean found = false;

		if (!offices.isEmpty()) {
			while (found == false && i < offices.size()) {

				if (offices.get(i).getIdOffice().compareTo(id) == 0) {
					found = true;
					office = offices.get(i);
				}
				i++;
			}
		}
		officeDao.setOffice(office);
		return office;
	}

	/**
	 * Modifies the employee cost of a office
	 * 
	 * @param amount
	 *            the amount
	 */
	public void employeeCostModify(double amount) {

		Office office = officeDao.getOffice();
		if (office != null) {
			office.setEmployeeCost(amount);
			officeDao.saveOffice(office);
		}
	}

	/**
	 * Returns an office
	 */
	public Office getOffice() {
		return officeDao.getOffice();
	}

	public List<Account> getAccountList(Handler officeID) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Searches an office in the officeDao with the officeId
	 * 
	 * @param officeId
	 */
	public Office findOffice(Handler officeId) {
		return officeDao.findOffice(officeId.toString());
	}

}
