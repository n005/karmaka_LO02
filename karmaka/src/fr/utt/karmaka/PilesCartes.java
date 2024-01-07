package fr.utt.karmaka;

import java.io.Serializable;
import java.util.*;

/**
 * Classe PilesCartes
 */
public class PilesCartes implements Serializable{
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
		try {
			return this.cartes.get(index);
		}
		catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("La pile est vide");
		}
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
		StringBuilder sb = new StringBuilder();
		Iterator<Carte> it = cartes.iterator();
		if (!it.hasNext() || cartes.isEmpty()) {
			sb.append("La pile est vide");
		} else {
			while (it.hasNext()) {
				Carte carte = it.next();
				if (carte != null) {
					sb.append(carte.toString());
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Methode distribuerUneCarte
	 * @return
	 */
	// retire la premiére carte de la pile de cartes 
	// ajout exception si la pile est vide
	public Carte distribuerUneCarte(){ 
		Carte c;
		// on retire la carte du dessus de la pile de cartes
		try {
			c= this.cartes.get(0);
			this.cartes.remove(0);
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("La pile est vide");
			c=null;
		}
	return c;
		
	}
	
	public void viderPile() {
		cartes.clear();
	}
	
	
}
