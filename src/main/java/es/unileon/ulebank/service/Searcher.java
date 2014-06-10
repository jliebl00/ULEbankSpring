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

	/**
	 * The id
	 */
	private String id;
	/**
	 * The id of the office
	 */
	private String officeID;

	/**
	 * Returns the officeID
	 * 
	 * @return officeID
	 */
	public String getOfficeID() {
		return officeID;
	}

	/**
	 * Sets the officeID
	 * 
	 * @param officeID
	 */
	public void setOfficeID(String officeID) {
		this.officeID = officeID;
		LOGGER.info("Officeid set to " + officeID);
	}

	/**
	 * Returns the id
	 * 
	 * @return id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
		LOGGER.info("Id set to " + id);
	}

}
