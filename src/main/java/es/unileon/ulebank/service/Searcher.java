package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author patricia
 *
 */
public class Searcher {

	/** Logger for this class and subclasses */
	private static final Log LOGGER = LogFactory.getLog(Searcher.class
			.getName());

	private String address;
	private String id;
	private String officeID;

	public String getOfficeID() {
		return officeID;
	}

	public void setOfficeID(String officeID) {
		this.officeID = officeID;
		LOGGER.info("Officeid set to " + officeID);
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
		LOGGER.info("Address set to " + address);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		LOGGER.info("Id set to " + id);
	}

}
