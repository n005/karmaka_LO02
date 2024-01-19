package fr.utt.karmaka.Cartes.CartesMosaiques;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.JoueurVirtuel;
import fr.utt.karmaka.Partie;

/**
 * Class Mimetisme
 */
public class Mimetisme extends CartesMosaiques {
	public Mimetisme() {
		super(1, 2, "Mimétisme");
	}

	// Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée (la plus
	// récente).
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		if (!(j instanceof JoueurVirtuel)) {
			System.out.println("Vous jouez la carte " + this.getNom());
			System.out.println("Choisissez un Rival. Copiez le pouvoir de son Oeuvre Exposée (la plus récente).");
			rival.getOeuvres().getCarte(rival.getOeuvres().getSize() - 1).jouerPouvoir(j, rival, p);
		}
	}
}
