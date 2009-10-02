package modele;


/**
 * Classe utilisée lorsque l'on souhaite définir les paramètres perso mais que ceux-ci sont incorrects.
 * @author Dorian
 *
 */
public class BadInitializationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de l'exception.
	 * @param s	Décrit l'exception.
	 */
	public BadInitializationException(final String s) {
		super(s);
	}

}
