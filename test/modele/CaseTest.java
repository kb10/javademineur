package modele;

import java.lang.reflect.Field;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CaseTest extends TestCase {
	
	public void setUp(){
		
	}
	
	/**
	 * On crée une case,<br />
	 * On vérifie que les attributs sont à leur valeur par défaut.
	 */
	public void testCase(){
		
		Case c = new Case();
		Field f;
		try {
			f = c.getClass().getDeclaredField("bombe");
			f.setAccessible(true);
			assertFalse((Boolean) f.get(c));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * On crée une case,<br />
	 * On modifie bombe à faux,<br />
	 * On vérifie que la modification est effectuée,<br />
	 * On modifie bombe à vrai,<br />
	 * On vérifie que la modification est effectuée,
	 */
	public void testSetBombe(){
		
		Case c = new Case();
		
		c.setBombe(false);
		
		Field f;
		
		try {
			f = c.getClass().getDeclaredField("bombe");
			f.setAccessible(true);
			assertFalse((Boolean) f.get(c));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		c.setBombe(true);
		
		try {
			f = c.getClass().getDeclaredField("bombe");
			f.setAccessible(true);
			assertTrue((Boolean) f.get(c));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * On crée une case,<br />
	 * On vérifie que getBombe retourne bien le contenu du field.<br />
	 * On modifie (à l'aide de setBombe) l'attribut bombe,<br />
	 * On vérifie que getBombe retourne bien la valeur entrée, et correspond au contenu du field.
	 */
	public void testIsBombe(){
		
		Case c = new Case();
		
		Field f;
		
		try{
			f = c.getClass().getDeclaredField("bombe");
			f.setAccessible(true);
			assertEquals(c.isBombe(),f.get(c));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

		c.setBombe(true);
		assertTrue(c.isBombe());
		
		try{
			f = c.getClass().getDeclaredField("bombe");
			f.setAccessible(true);
			assertEquals(c.isBombe(),f.get(c));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
		c.setBombe(false);
		assertFalse(c.isBombe());
		
		try{
			f = c.getClass().getDeclaredField("bombe");
			f.setAccessible(true);
			assertEquals(c.isBombe(),f.get(c));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		
	}

	/**
	 * On crée une case par défaut,
	 * on vérifie que toString() retourne bien ' ',
	 * On modifie la case pour qu'elle contienne une bombe,
	 * On vérifie que toString() retourne bien 'X',
	 * On retire la bombe,
	 * On vérifie que toString() retourne bien ' '.
	 */
	public void testToString() {
		Case c = new Case();
		assertEquals(c.toString(), " ");
		c.setBombe(true);
		assertEquals(c.toString(), "X");
		c.setBombe(false);
		assertEquals(c.toString(), " ");
	}
}
