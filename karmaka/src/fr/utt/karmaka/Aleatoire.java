package fr.utt.karmaka;

import java.util.Random;

/**
 * Classe aleatoire du jeu
 * 
 * @version 1.0
 * @since 1.0
 */
public class Aleatoire implements Strategie, java.io.Serializable {
	public void jouer(Joueur joueur, Partie p) {
		joueur.piocher();
		Random numAleatoire = new Random();
		int choix = numAleatoire.nextInt(4);
		switch (choix) {
			// jouer pour les points
			case 0:
				System.out.println(joueur.getNom() + " joue pour les points.");
				joueur.jouerPoints(numAleatoire.nextInt(joueur.getMain().getSize()));
				break;
			// jouer pour le futur
			case 1:
				System.out.println(joueur.getNom() + " joue pour son futur.");
				joueur.jouerFuture(numAleatoire.nextInt(joueur.getMain().getSize()));
				break;
			// jouer le pouvoir
			case 2:
				System.out.println(joueur.getNom() + " joue un pouvoir.");
				joueur.jouePouvoir(joueur.getMain().getCarte(numAleatoire.nextInt(joueur.getMain().getSize())), joueur,
						p);
				break;
			// passer le tour
			case 3:
				boolean passable = joueur.passer();
				if (passable) {
					System.out.println(joueur.getNom() + " passe son tour.");
					break;
				} else {
					this.jouer(joueur, p);
					break;
				}
			default:
				System.out.println("Impossible de jouer");
				break;
		}

	}

}
