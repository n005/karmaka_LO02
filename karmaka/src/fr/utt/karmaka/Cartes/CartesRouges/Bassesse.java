package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Bassesse
 */
public class Bassesse extends CartesRouges {
	public Bassesse() {
		super(3, 2, "Bassesse");
	}

	// Défaussez au hasard 2 cartes de la Main d’un rival.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Défaussez au hasard 2 cartes de la Main d’un rival.");
			if (rival.getMain().getSize() >= 2) {
				for (int i = 0; i < 2; i++) {
					int numCarte = (int) (Math.random() * rival.getMain().getSize());
					rival.getMain().supprimerCarte(numCarte);
				}
			} else
				System.out.println("Votre rival n'a pas 2 cartes dans sa Main ! ");

		} else {
			if (rival.getMain().getSize() >= 2) {
				for (int i = 0; i < 2; i++) {
					int numCarte = (int) (Math.random() * rival.getMain().getSize());
					rival.getMain().supprimerCarte(numCarte);
				}
			}
		}
	}
}
