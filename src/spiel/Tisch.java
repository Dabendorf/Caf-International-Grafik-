package spiel;

public class Tisch {
	
	private Laenderkarte land;
    private Stuhl[] stuehle;
    private Spielzelle sz;
    
	public Laenderkarte getLand() {
		return land;
	}
	
	public void setLand(Laenderkarte land) {
		this.land = land;
	}
	
	public void setStuehle(int...stuehleNr) {
		Stuhl[] stuehletemp = new Stuhl[stuehleNr.length];
		int i=0;
		for(int stuhlNr : stuehleNr) {
			stuehletemp[i++] = CafeMain.getStuhl(stuhlNr);
		}
		this.stuehle = stuehletemp;
	}

	public void setSpielzelle(Spielzelle sz) {
		this.sz = sz;
	}

}