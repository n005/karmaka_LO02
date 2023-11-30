package fr.utt.karmaka.Cartes.CartesVertes;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Lendemain extends CartesVertes{
	public Lendemain() {
		super(1,3,"Lendemain");
	}
public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
	System.out.println("Vous jouez la carte "+this.getNom());
	j.piocher();
	p.jouerUneCarte(j);
	}
}
