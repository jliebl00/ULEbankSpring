package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class PaymentsControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		PaymentsController controller = new PaymentsController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("payments", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}