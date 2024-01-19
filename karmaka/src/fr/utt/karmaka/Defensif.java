package fr.utt.karmaka;

import java.util.Random;
/**
 * Classe defensif du jeu
 * 
 * @version 1.0
 * @since 1.0
 */
public class Defensif implements Strategie {
	public void jouer(Joueur joueur, Partie p) {
		joueur.piocher();
		Random numAleatoire = new Random();
		int choix = numAleatoire.nextInt(100);
		if (choix >= 0 && choix <= 30) {
			// jouer pour les points
			System.out.println(joueur.getNom()+" joue pour les points.");
			joueur.jouerPoints(numAleatoire.nextInt(joueur.getMain().getSize()));
		} else if (choix > 30 && choix <= 65) {
			// jouer pour le futur
			System.out.println(joueur.getNom()+" joue pour le futur.");
			joueur.jouerFuture(numAleatoire.nextInt(joueur.getMain().getSize()));
		} else if (choix > 65 && choix <= 85) {
			// jouer le pouvoir
			System.out.println(joueur.getNom()+" joue un pouvoir.");
			joueur.jouePouvoir(joueur.getMain().getCarte(numAleatoire.nextInt(joueur.getMain().getSize())), joueur, p);
		} else {
			boolean passable = joueur.passer();
			if (passable) {
				System.out.println(joueur.getNom()+" passe son tour.");
			} else {
				this.jouer(joueur, p);
			}
		}

	}

}
