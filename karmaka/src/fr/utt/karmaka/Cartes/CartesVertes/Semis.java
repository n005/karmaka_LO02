package fr.utt.karmaka.Cartes.CartesVertes;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Semis extends CartesVertes {
	public Semis() {
		super(2, 3, "Semis");
	}

	// Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main.");
		j.piocher();
		j.piocher();
		System.out.println("Les cartes de votre main sont :");
		for(int i=0;i<j.getMain().getSize();i++) {
			System.out.println(i+" : "+j.getMain().getCarte(i).getNom());
		}
		System.out.println("Taper le numéro de la première carte que vous voulez placer :");
		int numCarte = choisirCarte(j.getMain().getSize()-1);
		j.getVieFuture().ajouterCarte(j.getMain().getCarte(numCarte));
		j.getMain().supprimerCarte(numCarte);
		System.out.println("Taper le numéro de la deuxième carte que vous voulez placer :");
		numCarte = choisirCarte(j.getMain().getSize()-1);
		j.getVieFuture().ajouterCarte(j.getMain().getCarte(numCarte));
		j.getMain().supprimerCarte(numCarte);

	}
}
