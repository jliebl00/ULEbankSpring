package es.unileon.ulebank.domain.handler;

/**
 * Handler pattern.
 * 
 * @author runix
 */
public interface Handler {

	/**
	 * Compare the actual handler with another
	 *
	 * @param another
	 *            ( Handler to compare )
	 * @return (0 if are equals, != 0 otherwise )
	 */
	public int compareTo(Handler another);

	/**
	 * toString method
	 */
	@Override
	public String toString();
}
