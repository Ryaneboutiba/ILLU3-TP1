package jeu;

import cartes.Carte;

public class Joueur {
	private String nomJoueur;
	private MainJoueur main;
	private ZoneDeJeu zone;
	
	public Joueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
		this.main=new MainJoueur();
		this.zone=new ZoneDeJeu();
	}

	public String getNomJoueur() {
		return nomJoueur;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur) {
			Joueur joueur=(Joueur)obj;
			return nomJoueur.equals(joueur.getNomJoueur());
		}
		return false;
	}
	
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}else {
			Carte carte=sabot.piocher();
			main.prendre(carte);
			return carte;	
		}
	}
	
	public void deposer(Carte c) {
		zone.deposer(c);
	}
	
	public int donnerKmParcourus() {
		return zone.donnerKmParcourus();
	}
	
	
	
	@Override
	public String toString() {
		return nomJoueur;
	}
}
