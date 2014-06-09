package es.unileon.ulebank.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.service.SimpleOfficeManager;
import es.unileon.ulebank.repository.InMemoryOfficeDao;
import es.unileon.ulebank.domain.office.Office;

public class OfficesControllerTests {

	@Test
	public void testHandleRequestView() throws Exception {

		OfficesController controller = new OfficesController();
		SimpleOfficeManager spm = new SimpleOfficeManager();
		spm.setOfficeDao(new InMemoryOfficeDao(new ArrayList<Office>()));
		controller.setOfficeManager(spm);
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("officeslist", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);

	}

}