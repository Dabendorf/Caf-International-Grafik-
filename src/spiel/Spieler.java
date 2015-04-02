package spiel;

import java.util.ArrayList;
import java.util.List;

public class Spieler {
	
	private String name;
    private int punkte = 0;
    private ArrayList<Gastkarte> handkarten = new ArrayList<Gastkarte>();

	public Spieler() {
		
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public List<Gastkarte> getHandkarten() {
		return handkarten;
	}

}