package fr.utt.karmaka.Cartes.CartesBleues;

import java.util.Scanner;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Destinee
 */
public class Destinee extends CartesBleues {
	/**
	 * Constructeur de la carte.
	 */
	public Destinee() {
		super(2, 3, "Destinée");
	}

	/**
	 * Permet de jouer le pouvoir de la carte.
	 * 
	 * @param j
	 * @param rival
	 * @param p
	 */
	public void jouerPourvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println(
					"Vous devez regarder les 3 premières cartes de la Source ; ajoutez-en jusqu’à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.");
			// Affiche les 3 premières cartes de la source
			System.out.println("Les 3 premières cartes de la source sont :");
			for (int i = 0; i < 3; i++) {
				System.out.println(p.getSource().getCarte(i).getNom());
			}
			// choisir les cartes à ajouter à la vie future
			for (int i = 0; i < 2; i++) {
				System.out.println(
						"Taper le numéro de la carte que vous voulez ajouter à votre vie future (0 pour ne pas ajouter de carte) :");
				Scanner scCarte = new Scanner(System.in);
				int numCarte = scCarte.nextInt();
				if (numCarte != 0) {
					j.ajouterVieFuture(p.getSource().getCarte(numCarte - 1));
				}
			}
		} else {
			for (int i = 0; i < 2; i++) {
				int numCarte = (int) (Math.random() * 3);
				if (numCarte != 0) {
					j.ajouterVieFuture(p.getSource().getCarte(numCarte - 1));
				}
			}
		}
	}
}