package fr.utt.karmaka;

import java.util.Random;

/**
 * Classe aleatoire du jeu
 * 
 * @version 1.0
 * @since 1.0
 */
public class Agressif implements Strategie {
	public void jouer(Joueur joueur) {
		joueur.piocher();
		Random numAleatoire = new Random();
		int choix = numAleatoire.nextInt(100);
		if (choix >= 0 && choix <= 30) {
			// jouer pour les points
			System.out.println("joue points");
			joueur.jouerPoints(numAleatoire.nextInt(joueur.getMain().getSize()));
		} else if (choix > 30 && choix <= 55) {
			// jouer pour le futur
			System.out.println("joue futur");
			joueur.jouerFuture(numAleatoire.nextInt(joueur.getMain().getSize()));
		} else if (choix > 55 && choix <= 85) {
			// jouer le pouvoir
			System.out.println("joue pouvoir");
			//joueur.jouePouvoir(numAleatoire.nextInt(joueur.getMain().getSize()), joueur, null);
		} else {
			boolean passable = joueur.passer();
			if (passable) {
				System.out.println("passe");
			} else {
				this.jouer(joueur);
			}
		}
	}
}
