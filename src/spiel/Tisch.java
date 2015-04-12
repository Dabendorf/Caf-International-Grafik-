package spiel;

public class Tisch {
	
	private Laenderkarte laenderkarte; //Tisch leeren -> Erst feststellen, dann leeren, für Fehlervermeidung und PktBerechnung bei mehreren Tischen
    private Stuhl[] stuehle;
	private Spielzelle sz;

	protected Laenderkarte getLaenderkarte() {
		return laenderkarte;
	}
	
	protected void setLaenderkarte(Laenderkarte laenderkarte) {
		this.laenderkarte = laenderkarte;
		if(sz!=null) {
			this.sz.repaint();
		}
	}
	
	protected Stuhl[] getStuehle() {
		return stuehle;
	}
	
	protected void setStuehle(int...stuehleNr) {
		Stuhl[] stuehletemp = new Stuhl[stuehleNr.length];
		int i=0;
		for(int stuhlNr : stuehleNr) {
			stuehletemp[i++] = CafeMain.getStuhl(stuhlNr);
		}
		this.stuehle = stuehletemp;
	}

	protected Spielzelle getSpielzelle() { //Wenn nicht gebraucht, löschen!
		return sz;
	}
	
	protected void setSpielzelle(Spielzelle sz) {
		this.sz = sz;
	}
	
}