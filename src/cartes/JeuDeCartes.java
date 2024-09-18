package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes=new Configuration[19];
	
	public String affichageJeuDeCartes() {
		System.out.println("JEU \n");
		StringBuilder affichage=new StringBuilder();
		for(int i=0;i<typesDeCartes.length;i++) {
			affichage.append(typesDeCartes[i].getNbExemplaire()+" "+typesDeCartes[i].getCarte()+" \n");
		}
		return affichage.toString();
	}
	
	
	private static class Configuration{
		private int nbExemplaire;
		private Carte carte;
		
		private Configuration(Carte carte,int nbExemplaires) {
			this.carte=carte;
			this.nbExemplaire=nbExemplaires;
		}

		public int getNbExemplaire() {
			return nbExemplaire;
		}

		public Carte getCarte() {
			return carte;
		}
		
		
	}
}
