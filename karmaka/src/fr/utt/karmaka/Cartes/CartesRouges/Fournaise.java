package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Carte;
import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;
import fr.utt.karmaka.PilesCartes;

public class Fournaise extends CartesRouges{

	public Fournaise() {
		super(2,3,"Fournaise");
	}
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte "+this.getNom());
		PilesCartes vieRival = rival.getVieFuture();
		if(vieRival.getSize()>0) {
			//defausser les deux premieres cartes de la vie future du rival
			vieRival.supprimerCarte(0);
			if(vieRival.getSize()>1) {
			vieRival.supprimerCarte(0);
			}
			
			rival.setVieFuture(vieRival);

		}
		else {
			System.out.println("Votre rival n'a pas de carte dans sa vie Future");
		}
		
	}
}
