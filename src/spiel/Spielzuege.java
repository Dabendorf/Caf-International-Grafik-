package spiel;

public class Spielzuege {
	
	public static void legetischkarte(int tischnr, int landnr) {
		CafeMain.getTische().get(tischnr).setLand(CafeMain.getLaenderkarten().get(landnr));
		Spielfeld.getSpielfeldtisch().get(tischnr).setLand(CafeMain.getLaenderkarten().get(landnr).land);
		CafeMain.getLaenderkarten().remove(landnr);
	}

}
