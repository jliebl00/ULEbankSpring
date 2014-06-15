package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class AccountsControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		AccountsController controller = new AccountsController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("accounts", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}