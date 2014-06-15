package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AddressChange {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private String address;

	public void setAddress(String i) {
		address = i;
		logger.info("Address set to " + i);
	}

	public String getAddress() {
		return address;
	}
}