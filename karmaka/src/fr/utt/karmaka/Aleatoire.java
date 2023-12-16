package fr.utt.karmaka;
/**
 * Classe aleatoire du jeu
 * 
 * @version 1.0
 * @since 1.0
 */
public class Aleatoire implements Strategie {
	public void jouer(Joueur joueur) {
		joueur.piocher();
		int numCarte = 0; 
		joueur.jouerPoints(numCarte);
	}

}
