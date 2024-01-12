package fr.utt.karmaka;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Classe principale du jeu. Permet de jouer à Karmaka contre à deux joueurs ou bien seul contre l'ordinateur.
 * 
 * @version 1.0
 * @since 1.0
 */
public class Partie implements Serializable {
	private ArrayList<Joueur> listeJoueur;
	private Source source;
	private Fosse fosse;
	private int nbJoueurCourant;

	public int getNbJoueurCourant() {
		return nbJoueurCourant;
	}

	public void setNbJoueurCourant(int nbJoueurCourant) {
		this.nbJoueurCourant = nbJoueurCourant;
	}

	public Boolean getEstContreOrdinateur() {
		return estContreOrdinateur;
	}

	public void setEstContreOrdinateur(Boolean estContreOrdinateur) {
		this.estContreOrdinateur = estContreOrdinateur;
	}

	private Boolean estContreOrdinateur;

	public Fosse getFosse() {
		return fosse;
	}

	public void setFosse(Fosse fosse) {
		this.fosse = fosse;
	}

	/**
	 * Constructeur d'une partie
	 */
	public Partie() {
		this.listeJoueur = new ArrayList<Joueur>();
		this.source = new Source();
		this.fosse = new Fosse();

	}

	// ajout d'un joueur à la liste des joueurs
	/**
	 * Permet d'ajouter un joueur dans la partie.
	 * @param joueur à ajouter dans la partie
	 */
	public void ajouterUnJoueur(Joueur joueur) {
		this.listeJoueur.add(joueur);
	}

	/**
	 * Permet de faire rennaitre un joueur à l'échellon supérieur
	 * 
	 * @param j : joueur à faire rennaitre
	 */
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
		System.out.println(j.getNom() + " se réincarne.");
	}

	/**
	 * Permet de distribuer les cartes au début de la partie.
	 * @param joueurs aux quels il faut donner des cartes
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

	/**
	 * Permet de créer un nouveau joueur en demandant le nom à l'utilisateur.
	 * @return j le joueur créé
	 */
	public Joueur creerJoueur() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisiser le nom du joueur :");
		String nom = sc.nextLine();
		Joueur j = new Joueur(nom);
		return j;
	}

	/**
	 * Permet au joueur de choisir le numéro de la carte qu'il souhaite jouer.
	 * @param j le joueur qui doit jouer
	 * @return numCarte le numéro de la carte choisi par le joueur
	 */
	public int choisirCarteAJouer(Joueur j) {
		System.out.println(j.mainToString());
		System.out.println("Taper le numéro de la carte que vous voulez jouer :");
		Scanner scCarte = new Scanner(System.in);
		int numCarte;
		while (true) {
			try {
				numCarte = scCarte.nextInt();
				if (numCarte >= 0 && numCarte <= j.getMain().getSize())
					break;
				else {
					System.out.println("Entrée incorrecte !");
					System.out.println("Taper le numéro de la carte que vous voulez jouer :");		
					scCarte.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrée incorrecte !");
				System.out.println("Taper le numéro de la carte que vous voulez jouer :");
				scCarte.nextLine();
			}
		}
		return numCarte;
	}

	/**
	 * Permet de récuperer le choix du joueur, et de lui permettre de joueur son
	 * tour
	 * 
	 * @param j : joueur à faire jouer
	 */
	public void jouerUneCarte(Joueur j) {
		// choix des actions du joueur
		Scanner scChoix = new Scanner(System.in);
		System.out.println(
				"Taper 1 pour jouer une carte pour ses points, 2 pour son pouvoir, 3 pour votre futur, 4 pour passer");
		int choix;

		while (true) {
			try {
				choix = scChoix.nextInt();
				if (choix >= 1 && choix <= 3)
					break;
				else {
					System.out.println("Entrée incorrecte !");
					System.out.println(
							"Taper 1 pour jouer une carte pour ses points, 2 pour son pouvoir, 3 pour votre futur, 4 pour passer");
					scChoix.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrée incorrecte !");
				System.out.println(
						
						"Taper 1 pour jouer une carte pour ses points, 2 pour son pouvoir, 3 pour votre futur, 4 pour passer");
				scChoix.nextLine();
			}
		}

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
			System.out.println("Le joueur " + this.listeJoueur.get(1 - this.listeJoueur.indexOf(j)).getNom()
					+ " doit faire un choix  :");
			Scanner scChoixRecupCarte = new Scanner(System.in);
			System.out.println("Taper 1 pour Récuperer la carte qui vient d'être jouée, 2 pour la défausser");
			int choixRecupCarte = scChoixRecupCarte.nextInt();
			switch (choixRecupCarte) {
			case 1:
				this.listeJoueur.get(1 - this.listeJoueur.indexOf(j)).ajouterVieFuture(carte);
				;
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

	/**
	 * Permet de choisir de sauvegarder la partie ou non. Puis, la méthode lance le
	 * tour du joueur.
	 * 
	 * @param j : joueur en cours
	 */
	public void jouerUnTour(Joueur j) {
		System.out.println("****************************");
		System.out.println("Tour de " + j.getNom());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Appuyez sur entrée pour jouer ou tapez \"s\" pour sauvegarder la partie :");
		this.setNbJoueurCourant(this.listeJoueur.indexOf(j));
		while (true) {
			String input = scanner.nextLine();

			if ("s".equals(input)) {
				// sauvegarde
				this.sauvegarder();
			} else if (input.isEmpty()) {
				// tour du joueur
				break;
			} else {
				System.out.println("Choix incorect");
			}
		}
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

	/**
	 * Lancement d'une partie à deux joueur. A chaque tour, la méthode vérifie si il
	 * y a un vainqueur.
	 */
	public void jeuDeuxJoueurs() {
		setEstContreOrdinateur(false);
		Joueur joueur1;
		Joueur joueur2;
		if (this.listeJoueur.size() != 2) {
			// création des joueurs et ajout
			joueur1 = this.creerJoueur();
			this.ajouterUnJoueur(joueur1);
			joueur2 = this.creerJoueur();
			this.ajouterUnJoueur(joueur2);
			// distribution des cartes
			this.DonnerCarteMiseEnPlace(joueur1, joueur2);
		} else {
			joueur1 = this.listeJoueur.get(0);
			joueur2 = this.listeJoueur.get(1);
		}
		while (!(joueur1.aGagner()) || (joueur1.aGagner())) {
			this.jouerUnTour(joueur1);
			this.jouerUnTour(joueur2);
		}
		if (joueur1.aGagner()) {
			System.out.println("Le joueur " + joueur1.getNom() + " a gagné !");
		} else {
			System.out.println("Le joueur " + joueur2.getNom() + " a gagné !");
		}

	}

	/**
	 * Lancement d'une partie contre l'ordinateur. A chaque tour, la méthode vérifie
	 * si il y a un vainqueur.
	 */
	public void jeuOrdinateur() {
		setEstContreOrdinateur(true);
		Joueur joueurH;
		JoueurVirtuel joueurO;
		if (this.listeJoueur.size() != 2) {
			joueurH = this.creerJoueur();
			this.ajouterUnJoueur(joueurH);
			Scanner scChoixStrategie = new Scanner(System.in);
			System.out.println(
					"Taper 1 pour que l'ordinateur soit en mode Aléatoire, 2 pour défensif, 3 pour Agressif :");
			int choixStrategie = 0;
			while (true) {
				try {
					choixStrategie = scChoixStrategie.nextInt();
					if (choixStrategie >= 1 && choixStrategie <= 3)
						break;
					else {
						System.out.println("Entrée incorrecte !");
						System.out.println(
								"Taper 1 pour que l'ordinateur soit en mode Aléatoire, 2 pour défensif, 3 pour Agressif :");
						scChoixStrategie.nextLine();
					}
				} catch (InputMismatchException e) {
					System.out.println("Entrée incorrecte !");
					System.out.println(
							"Taper 1 pour que l'ordinateur soit en mode Aléatoire, 2 pour défensif, 3 pour Agressif :");
					scChoixStrategie.nextLine();
				}
			}

			switch (choixStrategie) {
			case 1:
				joueurO = new JoueurVirtuel("L'ordinateur", new Aleatoire(), this);
				break;
			case 2:
				joueurO = new JoueurVirtuel("L'ordinateur", new Defensif(), this);
				break;
			case 3:
				joueurO = new JoueurVirtuel("L'ordinateur", new Agressif(), this);
				break;
			default:
				joueurO = new JoueurVirtuel("L'ordinateur", new Aleatoire(), this);
				break;
			}
			this.ajouterUnJoueur(joueurO);
			// distribution des cartes
			this.DonnerCarteMiseEnPlace(joueurH, joueurO);
		} else {
			joueurH = this.listeJoueur.get(0);
			joueurO = (JoueurVirtuel) this.listeJoueur.get(1);
		}
		while (!(joueurH.aGagner()) || (joueurO.aGagner())) {
			this.jouerUnTour(joueurH);
			// faire jouer le bot
			if (joueurO.getPile().getSize() == 0 && joueurO.getMain().getSize() == 0) {
				this.rennaitre(joueurO);
			}
			joueurO.jouerBot();
		}
		if (joueurH.aGagner()) {
			System.out.println("Le joueur " + joueurH.getNom() + " a gagné !");
		} else {
			System.out.println("Le joueur " + joueurO.getNom() + " a gagné !");
		}

	}

	/**
	 * Lancement de l'application, permet de choisir entre le démarage d'une partie
	 * à deux joueurs ou contre l'ordinateur. Offre aussi la possibilité de charger
	 * une partie sauvegardée.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// création de la partie
		Partie karmaka = new Partie();

		// texte d'accueil
		System.out.println("Bienvenue dans Karmaka !");
		// choix du mode de jeu

		Scanner scChoix = new Scanner(System.in);
		System.out.println(
				"Taper 1 pour jouer contre l'ordinateur ou 2 pour jouer avec quelqu'un, 3 pour charger une partie sauvegardée :");

		int choix = 0;
		while (true) {
			try {
				choix = scChoix.nextInt();
				if (choix >= 1 && choix <= 3)
					break;
				else {
					System.out.println("Entrée incorrecte !");
					System.out.println(
							"Taper 1 pour jouer contre l'ordinateur ou 2 pour jouer avec quelqu'un, 3 pour charger une partie sauvegardée :");
					scChoix.nextLine();
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrée incorrecte !");
				System.out.println(
						"Taper 1 pour jouer contre l'ordinateur ou 2 pour jouer avec quelqu'un, 3 pour charger une partie sauvegardée :");
				scChoix.nextLine();
			}
		}

		switch (choix) {
		case 1: {
			System.out.println("Démarage d'une partie contre l'ordinateur");
			karmaka.jeuOrdinateur();
			break;
		}
		case 2: {
			System.out.println("Démarage d'une partie à deux joueur");
			karmaka.jeuDeuxJoueurs();
			break;

		}
		case 3: {
			System.out.println("Chargement de la partie sauvegardée...");
			karmaka.chargerPartie();
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

	/**
	 * Méthode qui permet de sauvegarder la partie dans le fichier partie.ser
	 */
	public void sauvegarder() {
		try {
			FileOutputStream file = new FileOutputStream("partie.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this);
			out.close();
			file.close();
			System.out.println("Partie sauvegardée");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Erreur lors de la sauvegarde");
		}
	}

	/**
	 * Méthode qui permet de charger la partie enregistrée.
	 */
	public void chargerPartie() {
		try {
			FileInputStream file = new FileInputStream("partie.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			Partie partieChargee = (Partie) in.readObject();
			this.listeJoueur = partieChargee.listeJoueur;
			this.source = partieChargee.source;
			this.fosse = partieChargee.fosse;
			this.nbJoueurCourant = partieChargee.nbJoueurCourant;
			this.estContreOrdinateur = partieChargee.estContreOrdinateur;

			in.close();
			file.close();

			System.out.println("Partie chargée avec succès");
			if (this.estContreOrdinateur) {
				this.jeuOrdinateur();
			} else {
				if (this.nbJoueurCourant == 0) {
					this.jeuDeuxJoueurs();
				} else {
					this.listeJoueur = new ArrayList<Joueur>(
							Arrays.asList(this.listeJoueur.get(1), this.listeJoueur.get(0)));
					this.jeuDeuxJoueurs();
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Erreur lors du chargement de la partie");
		}
	}

}
