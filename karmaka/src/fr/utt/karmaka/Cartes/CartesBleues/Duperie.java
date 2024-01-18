package fr.utt.karmaka.Cartes.CartesBleues;

import java.util.Scanner;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Duperie
 */
public class Duperie extends CartesBleues {
	public Duperie() {
		super(3, 2, "Duperie");
	}

	// Regardez 3 cartes de la Main d’un rival ; ajoutez-en une à votre Main
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Vous devez regarder 3 cartes de la Main d’un rival ; ajoutez-en une à votre Main");
			System.out.println("Taper le numéro du joueur dont vous voulez regarder la main :");
			p.afficherJoueurs();
			int numJoueur = p.choisirJoueur();
			System.out.println(
					"Les 3 premières cartes de la main du joueur " + p.getJoueur(numJoueur).getNom() + " sont :");
			for (int i = 0; i < 3; i++) {
				System.out.println(p.getJoueur(numJoueur).getMain().getCarte(i).getNom());
			}
			System.out.println("Taper le numéro de la carte que vous voulez ajouter à votre main :");
			int numCarte = choisirCarte(2);
			j.ajouterMain(p.getJoueur(numJoueur).getMain().getCarte(numCarte));
		} else {
			if (p.getJoueur(0).getMain().getSize() != 0) {
				j.ajouterMain(p.getJoueur(0).getMain().getCarte(0));
			}
		}
	}
}
