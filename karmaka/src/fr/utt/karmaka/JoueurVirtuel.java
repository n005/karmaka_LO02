package fr.utt.karmaka;

public class JoueurVirtuel extends Joueur{
	private Strategie strategie;
	private Partie partie;
	
	public JoueurVirtuel(String nom,Strategie s,Partie p) {
		super(nom);
		this.strategie=s;
		this.partie=p;
		
	}

	public void jouerBot() {
		strategie.jouer(this,this.partie);
	}

}
