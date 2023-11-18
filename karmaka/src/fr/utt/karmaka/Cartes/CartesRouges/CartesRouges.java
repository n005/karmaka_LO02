package fr.utt.karmaka.Cartes.CartesRouges;

import fr.utt.karmaka.Carte;

public class CartesRouges extends Carte{
	private String couleur;

	public CartesRouges(int points, int nbCartes, String nom) {
		super(points, nbCartes, nom);
		this.couleur="Rouge";
	}
	
	
}
