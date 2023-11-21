package fr.utt.karmaka;

import fr.utt.karmaka.Cartes.*;
import java.util.*;

public class Joueur {
	private String nom;
	private int anneauxKarmique;
	private int points;
	private PilesCartes pile;
	private PilesCartes vieFuture;
	private PilesCartes main;
	private PilesCartes oeuvres;
	private EchelleKarmique echelonKarmique;
	
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
		sb.append(this.nom +" est à l'echellon "+this.echelonKarmique + ", a  " +  this.points + " points et "+ this.anneauxKarmique +" anneaux Karmiques\n");
		sb.append("Pile : \n"+this.pile+"\n");
		sb.append("Vie Future : \n"+this.vieFuture+"\n");
		sb.append("Main : \n"+this.main+"\n");
		sb.append("Oeuvres : \n"+this.oeuvres+"\n");
		sb.append("\n ******************************************* \n");
		return sb.toString();
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void jouerPoints(Carte carte) {
		this.oeuvres.ajouterCarte(carte);
		this.main.supprimerCarte(carte);
	}
	
	public void jouerFuture(Carte carte) {
		this.vieFuture.ajouterCarte(carte);
		this.main.supprimerCarte(carte);
	}
	
	public void piocher() {
		if(this.pile.getSize()!=0) {
			//le joueur pioche une carte dans sa pile
			Random r = new Random();
			int numCarte = r.nextInt(this.pile.getSize());
			this.main.ajouterCarte(this.pile.getCarte(numCarte));
			this.pile.supprimerCarte(numCarte);
		}
			
		
	}
	
	public void jouePouvoir(Carte carte) {
		
	}
	
	public void passer() {
		if(this.pile.getSize()!=0) {
			//passer le tour
		}
		else {
			//forcer le joueur à jouer 
		}
		
	}
	
	public void compterPointsOeuvres() {
		
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

	public EchelleKarmique getEchelonKarmique() {
		return echelonKarmique;
	}

	public void setEchelonKarmique(EchelleKarmique echelonKarmique) {
		this.echelonKarmique = echelonKarmique;
	}
	
}
