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
		CafeMain.getSpieler(42).getHandkarten().set(handkartennum,null);
		Uebersichtsecke.getKartsp(CafeMain.getAktSpieler(), handkartennum).repaint();
		punktzahl(Barkartenecke.getBarzellen(barnum).getPunkte());
		handkartendemarkieren();
		
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
		CafeMain.setZustand(21);
	}

	protected void legegastkarte(int handkartennum,int stuhlNr) {
		if(CafeMain.getStuehle().get(stuhlNr).setGast(CafeMain.getSpieler(42).getHandkarten().get(handkartennum)) == true) {
			CafeMain.getSpieler(42).getHandkarten().set(handkartennum,null);
			Uebersichtsecke.getKartsp(CafeMain.getAktSpieler(), handkartennum).repaint();
		}
		//Punktzahl und Neuekartenziehen
		handkartendemarkieren();
	}
	
	protected void gastkarteziehen(int handkartennum) {
		CafeMain.getSpieler(42).getHandkarten().set(handkartennum, CafeMain.getGastkarten().get(0));
		CafeMain.getGastkarten().remove(0);
		
		Uebersichtsecke.getKartsp(CafeMain.getAktSpieler(), handkartennum).repaint();
		Uebersichtsecke.getKartsp(CafeMain.getAktSpieler(), handkartennum).setBorder(BorderFactory.createLineBorder(Color.red, 2));
		Thread thread = new Thread(new Runnable() {
			  @Override
			  public void run() {
				  try {
					  Thread.sleep(1500);
					  Uebersichtsecke.getKartsp(0, handkartennum).setBorder(BorderFactory.createLineBorder(Color.black, 2));
					  Uebersichtsecke.getKartsp(1, handkartennum).setBorder(BorderFactory.createLineBorder(Color.black, 2));
					  } catch(InterruptedException e) {}
				  }
			  }
		);
		thread.start();
		handkartendemarkieren();
		CafeMain.setZustand(12);
		if(!new Spielende().barvoll()) {
			spielerwechsel();
		}
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