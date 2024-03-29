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

@Controller
public class OfficesController {

	private static final Log LOGGER = LogFactory.getLog(OfficesController.class
			.getName());
	@Autowired
	private OfficeManager officeManager;

	@RequestMapping(value = "/officeslist.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		LOGGER.info("Returning officeslist view");

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("offices", this.officeManager.getOffices());

		return new ModelAndView("officeslist", "model", myModel);
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}
}