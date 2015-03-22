package spiel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

	private Spielzelle spielfeldzelle[][] = new Spielzelle[11][11];
	private static ArrayList<Spielzelle> spielfeldtisch = new ArrayList<Spielzelle>(12);
	private static ArrayList<Spielzelle> spielfeldstuhl = new ArrayList<Spielzelle>(24);
	private int aktstuhlnummer;

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
	
	public int getAktstuhlnummer() {
		return aktstuhlnummer;
	}

	public void setAktstuhlnummer(int aktstuhlnummer) {
		this.aktstuhlnummer = aktstuhlnummer;
	}
	
}

class Spielkartenecke extends JPanel {
	private static Kartenstapel handkarten[] = new Kartenstapel[5]; //WICHTIGE INFORMATION: Die Anzahl der Restkarten muss festgehalten werden.
	private static int akthandkartnum;

	public Spielkartenecke() {
		setLayout(new GridLayout(5,2));
		for(int i=0;i<10;i++) {
			if(i%2==0) {
				handkarten[i/2] = new Kartenstapel(Typ.Handkarte);
				handkarten[i/2].setOpaque(true);
				handkarten[i/2].setHandkartnum(i/2);
				handkarten[i/2].setBorder(BorderFactory.createLineBorder(Color.black, 2));
				final int index = i/2;
				handkarten[i/2].addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent e) {
	            		klick(index);
	            	}
	            });
				add(handkarten[i/2]);
			} else if(i==3) {
				Kartenstapel kst = new Kartenstapel(Typ.Tische);
				kst.setOpaque(true);
				kst.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				add(kst);
			} else if(i==7) {
				Kartenstapel kst = new Kartenstapel(Typ.Gaeste);
				kst.setOpaque(true);
				kst.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				add(kst);
			} else {
				Kartenstapel kst = new Kartenstapel(Typ.Leer);
				kst.setOpaque(true);
				kst.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				add(kst);
			}
		}
	}
	
	private void klick(int num) {
		if(handkarten[num].isGeklickt()) {
			handkarten[num].setBorder(BorderFactory.createLineBorder(Color.black, 2));
			handkarten[num].setGeklickt(false);
		} else {
			handkarten[num].setBorder(BorderFactory.createLineBorder(Color.red, 2));
			handkarten[num].setGeklickt(true);
			akthandkartnum = num;
			for(int i=0;i<5;i++) {
				if(i!=num) {
					handkarten[i].setBorder(BorderFactory.createLineBorder(Color.black, 2));
					handkarten[i].setGeklickt(false);
				}
			}
		}
	}
	
	public static Kartenstapel getHandkarte(int n) {
		return handkarten[n];
	}

	public void setHandkarten(Kartenstapel[] handkarten) {
		Spielkartenecke.handkarten = handkarten;
	}

	public static int getAkthandkartnum() {
		return akthandkartnum;
	}
}

class Barkartenecke extends JPanel {
	private static ArrayList<Barzelle> barzellen = new ArrayList<Barzelle>(21);
	private static int barpunkte[] = {1,2,3,4,5,-2,-4,-6,-8,-10,-4,-6,-8,-10,-12,-6,-8,-10,-12,-14,-16};
	
	public Barkartenecke() {
		setLayout(new GridLayout(7,3));
		for(int i=0;i<21;i++) {
			Barzelle bz = new Barzelle(i);
			bz.setOpaque(true);
			bz.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		Spielzuege.legebarkarte(Spielkartenecke.getAkthandkartnum());
            	}
            });
			barzellen.add(bz);
			add(bz);
		}
	}

	public static Barzelle getBarzellen(int num) {
		return barzellen.get(num);
	}

	public static int getBarpunkte(int n) {
		return barpunkte[n];
	}
}

class Uebersichtsecke extends JPanel {
	private Kartenstapel handkarten[][] = new Kartenstapel[2][5];
	private static Informationszelle[] infz = new Informationszelle[2];
	
	public Uebersichtsecke() {
		setLayout(new GridLayout(6,2));
		for(int i=0;i<2;i++) {
			infz[i] = new Informationszelle(i);
			infz[i].setOpaque(true);
			infz[i].setBorder(BorderFactory.createLineBorder(Color.black));
			add(infz[i]);
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

	public static Informationszelle getInfz(int num) {
		return infz[num];
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