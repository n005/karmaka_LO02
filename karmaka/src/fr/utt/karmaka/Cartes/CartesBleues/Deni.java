package fr.utt.karmaka.Cartes.CartesBleues;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

/**
 * Classe Deni
 */
public class Deni extends CartesBleues{
	public Deni() {
		super(2,3,"Déni");
	}
//Défaussez une carte de votre Main.
//Copiez le pouvoir de cette carte.
/**
 * Permet de jouer le pouvoir de la carte
 * @param j
 * 			Joueur qui joue la carte
 * @param p
 * 			Partie en cours
 */
public void jouerPourvoir( Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte "+this.getNom());
		System.out.println("Vous devez défausser une carte de votre main");
		p.jouerUneCarte(j);
}
}
