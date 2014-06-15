package es.unileon.ulebank.web;

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

import es.unileon.ulebank.domain.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.service.EmployeeCostModify;
import es.unileon.ulebank.service.OfficeManager;

/**
 * Class handles requests to the page that changes the employee cost called
 * costmodify
 * 
 */
@Controller
@RequestMapping(value = "/costmodify.htm")
public class EmployeeCostModifyFormController {

	/** Logger for this class and subclasses */
	private static final Log LOGGER = LogFactory
			.getLog(EmployeeCostModifyFormController.class.getName());

	@Autowired
	private OfficeManager officeManager;

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid EmployeeCostModify employeeCostModify,
			BindingResult result) throws OfficeNotFoundException {
		if (result.hasErrors()) {
			return "costmodify";
		}

		double amount = employeeCostModify.getAmount();
		LOGGER.info("Modifiying employee cost to " + amount + "E.");

		officeManager.employeeCostModify(amount);

		return "redirect:/office.htm";
	}

	@RequestMapping(method = RequestMethod.GET)
	protected EmployeeCostModify formBackingObject(HttpServletRequest request)
			throws ServletException {
		EmployeeCostModify employeeCostModify = new EmployeeCostModify();
		employeeCostModify.setAmount(0);
		return employeeCostModify;
	}

	/**
	 * Method that sets the office manager
	 * 
	 * @param officeManager
	 *            the office manager
	 */
	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

	/**
	 * Method that returns the office manager
	 * 
	 * @return the office manager
	 */
	public OfficeManager getOfficeManager() {
		return officeManager;
	}

}
