package es.unileon.ulebank.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Patricia
 *
 */
@Controller
public class PaymentsController {
	private static final Log LOGGER = LogFactory.getLog(StartController.class
			.getName());

	@RequestMapping(value = "/payments.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		LOGGER.info("Returning payments view");

		// Cambiar el modelo para lo que queráis mostrar.
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);

		return new ModelAndView("payments", "model", myModel);
	}
}
