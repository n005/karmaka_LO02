package fr.utt.karmaka.Cartes.CartesVertes;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Longevite
 */
public class Longevite extends CartesVertes {
	public Longevite() {
		super(2, 3, "Longévité");
	}

	// Placez 2 cartes puisées à la Source sur la Pile d'un joueur.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Placez 2 cartes puisées à la Source sur la Pile d'un joueur.");
			j.piocher();
			j.piocher();
			System.out.println("Les cartes de votre main sont :");
			for (int i = 0; i < j.getMain().getSize(); i++) {
				System.out.println(i + " : " + j.getMain().getCarte(i).getNom());
			}
		} else {
			j.piocher();
			j.piocher();
		}
	}
}
