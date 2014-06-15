package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class BrokerageControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		BrokerageController controller = new BrokerageController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("brokerage", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}