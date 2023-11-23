package fr.utt.karmaka;

public class Main {
	public static void main(String[] args) {
		Partie partie = new Partie();
		Joueur joueur1 = partie.creerJoueur();
		JoueurVirtuel joueurVirtuel1 = new JoueurVirtuel("joueurvirtuel");
		
		partie.ajouterUnJoueur(joueurVirtuel1);
		partie.ajouterUnJoueur(joueur1);
		
		partie.DonnerCarteMiseEnPlace(joueur1, joueurVirtuel1);
		
		while (!(joueur1.aGagner() || joueurVirtuel1.aGagner())) {
			partie.jouerUnTour(joueur1);
			joueurVirtuel1.jouerBot();
		}
		
		
	}
}
