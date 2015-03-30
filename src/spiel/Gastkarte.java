package spiel;

public class Gastkarte {
	
	protected enum Geschlecht {Mann, Frau};
	protected enum Land {DE, FR, GB, US, TR, IN, CN, RU, ES, CU, CF, IT, JOKER};
	 
	private final Land land;
	private final Geschlecht geschlecht;
	 
	protected Gastkarte(Geschlecht geschlecht, Land land){
		this.land = land;
		this.geschlecht= geschlecht;
	}
	 
	public String toString(){
		return land + ":" + geschlecht;
	}

	protected Land getLand() {
		return land;
	}

	protected Geschlecht getGeschlecht() {
		return geschlecht;
	}
}