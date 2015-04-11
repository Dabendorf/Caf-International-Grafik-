package spiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Kartenstapel extends JPanel {

	protected enum Typ {Leer, Gaeste, Tische, Handkarte, HandkarteInfo};
	
	private Typ t;
	private BufferedImage i;
	private int handkartnum, spieler;
	private String key;
	private boolean geklickt = false;
	
	protected Kartenstapel(Typ t) {
		setTyp(t);
	}
	
	@Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        loadImage();
        if(i!=null) {
        	gr.drawImage(i, 0, 0, getWidth(), getHeight(), null);
        }
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
				spielertemp = CafeMain.getAktSpieler();
			} else {
				spielertemp = this.spieler;
			}
			if(CafeMain.getSpieler(spielertemp).getHandkarten().get(handkartnum)!=null) {
				key = "./gast_"+CafeMain.getSpieler(spielertemp).getHandkarten().get(handkartnum).getLand()+"_"+CafeMain.getSpieler(spielertemp).getHandkarten().get(handkartnum).getGeschlecht()+".png";
			}else{
				i = null;
				key = null;
			}
		}
		
		if(!t.equals(Typ.Leer) && key!=null) {
			if(t.equals(Typ.Handkarte) || t.equals(Typ.HandkarteInfo) || t.equals(Typ.Gaeste)) {
				i = CafeMain.getStuhlcache().get(key);
			} else if (t.equals(Typ.Tische)){
				i = CafeMain.getTischcache().get(key);
			}
		}
	}
	
	protected Typ getTyp() {
		return t;
	}

	protected void setTyp(Typ t) {
		this.t = t;
	}

	protected BufferedImage getI() {
		return i;
	}

	protected void setI(BufferedImage i) {
		this.i = i;
	}
	
	protected int getHandkartnum() {
		return handkartnum;
	}
	
	protected void setHandkartnum(int handkartnum) {
		this.handkartnum = handkartnum;
	}
	
	protected void setSpieler(int spieler) {
		this.spieler = spieler;
	}
	
	protected boolean isGeklickt() {
		return geklickt;
	}

	protected void setGeklickt(boolean geklickt) {
		this.geklickt = geklickt;
	}

}