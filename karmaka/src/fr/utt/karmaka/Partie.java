package fr.utt.karmaka;

import java.util.*;

public class Partie {
	private ArrayList<Joueur> listeJoueur;
	private Source source;
	private Fosse fosse;

	public Fosse getFosse() {
		return fosse;
	}

	public void setFosse(Fosse fosse) {
		this.fosse = fosse;
	}

	public Partie() {
		this.listeJoueur = new ArrayList<Joueur>();
		this.source = new Source();
		this.fosse = new Fosse();

	}

	// ajout d'un joueur à la liste des joueurs
	public void ajouterUnJoueur(Joueur joueur) {
		this.listeJoueur.add(joueur);
	}

	public void rennaitre(Joueur j) {
		j.rennaissance();
		// defausser les ouevres dans la fosse
		this.fosse.ajouterCarte(j.getOeuvres());
		j.viderOeuvres();
		// Creer la nouvelle pile
		while ((j.getMain().getSize() + j.getPile().getSize()) < 6) {
			// piocher des cartes a la source et les ajouter a la pile du joueur
			Carte c;
			c = source.distribuerUneCarte();
			j.ajouterPile(c);
		}
	}

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

	public void jouerUneCarte(Joueur j) {
		// choix des actions du joueur
		Scanner scChoix = new Scanner(System.in);
		System.out.println(
				"Taper 1 pour jouer une carte pour ses points, 2 pour son pouvoir, 3 pour votre futur, 4 pour passer");
		int choix = scChoix.nextInt();
		switch (choix) {
		case 1: {
			int numCarte = this.choisirCarteAJouer(j);
			j.jouerPoints(numCarte);
			break;
		}
		case 2: {
			int numCarte = this.choisirCarteAJouer(j);
			// appeler le bon pouvoir de la carte
			Carte carte = j.getMain().getCarte(numCarte);
			j.jouePouvoir(carte, this.listeJoueur.get(1 - this.listeJoueur.indexOf(j)), this);
			// proposer à l'autre joueur de recup la carte
			System.out.println("Le joueur "+this.listeJoueur.get(1 - this.listeJoueur.indexOf(j)).getNom()+" doit faire un choix  :");
			Scanner scChoixRecupCarte = new Scanner(System.in);
			System.out.println(
					"Taper 1 pour Récuperer la carte qui vient d'être jouée, 2 pour la défausser");
			int choixRecupCarte = scChoixRecupCarte.nextInt();
			switch(choixRecupCarte) {
			case 1:
				this.listeJoueur.get(1 - this.listeJoueur.indexOf(j)).ajouterVieFuture(carte);;
				break;
			case 2:
				this.fosse.ajouterCarte(carte);
				break;
			default:
				break;
			}
			PilesCartes cartesMain = j.getMain();
			cartesMain.supprimerCarte(numCarte);
			j.setMain(cartesMain);
			break;

		}
		
		case 3: {
			int numCarte = this.choisirCarteAJouer(j);
			j.jouerFuture(numCarte);
			break;

		}
		case 4: {
			boolean passable = j.passer();
			if (passable) {
				System.out.println("Vous passez votre tour.");
				break;
			} else {
				System.out.println("Vous ne pouvez pas passer votre tour car votre pile est vide");
				// reproposer le choix
			}

		}
		default:
			System.out.println("choix incorect");
			break;
		}
	}

	public void jouerUnTour(Joueur j) {
		// verifier que la source n'est pas vide
		// si elle est vide, on reprends les cartes de la fosse pour les ajouter à la
		// source (sauf les 3premières)
		if (this.source.getSize() == 0) {
			this.source.ajouterCarte(this.fosse.recupererCartesFosse());
		}
		if (j.getPile().getSize() == 0 && j.getMain().getSize() == 0) {
			this.rennaitre(j);
		} else {
			// debut du tour
			j.piocher();
			System.out.println("C'est au tour de " + j.getNom());
			System.out.println(j);
			this.jouerUneCarte(j);

		}
	}

	public void jeuDeuxJoueurs() { // NB: Add generalisation here
		// création des joueurs et ajout
		Joueur joueur1 = this.creerJoueur();
		this.ajouterUnJoueur(joueur1);
		Joueur joueur2 = this.creerJoueur();
		this.ajouterUnJoueur(joueur2);
		// distribution des cartes
		this.DonnerCarteMiseEnPlace(joueur1, joueur2);
		// System.out.println(joueur1);
		// System.out.println(joueur2);
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
		 * //création des joueurs Joueur joueur1 = new Joueur("J1"); Joueur joueur2 =
		 * new Joueur("J2");
		 * 
		 * // on ajoute les 2 joueurs à la partie karmaka.ajouterUnJoueur(joueur1);
		 * karmaka.ajouterUnJoueur(joueur2);
		 * 
		 * System.out.println(joueur1);
		 * 
		 * System.out.println(karmaka.source);
		 * 
		 * karmaka.DonnerCarteMiseEnPlace(joueur1, joueur2);
		 * System.out.println(joueur1);
		 */
	}
	public Source getSource() {
		return this.source;
	}

	public void afficherJoueurs() {
		for (int i = 0; i < this.listeJoueur.size(); i++) {
			System.out.println(i + " : " + this.listeJoueur.get(i).getNom());
		}
	}

	public int choisirJoueur() {
		Scanner scJoueur = new Scanner(System.in);
		int numJoueur = scJoueur.nextInt();
		return numJoueur;
	}

	public Joueur getJoueur(int numJoueur) {
		return this.listeJoueur.get(numJoueur);
	}
}
