package modele;

/**
 * Classe permettant de définir plusieurs Niveau à une partie de Démineur.
 * @author Dorian
 *
 */
public enum Niveau {
	
	/**
	 * Différents niveaux.
	 */
	Default, Facile, Moyen, Expert, Perso;
	/**
	 * Largeur de la grille niveau Perso.
	 */
	private static int xPerso = 0;
	/**
	 * Hauteur de la grille niveau Perso.
	 */
	private static int yPerso = 0;
	/**
	 * Nombre de mines de la grille niveau Perso.
	 */
	private static int nbMinePerso = 0;
	
	/**
	 * Récupère le nombre de case en largeur.
	 * @return	Nombre de case de large de la grille.
	 * @throws NotInitializedException Génère une exception si xPerso non initialisé.
	 */
	public int getX() throws NotInitializedException {
		switch (this) {
		default :
		case Facile :
			return 10;
		case Moyen :
			return 16;
		case Expert :
			return 30;
		case Perso :
			if (this.xPerso == 0) {
				throw new NotInitializedException("xPerso non initialisé");
			}
			return this.xPerso;
		}
	}
	
	/**
	 * Récupère le nombre de case en hauteur.
	 * @return	Retourne le nombre de case en haut de la grille.
	 * @throws NotInitializedException Génère une exception si yPerso non initialisé.
	 */
	public int getY() throws NotInitializedException {
		switch (this) {
		default	:
		case Facile :
			return 10;
		case Moyen :
			return 16;
		case Expert :
			return 16;
		case Perso :
			if (this.yPerso == 0) {
				throw new NotInitializedException("yPerso non initialisé");
			}
			return this.yPerso;
		}
	}
	
	/**
	 * Récupère le nombre de mines.
	 * @return	Retourne le nombre de mines contenues dans la grille.
	 * @throws NotInitializedException Génère une exception si nbMinePerso non initialisé.
	 */
	public int getNbMines() throws NotInitializedException {
		switch (this) {
		default	:
		case Facile :
			return 10;
		case Moyen :
			return 40;
		case Expert :
			return 99;
		case Perso :
			if (this.nbMinePerso == 0) {
				throw new NotInitializedException("nbMinePerso non initialisé");
			}
			return this.nbMinePerso;
		}
	}
	
	/**
	 * Setter setXYPerso().<br />
	 * Permet de modifier la largeur et la hauteur du niveau Perso.
	 * @param x	Largeur de la grille.
	 * @param y Hauteur de la grille.
	 * @param nbMine Nombre de mine contenues dans la grille.
	 * @throws BadInitializationException Génère une exception si <b>x <= 0</b>, <b>y <= 0</b>, <b>nbMine <= 0</b> ou <b>nbMine >= x * y * 0.25</b>.
	 */
	public void setPerso(final int x, final int y, final int nbMine) throws BadInitializationException {
		if (x <= 0) {
			throw new BadInitializationException("x <= 0");
		}
		if (y <= 0) {
			throw new BadInitializationException("y <= 0");
		}
		if (nbMine <= 0) {
			throw new BadInitializationException("nbMine <= 0");
		}
		if (nbMine >= x * y * 0.25) {
			throw new BadInitializationException("nbMine >= x * y * 0.25");
		}

		this.xPerso = x;
		this.yPerso = y;
		this.nbMinePerso = nbMine;
	}
}
