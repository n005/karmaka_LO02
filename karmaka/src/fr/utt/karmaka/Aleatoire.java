package fr.utt.karmaka;

public class Aleatoire implements Strategie {
	public void jouer(Joueur joueur) {
		int numCarte = 1; 
		joueur.jouerPoints(numCarte);
	}

}
