package fr.utt.karmaka.Cartes.CartesBleues;

import fr.utt.karmaka.Carte;

public class CartesBleues extends Carte{
	private String couleur;

	public CartesBleues(int points, int nbCartes, String nom) {
		super(points, nbCartes, nom);
		this.couleur="Bleue";
	}

}
