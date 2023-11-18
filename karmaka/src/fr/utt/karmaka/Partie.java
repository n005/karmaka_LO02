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

	public static void main(String[] args) {

		// création de la partie
		Partie karmaka = new Partie();

		// création des joueurs
		Joueur joueur1= new Joueur("J1");
		Joueur joueur2= new Joueur("J2");
		
		// on ajoute les 2 joueurs à la partie
		karmaka.ajouterUnJoueur(joueur1);
		karmaka.ajouterUnJoueur(joueur2);
		
		System.out.println(joueur1);
		
		System.out.println(karmaka.source);
		// instancier les cartes
		//afficher les cartes
		//distrib les cartes
	}
}
