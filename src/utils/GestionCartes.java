package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import cartes.Carte;

public class GestionCartes <T extends Carte>{
	
	public static <T> T extraire(List<T> carte) {
		int indice=new Random().nextInt(carte.size());
		T element=carte.remove(indice);
		return element;
	}
	
	public static <T> T extraireV2(List<T> carte) {
		Iterator<T> iterateur=carte.iterator();
		int indice=new Random().nextInt(carte.size());
		
		T element=carte.get(0);
		for(int i=0;i<indice;i++) {
			element=iterateur.next();
		}
		iterateur.remove();
		return element;
	}
	
	
	public static <T> List<T> melanger(List<T> carte){
		List<T> melange=new ArrayList<T>();
		while(!carte.isEmpty()) {
			melange.add(extraire(carte));
		}
		return melange;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1,List<T> liste2) {
		for(int i=0;i<liste1.size();i++) {
			T element=liste1.get(i);
			if(Collections.frequency(liste1, element)!=Collections.frequency(liste2, element)) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> carte){
		List<T> rassemblement=new ArrayList<T>();
		List<T> intermediare=new ArrayList<T>();
		for(int i=0;i<carte.size();i++) {
			T element=carte.get(i);
			for(int j=0;j<carte.size();j++) {
				if(carte.get(j).equals(element)) {
					intermediare.add(element);
				}
			}
			if(!rassemblement.contains(element)) {
				rassemblement.addAll(intermediare);
			}
			intermediare.clear();
		}
		return rassemblement;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		if(liste.isEmpty()) {
			return true;
		}
		ListIterator<T> iterateurList=liste.listIterator();
		T precedent=iterateurList.next();
		while(iterateurList.hasNext()) {
			T courant=iterateurList.next();
			int index=iterateurList.previousIndex();
			if(precedent!=courant) {
				for(ListIterator<T> it2=liste.listIterator(index);it2.hasNext();) {
					if(precedent.equals(it2.next())) {
						return false;
					}
				}
				
			}
			precedent=courant;
		}
		return true;
	}
}
