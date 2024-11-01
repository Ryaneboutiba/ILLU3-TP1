package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	public List<Carte> carteEnMain=new ArrayList<>();
	private Iterator<Carte> iterateur=carteEnMain.iterator();
	
	public void prendre(Carte carte) {
		carteEnMain.add(carte);
	}
	
	public void jouer(Carte carte) {
		if(carteEnMain.contains(carte)) {
			carteEnMain.remove(carte);
		}else {
			 throw new IllegalArgumentException("La carte n'est pas présente dans la main");
		}
	}
	
	@Override
	public String toString() {
		return carteEnMain.toString();
	}
	
}
