package spiel;

import spiel.Gastkarte.Land;

public class Laenderkarte {
	
	private final Land land;
	 
	public Laenderkarte(Land land) {
		this.land = land;
	}
	 
	public String toString() {
		return land + "";
	}
}