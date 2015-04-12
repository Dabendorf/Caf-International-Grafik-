package spiel;

import spiel.Gastkarte.Geschlecht;
import spiel.Gastkarte.Land;

public class Stuhl {

	private Gastkarte gast;
    private Tisch[] tische;
    private Spielzelle sz;
    
	protected Gastkarte getGast() {
		return gast;
	}
	
	protected boolean setGast(Gastkarte gasttemp) { //Man kann Joker austauschen
		Meldungen msgbox = new Meldungen();
		if(!gastLandKorrekt(gasttemp)) {
			Spielfeld.getMeldungsbox().setText(msgbox.gastlandfalsch);
			return false;
		} else if(!gastGeschlechtKorrekt(gasttemp)) {
			if(gasttemp.getGeschlecht().equals(Geschlecht.Mann)) {
				Spielfeld.getMeldungsbox().setText(msgbox.gastzuvielemaenner);
			} else {
				Spielfeld.getMeldungsbox().setText(msgbox.gastzuvielefrauen);
			}
			return false;
		} else if(!gastPartnerKorrekt(gasttemp)) {
			Spielfeld.getMeldungsbox().setText(msgbox.gastpartnerfalsch);
			return false;
		} else {
			this.gast = gasttemp;
			this.sz.repaint();
			if(CafeMain.getZustand()==12) {
				CafeMain.setZustand(11);
			} else if(CafeMain.getZustand()==11) {
				CafeMain.setZustand(21);
			}
			return true;
		}
	}
	
	protected void setTische(int...tischeNr) {
		Tisch[] tischetemp = new Tisch[tischeNr.length];
		int i=0;
		for(int tischNr : tischeNr) {
			tischetemp[i++] = CafeMain.getTisch(tischNr);
		}
		this.tische = tischetemp;
	}

	protected void setSpielzelle(Spielzelle sz) {
		this.sz = sz;
	}
	
	private boolean gastLandKorrekt(Gastkarte gasttemp) {
		boolean korr = false;
		for(Tisch tisch:this.tische) {
			if(tisch.getLaenderkarte().getLand().equals(gasttemp.getLand()) || gasttemp.getLand().equals(Land.JOKER)) {
				korr = true;
			}
		}
		return korr;
	}
	
	private boolean gastGeschlechtKorrekt(Gastkarte gasttemp) {
		boolean korr = true;
		for(Tisch tisch:this.tische) {
			int mann=0, frau=0;
			for(Stuhl stuhl:tisch.getStuehle()) {
				if(stuhl.getGast()!=null) {
					if(stuhl.getGast().getGeschlecht().equals(Geschlecht.Mann)) {
						mann++;
					} else {
						frau++;
					}
				}
			}
			if((gasttemp.getGeschlecht().equals(Geschlecht.Mann)) && (mann > frau)) {
				korr = false;
			} else if((gasttemp.getGeschlecht().equals(Geschlecht.Frau)) && (frau > mann)) {
				korr = false;
			}
		}
		return korr;
	}
	
	private boolean gastPartnerKorrekt(Gastkarte gasttemp) {
		return true;
	}

}