package fr.utt.karmaka;

import java.io.Serializable;
import java.util.Scanner;
/**
 * Classe représentant une carte.
 */
public class Carte implements Serializable{
	private int points;
	private int nbCartes;
	private String nom;
	private String couleur;

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	/**
	 * Constructeur de la carte.
	 * @param points
	 * @param nbCartes
	 * @param nom
	 * @param couleur
	 */
	public Carte(int points, int nbCartes, String nom, String couleur) {
		this.setPoints(points);
		this.setNbCartes(nbCartes);
		this.setNom(nom);
		this.setCouleur(couleur);
	}
	/**
	 * Construit une chaîne de caractère contenant les informations de la carte.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(nom + "(" + points + " points, " + nbCartes + " cartes dans le paquet)" + "\n");
		return sb.toString();
	}

	/**
	 * Permet d'utiliser le pouvoir de la carte.
	 * @param joueur
	 * @param rival
	 * @param p
	 */
	public void jouerPouvoir(Joueur joueur, Joueur rival, Partie p) {

	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int choisirCarte(int maxvalue) {
		Scanner scCarte = new Scanner(System.in);
		int numCarte = scCarte.nextInt();
		while (numCarte < 0 || numCarte > maxvalue) {
			System.out.println("Veuillez saisir un numéro valide");
			numCarte = scCarte.nextInt();
		}
		return numCarte;
	}
}
