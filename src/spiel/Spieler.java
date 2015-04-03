package spiel;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	
	private String name;
    private int punkte = 0;
    private List<Gastkarte> handkarten = new ArrayList<Gastkarte>();

	public Spieler() {}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected int getPunkte() {
		return punkte;
	}

	protected void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	protected List<Gastkarte> getHandkarten() {
		return handkarten;
	}

}