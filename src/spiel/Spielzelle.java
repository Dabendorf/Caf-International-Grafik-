package spiel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Spielzelle extends JPanel {
	
	public enum Typ {Leer, Stuhl, Tisch};

	private Typ t;
	private BufferedImage i;
	private Stuhl st;
	private Tisch ti;
	 
	public Spielzelle(Typ t) {
	    setTyp(t);
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

	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		URL url = null;
		if(t.equals(Typ.Leer)) {
			
		}else if(t.equals(Typ.Stuhl)) {
			if(this.getSt().getGast()!=null) {
				try{
					url = new URL(BaseURL.getJarBase(Spielfeld.class), "./gast_"+this.getSt().getGast().land+"_"+this.getSt().getGast().geschlecht+".jpg");
					i = ImageIO.read(url);
				}catch(MalformedURLException e) {
				}catch(IOException e) { }
			}else{
				try {
					url = new URL(BaseURL.getJarBase(Spielfeld.class), "./stuhl_leer2.jpg");
					i = ImageIO.read(url);
				}catch(MalformedURLException e) {
				}catch(IOException e) { }
			}
		}else if(t.equals(Typ.Tisch)) {
			if(this.getTi().getLand()!=null) {
				try{
					url = new URL(BaseURL.getJarBase(Spielfeld.class), "./tisch_"+this.getTi().getLand().land+".jpg");
					i = ImageIO.read(url);
				}catch(MalformedURLException e) {
				}catch(IOException e) { }
			}else{
				try {
					url = new URL(BaseURL.getJarBase(Spielfeld.class), "./tisch_leer2.jpg");
					i = ImageIO.read(url);
				}catch(MalformedURLException e) {
				}catch(IOException e) { }
			}
		}
		if(i!=null) {
	    	gr.drawImage(i,0,0, getWidth(), getHeight(), null);
	    }
	}
}