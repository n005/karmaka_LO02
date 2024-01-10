package fr.utt.karmaka;

public class JoueurVirtuel extends Joueur{
	private Strategie strategie;
	
	public JoueurVirtuel(String nom,Strategie s) {
		super(nom);
		this.strategie=s;
		
	}

	public void jouerBot() {
		strategie.jouer(this);
	}

}
