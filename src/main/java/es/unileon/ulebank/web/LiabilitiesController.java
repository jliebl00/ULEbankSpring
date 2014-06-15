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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.OfficeDao;
import es.unileon.ulebank.service.OfficeManager;

@Controller
public class LiabilitiesController {

	/** Logger for this class and subclasses */
	private static final Log LOGGER = LogFactory
			.getLog(LiabilitiesController.class.getName());
	@Autowired
	private OfficeManager officeManager;

	@Autowired
	private OfficeDao officeDao;

	@RequestMapping(value = "/liabilities.htm", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		LOGGER.info("Returning liabilities view");

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);

		return new ModelAndView("liabilities", "model", myModel);
	}

	@RequestMapping(value = "/liabilitiesofficeslist.htm", method = RequestMethod.GET)
	public ModelAndView showOfficesList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		LOGGER.info("Returning officeslist view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("offices", this.officeManager.getOffices());

		return new ModelAndView("liabilitiesofficeslist", "model", myModel);

	}

	@RequestMapping(value = "/liabilitiesoffice.htm", method = RequestMethod.GET)
	public ModelAndView onSubmit(HttpServletRequest request) {

		String id = request.getParameter("officeID");

		if (id.equals("") || id == null) {

			String now = (new Date()).toString();
			LOGGER.info("Returning liabilitiesofficeslist view with " + now);

			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("now", now);
			myModel.put("offices", this.officeManager.getOffices());

			return new ModelAndView("liabilitiesofficeslist", "model", myModel);
		} else {
			LOGGER.info("Search office with id " + id + ".");

			Office office = this.officeManager.searchOffice(id);
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("office", office);

			if (office != null) {
				LOGGER.info("Returning liabilitiesoffice view");
				return new ModelAndView("liabilitiesoffice", "model", model);
			} else {

				String now = (new Date()).toString();
				LOGGER.info("Returning liabilitiesofficeslist view with " + now);

				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("now", now);
				myModel.put("offices", this.officeManager.getOffices());

				return new ModelAndView("liabilitiesofficeslist", "model",
						myModel);
			}

		}
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

	public OfficeManager getOfficeManager() {
		return officeManager;
	}
}
