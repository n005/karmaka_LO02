package fr.utt.karmaka.Cartes.CartesVertes;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

public class Sauvetage extends CartesVertes {
	public Sauvetage() {
		super(2, 3, "Sauvetage");
	}

	// Ajoutez à votre Main une des 3 dernières cartes de la Fosse.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Ajoutez à votre Main une des 3 dernières cartes de la Fosse.");
			System.out.println("Les 3 dernières cartes de la fosse sont :");
			for (int i = p.getFosse().getSize() - 3; i < p.getFosse().getSize(); i++) {
				System.out.println(i + " : " + p.getFosse().getCarte(i).getNom());
			}
			System.out.println("Taper le numéro de la carte que vous voulez ajouter à votre Main :");
			int numCarte = choisirCarte(p.getFosse().getSize() - 1);
			j.getMain().ajouterCarte(p.getFosse().getCarte(numCarte));
			p.getFosse().supprimerCarte(numCarte);
		}
		else {
			if (p.getFosse().getSize() > 0) {
				j.getMain().ajouterCarte(p.getFosse().getCarte(p.getFosse().getSize() - 1));
				p.getFosse().supprimerCarte(p.getFosse().getSize() - 1);
			}
		}
	}

}
