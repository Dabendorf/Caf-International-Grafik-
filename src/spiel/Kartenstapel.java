package spiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Kartenstapel extends JPanel {

	public enum Typ {Leer, Gaeste, Tische, Handkarte, HandkarteInfo};
	
	private Typ t;
	private BufferedImage i;
	private int handkartnum, spieler;
	private String key;
	private boolean geklickt = false;
	
	public Kartenstapel(Typ t) {
		setTyp(t);
	}
	
	@Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        loadImage();
        gr.drawImage(i, 0, 0, getWidth(), getHeight(), null);
    }
	
	private void loadImage() {
		if(this.t == Typ.Leer) {
			this.setBackground(Color.white);
		} else if(this.t == Typ.Gaeste) {
			key = "./stapel_gaeste.png";
		} else if(this.t == Typ.Tische) {
			key = "./stapel_tische.png";
		} else if(this.t == Typ.Handkarte || this.t == Typ.HandkarteInfo) {
			int spielertemp;
			if(this.t == Typ.Handkarte) {
				spielertemp = CafeMain.getSpieler();
			} else {
				spielertemp = this.spieler;
			}
			
			if(spielertemp == 0) {
				key = "./gast_"+CafeMain.getKartenspieler0().get(handkartnum).getLand()+"_"+CafeMain.getKartenspieler0().get(handkartnum).getGeschlecht()+".png";
			} else {
				key = "./gast_"+CafeMain.getKartenspieler1().get(handkartnum).getLand()+"_"+CafeMain.getKartenspieler1().get(handkartnum).getGeschlecht()+".png";
			}
		}
		
		if(!t.equals(Typ.Leer)) {
			if(t.equals(Typ.Handkarte) || t.equals(Typ.HandkarteInfo) || t.equals(Typ.Gaeste)) {
				i = CafeMain.getStuhlcache().get(key);
			} else if (t.equals(Typ.Tische)){
				i = CafeMain.getTischcache().get(key);
			}
		}
	}
	
	public Typ getTyp() {
		return t;
	}

	public void setTyp(Typ t) {
		this.t = t;
	}

	public BufferedImage getI() {
		return i;
	}

	public void setI(BufferedImage i) {
		this.i = i;
	}
	
	public int getHandkartnum() {
		return handkartnum;
	}
	
	public void setHandkartnum(int handkartnum) {
		this.handkartnum = handkartnum;
	}
	
	public void setSpieler(int spieler) {
		this.spieler = spieler;
	}
	
	public boolean isGeklickt() {
		return geklickt;
	}

	public void setGeklickt(boolean geklickt) {
		this.geklickt = geklickt;
	}

}