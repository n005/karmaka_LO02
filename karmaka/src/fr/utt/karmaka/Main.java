package fr.utt.karmaka;

import java.io.Serializable;

/**
 * Classe principale du jeu
 * 
 * @version 1.0
 * @since 1.0
 */

public class Main implements Serializable{
	public static void main(String[] args) {
		Partie partie = new Partie();
		//Joueur joueur1 = partie.creerJoueur();
		JoueurVirtuel joueurVirtuel1 = new JoueurVirtuel("joueurvirtuel", new Aleatoire());
		JoueurVirtuel joueurVirtuel2 = new JoueurVirtuel("joueurvirtuel2",new Aleatoire());
		
		partie.ajouterUnJoueur(joueurVirtuel1);
		//partie.ajouterUnJoueur(joueur1);
		partie.ajouterUnJoueur(joueurVirtuel2);
		
		partie.DonnerCarteMiseEnPlace(joueurVirtuel1, joueurVirtuel2);
		
		while (!(joueurVirtuel2.aGagner() || joueurVirtuel1.aGagner())) {
			//partie.jouerUnTour(joueur1);
			if(joueurVirtuel1.getPile().getSize()==0&&joueurVirtuel1.getMain().getSize()==0) {
				partie.rennaitre(joueurVirtuel1);
			}
			if (joueurVirtuel2.aGagner() || joueurVirtuel1.aGagner()) {
				break;
			}
			if(joueurVirtuel2.getPile().getSize()==0&&joueurVirtuel2.getMain().getSize()==0) {
				partie.rennaitre(joueurVirtuel2);
			}

			if (joueurVirtuel2.aGagner() || joueurVirtuel1.aGagner()) {
				break;
			}
			System.out.println("C'est au tour de "+joueurVirtuel1.getNom());
			System.out.println(joueurVirtuel1);
			joueurVirtuel1.jouerBot();
			
			if (joueurVirtuel2.aGagner() || joueurVirtuel1.aGagner()) {
				break;
			}
			System.out.println("C'est au tour de "+joueurVirtuel2.getNom());
			System.out.println(joueurVirtuel2);
			joueurVirtuel2.jouerBot();
			if (joueurVirtuel2.aGagner() || joueurVirtuel1.aGagner()) {
				break;
			}
		}
		if (joueurVirtuel2.aGagner()) {
			System.out.println("Joueur virt2 a gagne");
		}
		if (joueurVirtuel1.aGagner()) {
			System.out.println("Joueur virt1 a gagne");
		}
		
	}
}
