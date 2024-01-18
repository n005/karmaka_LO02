package fr.utt.karmaka.Cartes.CartesBleues;

import java.util.jar.JarOutputStream;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Vol
 */
public class Vol extends CartesBleues {
	public Vol() {
		super(3, 2, "Vol");
	}

	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
		} else {
		}
	}
}