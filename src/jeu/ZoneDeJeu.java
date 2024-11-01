package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Limite> pileLimite=new ArrayList<>();
	private List<Bataille> pileBataille=new ArrayList<>();
	private List<Borne> collectionBorne=new ArrayList<>();
	
	
	public int donnerLimitationVitesse() {
		FinLimite finLimite=new FinLimite();
		if(pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1).equals(finLimite)) {
			return 200;
		}
		return 50;
	}
	
	
	public void deposer(Carte c) {
		if(c instanceof Borne) {
			Borne borne=(Borne)c;
			collectionBorne.add(borne);
		}else if(c instanceof Limite) {
			Limite limite=(Limite)c;
			pileLimite.add(limite);
		}else if(c instanceof Bataille) {
			Bataille bataille=(Bataille)c;
			pileBataille.add(bataille);
		}
	}
	
	public int donnerKmParcourus() {
		int kmParcourus=0;
		int taille=collectionBorne.size();
		Borne borne;
		for(int i=0;i<taille;i++) {
			borne=collectionBorne.get(i);
			kmParcourus+=borne.getKm();
		}
		return kmParcourus;
	}
}
