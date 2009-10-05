package modele;

/**
 * 
 * @author Dorian Langlais
 *
 */
public class BadCoordonneeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * @param s description de l'erreur.
	 */
	public BadCoordonneeException(final String s) {
		super(s);
	}
}
