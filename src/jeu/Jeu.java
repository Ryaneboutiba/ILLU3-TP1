package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.GestionCartes;

public class Jeu {
	Sabot sabot;
	public Jeu(JeuDeCartes jeuDeCarte) {
		Carte[] carte=jeuDeCarte.donnerCartes();
		List<Carte> listeCartesNonMelanger=new  ArrayList<Carte>();
		for(int i=0;i<carte.length;i++) {
			listeCartesNonMelanger.add(i, carte[i]);
		}
		List<Carte> listeCartes=GestionCartes.melanger(listeCartesNonMelanger);
		
		
	}
}
