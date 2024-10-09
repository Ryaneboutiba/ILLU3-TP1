package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {                                                                                                                                                                                                         
	
	private int nbCartes;
	private Carte[] pioche;
	private int nbOperation=0;
	private Iterator<Carte> iterator=iterator();
	
	public Sabot(Carte[] carte) {
		pioche=carte;
		nbCartes=carte.length;
	}
	
	public boolean estVide() {
		return nbCartes==0;
	}
	
	public void ajouterCartes(Carte carte) {
		if(nbCartes>= 106) {
			throw new IllegalStateException();
		}else{
			pioche[nbCartes]=carte;
			nbCartes++;
			nbOperation++;
		}
	}
	
	public Carte piocher() {
		Carte carte=iterator.next();
		iterator.remove();
		System.out.println("je pioche "+ carte.toString());
		return carte;
	}
	
	public Iterator<Carte> iterator(){
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte>{
		private int indiceIterator=0;
		private boolean nextEffectuer=false;
		private int nbOperationReference=nbOperation;
		
		public boolean hasNext() {
			verifierConcurrence();
			return indiceIterator<nbCartes;
		}
		
		public Carte next() {
			verifierConcurrence();
			if(!hasNext()) {
				throw new NoSuchElementException();
			}else {
				Carte carte=pioche[indiceIterator];
				indiceIterator++;
				nextEffectuer=true;
				return carte;
			}
		}
		
		public void verifierConcurrence() {
			if(nbOperationReference!=nbOperation) {
				throw new ConcurrentModificationException();
			}
		}
		
		public void remove() {
			verifierConcurrence();
			if(!nextEffectuer||nbCartes<1) {
				throw new IllegalStateException();
			}else {
				for(int i=indiceIterator-1;i<nbCartes-1;i++) {
					pioche[i]=pioche[i+1];
				}
				nbOperation--;
				nbOperationReference--;
				nbCartes--;
				indiceIterator--;
				nextEffectuer=false;
			}
		}
	}
	
}
