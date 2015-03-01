package spiel;

public class Spielzuege {
	
	public static void legetischkarte(int tischnr) {
		CafeMain.getTische().get(tischnr).setLand(CafeMain.getLaenderkarten().get(0));
		CafeMain.getLaenderkarten().remove(0);
	}

}