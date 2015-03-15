package spiel;

import spiel.Gastkarte.Geschlecht;
import spiel.Gastkarte.Land;

public class Stuhl {

	private Gastkarte gast;
    private Tisch[] tische;
    private Spielzelle sz;
	private boolean bosetgastland = false;
    private boolean bosetgastgeschlecht = false;
    public boolean gastistjoker = false;
    public int maenner = 0;
    public int frauen = 0;
    
    public String toString() {
		return "Stuhl [gast=" + gast + ", tisch=" + tische + "]";
	}
    
	public Gastkarte getGast() {
		return gast;
	}
	
	public void setGast(Gastkarte newgast) {
		if(this.gast == null || this.gast.getLand() == Land.JOKER){
			for(Tisch t:this.getTische()) {
				if(t.getLand().equals(newgast.getLand()) || newgast.getLand() == Land.JOKER) {
					bosetgastland = true;
				}
			}
			if(bosetgastland == true) {
				bosetgastgeschlecht = true;
				if(newgast.getGeschlecht() == Geschlecht.Mann) {
					for(Tisch t2:this.getTische()) {
						for(Stuhl s1:t2.getStuehle()) {
							if(s1.getGast() != null) { //Ohne diese Extrazeile hab ich immer eine NullPointerException bekommen
								if(s1.getGast().getGeschlecht().equals(Geschlecht.Mann)) {
									maenner += 1;
								} else if(s1.getGast().getGeschlecht().equals(Geschlecht.Frau)) {
									frauen += 1;
								}
							}
						}
						if(maenner > frauen) {
							bosetgastgeschlecht = false;
						}
						maenner = 0;
						frauen = 0;
					}
				} else {
					for(Tisch t2:this.getTische()) {
						for(Stuhl s1:t2.getStuehle()) {
							if(s1.getGast() != null) { //Ohne diese Extrazeile hab ich immer eine NullPointerException bekommen
								if(s1.getGast().getGeschlecht().equals(Geschlecht.Mann)) {
									maenner += 1;
								} else if(s1.getGast().getGeschlecht().equals(Geschlecht.Frau)) {
									frauen += 1;
								}
							}
						}
						if(maenner < frauen) {
							bosetgastgeschlecht = false;
						}
						maenner = 0;
						frauen = 0;
					}
				}
				
				if(bosetgastgeschlecht == true) {
        			this.gast = newgast;
        		} else {System.out.println("Die Geschlechter sind nicht ausgeglichen!");}
			} else { System.out.println("Das Land stimmt nicht überein!");}
		} else { System.out.println("Der Stuhl ist bereits belegt!");}
		bosetgastland = false;
		bosetgastgeschlecht = false;
	}
	
	public Tisch[] getTische() {
		return tische;
	}
	
	public void setTische(Tisch...tische) {
		this.tische = tische;
	}

	public Spielzelle getSz() {
		return sz;
	}

	public void setSz(Spielzelle sz) {
		this.sz = sz;
	}

}