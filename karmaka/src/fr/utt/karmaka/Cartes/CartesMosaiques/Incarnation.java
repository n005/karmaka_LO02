package fr.utt.karmaka.Cartes.CartesMosaiques;

import java.util.Scanner;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Incarnation extends CartesMosaiques {
	public Incarnation() {
		super(1, 5, "Incarnation");
	}

	// Choisissez une de vos Oeuvres. Copiez son pouvoir.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Choisissez une de vos Oeuvres. Copiez son pouvoir.");
		// Affiche les oeuvres du joueur
		System.out.println("Vos oeuvres sont :");
		for (int i = 0; i < j.getOeuvres().getSize(); i++) {
			System.out.println(i + " : " + j.getOeuvres().getCartes());
		}
		System.out.println("Taper le numéro de l'oeuvre dont vous voulez copier le pouvoir :");
		int numOeuvre = this.choisirCarte(j.getOeuvres().getSize());
		j.getOeuvres().getCarte(numOeuvre).jouerPouvoir(j, rival, p);
	}
}
