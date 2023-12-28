package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Crise extends CartesRouges {
	public Crise() {
		super(2, 3, "Crise");
	}

	// Le rival de votre choix défausse une de ses Oeuvres.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Le rival de votre choix défausse une de ses Oeuvres.");
		System.out.println("Les oeuvres du joueur "+rival.getNom()+" sont :");
		for(int i=0;i<rival.getOeuvres().getSize();i++) {
			System.out.println(i+" : "+rival.getOeuvres().getCarte(i).getNom());
		}
		System.out.println("Taper le numéro de l'oeuvre que vous voulez défausser :");
		int numOeuvre = choisirCarte(rival.getOeuvres().getSize()-1);
		rival.getOeuvres().supprimerCarte(numOeuvre);
	}
}
