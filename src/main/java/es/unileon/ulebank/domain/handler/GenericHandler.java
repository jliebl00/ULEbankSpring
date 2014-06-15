package es.unileon.ulebank.domain.handler;


public class GenericHandler implements Handler {

	/**
	 * Generic id
	 */
	private final String id;

	/**
	 * Creates a new Generic Handler
	 *
	 * @param id
	 *            (The id)
	 * @author runix
	 */
	public GenericHandler(String id) {
		this.id = id;
	}

	public int compareTo(Handler another) {
		return this.id.compareTo(another.toString());
	}

	/**
	 * toString method
	 * 
	 * @return the id
	 */
	@Override
	public String toString() {
		return this.id;
	}

}
