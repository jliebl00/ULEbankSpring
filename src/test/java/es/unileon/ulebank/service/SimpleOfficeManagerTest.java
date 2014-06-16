package es.unileon.ulebank.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.repository.OfficeDao;

public class SimpleOfficeManagerTest {

	private SimpleOfficeManager officeManager;

	private List<Office> offices;

	private List<Account> accounts;

	@Before
	public void setUp() throws Exception {

		officeManager = new SimpleOfficeManager();
		offices = new ArrayList<Office>();
		accounts = new ArrayList<Account>();
		// stub up a list of offices

		Office office = new Office("1234", "2104");
		office.setAddress("Nocedo");
		offices.add(office);

		Office office2 = new Office("2345", "2104");

		office2.setAddress("Padre Isla");
		offices.add(office2);

		Account account1 = new Account("0123");
		account1.setAccountID("0024");
		account1.setOfficeID("1234");
		accounts.add(account1);

		Account account2 = new Account("4567");
		account2.setAccountID("0025");
		account2.setOfficeID("1234");
		accounts.add(account2);

		Account account3 = new Account("8910");
		account3.setAccountID("0026");
		account3.setOfficeID("2345");
		accounts.add(account3);

		OfficeDao officeDao = new InMemoryOfficeDao(offices, accounts, null);
		officeManager.setOfficeDao(officeDao);
	}

	@Test
	public void testGetOfficesWithNoOffices() {
		officeManager = new SimpleOfficeManager();
		officeManager.setOfficeDao(new InMemoryOfficeDao(null, null, null));
		assertNull(officeManager.getOffices());
	}

	@Test
	public void testGetOffices() {
		List<Office> offices = officeManager.getOffices();
		assertNotNull(offices);
		assertEquals(officeManager.getOffices().size(), 2);

		Office office = offices.get(0);
		assertEquals(office.getOfficeID(), "1234");

		Office office2 = offices.get(1);
		assertEquals(office2.getOfficeID(), "2345");
	}

	@Test
	public void testGetEmptyOffice() {
		officeManager = new SimpleOfficeManager();
		officeManager.setOfficeDao(new InMemoryOfficeDao(null, null, null));
	}

	@Test(expected = OfficeNotFoundException.class)
	public void testModifyCostWithNullOffice() throws OfficeNotFoundException {
		officeManager = new SimpleOfficeManager();
		officeManager.setOfficeDao(new InMemoryOfficeDao(null));
		officeManager.employeeCostModify(200.00);
	}

	@Test
	public void testModifyCost() throws OfficeNotFoundException {
		Office office = officeManager.searchOffice("1234");
		office.setEmployeeCost(400.00);
		assertEquals(400.00, office.getEmployeeCost(), 0);
		officeManager.employeeCostModify(500.00);
	}
}
