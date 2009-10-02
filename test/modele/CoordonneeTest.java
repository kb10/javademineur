package modele;

import junit.framework.TestCase;

public class CoordonneeTest extends TestCase {

	/**
	 * On crée deux coordonnée,<br />
	 * On vérifie que le getter x() retourne bien la valeur passée en paramètre.
	 */
	public void testX() {
		
		int x1 = 0;
		int x2 = 5;
		
		Coordonnee c1 = new Coordonnee(x1,0);
		assertEquals(c1.x(),x1);
		
		Coordonnee c2 = new Coordonnee(x2,0);
		assertEquals(c2.x(),x2);
	}
	
	/**
	 * On crée deux coordonnée,<br />
	 * On vérifie que le getter y() retourne bien la valeur passée en paramètre.
	 */
	public void testY() {
		
		int y1 = 0;
		int y2 = 5;
		
		Coordonnee c1 = new Coordonnee(0,y1);
		assertEquals(c1.y(),y1);
		
		Coordonnee c2 = new Coordonnee(0,y2);
		assertEquals(c2.y(),y2);
	}
	
	/**
	 * On crée une coordonnée,<br />
	 * On vérifie que la chaine retournée correspond à ce que l'on attend.
	 */
	public void testToString() {
		
		int x1 = 1;
		int y1 = 3;
		Coordonnee c1 = new Coordonnee(x1,y1);
		assertEquals(c1.toString(),"( " + x1 + " , " + y1 + " )");
		
		int x2 = 5;
		int y2 = 2;
		Coordonnee c = new Coordonnee(x2,y2);
		assertEquals(c.toString(),"( " + x2 + " , " + y2 + " )");
	}
	
	/**
	 * On crée une instance de Coordonnée et une autre instance de type Object,<br />
	 * On vérifie que equals retourne faux.<br />
	 * <br />
	 * On crée deux instances différentes,<br />
	 * On vérifie que equals retourne faux.<br />
	 * <br />
	 * On crée deux instances ayant même abcisse mais ordonnée différente,<br />
	 * On vérifie que equals retourne faux.<br />
	 * <br />
	 * On crée deux instances ayant même ordonnée mais abcisse différente,<br />
	 * On vérifie que equals retourne faux.<br />
	 * <br />
	 * On crée deux instances ayant même abcisse et ordonnée,<br />
	 * On vérifie que equals retourne vrai.<br />
	 * <br />
	 * On vérifie à chaque fois que equals est symétrique.
	 */
	public void testEquals() {
		
		Coordonnee c1, c2;
		// test0
		c1 = new Coordonnee(0,0);
		Object o = null ;
		assertFalse(c1.equals(o));
		
		// test1
		c1 = new Coordonnee(1,1);
		c2 = new Coordonnee(2,2);
		
		assertFalse(c1.equals(c2));
		assertFalse(c2.equals(c1));
		
		// test2
		c1 = new Coordonnee(1,1);
		c2 = new Coordonnee(1,2);
		
		assertFalse(c1.equals(c2));
		assertFalse(c2.equals(c1));
		
		// test3
		c1 = new Coordonnee(1,2);
		c2 = new Coordonnee(2,2);
		
		assertFalse(c1.equals(c2));
		assertFalse(c2.equals(c1));
		
		// test4
		c1 = new Coordonnee(1,2);
		c2 = new Coordonnee(1,2);
		
		assertTrue(c1.equals(c2));
		assertTrue(c2.equals(c1));
		
	}

	public void testHashCode(){
		
		Coordonnee c;
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				
				c = new Coordonnee(i, j);

				int hash = 3;
				hash = 59 * hash + c.x();
				hash = 59 * hash + c.y();
				assertEquals(c.hashCode(),hash);
			}
		}
	}
}
