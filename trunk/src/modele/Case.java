package modele;

/**
 * Classe représentant une case d'un grille de jeu.
 * Une case peut contenir une bombe ou non.
 * @author langlais
 *
 */
public class Case {
	
	/**
	 * Permet de savoir si la case contient une bombe - true - ou non - false -.
	 */
	private boolean bombe;
	
	/**
	 * Constructeur de case par défaut.
	 */
	public Case() {
		this.bombe = false;
	}
	
	/**
	 * setBombe().
	 * Modifie la case pour la valeur _bombe
	 * @param _bombe true si la case contient une bombe, false sinon.
	 */
	public void setBombe(final boolean _bombe) {
		this.bombe = _bombe;
	}
	
	/**
	 * isBombe().
	 * Permet de savoir si la case contient une bombe ou non.
	 * @return	retourne true si la case contient une bombe, false sinon.
	 */
	public boolean isBombe() {
		return this.bombe;
	}

	/**
	 * toString().
	 * @return Retourne 'X' si la case est minée, ' ' sinon.
	 */
	public String toString() {
		if (this.isBombe()) {
			return "X";
		} else {
			return " ";
		}
	}
}
