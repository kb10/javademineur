package modele;

import static modele.Niveau.*;

import java.lang.reflect.Field;

import junit.framework.Assert;
import junit.framework.TestCase;
/**
 * 
 * @author Dorian Langlais
 *
 */
public class NiveauTest extends TestCase {

	/**
	 * On change le niveau,<br />
	 * On vérifie que la valeur X retournée est exacte.
	 */
	public void testGetX() {
		Niveau n;
		
		try {
			n = Facile;
			assertEquals(n.getX(), 10);
			n = Moyen;
			assertEquals(n.getX(), 16);
			
			n = Expert;
			assertEquals(n.getX(), 30);
		} catch (NotInitializedException e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}
	
	/**
	 * On change le niveau,<br />
	 * On vérifie que la valeur Y retournée est exacte.
	 */
	public void testGetY() {
		Niveau n;

		try {
			n = Facile;
			assertEquals(n.getY(), 10);
			
			n = Moyen;
			assertEquals(n.getY(), 16);
			
			n = Expert;
			assertEquals(n.getY(), 16);
		} catch (NotInitializedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * On change le niveau,<br />
	 * On vérifie que le nombre de mines retourné est exact.
	 */
	public void testGetNbMines() {
		Niveau n;

		try {
			n = Facile;
			assertEquals(n.getNbMines(), 10);
			
			n = Moyen;
			assertEquals(n.getNbMines(), 40);
			
			n = Expert;
			assertEquals(n.getNbMines(), 99);
		} catch (NotInitializedException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * On instancie un niveau.<br />
	 * On vérifie que xPerso, yPerso et nbMinePerso sont tous à zéro.<br />
	 * On modifie ces attributs.<br />
	 * On vérifie que la modification est prise en compte.<br />
	 */
	public void testSetPerso() {
		Niveau n = Facile;

		Field fxPerso, fyPerso, fnbMinePerso;
		try {
			fxPerso = n.getClass().getDeclaredField("xPerso");
			fyPerso = n.getClass().getDeclaredField("yPerso");
			fnbMinePerso = n.getClass().getDeclaredField("nbMinePerso");
			
			fxPerso.setAccessible(true);
			fyPerso.setAccessible(true);
			fnbMinePerso.setAccessible(true);

			assertEquals(fxPerso.get(n), 0);
			assertEquals(fyPerso.get(n), 0);
			assertEquals(fnbMinePerso.get(n), 0);
		} catch (Exception e) {
			Assert.fail();
		}
		
		int xPerso = 11, yPerso = 13, nbMinePerso = 25;
		try {
			n.setPerso(xPerso, yPerso, nbMinePerso);
			
			fxPerso = n.getClass().getDeclaredField("xPerso");
			fyPerso = n.getClass().getDeclaredField("yPerso");
			fnbMinePerso = n.getClass().getDeclaredField("nbMinePerso");
			
			fxPerso.setAccessible(true);
			fyPerso.setAccessible(true);
			fnbMinePerso.setAccessible(true);

			assertEquals(fxPerso.get(n), xPerso);
			assertEquals(fyPerso.get(n), yPerso);
			assertEquals(fnbMinePerso.get(n), nbMinePerso);
			
			n = Facile;

			assertEquals(n.getX(), 10);
			assertEquals(n.getY(), 10);
			assertEquals(n.getNbMines(), 10);
			
			n = Perso;

			assertEquals(n.getX(), xPerso);
			assertEquals(n.getY(), yPerso);
			assertEquals(n.getNbMines(), nbMinePerso);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * On test le comportement de Niveau lorsque l'on joue au niveau Perso.<br />
	 * Si l'on 
	 */
	public void testPerso() {
		
		Niveau n;
		
		try {
			n = Facile;
			
			assertEquals(n.getX(), 10);
			assertEquals(n.getY(), 10);
			assertEquals(n.getNbMines(), 10);
			
			n = Perso;
			
			int xPerso = 11, yPerso = 12, nbMinePerso = 13;
			n.setPerso(xPerso, yPerso, nbMinePerso);
	
			assertEquals(n.getX(), xPerso);
			assertEquals(n.getY(), yPerso);
			assertEquals(n.getNbMines(), nbMinePerso);
		} catch (NotInitializedException e) {
			e.printStackTrace();
			Assert.fail();
		} catch (BadInitializationException e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}
}
