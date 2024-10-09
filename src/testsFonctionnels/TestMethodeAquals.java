package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.Parade;
import cartes.Type;

public class TestMethodeAquals {
	public static void main(String[] args) {
		Attaque attaque1=new Attaque(Type.FEU);
		Attaque attaque2=new Attaque(Type.FEU);
		System.out.println(attaque1.equals(attaque2));
		
		Borne borne1=new Borne(25);
		Borne borne2=new Borne(25);
		System.out.println(borne1.equals(borne2));
		
		Attaque attaque3=new Attaque(Type.FEU);
		Parade parade1=new Parade(Type.FEU);
		System.out.println(attaque3.equals(parade1));
	}
}
