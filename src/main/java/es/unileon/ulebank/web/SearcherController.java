package es.unileon.ulebank.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.repository.OfficeDao;
import es.unileon.ulebank.service.OfficeManager;
import es.unileon.ulebank.service.Searcher;

/**
 * 
 * @author Patricia
 *
 */
@Controller
public class SearcherController {

	/** Logger for this class and subclasses */
	private static final Log LOGGER = LogFactory
			.getLog(SearcherController.class.getName());
	@Autowired
	private OfficeManager officeManager;

	@Autowired
	private OfficeDao officeDao;

	@RequestMapping(value = "/searcher.htm", method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid Searcher searcher, BindingResult result)
			throws OfficeNotFoundException {

		String id = searcher.getId();

		if (id.equals("") || id == null) {

			String now = (new Date()).toString();
			LOGGER.info("Returning officeslist view with " + now);

			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("now", now);
			myModel.put("offices", this.officeManager.getOffices());

			return new ModelAndView("officeslist", "model", myModel);
		} else {
			LOGGER.info("Search office with id " + id + ".");

			Office office = this.officeManager.searchOffice(id);
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("office", office);

			if (office != null) {
				return new ModelAndView("office", "model", model);
			} else {

				String now = (new Date()).toString();
				LOGGER.info("Returning officeslist view with " + now);

				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("now", now);
				myModel.put("offices", this.officeManager.getOffices());

				return new ModelAndView("officeslist", "model", myModel);
			}

		}
	}

	@RequestMapping(value = "/searcher.htm", method = RequestMethod.GET)
	protected Searcher formBackingObject(HttpServletRequest request)
			throws ServletException {
		Searcher searcher = new Searcher();
		searcher.setId("Enter office id");
		return searcher;
	}

	@RequestMapping(value = "/officeslist.htm", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		LOGGER.info("Returning officeslist view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("offices", this.officeManager.getOffices());

		return new ModelAndView("officeslist", "model", myModel);
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

	public OfficeManager getOfficeManager() {
		return officeManager;
	}
}
