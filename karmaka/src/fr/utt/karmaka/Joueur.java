package fr.utt.karmaka;

import fr.utt.karmaka.Cartes.*;

import java.io.Serializable;
import java.util.*;

/**
 * Classe Joueur
 * 
 * @version 1.0
 * @since 1.0
 */
public class Joueur implements Serializable{
	private String nom;
	private int anneauxKarmique;
	private int points;
	private PilesCartes pile;
	private PilesCartes vieFuture;
	private PilesCartes main;
	private PilesCartes oeuvres;
	private EchelleKarmique echelonKarmique;
	
	/**
	 * Constructeur de la classe Joueur
	 * 
	 * @param nom
	 *            nom du joueur
	 */
	public Joueur(String nom) {
		this.setNom(nom);
		this.pile = new PilesCartes();
		this.vieFuture = new PilesCartes();
		this.main = new PilesCartes();
		this.oeuvres = new PilesCartes();
		this.echelonKarmique= EchelleKarmique.BOUSIER;
		
	}
	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\n ******************************************* \n");		
		sb.append(this.nom +" est à l'echellon "+this.echelonKarmique + " et "+ this.anneauxKarmique +" anneaux Karmiques\n");
		//La pile ne doit pas être devoilée quand on joue
		sb.append("Pile : \n"+this.pile+"\n");
		sb.append("Vie Future : \n"+this.vieFuture+"\n");
		sb.append("Main : \n"+this.main+"\n");
		sb.append("Oeuvres : \n"+this.oeuvres+"\n");
		sb.append("\n ******************************************* \n");
		return sb.toString();
	}
	
	public String mainToString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Main :\n");
		for (int i=0;i<this.main.getSize();i++) {
			sb.append(i+" : "+ this.main.getCarte(i));
		}
		return sb.toString();
	}
	
	public String vieFutureToString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Votre vie future :\n");
		for (int i=0;i<this.vieFuture.getSize();i++) {
			sb.append(i+" : "+ this.main.getCarte(i));
		}
		return sb.toString();
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}


	public void jouerPoints(int indexCarte) {
		Carte carte = this.main.getCarte(indexCarte);
		this.oeuvres.ajouterCarte(carte);
		this.main.supprimerCarte(carte);
	}
	
	public void jouerFuture(int indexCarte) {
		Carte carte = this.main.getCarte(indexCarte);
		this.vieFuture.ajouterCarte(carte);
		this.main.supprimerCarte(carte);
	}
	
	/**
	 * Méthode qui permet de piocher une carte dans la pile
	 */
	public void piocher() {
		if(this.pile.getSize()!=0) {
			//le joueur pioche une carte dans sa pile
			Random r = new Random();
			int numCarte = r.nextInt(this.pile.getSize());
			this.main.ajouterCarte(this.pile.getCarte(numCarte));
			this.pile.supprimerCarte(numCarte);
		}
			
		
	}
	
	/**
	 * Méthode qui permet de jouer une carte pour son pouvoir
	 * 
	 * @param carte
	 *            carte à jouer
	 * @param rival
	 *            joueur rival
	 * @param p
	 *            partie en cours
	 */
	public void jouePouvoir(Carte carte,Joueur rival, Partie p) {
		carte.jouerPouvoir(this,rival,p);
		
	}
	
	/**
	 * Méthode qui permet de choisir une carte à déplacer
	 * 
	 * @return carte à déplacer
	 */
	public Carte choisirCarteADeplacer() {
		System.out.println(this.vieFutureToString());
		System.out.println("Taper le numéro de la carte que vous voulez déplacer :");
		Scanner scCarte = new Scanner(System.in);
		int numCarte = scCarte.nextInt();
		Carte c = this.vieFuture.getCarte(numCarte);
		//a modif
		//suprimer la carte de vie future
		this.vieFuture.supprimerCarte(numCarte);
		return c;
	}
	
	public boolean passer() {
		boolean passable;
		if(this.pile.getSize()!=0) {
			passable=true;
		}
		else {
			passable=false;
		}
		return passable;
		
	}
	
	
	//on compte les points par couleur, les cartes mosaiques comptes dans toutes les couleurs
	//le joueur recois les points de sa couleur la plus rentable 
	/**
	 * Méthode qui permet de compter les points des oeuvres
	 * @return points des oeuvres
	 */
	public int compterPointsOeuvres() {
		int[] nbPointsCouleur = {0,0,0};//0 Rouge, 1 Vert, 2 Bleu 
		for(int i=0; i<this.oeuvres.getSize();i++) {
			Carte c =this.oeuvres.getCarte(i);
			//verifie s'il y a des cartes
			if (c == null) {
				return Arrays.stream(nbPointsCouleur).max().getAsInt();
			}
			switch (c.getCouleur()) {
			case "Rouge": 
				nbPointsCouleur[0] += c.getPoints();
				break;
			case "Verte":
				nbPointsCouleur[1] += c.getPoints();
				break;
			case "Bleue":
				nbPointsCouleur[2] += c.getPoints();
				break;
			case "Mosaique":
				nbPointsCouleur[0] += c.getPoints();
				nbPointsCouleur[1] += c.getPoints();
				nbPointsCouleur[2] += c.getPoints();
				break;
			default:
				break;
			}
			
		}
		return Arrays.stream(nbPointsCouleur).max().getAsInt();
	}
	
	/**
	 * Méthode qui permet de rennaitre
	 */
	public void rennaissance() {
		//marquer les points
		points=compterPointsOeuvres();
		//defaussez les oeuvres dans la fosse
		//oeuvres.viderPile();
		//Les cartes de la vieFuture constituent la nouvelle main
		for(int i=0;i<vieFuture.getSize();i++) {
			Carte c = vieFuture.getCarte(i);
			main.ajouterCarte(c);
			vieFuture.supprimerCarte(i);
		}
		points = anneauxKarmique + points; // NB: ON DEMANDE OU PAS LES ANNEAUX ?
		//passer à l'échellon supérieur ou pas
		switch(getEchelonKarmique()) {
		//4 points 
		case BOUSIER:
			if(points>=4) {
				setEchelonKarmique(EchelleKarmique.SERPENT);
			}
			else
				anneauxKarmique +=1;
			
			break;
		//5 points
		case SERPENT:
			if(points>=5){
				setEchelonKarmique(EchelleKarmique.LOUP);
				}
			else
				anneauxKarmique +=1;
			break;
		//6 pts
		case LOUP:
			if(points>=6) {
			setEchelonKarmique(EchelleKarmique.SINGE);
			}
			else
				anneauxKarmique +=1;
			break;
		//7 pts
		case SINGE:
			if(points>=7) {
			setEchelonKarmique(EchelleKarmique.TRANSCENDANCE);
			}
			else
				anneauxKarmique +=1;
			break;
		default:
			break;
		
		}
		points=0;
	}

	/**
	 * Méthode qui permet de savoir si le joueur a gagné
	 * @return true si le joueur a gagné, false sinon
	 */
	public Boolean aGagner() {
		if (this.getEchelonKarmique() == EchelleKarmique.TRANSCENDANCE) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAnneauxKarmique() {
		return anneauxKarmique;
	}

	public void setAnneauxKarmique(int anneauxKarmique) {
		this.anneauxKarmique = anneauxKarmique;
	}

	public PilesCartes getPile() {
		return pile;
	}

	public void setPile(PilesCartes pile) {
		this.pile = pile;
	}

	public void ajouterPile(Carte carte) {
		this.pile.ajouterCarte(carte);
	}
	public PilesCartes getVieFuture() {
		return vieFuture;
	}

	public void setVieFuture(PilesCartes vieFuture) {
		this.vieFuture = vieFuture;
	}

	
	public PilesCartes getMain() {
		return main;
	}

	public void setMain(PilesCartes main) {
		this.main = main;
	}
	
	public void ajouterMain(Carte carte) {
		this.main.ajouterCarte(carte);
	}

	public PilesCartes getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(PilesCartes oeuvres) {
		this.oeuvres = oeuvres;
	}

	public void viderOeuvres() {
		this.oeuvres.viderPile();
	}
	
	public EchelleKarmique getEchelonKarmique() {
		return echelonKarmique;
	}

	public void setEchelonKarmique(EchelleKarmique echelonKarmique) {
		this.echelonKarmique = echelonKarmique;
	}

	public void ajouterVieFuture(Carte carte) {
		this.vieFuture.ajouterCarte(carte);
		
	}
	
}
