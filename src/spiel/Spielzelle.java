package spiel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Spielzelle extends JPanel {
	
	protected enum Typ {Leer, Stuhl, Tisch};

	private Typ t;
	private BufferedImage i;
	private Stuhl st;
	private Tisch ti;
	private String key;
	 
	protected Spielzelle(Typ t) {
	    setTyp(t);
	}

	@Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        loadImage();
        gr.drawImage(i, 0, 0, getWidth(), getHeight(), null);
    }
	
	private void loadImage() {
		if(t.equals(Typ.Stuhl)) {
			if(this.getStuhl().getGast()!=null) {
				key = "./gast_"+this.getStuhl().getGast().getLand()+"_"+this.getStuhl().getGast().getGeschlecht()+".png";
			} else {
				key = "./stuhl_leer.png";
			}
		} else if(t.equals(Typ.Tisch)) {
			if(this.getTisch().getLaenderkarte()!=null) {
				key = "./tisch_"+this.getTisch().getLaenderkarte()+".png";
			} else {
				key = "./tisch_leer.png";
			}
		}
		if(!t.equals(Typ.Leer)) {
			if(t.equals(Typ.Stuhl)) {
				i = CafeMain.getStuhlcache().get(key);
			} else {
				i = CafeMain.getTischcache().get(key);
			}
		}
    }
	
	protected Typ getTyp() {
	    return t;
	}
	 
	protected void setTyp(Typ t) {
	    if(t != this.t) {
	    	i = null;
	    }
	    this.t = t;
	}
	 
	protected Stuhl getStuhl() {
		return st;
	}

	protected void setStuhl(Stuhl st) {
		this.st = st;
	}

	protected Tisch getTisch() {
		return ti;
	}

	protected void setTisch(Tisch ti) {
		this.ti = ti;
	}
}