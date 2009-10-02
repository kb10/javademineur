/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 *
 * @author Dorian Langlais
 */
public class GrilleTest extends TestCase {
	
	/**
	 * Une grille Facile...
	 */
	private Grille grilleFacile;
	/**
	 * Une grille Moyenne...
	 */
	private Grille grilleMoyen;
	/**
	 * Une grille Expert...
	 */
	private Grille grilleExpert;
	
//	public void setUp() {
//		try {
//			grilleFacile = new Grille(Niveau.Facile);
//		} catch (NotInitializedException ex) {
//			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		try {
//			grilleMoyen = new Grille(Niveau.Moyen);
//		} catch (NotInitializedException ex) {
//			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		try {
//			grilleExpert = new Grille(Niveau.Expert);
//		} catch (NotInitializedException ex) {
//			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
	
	/**
	 * testGrille().
	 */
	public void testGrille() {
		try {
			grilleFacile = new Grille(Niveau.Facile);
		} catch (NotInitializedException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		}

//		Field fgrille;
		Field fwidth;
		Field fheight;
//		Case[][] grilleF;
		int widthF = -1;
		int heightF = -1;

		try {
//			fgrille = grilleFacile.getClass().getDeclaredField("grille");
//			fgrille.setAccessible(true);
//			grilleF = (Case[][]) fgrille.get(grilleFacile);
			fwidth = grilleFacile.getClass().getDeclaredField("width");
			fwidth.setAccessible(true);
			widthF = (Integer) fwidth.get(grilleFacile);
			fheight = grilleFacile.getClass().getDeclaredField("height");
			fheight.setAccessible(true);
			heightF = (Integer) fheight.get(grilleFacile);
		} catch (IllegalArgumentException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchFieldException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SecurityException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		}

		assertEquals(widthF, grilleFacile.getWidth());
		assertEquals(heightF, grilleFacile.getHeight());
		assertEquals(Niveau.Facile, grilleFacile.getNiveau());
		
		try {
			grilleExpert = new Grille(Niveau.Expert);
		} catch (NotInitializedException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		}
		assertEquals(grilleExpert.getHeight(), 16);
		assertEquals(grilleExpert.getWidth(), 30);
	}
	
	/**
	 * testToString().
	 */
	public void testToString() {
		
		try {
			grilleFacile = new Grille(Niveau.Facile);
		} catch (NotInitializedException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		}

		Field fgrille;
		Field fwidth;
		Field fheight;
		Case[][] grilleF = null;
//		int widthF;
//		int height;

		try {
			fgrille = grilleFacile.getClass().getDeclaredField("grille");
			fgrille.setAccessible(true);
			grilleF = (Case[][]) fgrille.get(grilleFacile);

			fwidth = grilleFacile.getClass().getDeclaredField("width");
			fwidth.setAccessible(true);
//			widthF = (Integer) fwidth.get(grilleFacile);

			fheight = grilleFacile.getClass().getDeclaredField("height");
			fheight.setAccessible(true);
//			height = (Integer) fheight.get(grilleFacile);

		} catch (IllegalArgumentException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchFieldException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SecurityException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		}


		String retour = "";
		String interligne = "#";

		for (int j = 0; j < grilleFacile.getWidth(); j++) {
			interligne += "---#";
		}

		retour += interligne;

		for (int i = 0; i < grilleFacile.getHeight(); i++) {
			retour += "\n| ";
			for (int j = 0; j < grilleFacile.getWidth(); j++) {
				retour += grilleF[j][i].toString() + " | ";
			}
			retour += '\n' + interligne;
		}

		assertEquals(retour, grilleFacile.toString());

		System.out.println(grilleFacile.toString());
//		System.out.println(retour);

	}
	
	/**
	 * testIsBombe().
	 */
	public void testIsBombe() {

		Field fgrilleFacile;
		Case[][] grilleF = null;
		Field fgrilleMoyen;
		Case[][] grilleM = null;
		Field fgrilleExpert;
		Case[][] grilleE = null;

		try {
			grilleFacile = new Grille(Niveau.Facile);
			fgrilleFacile = grilleFacile.getClass().getDeclaredField("grille");
			fgrilleFacile.setAccessible(true);
			grilleF = (Case[][]) fgrilleFacile.get(grilleFacile);

			grilleMoyen = new Grille(Niveau.Moyen);
			fgrilleMoyen = grilleMoyen.getClass().getDeclaredField("grille");
			fgrilleMoyen.setAccessible(true);
			grilleM = (Case[][]) fgrilleMoyen.get(grilleMoyen);

			grilleExpert = new Grille(Niveau.Expert);
			fgrilleExpert = grilleExpert.getClass().getDeclaredField("grille");
			fgrilleExpert.setAccessible(true);
			grilleE = (Case[][]) fgrilleExpert.get(grilleExpert);
			
		} catch (IllegalArgumentException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchFieldException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SecurityException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NotInitializedException ex) {
			Logger.getLogger(GrilleTest.class.getName()).log(Level.SEVERE, null, ex);
		}

		for (int i = 0; i < grilleFacile.getWidth(); i++) {
			for (int j = 0; j < grilleFacile.getHeight(); j++) {
//				System.out.println("["+i+"]["+j+"]"+grilleFacile.isBombe(i, j)+" "+grilleF[i][j]);
				assertEquals(grilleFacile.isBombe(i, j), grilleF[i][j].isBombe());
			}
		}
		System.out.println('\n');

		for (int i = 0; i < grilleMoyen.getWidth(); i++) {
			for (int j = 0; j < grilleMoyen.getHeight(); j++) {
//				System.out.println("["+i+"]["+j+"]"+grilleMoyen.isBombe(i, j)+" "+grilleM[i][j]);
				assertEquals(grilleMoyen.isBombe(i, j), grilleM[i][j].isBombe());
			}
		}
		System.out.println('\n');

		for (int i = 0; i < grilleExpert.getWidth(); i++) {
			for (int j = 0; j < grilleExpert.getHeight(); j++) {
//				System.out.println("["+i+"]["+j+"]"+grilleExpert.isBombe(i, j)+" "+grilleE[i][j]);
				assertEquals(grilleExpert.isBombe(i, j), grilleE[i][j].isBombe());
			}
		}
	}


	
}
