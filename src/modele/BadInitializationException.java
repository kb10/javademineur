package modele;


/**
 * Classe utilisée lorsque l'on souhaite définir les paramètres perso mais que ceux-ci sont incorrects.
 * @author Dorian
 *
 */
public class BadInitializationException extends Exception {
	
	/**
	 * Constructeur de l'exception.
	 * @param s	Décrit l'exception.
	 */
	public BadInitializationException(final String s) {
		super(s);
	}

}
