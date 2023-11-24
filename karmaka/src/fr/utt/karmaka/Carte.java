package fr.utt.karmaka;

public class Carte {
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

	public Carte(int points, int nbCartes, String nom, String couleur) {
		this.setPoints(points);
		this.setNbCartes(nbCartes);
		this.setNom(nom);
		this.setCouleur(couleur);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();	
		sb.append(nom + "(" +points+" points, "+ nbCartes+" cartes dans le paquet)" +"\n");
		return sb.toString();
	}
	
	
	public void jouerPouvoir() {
		
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
}
