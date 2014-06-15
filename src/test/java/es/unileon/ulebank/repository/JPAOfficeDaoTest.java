package es.unileon.ulebank.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.domain.office.Office;

public class JPAOfficeDaoTest {

	private ApplicationContext context;
	private OfficeDao officeDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml");
		officeDao = (OfficeDao) context.getBean("officeDao");
	}

	@Test
	public void testGetOfficeList() {

		List<Office> offices = officeDao.getOfficeList();
		assertEquals(offices.size(), 3, 0);
	}

	@Test
	public void testGetOffice() {
		Office office = officeDao.getOffice();
		assertNull(office);

	}

	@Test
	public void testSaveOffice() {
		List<Office> offices = officeDao.getOfficeList();

		Office p = offices.get(0);
		Double balance = p.getBalance();
		p.setBalance(200.0);
		officeDao.saveOffice(p);

		List<Office> updatedOffices = officeDao.getOfficeList();
		Office p2 = updatedOffices.get(0);
		assertEquals(p2.getBalance(), 200.0, 0);

		p2.setBalance(balance);
		officeDao.saveOffice(p2);
	}
}