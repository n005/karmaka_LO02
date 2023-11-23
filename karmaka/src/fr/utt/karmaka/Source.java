package fr.utt.karmaka;

import fr.utt.karmaka.Cartes.CartesBleues.CartesBleues;
import fr.utt.karmaka.Cartes.CartesBleues.CoupDoeil;
import fr.utt.karmaka.Cartes.CartesBleues.Deni;
import fr.utt.karmaka.Cartes.CartesBleues.Destinee;
import fr.utt.karmaka.Cartes.CartesBleues.Duperie;
import fr.utt.karmaka.Cartes.CartesBleues.RevesBrises;
import fr.utt.karmaka.Cartes.CartesBleues.Transmigration;
import fr.utt.karmaka.Cartes.CartesBleues.Vol;
import fr.utt.karmaka.Cartes.CartesMosaiques.CartesMosaiques;
import fr.utt.karmaka.Cartes.CartesMosaiques.Incarnation;
import fr.utt.karmaka.Cartes.CartesMosaiques.Mimetisme;
import fr.utt.karmaka.Cartes.CartesRouges.Bassesse;
import fr.utt.karmaka.Cartes.CartesRouges.CartesRouges;
import fr.utt.karmaka.Cartes.CartesRouges.Crise;
import fr.utt.karmaka.Cartes.CartesRouges.DernierSoufle;
import fr.utt.karmaka.Cartes.CartesRouges.Fournaise;
import fr.utt.karmaka.Cartes.CartesRouges.Panique;
import fr.utt.karmaka.Cartes.CartesRouges.Roulette;
import fr.utt.karmaka.Cartes.CartesRouges.Vengeance;
import fr.utt.karmaka.Cartes.CartesVertes.CartesVertes;
import fr.utt.karmaka.Cartes.CartesVertes.Jubile;
import fr.utt.karmaka.Cartes.CartesVertes.Lendemain;
import fr.utt.karmaka.Cartes.CartesVertes.Longevite;
import fr.utt.karmaka.Cartes.CartesVertes.Recyclage;
import fr.utt.karmaka.Cartes.CartesVertes.Sauvetage;
import fr.utt.karmaka.Cartes.CartesVertes.Semis;
import fr.utt.karmaka.Cartes.CartesVertes.Voyage;

public class Source extends PilesCartes{

	//permet d'instancier le nombre bon nombre de chaque carte
	public void instancierCarte(Carte c) {
		for(int i=0;i<c.getNbCartes();i++) {
			this.cartes.add(c);
		}
	}
	
	//instancie toutes les cartes de la partie
	public Source() {
		super();
		//cartes bleues
		CartesBleues coupDOeil  = new CoupDoeil();
		this.instancierCarte(coupDOeil);
		CartesBleues deni  = new Deni();
		this.instancierCarte(deni);
		CartesBleues destinee  = new Destinee();
		this.instancierCarte(destinee);
		CartesBleues duperie  = new Duperie();
		this.instancierCarte(duperie);
		CartesBleues revesBrises  = new RevesBrises();
		this.instancierCarte(revesBrises);
		CartesBleues transmigration  = new Transmigration();
		this.instancierCarte(transmigration);
		CartesBleues vol  = new Vol();
		this.instancierCarte(vol);
		//cartes rouges
		CartesRouges bassesse = new Bassesse();
		this.instancierCarte(bassesse);
		CartesRouges crise = new Crise();
		this.instancierCarte(crise);
		CartesRouges dernierSoufle = new DernierSoufle();
		this.instancierCarte(dernierSoufle);
		CartesRouges fournaise = new Fournaise();
		this.instancierCarte(fournaise);
		CartesRouges panique = new Panique();
		this.instancierCarte(panique);
		CartesRouges roulette = new Roulette();
		this.instancierCarte(roulette);
		CartesRouges vengeance = new Vengeance();
		this.instancierCarte(vengeance);
		//cartes mosaiques
		CartesMosaiques incarnation = new Incarnation();
		this.instancierCarte(incarnation);
		CartesMosaiques mimetisme = new Mimetisme();
		this.instancierCarte(mimetisme);
		//Cartes vertes
		CartesVertes jubile = new Jubile();
		this.instancierCarte(jubile);
		CartesVertes lendemain = new Lendemain();
		this.instancierCarte(lendemain);
		CartesVertes longevite = new Longevite();
		this.instancierCarte(longevite);
		CartesVertes recyclage = new Recyclage();
		this.instancierCarte(recyclage);
		CartesVertes sauvetage = new Sauvetage();
		this.instancierCarte(sauvetage);
		CartesVertes semis = new Semis();
		this.instancierCarte(semis);
		CartesVertes voyage = new Voyage();
		this.instancierCarte(voyage);
		
	}
	
	
}
