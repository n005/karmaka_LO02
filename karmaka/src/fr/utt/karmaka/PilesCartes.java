package fr.utt.karmaka;

import java.io.Serializable;
import java.util.*;

/**
 * Classe PilesCartes
 */
public class PilesCartes implements Serializable {
	protected ArrayList<Carte> cartes;

	/**
	 * Constructeur de pilesCartes
	 */
	public PilesCartes() {
		this.cartes = new ArrayList<Carte>();
	}

	/**
	 * Permet de supprimer la carte passée en paramètre de la pile.
	 * 
	 * @param carte
	 */
	public void supprimerCarte(Carte carte) {
		this.cartes.remove(carte);
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public Carte getCarte(int index) {
		try {
			return this.cartes.get(index);
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("La pile est vide");
		}
	}

	public void setCartes(ArrayList<Carte> cartes) {
		this.cartes = cartes;
	}

	/**
	 * Permer d'ajouter la carte passée en paramètre dans la pile.
	 * 
	 * @param carte
	 */
	public void ajouterCarte(Carte carte) {
		this.cartes.add(carte);

	}

	/**
	 * Permet d'ajouter toutes les cartes de la pile de cartes passée en paramètre
	 * dans cette pile.
	 * 
	 * @param cartes
	 */
	public void ajouterCarte(PilesCartes cartes) {
		for (int i = 0; i < cartes.getSize(); i++) {
			Carte c = cartes.getCarte(i);
			this.ajouterCarte(c);
		}
	}

	/**
	 * Supprime la carte ayant pour indice le chiffre passée en paramètre.
	 * 
	 * @param index
	 */
	public void supprimerCarte(int index) {
		this.cartes.remove(index);

	}

	/**
	 * Retourne le nombre de carte dans la pile de cartes.
	 * 
	 * @return nbCartes
	 */
	public int getSize() {
		return this.cartes.size();
	}

	/**
	 * Mélange les cartes de la pile.
	 */
	public void melanger() {
		Collections.shuffle(cartes);
	}

	/**
	 * Construit une chaine de caractère contenant les informations de toutes les
	 * cartes de la pile.
	 */
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
	 * 
	 * @return
	 */
	// retire la premiére carte de la pile de cartes
	// ajout exception si la pile est vide
	public Carte distribuerUneCarte() {
		Carte c;
		// on retire la carte du dessus de la pile de cartes
		try {
			c = this.cartes.get(0);
			this.cartes.remove(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La pile est vide");
			c = null;
		}
		return c;

	}

	/**
	 * Permet de vider entièrement la pile de cartes.
	 */
	public void viderPile() {
		cartes.clear();
	}

}
