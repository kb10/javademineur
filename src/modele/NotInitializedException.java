package modele;

/**
 * Classe utilisée lorsque l'on souhaite créer une grille de niveau Perso, mais que Perso n'a pas été défini.
 * @author Dorian
 *
 */
public class NotInitializedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5048248206016795399L;

	/**
	 * Constructeur de l'exception.
	 * @param s Décrit l'exception.
	 */
	public NotInitializedException(final String s) {
		super(s);
	}
}
