package cartes;

public class Parade extends Bataille{

	public Parade(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Parade : "+getType().getParade()+".";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Parade) {
			Parade parade=(Parade)obj;
			return getType().getParade().equals(parade.getType().getParade());
		}
		return false;
	}
	
}
