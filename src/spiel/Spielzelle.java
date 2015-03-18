package spiel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Spielzelle extends JPanel {
	
	public enum Typ {Leer, Stuhl, Tisch};

	private Typ t;
	private BufferedImage i;
	private Stuhl st;
	private Tisch ti;
	private String key;
	 
	public Spielzelle(Typ t) {
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
			if(this.getSt().getGast()!=null) {
				key = "./gast_"+this.getSt().getGast().getLand()+"_"+this.getSt().getGast().getGeschlecht()+".png";
			} else {
				key = "./stuhl_leer.png";
			}
		} else if(t.equals(Typ.Tisch)) {
			if(this.getTi().getLand()!=null) {
				key = "./tisch_"+this.getTi().getLand()+".png";
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
	
	public Typ getTyp() {
	    return t;
	}
	 
	public void setTyp(Typ t) {
	    if(t != this.t) {
	    	i = null;
	    }
	    this.t = t;
	}
	 
	public Stuhl getSt() {
		return st;
	}

	public void setSt(Stuhl st) {
		this.st = st;
	}

	public Tisch getTi() {
		return ti;
	}

	public void setTi(Tisch ti) {
		this.ti = ti;
	}
}