package spiel;

public class Tisch {
	
	private Laenderkarte laenderkarte; //Tisch leeren
    private Stuhl[] stuehle;
	private Spielzelle sz;
    
	protected Laenderkarte getLaenderkarte() {
		return laenderkarte;
	}
	
	protected void setLaenderkarte(Laenderkarte laenderkarte) {
		this.laenderkarte = laenderkarte;
		this.sz.repaint();
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

	protected void setSpielzelle(Spielzelle sz) {
		this.sz = sz;
	}

}