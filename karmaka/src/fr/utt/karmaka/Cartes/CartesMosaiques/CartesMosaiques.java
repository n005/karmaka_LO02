package fr.utt.karmaka.Cartes.CartesMosaiques;

import fr.utt.karmaka.Carte;

public class CartesMosaiques extends Carte{
	private String couleur;

	public CartesMosaiques(int points, int nbCartes, String nom) {
		super(points, nbCartes, nom);
		this.couleur="Mosaique";
	}

	
}
