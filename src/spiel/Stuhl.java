package spiel;

public class Stuhl {

	private Gastkarte gast;
    private Tisch[] tische;
    private Spielzelle sz;
    
	public Gastkarte getGast() {
		return gast;
	}
	
	public void setGast(Gastkarte gast) {
		this.gast = gast;
	}
	
	public void setTische(int...tischeNr) {
		Tisch[] tischetemp = new Tisch[tischeNr.length];
		int i=0;
		for(int tischNr : tischeNr) {
			tischetemp[i++] = CafeMain.getTisch(tischNr);
		}
		this.tische = tischetemp;
	}

	public void setSpielzelle(Spielzelle sz) {
		this.sz = sz;
	}

}