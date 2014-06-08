package es.unileon.ulebank.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.domain.handler.Handler;
import es.unileon.ulebank.domain.office.Office;
import es.unileon.ulebank.domain.handler.OfficeHandler;
import es.unileon.ulebank.repository.OfficeDao;
import es.unileon.ulebank.service.OfficeManager;
import es.unileon.ulebank.service.Searcher;

@Controller
@RequestMapping(value = "/find.htm")
public class FindOfficeFormController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private OfficeManager officeManager;
	@Autowired
	private OfficeDao officeDao;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid Searcher finder, BindingResult result) {

		String idOffice = finder.getOfficeID();
		System.out.println("gj " + idOffice);
		Handler officeID = new OfficeHandler(idOffice);
		logger.info("Search office with id " + idOffice + ".");

		Map<String, Object> myModel = new HashMap<String, Object>();
		String now = (new Date()).toString();

		Office office = officeDao.findOffice(idOffice);

		myModel.put("accounts", officeDao.getAccountList(office.getIdOffice()));
		myModel.put("id", officeID);
		myModel.put("now", now);
		myModel.put("offices", this.officeManager.getOffices());
		System.out.println("oficina: " + office.toString());
		if (officeDao.getAccountList(office.getIdOffice()) != null) {
			return new ModelAndView("accounts", "model", myModel);
		} else {
			return new ModelAndView("hello", "offices", myModel);
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	protected Searcher formBackingObject(HttpServletRequest request)
			throws ServletException {
		Searcher finder = new Searcher();

		finder.setId("----");
		return finder;
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

	public OfficeManager getOfficeManager() {
		return this.officeManager;
	}
}
