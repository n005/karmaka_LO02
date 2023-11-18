package fr.utt.karmaka;

import fr.utt.karmaka.Cartes.CartesBleues.CartesBleues;
import fr.utt.karmaka.Cartes.CartesBleues.CoupDoeil;
import fr.utt.karmaka.Cartes.CartesBleues.Transmigration;

public class Source extends PilesCartes{

	//instancie toutes les cartes de la partie
	public Source() {
		super();
		CartesBleues transmigration  = new Transmigration();
		this.cartes.add(transmigration);
		CartesBleues CoupDOeil  = new CoupDoeil();
		this.cartes.add(CoupDOeil);
	}
}
