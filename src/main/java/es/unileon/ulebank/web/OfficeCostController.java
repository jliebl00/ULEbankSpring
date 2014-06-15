package es.unileon.ulebank.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.service.OfficeManager;

/**
 * Class that handles requests to the page that shows information about one
 * office
 * 
 */
@Controller
public class OfficeCostController {
	private static final Log LOGGER = LogFactory
			.getLog(OfficeCostController.class.getName());
	@Autowired
	private OfficeManager officeManager;

	@RequestMapping(value = "/office.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("office", this.officeManager.getOffice());
		LOGGER.info("Returning office view");
		return new ModelAndView("office", "model", model);
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

}
