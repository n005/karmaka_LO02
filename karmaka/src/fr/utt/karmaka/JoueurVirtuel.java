package fr.utt.karmaka;

public class JoueurVirtuel extends Joueur{
	private Strategie strategie;
	
	public JoueurVirtuel(String nom) {
		super(nom);
		
	}

	public void jouerBot() {
		strategie = new Aleatoire();
		strategie.jouer(this);
	}

}
