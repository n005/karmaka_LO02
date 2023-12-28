package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Vengeance extends CartesRouges {
	public Vengeance() {
		super(3, 2, "Vengeance");
	}

	// Défaussez l’Oeuvre Exposée d’un rival (la dernière).
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Défaussez l’Oeuvre Exposée d’un rival (la dernière).");
		rival.getOeuvres().supprimerCarte(rival.getOeuvres().getSize()-1);
	}
}
