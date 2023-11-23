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

/*	public void DonnerCarteMiseEnPlace(Joueur j1, Joueur j2) {
		source.melanger();
		// main de départ
		for (int i = 0; i < 4; i++) {
			Carte c;
			c = source.distribuerUneCarte();
			j1.ajouterMain(c);
			c = source.distribuerUneCarte();
			j2.ajouterMain(c);
		}
		// pile initiale
		for (int i = 0; i < 2; i++) {
			Carte c;
			c = source.distribuerUneCarte();
			j1.ajouterPile(c);
			c = source.distribuerUneCarte();
			j2.ajouterPile(c);
		}

	}
*/
	public void DonnerCarteMiseEnPlace(Joueur... joueurs) {
		source.melanger();
		// main de départ
		for (Joueur joueur : joueurs) {
		for (int i = 0; i < 4; i++) {
			Carte c;
			c = source.distribuerUneCarte();
			joueur.ajouterMain(c);
		}
		// pile initiale
		for (int i = 0; i < 2; i++) {
			Carte c;
			c = source.distribuerUneCarte();
			joueur.ajouterPile(c);
		}
		}
	}
	
	public Joueur creerJoueur() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisiser le nom du joueur :");
		String nom = sc.nextLine();
		Joueur j = new Joueur(nom);
		return j;
	}
	
	public int choisirCarteAJouer(Joueur j) {
		System.out.println(j.mainToString());
		System.out.println("Taper le numéro de la carte que vous voulez jouer :");
		Scanner scCarte = new Scanner(System.in);
		int numCarte = scCarte.nextInt();
		return numCarte;
	}

	public void jouerUnTour(Joueur j) {
		//debut du tour
		j.piocher();
		System.out.println("C'est au tour de "+j.getNom());
		System.out.println(j);
		// choix des actions du joueur
		Scanner scChoix = new Scanner(System.in);
		System.out.println("Taper 1 pour jouer une carte pour ses points, 2 pour son pouvoir, 3 pour votre futur, 4 pour passer");
		int choix = scChoix.nextInt();
		switch (choix) {
		case 1: {
			int numCarte = this.choisirCarteAJouer(j);
			j.jouerPoints(numCarte);
			break;
		}
		case 2: {
			int numCarte = this.choisirCarteAJouer(j);
			j.jouePouvoir(numCarte);
			break;

		}
		case 3: {
			int numCarte = this.choisirCarteAJouer(j);
			j.jouerFuture(numCarte);
			break;

		}
		case 4: {
			j.passer();
			System.out.println("");
			break;

		}
		default:
			System.out.println("choix incorect");
			break;
		}
	}

	public void jeuDeuxJoueurs() {
		// création des joueurs et ajout
		Joueur joueur1 = this.creerJoueur();
		this.ajouterUnJoueur(joueur1);
		Joueur joueur2 = this.creerJoueur();
		this.ajouterUnJoueur(joueur2);
		// distribution des cartes
		this.DonnerCarteMiseEnPlace(joueur1, joueur2);
		System.out.println(joueur1);
		System.out.println(joueur2);
		while ((joueur1.getEchelonKarmique() != EchelleKarmique.TRANSCENDANCE)
				|| (joueur1.getEchelonKarmique() != EchelleKarmique.TRANSCENDANCE)) {
			this.jouerUnTour(joueur1);
			this.jouerUnTour(joueur2);
		}

	}

	public void jeuOrdinateur() {

	}

	public static void main(String[] args) {

		// création de la partie
		Partie karmaka = new Partie();

		// texte d'accueil
		System.out.println("Bienvenue dans Karmaka !");

		// choix du mode de jeu
		
		Scanner scChoix = new Scanner(System.in);
		System.out.println("Taper 1 pour jouer contre l'ordinateur ou 2 pour jouer avec quelqu'un :");
		int choix = scChoix.nextInt();
		System.out.println("Vous avez saisi : " + choix);

		switch (choix) {
		case 1: {
			System.out.println("Démarage d'une partie contre l'ordinateur");
			break;
		}
		case 2: {
			System.out.println("Démarage d'une partie à deux joueur");
			karmaka.jeuDeuxJoueurs();
			break;

		}
		default:
			System.out.println("choix incorect");
			break;
		}

		/*
		  //création des joueurs 
		  Joueur joueur1 = new Joueur("J1"); 
		  Joueur joueur2 = new Joueur("J2");
		  
		  // on ajoute les 2 joueurs à la partie karmaka.ajouterUnJoueur(joueur1);
		  karmaka.ajouterUnJoueur(joueur2);
		  
		  System.out.println(joueur1);
		  
		  System.out.println(karmaka.source);
		  
		  karmaka.DonnerCarteMiseEnPlace(joueur1, joueur2);
		  System.out.println(joueur1);
		*/ 
	}
}
