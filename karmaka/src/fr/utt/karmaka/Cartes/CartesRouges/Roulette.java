package fr.utt.karmaka.Cartes.CartesRouges;

import java.util.Scanner;

import fr.utt.karmaka.Joueur;
import fr.utt.karmaka.Partie;

public class Roulette extends CartesRouges {
	public Roulette() {
		super(2, 3, "Roulette");
	}

	// Défaussez jusqu’à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1 que vous avez défaussé.
	public void jouerPouvoir(Joueur j, Joueur rival, Partie p) {
		System.out.println("Vous jouez la carte " + this.getNom());
		System.out.println("Défaussez jusqu’à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1 que vous avez défaussé.");
		System.out.println("Les cartes de votre main sont :");
		for(int i=0;i<j.getMain().getSize();i++) {
			System.out.println(i+" : "+j.getMain().getCarte(i).getNom());
		}
		System.out.println("Taper le numéro de la carte que vous voulez défausser :");
		int numCarte = choisirCarte(j.getMain().getSize()-1);
		j.getMain().supprimerCarte(numCarte);
		System.out.println("Vous pouvez piocher 2 cartes à la source");
		j.piocher();
		j.piocher();
		System.out.println("Vous avez piocher les cartes suivantes :");
		for(int i=0;i<2;i++) {
			System.out.println(j.getMain().getCarte(j.getMain().getSize()-1-i).getNom());
		}
		System.out.println("Voulez-vous défausser une autre carte ? (o/n)");
		String reponse = choisirOuiNon();
		if(reponse.equals("o")) {
			System.out.println("Les cartes de votre main sont :");
			for(int i=0;i<j.getMain().getSize();i++) {
				System.out.println(i+" : "+j.getMain().getCarte(i).getNom());
			}
			System.out.println("Taper le numéro de la carte que vous voulez défausser :");
			numCarte = choisirCarte(j.getMain().getSize()-1);
			j.getMain().supprimerCarte(numCarte);
			System.out.println("Vous pouvez piocher 1 carte à la source");
			j.piocher();
			System.out.println("Vous avez piocher la carte suivante :");
			System.out.println(j.getMain().getCarte(j.getMain().getSize()-1).getNom());
		}
		

	}

	private String choisirOuiNon() {
		String reponse = "";
		Scanner sc = new Scanner(System.in);
		while(!reponse.equals("o") && !reponse.equals("n")) {
			reponse = sc.nextLine();
		}
		return reponse;
	}
}
