package fr.utt.karmaka;

import java.util.*;

public class PilesCartes {
	private List<Carte> cartes;
	
	public void supprimerCarte(Carte carte) {
		this.cartes.remove(carte);
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public Carte getCarte(int index) {
		return this.cartes.get(index);
	}
	
	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public void ajouterCarte(Carte carte) {
		this.cartes.add(carte);
		
	}

	public void supprimerCarte(int index) {
		this.cartes.remove(index);
		
	}
	
	public int getSize() {
		return this.cartes.size();
	}
}
