package spiel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import spiel.Kartenstapel.Typ;

public class Uebersichtsecke extends JPanel {
	private static Kartenstapel handkarten[][] = new Kartenstapel[2][5];
	private static Informationszelle[] infz = new Informationszelle[2];
	
	protected Uebersichtsecke() {
		setLayout(new GridLayout(6,2));
		for(int i=0;i<2;i++) {
			infz[i] = new Informationszelle(i);
			infz[i].setOpaque(true);
			infz[i].setPreferredSize(new Dimension(0, 20));
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

	protected static Informationszelle getInfz(int num) {
		return infz[num];
	}
	
	protected static Kartenstapel getKartsp(int x, int y) {
		return handkarten[x][y];
	}
}