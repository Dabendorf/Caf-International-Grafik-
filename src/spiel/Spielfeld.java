package spiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import spiel.Kartenstapel.Typ;

public class Spielfeld extends JPanel {

	protected Spielzelle spielfeldzelle[][] = new Spielzelle[11][11];
	protected static ArrayList<Spielzelle> spielfeldtisch = new ArrayList<Spielzelle>(12);
	protected static ArrayList<Spielzelle> spielfeldstuhl = new ArrayList<Spielzelle>(24);
	//protected int stuhlnummer;
	//protected int tischnummer;
	
	public Spielfeld() {
		setLayout(new GridLayout(11,11));
		for(int i=0;i<11;i++) {
			for(int n=0;n<11;n++) {
				spielfeldzelle[n][i] = new Spielzelle(Spielzelle.Typ.Leer);
				spielfeldzelle[n][i].setBackground(new Color(0,255,255));
				spielfeldzelle[n][i].setOpaque(true);
				add(spielfeldzelle[n][i]);
			}
		}
		feldmalen();
	}

	private void feldmalen() {
		spielfeldtisch.add(spielfeldzelle[4][3]);
		spielfeldtisch.add(spielfeldzelle[5][2]);
		spielfeldtisch.add(spielfeldzelle[6][3]);
		spielfeldtisch.add(spielfeldzelle[7][4]);
		spielfeldtisch.add(spielfeldzelle[8][5]);
		spielfeldtisch.add(spielfeldzelle[7][6]);
		spielfeldtisch.add(spielfeldzelle[6][7]);
		spielfeldtisch.add(spielfeldzelle[5][8]);
		spielfeldtisch.add(spielfeldzelle[4][7]);
		spielfeldtisch.add(spielfeldzelle[3][6]);
		spielfeldtisch.add(spielfeldzelle[2][5]);
		spielfeldtisch.add(spielfeldzelle[3][4]);
		
		spielfeldstuhl.add(spielfeldzelle[4][4]);
		spielfeldstuhl.add(spielfeldzelle[5][1]);
		spielfeldstuhl.add(spielfeldzelle[6][2]);
		spielfeldstuhl.add(spielfeldzelle[7][3]);
		spielfeldstuhl.add(spielfeldzelle[8][4]);
		spielfeldstuhl.add(spielfeldzelle[7][5]);
		spielfeldstuhl.add(spielfeldzelle[6][6]);
		spielfeldstuhl.add(spielfeldzelle[5][7]);
		spielfeldstuhl.add(spielfeldzelle[4][6]);
		spielfeldstuhl.add(spielfeldzelle[3][5]);
		spielfeldstuhl.add(spielfeldzelle[2][4]);
		spielfeldstuhl.add(spielfeldzelle[3][3]);
		spielfeldstuhl.add(spielfeldzelle[4][2]);
		spielfeldstuhl.add(spielfeldzelle[5][3]);
		spielfeldstuhl.add(spielfeldzelle[6][4]);
		spielfeldstuhl.add(spielfeldzelle[9][5]);
		spielfeldstuhl.add(spielfeldzelle[8][6]);
		spielfeldstuhl.add(spielfeldzelle[7][7]);
		spielfeldstuhl.add(spielfeldzelle[6][8]);
		spielfeldstuhl.add(spielfeldzelle[5][9]);
		spielfeldstuhl.add(spielfeldzelle[4][8]);
		spielfeldstuhl.add(spielfeldzelle[3][7]);
		spielfeldstuhl.add(spielfeldzelle[2][6]);
		spielfeldstuhl.add(spielfeldzelle[1][5]);
		
		for(Spielzelle a:spielfeldtisch) {
            a.setTyp(Spielzelle.Typ.Tisch);
        }
        for(Spielzelle b:spielfeldstuhl) {
            b.setTyp(Spielzelle.Typ.Stuhl);
        }
        
		Spielstart.gastkartenmischen();
		Spielstart.laenderkartenmischen();
		Spielstart.spielfeldgenerieren();
		Spielstart.tischstuhlzuordnung();
		Spielstart.zellelementzuordnung();
	}
	
	public static ArrayList<Spielzelle> getSpielfeldtisch() {
		return spielfeldtisch;
	}

	public static void setSpielfeldtisch(ArrayList<Spielzelle> spielfeldtisch) {
		Spielfeld.spielfeldtisch = spielfeldtisch;
	}

	public static ArrayList<Spielzelle> getSpielfeldstuhl() {
		return spielfeldstuhl;
	}

	public static void setSpielfeldstuhl(ArrayList<Spielzelle> spielfeldstuhl) {
		Spielfeld.spielfeldstuhl = spielfeldstuhl;
	}
	
}

class Spielkartenecke extends JPanel {
	private Kartenstapel handkarten[] = new Kartenstapel[5]; //WICHTIGE INFORMATION: Die Anzahl der Restkarten muss festgehalten werden.
	
	public Spielkartenecke() {
		setLayout(new GridLayout(5,2));
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				handkarten[i/2] = new Kartenstapel(Typ.Handkarte);
				handkarten[i/2].setOpaque(true);
				handkarten[i/2].setHandkartnum(i/2);
				add(handkarten[i/2]);
			} else if(i==3) {
				Kartenstapel kst = new Kartenstapel(Typ.Tische);
				kst.setOpaque(true);
				add(kst);
			} else if(i==7) {
				Kartenstapel kst = new Kartenstapel(Typ.Gaeste);
				kst.setOpaque(true);
				add(kst);
			} else {
				Kartenstapel kst = new Kartenstapel(Typ.Leer);
				kst.setOpaque(true);
				add(kst);
			}
		}
	}
	
	public Kartenstapel[] getHandkarten() {
		return handkarten;
	}

	public void setHandkarten(Kartenstapel[] handkarten) {
		this.handkarten = handkarten;
	}
}

class Barkartenecke extends JPanel {
	private int barpunkte[] = {1,2,3,4,5,-2,-4,-6,-8,-10,-4,-6,-8,-10,-12,-6,-8,-10,-12,-14,-16};
	
	public Barkartenecke() {
		setLayout(new GridLayout(7,3));
		for(int i=0;i<21;i++) {
			Barzelle bz = new Barzelle(i);
			bz.setOpaque(true);
			add(bz);
		}
	}

	public int getBarpunkte(int n) {
		return barpunkte[n];
	}
}

class Uebersichtsecke extends JPanel {
	private Kartenstapel handkarten[][] = new Kartenstapel[2][5];
	
	public Uebersichtsecke() {
		setLayout(new GridLayout(6,2));
		for(int i=0;i<2;i++) {
			Informationszelle infz = new Informationszelle(i);
			infz.setOpaque(true);
			infz.setBorder(BorderFactory.createLineBorder(Color.black));
			add(infz);
		}
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				handkarten[0][i/2] = new Kartenstapel(Typ.HandkarteInfo);
				handkarten[0][i/2].setOpaque(true);
				handkarten[0][i/2].setHandkartnum(i/2);
				handkarten[0][i/2].setSpieler(0);
				handkarten[0][i/2].setBorder(BorderFactory.createLineBorder(Color.black));
				add(handkarten[0][i/2]);
			} else {
				handkarten[1][(i-1)/2] = new Kartenstapel(Typ.HandkarteInfo);
				handkarten[1][(i-1)/2].setOpaque(true);
				handkarten[1][(i-1)/2].setHandkartnum((i-1)/2);
				handkarten[1][(i-1)/2].setSpieler(1);
				handkarten[1][(i-1)/2].setBorder(BorderFactory.createLineBorder(Color.black));
				add(handkarten[1][(i-1)/2]);
			}
		}
	}
}

final class Bildecke extends JPanel {
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		try{
			URL url = new URL(BaseURL.getJarBase(Spielfeld.class), "./icon.png");
			BufferedImage i = ImageIO.read(url);
			if(i!=null) {
		    	gr.drawImage(i,0,0, getWidth(), getHeight(), null);
		    }
		}catch(MalformedURLException e) {
		}catch(IOException e) { }
	}
}