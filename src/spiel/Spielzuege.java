package spiel;

import java.awt.Color;

import javax.swing.BorderFactory;

public class Spielzuege {
	
	protected void legetischkarte(int tischnr) {
		CafeMain.getTisch(tischnr).setLaenderkarte(CafeMain.getLaenderkarten().get(0));
		CafeMain.getLaenderkarten().remove(0);
	}
	
	protected void legebarkarte(int handkartennum) {
		int barnum = CafeMain.getBarkarten().size();
		if(CafeMain.getSpieler() == 0) {
			CafeMain.getBarkarten().add(CafeMain.getKartenspieler0().get(handkartennum));
			Barkartenecke.getBarzellen(barnum).setGast(CafeMain.getKartenspieler0().get(handkartennum));
			punktzahl(Barkartenecke.getBarzellen(barnum).getPunkte());
		} else {
			CafeMain.getBarkarten().add(CafeMain.getKartenspieler1().get(handkartennum));
			Barkartenecke.getBarzellen(barnum).setGast(CafeMain.getKartenspieler1().get(handkartennum));
			punktzahl(Barkartenecke.getBarzellen(barnum).getPunkte());
		}
		
		Barkartenecke.getBarzellen(barnum).setBorder(BorderFactory.createLineBorder(Color.red));
		Thread thread = new Thread(new Runnable() {
			  @Override
			  public void run() {
				  try {
					  Thread.sleep(1500);
					  Barkartenecke.getBarzellen(barnum).setBorder(BorderFactory.createLineBorder(Color.black));
					  } catch(InterruptedException e) {}
				  }
			  }
		);
		thread.start();
		new Spielende().barvoll();
		spielerwechsel();
	}

	protected void legegastkarte(int handkartennum,int stuhlNr) {
		if(CafeMain.getSpieler() == 0) {
			CafeMain.getStuehle().get(stuhlNr).setGast(CafeMain.getKartenspieler0().get(handkartennum));
			//Punktzahl und Neuekartenziehen
		} else {
			//anderer Spieler
		}
	}
	
	protected void punktzahl(int addition) {
		if(CafeMain.getSpieler() == 0) {
			int neupktz = CafeMain.getPunktespieler(0) + addition;
			CafeMain.setPunktespieler(0, neupktz);
			Uebersichtsecke.getInfz(0).repaint();
		} else {
			int neupktz = CafeMain.getPunktespieler(1) + addition;
			CafeMain.setPunktespieler(1, neupktz);
			Uebersichtsecke.getInfz(1).repaint();
		}
	}
	
	protected void spielerwechsel() {
		if(CafeMain.getSpieler() == 0) {
			CafeMain.setSpieler(1);
		} else {
			CafeMain.setSpieler(0);
		}
		for(int i=0;i<5;i++) {
			Spielkartenecke.getHandkarte(i).setBorder(BorderFactory.createLineBorder(Color.black));
			Spielkartenecke.getHandkarte(i).repaint();
		}
	}

}