package jeu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Botte;
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
	private Set<Botte> pilebotte=new HashSet<>();
	
	
	public int donnerLimitationVitesse() {
		FinLimite finLimite=new FinLimite();
		if(estPrioritaire() || pileLimite.isEmpty() || pileLimite.get(pileLimite.size()-1).equals(finLimite)) {
			return 200;
		}
		return 50;
	}
	
	
	public boolean estPrioritaire() {
		Botte  botteb=new Botte(Type.FEU);
		return pilebotte.contains(botteb);
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
		}else if(c instanceof Botte) {
			Botte botte=(Botte) c;
			pilebotte.add(botte);
		}
	}
	
	public boolean peutAvancer() {
		Parade parade1=new Parade(Type.FEU); 
		Attaque attaque1=new Attaque(Type.FEU);
		if(pileBataille.isEmpty()) {
			return estPrioritaire();
		}
		if(pileBataille.get(pileBataille.size()-1).equals(parade1) || (pileBataille.get(pileBataille.size()-1) instanceof Parade && estPrioritaire()) || (pileBataille.get(pileBataille.size()-1).getType().equals(attaque1.getType()) && estPrioritaire() || !pileBataille.get(pileBataille.size()-1).getType().equals(attaque1.getType()) && pilebotte.contains(new Botte(pileBataille.get(pileBataille.size()-1).getType())) && estPrioritaire() )  ) {
			return true;
		}else{
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
		if(estPrioritaire()) {
			return false;
		}
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
		Attaque attaque1=new Attaque(Type.FEU);
		Type type=bataille.getType();
		if(bataille instanceof Attaque) {
			return peutAvancer();
		}else if(bataille instanceof Parade) {
			Parade parade1=new Parade(Type.FEU);
			if(bataille.equals(parade1)) {
				if(pileBataille.isEmpty() || pileBataille.get(pileBataille.size()-1).equals(attaque1) || !pileBataille.get(pileBataille.size()-1).equals(parade1)) {
					return true;
				}else {
					return false;
				}
			}else {
				if(!pileBataille.isEmpty() && pileBataille.get(pileBataille.size()-1) instanceof Attaque && type.equals(pileBataille.get(pileBataille.size()-1).getType())) {
					return true;
				}else {
					return false;
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
