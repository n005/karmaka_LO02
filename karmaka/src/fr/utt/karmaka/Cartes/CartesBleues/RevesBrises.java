package fr.utt.karmaka.Cartes.CartesBleues;

import fr.utt.karmaka.Carte;
import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;
import fr.utt.karmaka.PilesCartes;

public class RevesBrises extends CartesBleues {
	public RevesBrises() {
		super(2, 3, "Rêves Brisés");
	}

	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			PilesCartes vieRival = rival.getVieFuture();
			if (vieRival.getSize() > 0) {
				// placer la prmiere carte de la vie future du rival sur celle du joueur
				Carte c = vieRival.getCarte(0);
				vieRival.supprimerCarte(0);
				rival.setVieFuture(vieRival);
				j.ajouterVieFuture(c);
			} else {
				System.out.println("Votre rival n'a pas de carte dans sa vie Future");
			}
		} else {
			PilesCartes vieRival = rival.getVieFuture();
			if (vieRival.getSize() > 0) {
				// placer la prmiere carte de la vie future du rival sur celle du joueur
				Carte c = vieRival.getCarte(0);
				vieRival.supprimerCarte(0);
				rival.setVieFuture(vieRival);
				j.ajouterVieFuture(c);
			} else {
			}
		}
	}
}