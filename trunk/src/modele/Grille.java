package modele;

import static modele.Niveau.*;

/**
 * Classe Grille.
 * Permet de représenter une grille de jeu.
 * @author langlais
 *
 */
public class Grille {
	
	/**
	 * Grille du Démineur.
	 */
	private Case[][] grille;
	/**
	 * Attribut stockant la largeur de la grille.
	 */
	private int width;

	/**
	 * Attribut stockant la hauteur de la grille.
	 */
	private int height;
	
	/**
	 * Niveau de la grille.
	 */
	private Niveau niveau;
	
	/**
	 * Constructeur par défaut.<br />
	 * Construit une grille de démineur de niveau Facile.
	 * @throws NotInitializedException Retourne l'erreur si le niveau par défaut n'est pas initialisé.
	 * @link modele.Grille#Grille(Niveau)
	 */
	public Grille() throws NotInitializedException {
		this(Facile);
	}
	
	/**
	 * Constructeur à l'aide d'un niveau.
	 * @param n Indique le niveau de la grille.
	 * @throws NotInitializedException Retourne l'erreur si Niveau n'est pas initialisé.
	 * 
	 */
	public Grille(final Niveau n) throws NotInitializedException {
		
		this.niveau = n;
		this.width = niveau.getX();
		this.height = niveau.getY();
		this.grille = new Case[n.getX()][n.getY()];

//		System.out.println(n);
//		System.out.println(n.getX());
//		System.out.println(n.getY());
//		System.out.println(n.getNbMines());

		for (int i = 0; i < n.getX(); i++) {
			for (int j = 0; j < n.getY(); j++) {
				grille[i][j] = new Case();
			}
		}
		
		for (int i = 0; i < n.getNbMines(); i++) {

//			System.out.println(this.width+" "+this.height);
			int xMine = (int) (Math.random() * this.width);
			int yMine = (int) (Math.random() * this.height);

			if (!this.isBombe(xMine, yMine)) {
				this.setBombe(xMine, yMine, true);
//				System.out.println(" [ "+xMine+" , "+yMine+" ] is mined.");
			} else {
//				System.out.println(" [ "+xMine+" , "+yMine+" ] is already mined.");
				i--;
			}
		}
	}
	
	/**
	 * Fonction permettant de savoir si la case de coordonnées (x,y) est minée.
	 * @param x	Abcisse de la case à tester.
	 * @param y Ordonnée de la case à tester.
	 * @return Retourne true si la case est minée, false sinon.
	 */
	public boolean isBombe(final int x, final int y) {
		return grille[x][y].isBombe();
	}
	
	/**
	 * Fonction permettant de mettre une mine ou non dans la case.
	 * @param x Abcisse de la case.
	 * @param y Ordonnée de la case.
	 * @param bombe true si l'on met une mine, false sinon.
	 */
	public void setBombe(final int x, final int y, final boolean bombe) {
		grille[x][y].setBombe(bombe);
	}
	
	/**
	 * Retourne le nombre de mine autour de la case de coordonnée (x,y).
	 * @param x Abcisse de la case à tester.
	 * @param y Ordonnée de la case à tester.
	 * @return Retourne le nombre de mine autour de la case.
	 */
	public int getNbMineAutour(final int x, final int y) {
		
		int count = 0;
		
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!(i == 0 && j == 0)) {
					
					int X = x + i;
					int Y = y + j;
					
					if (X >= 0 && Y >= 0 && X < width && Y < height) {
						if (this.isBombe(X, Y)) {
							count++;
						}
					}
				}	
			}
		}
		return count;
	}

	/**
	 * Permet l'affichage de la grille sous forme de texte.
	 * @return Retourne une réprésentation visuelle textuelle de la grille.
	 */
	public String toString() {

		String retour = "";
		String interligne = "#";

		for (int j = 0; j < this.width; j++) {
			interligne += "---#";
		}

		retour += interligne;
		
		for (int i = 0; i < this.height; i++) {
			retour += "\n| ";
			for (int j = 0; j < this.width; j++) {
				retour += this.grille[j][i].toString() + " | ";
			}
			retour += '\n'+interligne;
		}

		return retour;
	}

	/**
	 * Hauteur de la grille.
	 * @return Retourne la hauteur de la grille.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Niveau de la grille.
	 * @return Retourne le niveau de la grille.
	 */
	public Niveau getNiveau() {
		return niveau;
	}

	/**
	 * Largeur de la grille.
	 * @return Retourne la largeur de la grille.
	 */
	public int getWidth() {
		return width;
	}
}
