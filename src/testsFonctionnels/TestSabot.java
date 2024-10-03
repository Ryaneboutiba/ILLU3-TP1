package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] carte=jeu.donnerCartes();
		
		Sabot sabot=new Sabot(carte);
		while(!sabot.estVide()) {
			Carte cartePiocher=sabot.piocher();
		}
	}
}
