package fr.utt.karmaka.Cartes.CartesBleues;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class CoupDoeil
 */
public class CoupDoeil extends CartesBleues {

	public CoupDoeil() {
		super(1, 3, "Coup d\'Oeil");
	}

	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Voici la main de votre rival :");
			// voir la main de l'adversaire
			System.out.println(rival.mainToString());
			// avoir la possibilité de rejouer une carte
			p.jouerUneCarte(j);
		}
		else {}
	}
}
