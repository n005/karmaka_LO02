package fr.utt.karmaka;
/**
 * Classe Fosse.
 */
public class Fosse extends PilesCartes {

	public Fosse() {
		
	}
	/**
	 * Permet de récupérer toutes les cartes de la fosse sauf les trois dernières.
	 * @return cartesFosse
	 */
	public PilesCartes recupererCartesFosse() {
		PilesCartes cartesFosse = new PilesCartes();
		for(int i=0;i<this.cartes.size()-3;i++) {
			cartesFosse.ajouterCarte(this.cartes.get(i));
			this.cartes.remove(i);
		}
		
		return cartesFosse;
	}
}
