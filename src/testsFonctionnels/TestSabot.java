package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] carte=jeu.donnerCartes();
		
		Sabot sabot=new Sabot(carte);
	    while(!sabot.estVide()) {
			Carte cartePiocher=sabot.piocher();
		}
		
		/*for(Iterator<Carte> iterator=sabot.iterator();iterator.hasNext();) {
			Carte cartePiocher=sabot.piocher();
			//sabot.ajouterCartes(new Botte(Type.ACCIDENT));
		}*/
	}
}
