package spiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Kartenstapel extends JPanel {
	
	public enum Typ {Leer, Gaeste, Tische, Handkarte};
	
	private Typ t;
	private BufferedImage i;
	private int handkartnum;

	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		URL url = null;
		
		if(this.t == Typ.Leer) {
			this.setBackground(Color.white);
		} else if(this.t == Typ.Gaeste) {
			try{
				url = new URL(BaseURL.getJarBase(Spielfeld.class), "./stapel_gaeste.jpg");
				i = ImageIO.read(url);
			}catch(MalformedURLException e) {
			}catch(IOException e) { }
		} else if(this.t == Typ.Tische) {
			try{
				url = new URL(BaseURL.getJarBase(Spielfeld.class), "./stapel_tische.jpg");
				i = ImageIO.read(url);
			}catch(MalformedURLException e) {
			}catch(IOException e) { }
		} else if(this.t == Typ.Handkarte) {
			int spieler = CafeMain.getSpieler();
			if(spieler == 0) {
				try{
					url = new URL(BaseURL.getJarBase(Spielfeld.class), "./gast_"+CafeMain.getKartenspieler0().get(handkartnum).getLand()+"_"+CafeMain.getKartenspieler0().get(handkartnum).getGeschlecht()+".jpg");
					i = ImageIO.read(url);
				}catch(MalformedURLException e) {
				}catch(IOException e) { }
			} else {
				try{
					url = new URL(BaseURL.getJarBase(Spielfeld.class), "./gast_"+CafeMain.getKartenspieler1().get(handkartnum).getLand()+"_"+CafeMain.getKartenspieler1().get(handkartnum).getGeschlecht()+".jpg");
					i = ImageIO.read(url);
				}catch(MalformedURLException e) {
				}catch(IOException e) { }
			}
		}
		if(i!=null) {
	    	gr.drawImage(i,0,0, getWidth(), getHeight(), null);
	    }
	}
	
	public Kartenstapel(Typ t) {
		setTyp(t);
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
	
	public void setHandkartnum(int handkartnum) {
		this.handkartnum = handkartnum;
	}

}