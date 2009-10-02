package modele;

/**
 * Classe permettant de gérer les coordonnées des coups.
 * @author Dorian Langlais
 *
 */
public class Coordonnee {
	/**
	 * Abscisse.
	 */
	private int x;
	/**
	 * Ordonnée.
	 */
	private int y;
	
	/**
	 * Constructeur de coordonnée.
	 * @param _x Abcisse
	 * @param _y Ordonnée
	 */
	public Coordonnee(final int _x, final int _y) {
		/*try {
			if (x < 0) {
				throw new BadCoordonneeException("X < 0 : Abcisse Impossible !");
			}
			if (x > 7) {
				throw new BadCoordonneeException("X > 7 : Abcisse Impossible !");
			}
			if (y < 0) {
				throw new BadCoordonneeException("Y < 0 : Ordonnée Impossible !");
			}
			if (y > 7) {
				throw new BadCoordonneeException("Y > 7 : Ordonnée Impossible !");
			}
		} catch (BadCoordonneeException e) {
			e.printStackTrace();
		}*/
		this.x = _x;
		this.y = _y;
	}
	
	/**
	 * Accesseur permettant de récupérer l'abcisse de la coordonnée.
	 * @return Retourne l'abcisse de la coordonnée.
	 */
	public int x() {
		return x;
	}
	
	/**
	 * Accesseur permettant de récupérer l'ordonnée de la coordonnée.
	 * @return Retourne l'ordonnée de la coordonnée.
	 */
	public int y() {
		return y;
	}
	
	/**
	 * Vérifie l'égalité de deux coordonnées.
	 * @param other un autre objet
	 * @return retourne true si other est une Coordoonée, que other.x == this.x et other.y == this.y. retourne false dans tous les autres cas.
	 */
	@Override
	public boolean equals(final Object other) {
		if (other instanceof Coordonnee) {
			return ((Coordonnee)other).x == x && ((Coordonnee)other).y == y;
		} else {
			return false;
		}
	}

	/**
	 * hashCode() Fonction de hashage.
	 * @return Return un hashCode correspondant au coordonnée.
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 59 * hash + this.x;
		hash = 59 * hash + this.y;
		return hash;
	}
	
	/**
	 * Fonction permettant de retourner une représentation textuelle de la coordonnée.
	 * @return String
	 */
	@Override
	public String toString() {
		return "( " + this.x + " , " + this.y + " )";
	}
}
