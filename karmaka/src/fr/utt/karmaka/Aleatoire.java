package fr.utt.karmaka;
import java.util.Random;


/**
 * Classe aleatoire du jeu
 * 
 * @version 1.0
 * @since 1.0
 */
public class Aleatoire implements Strategie, java.io.Serializable{
	public void jouer(Joueur joueur) {
		joueur.piocher();
		Random numAleatoire= new Random();
		int choix = numAleatoire.nextInt(4);
		switch(choix) {
		//jouer pour les points
		case 0:
			System.out.println("joue points");
			joueur.jouerPoints(numAleatoire.nextInt(joueur.getMain().getSize()));
			break;
		//jouer pour le futur
		case 1:
			System.out.println("joue futur");
			joueur.jouerFuture(numAleatoire.nextInt(joueur.getMain().getSize()));
			break;
		//jouer le pouvoir
		case 2:
			System.out.println("joue pouvoir");
			//joueur.jouePouvoir(null, joueur, null);
			break;
		//passer le tour
		case 3:
			boolean passable = joueur.passer();
			if (passable) {
				System.out.println("passe");
				break;
			} else {
				this.jouer(joueur);
				break;
			}
		default:
			System.out.println("Impossible de jouer");
			break;
		}
		
	}

}
