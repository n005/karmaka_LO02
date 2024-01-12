package fr.utt.karmaka;

/**
 * Classe représentant l'ordinateur.
 */
public class JoueurVirtuel extends Joueur {
	private Strategie strategie;
	private Partie partie;

	/**
	 * Constructeur de JoueurVirtuel.
	 * 
	 * @param nom
	 * @param s
	 * @param p
	 */
	public JoueurVirtuel(String nom, Strategie s, Partie p) {
		super(nom);
		this.strategie = s;
		this.partie = p;

	}

	/**
	 * Permet à l'ordinateur de jouer. Appel la méthode jouerBot de la stratégie
	 * définie lors de l'instanciation du bot.
	 */
	public void jouerBot() {
		strategie.jouer(this, this.partie);
	}

}
