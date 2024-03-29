package fr.utt.karmaka.Cartes.CartesBleues;

import fr.utt.karmaka.Carte;
import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Transmigration
 */
public class Transmigration extends CartesBleues {
	public Transmigration() {
		super(1, 3, "Transmigration");
	}

	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			if (j.getVieFuture().getSize() > 0) {
				System.out.println("Choississez la carte de votre Vie Future à placer dans votre main :");
				Carte carte = j.choisirCarteADeplacer();
				// deplacer la carte
				j.ajouterMain(carte);
			} else {
				System.out.println("Vous n'avez pas de carte dans votre Vie Future");
			}
		}

		else {
			if (j.getVieFuture().getSize() > 0) {
				j.ajouterMain(j.getVieFuture().getCarte(0));
			} else {
			}
		}
	}
}
