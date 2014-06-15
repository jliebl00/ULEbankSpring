package es.unileon.ulebank.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class AssetsControllerTest {

	@Test
	public void testHandleRequestView() throws Exception {

		AssetsController controller = new AssetsController();
		
		ModelAndView modelAndView = controller.handleRequest(null, null);
		
		assertEquals("assets", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
	
	}

}