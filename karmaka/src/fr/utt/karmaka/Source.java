package fr.utt.karmaka;

import fr.utt.karmaka.Cartes.CartesBleues.CartesBleues;
import fr.utt.karmaka.Cartes.CartesBleues.CoupDoeil;
import fr.utt.karmaka.Cartes.CartesBleues.Deni;
import fr.utt.karmaka.Cartes.CartesBleues.Destinee;
import fr.utt.karmaka.Cartes.CartesBleues.Duperie;
import fr.utt.karmaka.Cartes.CartesBleues.RevesBrises;
import fr.utt.karmaka.Cartes.CartesBleues.Transmigration;
import fr.utt.karmaka.Cartes.CartesBleues.Vol;
import fr.utt.karmaka.Cartes.CartesRouges.Bassesse;
import fr.utt.karmaka.Cartes.CartesRouges.CartesRouges;
import fr.utt.karmaka.Cartes.CartesRouges.Crise;
import fr.utt.karmaka.Cartes.CartesRouges.DernierSoufle;
import fr.utt.karmaka.Cartes.CartesRouges.Fournaise;
import fr.utt.karmaka.Cartes.CartesRouges.Panique;
import fr.utt.karmaka.Cartes.CartesRouges.Roulette;
import fr.utt.karmaka.Cartes.CartesRouges.Vengeance;

public class Source extends PilesCartes{

	//instancie toutes les cartes de la partie
	public Source() {
		super();
		CartesBleues coupDOeil  = new CoupDoeil();
		this.cartes.add(coupDOeil);
		CartesBleues deni  = new Deni();
		this.cartes.add(deni);
		CartesBleues destinee  = new Destinee();
		this.cartes.add(destinee);
		CartesBleues duperie  = new Duperie();
		this.cartes.add(duperie);
		CartesBleues revesBrises  = new RevesBrises();
		this.cartes.add(revesBrises);
		CartesBleues transmigration  = new Transmigration();
		this.cartes.add(transmigration);
		CartesBleues vol  = new Vol();
		this.cartes.add(vol);
		CartesRouges bassesse = new Bassesse();
		this.cartes.add(bassesse);
		CartesRouges crise = new Crise();
		this.cartes.add(crise);
		CartesRouges dernierSoufle = new DernierSoufle();
		this.cartes.add(dernierSoufle);
		CartesRouges fournaise = new Fournaise();
		this.cartes.add(fournaise);
		CartesRouges panique = new Panique();
		this.cartes.add(panique);
		CartesRouges roulette = new Roulette();
		this.cartes.add(roulette);
		CartesRouges vengeance = new Vengeance();
		this.cartes.add(vengeance);
		
	}
	
	
}
