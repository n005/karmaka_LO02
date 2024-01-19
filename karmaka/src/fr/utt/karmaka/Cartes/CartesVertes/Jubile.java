package fr.utt.karmaka.Cartes.CartesVertes;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Jubile
 */
public class Jubile extends CartesVertes {
	public Jubile() {
		super(3, 2, "Jubilé");
	}

	// Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres");
			System.out.println("Les cartes de votre main sont :");
			for (int i = 0; i < j.getMain().getSize(); i++) {
				System.out.println(i + " : " + j.getMain().getCarte(i).getNom());
			}
			System.out.println("Taper le numéro de la première carte que vous voulez placer :");
			int numCarte = choisirCarte(j.getMain().getSize() - 1);
			j.getOeuvres().ajouterCarte(j.getMain().getCarte(numCarte));
			j.getMain().supprimerCarte(numCarte);
			System.out.println("Taper le numéro de la deuxième carte que vous voulez placer :");
			numCarte = choisirCarte(j.getMain().getSize() - 1);
			j.getOeuvres().ajouterCarte(j.getMain().getCarte(numCarte));
			j.getMain().supprimerCarte(numCarte);

		} else {
			if (j.getMain().getSize() > 0) {
				int numCarte = (int) (Math.random() * j.getMain().getSize());
				j.getOeuvres().ajouterCarte(j.getMain().getCarte(numCarte));
				j.getMain().supprimerCarte(numCarte);
			}
		}
	}
}
