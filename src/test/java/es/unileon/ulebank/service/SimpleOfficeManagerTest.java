package es.unileon.ulebank.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.domain.account.Account;
import es.unileon.ulebank.domain.handler.OfficeHandler;
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

		Office office = new Office();

		office.setIdOffice("1234");
		office.setBankID("2104");
		office.setAddress("Nocedo");
		offices.add(office);

		Office office2 = new Office();

		office2.setIdOffice("2345");
		office2.setBankID("2104");
		office2.setAddress("Padre Isla");
		offices.add(office2);

		Account account1 = new Account();
		account1.setAccountID("0024");
		account1.setOfficeID("1234");
		accounts.add(account1);

		Account account2 = new Account();
		account2.setAccountID("0025");
		account2.setOfficeID("1234");
		accounts.add(account2);

		Account account3 = new Account();
		account3.setAccountID("0026");
		account3.setOfficeID("2345");
		accounts.add(account3);

		OfficeDao officeDao = new InMemoryOfficeDao(offices, accounts);
		officeManager.setOfficeDao(officeDao);
		// officeManager.setOffices(offices);

	}

	@Test
	public void testGetOfficesWithNoOffices() {
		officeManager = new SimpleOfficeManager();
		officeManager.setOfficeDao(new InMemoryOfficeDao(null, null));
		assertNull(officeManager.getOffices());
	}

	@Test
	public void testGetOffices() {
		List<Office> offices = officeManager.getOffices();
		assertNotNull(offices);
		assertEquals(officeManager.getOffices().size(), 2);

		Office office = offices.get(0);
		assertEquals(office.getIdOffice(), "1234");

		Office office2 = offices.get(1);
		assertEquals(office2.getIdOffice(), "2345");
	}

	@Test
	public void testGetAccounts() {

		OfficeDao officeDao = new InMemoryOfficeDao(offices, accounts);
		Office office = new Office();
		office.setIdOffice("1234");

		OfficeHandler officeID = new OfficeHandler("1234");
		// officeManager.getAccountList(officeID)
		Account account1 = new Account();
		account1.setAccountID("0024");
		account1.setOfficeID("1234");
		// accounts.add(account1);

		officeDao.setOffice(office);

		officeManager.setOfficeDao(officeDao);

		// List<Account> accounts1 = officeManager.getAccountList(officeID);
		assertNotNull(officeManager.getAccountList(new OfficeHandler("1234")));

		offices = officeDao.getOfficeList();
		accounts = officeDao.getAccountList("1234");

		assertEquals(officeDao.getAccountList(officeID.toString()).size(), 3);
		;
	}

	@Test
	public void testfindOffice() {
		OfficeHandler officeID = new OfficeHandler("1234");
		try {
			officeManager = new SimpleOfficeManager();
			officeManager.setOfficeDao(new InMemoryOfficeDao(null, null));

			officeManager.findOffice(officeID);
		} catch (Exception ex) {
			fail("Office list is empty.");
		}
	}

}
