package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class LiabilitiesControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		LiabilitiesController controller = new LiabilitiesController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("liabilities", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}