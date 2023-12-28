package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class DernierSoufle extends CartesRouges {
	public DernierSoufle() {
		super(1, 3, "Dernier Soufle");
	}

	// Le joueur de votre choix défausse une carte de sa Main
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Le joueur de votre choix défausse une carte de sa Main");
		System.out.println("Les cartes de la main du joueur "+rival.getNom()+" sont :");
		for(int i=0;i<rival.getMain().getSize();i++) {
			System.out.println(i+" : "+rival.getMain().getCarte(i).getNom());
		}
		System.out.println("Taper le numéro de la carte que vous voulez défausser :");
		int numCarte = choisirCarte(rival.getMain().getSize()-1);
		rival.getMain().supprimerCarte(numCarte);
	}
}
