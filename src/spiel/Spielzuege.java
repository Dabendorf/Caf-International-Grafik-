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
		CafeMain.getBarkarten().add(CafeMain.getSpieler(42).getHandkarten().get(handkartennum));
		Barkartenecke.getBarzellen(barnum).setGast(CafeMain.getSpieler(42).getHandkarten().get(handkartennum));
		punktzahl(Barkartenecke.getBarzellen(barnum).getPunkte());
		
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
		CafeMain.getStuehle().get(stuhlNr).setGast(CafeMain.getSpieler(42).getHandkarten().get(handkartennum));
		//Punktzahl und Neuekartenziehen
		handkartendemarkieren();
	}
	
	protected void punktzahl(int addition) {
		int neupktz = CafeMain.getSpieler(42).getPunkte()+ addition;
		CafeMain.getSpieler(42).setPunkte(neupktz);
		Uebersichtsecke.getInfz(CafeMain.getAktSpieler()).punktzahlschreiben();
	}
	
	protected void spielerwechsel() {
		if(CafeMain.getAktSpieler() == 0) {
			CafeMain.setAktSpieler(1);
		} else {
			CafeMain.setAktSpieler(0);
		}
		handkartendemarkieren();
	}
	
	protected void handkartendemarkieren() {
		Spielkartenecke.setAkthandkartnum(-1);
		for(int i=0;i<5;i++) {
			Spielkartenecke.getHandkarte(i).setBorder(BorderFactory.createLineBorder(Color.black));
			Spielkartenecke.getHandkarte(i).setGeklickt(false);
			Spielkartenecke.getHandkarte(i).repaint();
		}
	}

}