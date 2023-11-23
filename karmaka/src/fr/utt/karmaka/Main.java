package fr.utt.karmaka;

public class Main {
	public static void main(String[] args) {
		Partie partie = new Partie();
		//Joueur joueur1 = partie.creerJoueur();
		JoueurVirtuel joueurVirtuel1 = new JoueurVirtuel("joueurvirtuel");
		JoueurVirtuel joueurVirtuel2 = new JoueurVirtuel("joueurvirtuel2");
		
		partie.ajouterUnJoueur(joueurVirtuel1);
		//partie.ajouterUnJoueur(joueur1);
		partie.ajouterUnJoueur(joueurVirtuel2);
		
		partie.DonnerCarteMiseEnPlace(joueurVirtuel1, joueurVirtuel2);
		
		while (!(joueurVirtuel2.aGagner() || joueurVirtuel1.aGagner())) {
			//partie.jouerUnTour(joueur1);
			System.out.println("C'est au tour de "+joueurVirtuel1.getNom());
			System.out.println(joueurVirtuel1);
			joueurVirtuel1.jouerBot();
			
			System.out.println("C'est au tour de "+joueurVirtuel2.getNom());
			System.out.println(joueurVirtuel2);
			joueurVirtuel2.jouerBot();
		}
		
		
	}
}
