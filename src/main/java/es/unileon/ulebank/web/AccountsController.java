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

import es.unileon.ulebank.repository.OfficeDao;
import es.unileon.ulebank.service.OfficeManager;

@Controller
public class AccountsController {
	private static final Log LOGGER = LogFactory
			.getLog(AccountsController.class.getName());
	@Autowired
	private OfficeManager officeManager;

	@Autowired
	private OfficeDao officeDao;

	@RequestMapping(value = "/accounts.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> model = new HashMap<String, Object>();

		model.put("accounts", officeDao.getAccountListOfOffice(this.officeManager
 				.getOffice().getOfficeID()));
		LOGGER.info("Returning accounts view");
		return new ModelAndView("accounts", "model", model);
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

}
