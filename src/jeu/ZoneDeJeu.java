package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

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
	
	public boolean peutAvancer() {
		int top=pileBataille.size()-1;
		Bataille bataille=pileBataille.get(top);
		Parade parade1=new Parade(Type.FEU);
		if(!pileBataille.isEmpty() && bataille.equals(parade1) ) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean estDepotFeuVertAutorise() {
		int top=pileBataille.size()-1;
		Bataille bataille=pileBataille.get(top);
		Parade parade1=new Parade(Type.FEU);
		Attaque attaque1=new Attaque(Type.FEU);
		if(pileBataille.isEmpty() || !bataille.equals(parade1) || bataille.equals(attaque1) ) {
			return true;
		}else {
			return false;
		}
	}
	public boolean estDepotBorneAutorise(Borne borne) {
		if(donnerLimitationVitesse()>=borne.getKm() && donnerKmParcourus()+borne.getKm()<1000) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		int top=pileLimite.size()-1;
		Limite limitetop=pileLimite.get(top);
		DebutLimite dlimite=new DebutLimite();
		FinLimite flimite=new FinLimite();
		if(limite instanceof DebutLimite) {
			if(pileLimite.isEmpty() || limitetop.equals(flimite) ) {
				return true;
			}else {
				return false;
			}
		}else {
			if(limitetop.equals(dlimite)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		int top=pileBataille.size()-1;
		Bataille batailletop=pileBataille.get(top);
		Attaque attaque1=new Attaque(Type.FEU);
		if(bataille instanceof Attaque) {
			return peutAvancer();
		}else if(bataille instanceof Parade) {
			Parade parade1=new Parade(Type.FEU);
			if(bataille.equals(parade1)) {
				if(pileBataille.isEmpty() || batailletop.equals(attaque1) || !batailletop.equals(parade1)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(!pileBataille.isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
        if (carte instanceof Borne) {
            return estDepotBorneAutorise((Borne) carte);
        } else if (carte instanceof Limite) {
            return estDepotLimiteAutorise((Limite) carte);
        } else if (carte instanceof Bataille) {
            return estDepotBatailleAutorise((Bataille) carte);
        }
        return false;
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
