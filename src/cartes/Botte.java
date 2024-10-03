package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Botte : "+getType().getBotte()+" .";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Botte) {
			Botte botte=(Botte)obj;
			return getType().getBotte().equals(botte.getType().getBotte());
		}
		return false;
	}
}
