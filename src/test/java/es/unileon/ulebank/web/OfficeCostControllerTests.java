package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.service.SimpleOfficeManager;

public class OfficeCostControllerTests {
	@Test
	public void testHandleRequestView() throws Exception {

		OfficeCostController controller = new OfficeCostController();

		SimpleOfficeManager spm = new SimpleOfficeManager();
		spm.setOfficeDao(new InMemoryOfficeDao(new ArrayList<Office>()));

		controller.setOfficeManager(spm);
		// controller.setOfficeManager(new SimpleOfficeManager());

		ModelAndView modelAndView = controller.handleRequest(null, null);

		assertEquals("office", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());

	}

}
