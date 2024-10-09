package cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes= {new Configuration(new Borne(25), 10),
	                                                        new Configuration(new Borne(50), 10),
	                                                        new Configuration(new Borne(75), 10),
	                                                        new Configuration(new Borne(100), 12),
	                                                        new Configuration(new Borne(200), 4),
	                                                        new Configuration(new Attaque(Type.FEU), 5),
	                                                        new Configuration(new Parade(Type.FEU), 14),
	                                                        new Configuration(new Botte(Type.FEU), 1),
	                                                        new Configuration(new Attaque(Type.ESSENCE), 3),
	                                                        new Configuration(new Parade(Type.ESSENCE), 6),
	                                                        new Configuration(new Botte(Type.ESSENCE), 1),
	                                                        new Configuration(new Attaque(Type.CREVAISON), 3),
	                                                        new Configuration(new Parade(Type.CREVAISON), 6),
	                                                        new Configuration(new Botte(Type.CREVAISON), 1),
	                                                        new Configuration(new Attaque(Type.ACCIDENT), 3),
	                                                        new Configuration(new Parade(Type.ACCIDENT), 6),
	                                                        new Configuration(new Botte(Type.ACCIDENT), 1),
	                                                        new Configuration(new DebutLimite(), 4),
	                                                        new Configuration(new FinLimite(), 6)};
	
	public String affichageJeuDeCartes() {
		System.out.println("JEU \n");
		StringBuilder affichage=new StringBuilder();
		for(int i=0;i<typesDeCartes.length;i++) {
			affichage.append(typesDeCartes[i].getNbExemplaire()+" "+typesDeCartes[i].getCarte()+" \n");
		}
		return affichage.toString();
	}
	
	public boolean checkCount(Carte carte[]) {
		boolean condition=false;
		for(int i=0;i<typesDeCartes.length;i++) {
			int nbexemplaire=0;
			if(typesDeCartes[i].getCarte().equals(carte[i])) {
				for(int j=0;j<carte.length;j++) {
					if(carte[j].equals(typesDeCartes[i].getCarte())) {
						nbexemplaire++;
					}
				}
				if(typesDeCartes[i].getNbExemplaire()==nbexemplaire) {
					condition=true;
				}else {
					return false;
				}
			}
		}
		return condition;
	}
	
	public Carte[] donnerCartes() {
        int totalCartes = 0;
        for (Configuration config : typesDeCartes) {
            totalCartes += config.getNbExemplaire();
        }

        Carte[] toutesLesCartes = new Carte[totalCartes];
        int index = 0;

        for (Configuration config : typesDeCartes) {
            for (int j = 0; j < config.getNbExemplaire(); j++) {
                toutesLesCartes[index++] = config.getCarte();
            }
        }
        
        return toutesLesCartes;
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
