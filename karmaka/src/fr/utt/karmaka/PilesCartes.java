package fr.utt.karmaka;

import java.util.*;


public class PilesCartes {
	protected ArrayList<Carte> cartes;
	
	public PilesCartes() {
		this.cartes = new ArrayList<Carte>();
	}
	
	public void supprimerCarte(Carte carte) {
		this.cartes.remove(carte);
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public Carte getCarte(int index) {
		return this.cartes.get(index);
	}
	
	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}

	public void ajouterCarte(Carte carte) {
		this.cartes.add(carte);
		
	}
	
	public void ajouterCarte(PilesCartes cartes) {
		for(int i=0;i<cartes.getSize();i++) {
			Carte c=cartes.getCarte(i);
			this.ajouterCarte(c);
		}
	}

	public void supprimerCarte(int index) {
		this.cartes.remove(index);
		
	}
	
	public int getSize() {
		return this.cartes.size();
	}
	
	public void melanger(){
		Collections.shuffle(cartes);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Iterator<Carte> it = cartes.iterator();
		while (it.hasNext()) {
			sb.append(it.next().toString());
		}
			
		return sb.toString();
	}
	
	// retire la premiére carte de la pile de cartes 
	public Carte distribuerUneCarte(){ 
		Carte c;
		// on retire la carte du dessus de la pile de cartes
		c= this.cartes.get(0);
		this.cartes.remove(0);
	return c;
		
	}
	
	public void viderPile() {
		cartes.clear();
	}
	
	
}
