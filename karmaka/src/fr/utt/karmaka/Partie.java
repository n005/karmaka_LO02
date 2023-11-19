package fr.utt.karmaka;

import java.util.*;



public class Partie {
	private ArrayList<Joueur> listeJoueur;
	private Source source;

	public Partie() {
		this.listeJoueur = new ArrayList<Joueur>();
		this.source = new Source();

	}

	// ajout d'un joueur à la liste des joueurs
	public void ajouterUnJoueur(Joueur joueur) {
		this.listeJoueur.add(joueur);
	}

	public void DonnerCarteMiseEnPlace(Joueur j1, Joueur j2) {
		source.melanger();
		// main de départ
		for (int i=0; i < 4; i++) {
			Carte c;
			c = source.distribuerUneCarte();
			j1.ajouterMain(c);
			c = source.distribuerUneCarte();
			j2.ajouterMain(c);
		}
		//pile initiale
		for (int i=0; i < 2; i++) {
			Carte c;
			c = source.distribuerUneCarte();
			j1.ajouterPile(c);
			c = source.distribuerUneCarte();
			j2.ajouterPile(c);
		}

	}

	public static void main(String[] args) {

		// création de la partie
		Partie karmaka = new Partie();

		// création des joueurs
		Joueur joueur1 = new Joueur("J1");
		Joueur joueur2 = new Joueur("J2");

		// on ajoute les 2 joueurs à la partie
		karmaka.ajouterUnJoueur(joueur1);
		karmaka.ajouterUnJoueur(joueur2);

		System.out.println(joueur1);

		System.out.println(karmaka.source);
		
		karmaka.DonnerCarteMiseEnPlace(joueur1, joueur2);
		System.out.println(joueur1);
		// instancier les cartes
		// afficher les cartes
		// distrib les cartes
	}
}
