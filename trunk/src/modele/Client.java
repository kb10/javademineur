/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

/**
 *
 * @author Dorian Langlais
 */
public class Client {
	
	/**
	 * main().
	 * @param argc argument passé en paramètre du main.
	 */
	public static void main(final String[] argc) {
		try {
			System.out.println("test");
			Grille g = new Grille();
			System.out.println(g);
		} catch (NotInitializedException e) {
			e.printStackTrace();
		}
	}
}
