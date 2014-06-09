package es.unileon.ulebank.domain.account;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Patricia
 *
 */
public class AccountTests {

	private Account account1;
	private Account account2;

	@Before
	public void setUp() throws Exception {
		account1 = new Account("1234");
		account2 = new Account();
	}

	@Test
	public void testGetAccountID() {
		assertEquals(account1.getAccountID(), "1234");
	}

	@Test
	public void testSetAccountID() {
		account2.setAccountID("5678");
		assertEquals(account2.getAccountID(), "5678");
	}

	@Test
	public void testSetAndGetOfficeID() {
		account1.setOfficeID("7654");
		account2.setOfficeID("1234");
		assertEquals(account1.getOfficeID(), "7654");
		assertEquals(account2.getOfficeID(), "1234");
	}
}
