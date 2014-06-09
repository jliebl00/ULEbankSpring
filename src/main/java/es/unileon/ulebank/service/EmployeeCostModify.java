package es.unileon.ulebank.service;

import javax.validation.constraints.Min;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Class that represents a modification in the employee costs
 * 
 * @author rut
 * 
 */
public class EmployeeCostModify {
	/** Logger for this class and subclasses */
	private static final Log logger = LogFactory
			.getLog(EmployeeCostModify.class.getName());

	@Min(0)
	private double amount;

	/**
	 * Sets the amount
	 * 
	 * @param i
	 *            the amount
	 */
	public void setAmount(double i) {
		amount = i;
		logger.info(" Employee Cost set to " + i);
	}

	/**
	 * Returns the amount
	 * 
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

}
