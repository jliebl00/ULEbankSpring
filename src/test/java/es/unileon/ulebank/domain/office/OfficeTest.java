package es.unileon.ulebank.domain.office;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OfficeTest {

	private Office office;

	@Before
	public void setUp() throws Exception {
		office = new Office("1234", "5678");
	}

	@Test
	public void testSetAndGetOfficeID() {
		String testOfficeID = "1234";
		assertEquals(testOfficeID, office.getOfficeID());
	}

	@Test
	public void testSetAndGetBankID() {
		String testBankID = "5678";
		assertEquals(testBankID, office.getBankID());
	}

	@Test
	public void testSetAndGetAddress() {
		String testAddress = "Ordonyo II";
		assertNull(office.getAddress());
		office.setAddress(testAddress);
		assertEquals(testAddress, office.getAddress());
	}

	@Test
	public void testSetAndGetBalance() {
		int testBalance = 600;
		office.setBalance(600.0);
		assertEquals(testBalance, office.getBalance(), 0);
	}

	@Test
	public void testSetAndGetEmployeeCost() {
		int testEmployeeCost = 600;
		office.setEmployeeCost(600.0);
		assertEquals(testEmployeeCost, office.getEmployeeCost(), 0);
	}

	@Test
	public void testSetAndGetLocalCost() {
		int testLocalCost = 600;
		office.setLocalCost(600.0);
		assertEquals(testLocalCost, office.getLocalCost(), 0);
	}

	@Test
	public void testSetAndGetUtilitiesCost() {
		int testUtilitiesCost = 600;
		office.setUtilitiesCost(600.0);
		assertEquals(testUtilitiesCost, office.getUtilitiesCost(), 0);
	}

	@Test
	public void testSetAndGetCity() {
		String testCity = "Leon";
		office.setCity("Leon");
		assertEquals(testCity, office.getCity());
	}

	@Test
	public void testSetAndGetPostCode() {
		String testPostCode = "24010";
		office.setPostCode("24010");
		assertEquals(testPostCode, office.getPostCode());
	}

	@Test
	public void testSetAndGetTelephone() {
		String testTelephone = "987654321";
		office.setTelephone("987654321");
		assertEquals(testTelephone, office.getTelephone());
	}

	@Test
	public void testGetTotalExpenses() {
		double localCost = 5000.0;
		double utilitiesCost = 1000.0;
		double employeeCost = 6000.0;
		double totalExpenses = localCost + utilitiesCost + employeeCost;
		office.setLocalCost(5000.0);
		office.setEmployeeCost(6000.0);
		office.setUtilitiesCost(1000.0);
		assertEquals(totalExpenses, office.getTotalExpenses(), 0);
	}

}
