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
	 * 
	 * @param argc
	 * @throws NotInitializedException
	 */
	public static void main(final String[] argc) throws NotInitializedException {
		System.out.println("test");
		Grille g = new Grille();
		System.out.println(g);
	}
}
