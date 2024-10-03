package testsFonctionnels;

import cartes.Attaque;
import cartes.Type;

public class TestMethodeAquals {
	public static void main(String[] args) {
		Attaque attaque1=new Attaque(Type.FEU);
		Attaque attaque2=new Attaque(Type.FEU);
		System.out.println(attaque1.equals(attaque2));
	}
}
