package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Panique
 */
public class Panique extends CartesRouges {
	public Panique() {
		super(1, 3, "Panique");
	}

	// Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer
	// une autre carte.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println(
					"Défaussez la première carte de la Pile d'un joueur. Vous pouvez ensuite jouer une autre carte.");
			if (rival.getPile().getSize() != 0) {
				rival.getPile().supprimerCarte(0);
				p.jouerUneCarte(j);
			} else
				System.out.println("La pile de votre rival est vide !");

		} else {
			if (rival.getPile().getSize() != 0) {
				rival.getPile().supprimerCarte(0);
			}

		}
	}
}