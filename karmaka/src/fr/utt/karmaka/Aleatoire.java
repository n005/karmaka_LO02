package fr.utt.karmaka;

public class Aleatoire implements Strategie {
	public void jouer(Joueur joueur) {
		joueur.piocher();
		int numCarte = 0; 
		joueur.jouerPoints(numCarte);
	}

}
