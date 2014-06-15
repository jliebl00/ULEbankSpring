package es.unileon.ulebank.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.service.SimpleOfficeManager;

public class SearcherControllerTests {

	SearcherController controller;
	SimpleOfficeManager officeManager;

	@Before
	public void setUp() throws Exception {
		controller = new SearcherController();
		officeManager = new SimpleOfficeManager();
	}

	@Test
	public void testHandleRequest() throws Exception {

		officeManager.setOfficeDao(new InMemoryOfficeDao(
				new ArrayList<Office>()));
		controller.setOfficeManager(officeManager);
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("officeslist", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}

	@Test
	public void testSetAndGetOfficeManager() {
		SimpleOfficeManager officeManager = new SimpleOfficeManager();
		controller.setOfficeManager(officeManager);
		assertEquals(officeManager, controller.getOfficeManager());

	}

}
