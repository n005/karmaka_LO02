package fr.utt.karmaka.Cartes.CartesVertes;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Voyage extends CartesVertes {
	public Voyage() {
		super(3, 2, "Voyage");
	}

	// Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Puisez 3 cartes à la Source. Vous pouvez ensuite jouer une autre carte.");
		j.piocher();
		j.piocher();
		j.piocher();
		System.out.println("Les cartes de votre main sont :");
		for(int i=0;i<j.getMain().getSize();i++) {
			System.out.println(i+" : "+j.getMain().getCarte(i).getNom());
		}
		p.jouerUneCarte(j);

	}
}
