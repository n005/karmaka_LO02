package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Panique extends CartesRouges {
	public Panique() {
		super(1, 3, "Panique");
	}

	// Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.");
		rival.getPile().supprimerCarte(0);
		p.jouerUnTour(j);
	}
}
