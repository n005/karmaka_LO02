package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

public class Vengeance extends CartesRouges {
	public Vengeance() {
		super(3, 2, "Vengeance");
	}

	// Défaussez l’Oeuvre Exposée d’un rival (la dernière).
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Défaussez l’Oeuvre Exposée d’un rival (la dernière).");
			if (rival.getOeuvres().getSize() != 0)
				rival.getOeuvres().supprimerCarte(rival.getOeuvres().getSize() - 1);
			else
				System.out.println("Votre rival n'a pas d'oeuvre !");
		} else {
			if (rival.getOeuvres().getSize() != 0)
				rival.getOeuvres().supprimerCarte(0);
		}
	}
}
