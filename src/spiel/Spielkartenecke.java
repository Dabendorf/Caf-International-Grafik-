package spiel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import spiel.Kartenstapel.Typ;

public class Spielkartenecke extends JPanel {
	private static Kartenstapel handkarten[] = new Kartenstapel[5]; //WICHTIGE INFORMATION: Die Anzahl der Restkarten muss festgehalten werden.
	private static int akthandkartnum = -1;

	protected Spielkartenecke() {
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
	            		if(CafeMain.getZustand()==11 || CafeMain.getZustand()==12) {
	            			klickhand(index);
	            		}
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
				kst.addMouseListener(new MouseAdapter() {
	            	@Override
	            	public void mouseClicked(MouseEvent e) {
	            		klickgast();
	            	}
	            });
				add(kst);
			} else {
				Kartenstapel kst = new Kartenstapel(Typ.Leer);
				kst.setOpaque(true);
				kst.setBorder(BorderFactory.createLineBorder(Color.black, 2));
				add(kst);
			}
		}
	}
	
	private void klickhand(int num) {
		if(handkarten[num].isGeklickt()) {
			handkarten[num].setBorder(BorderFactory.createLineBorder(Color.black, 2));
			handkarten[num].setGeklickt(false);
			akthandkartnum = -1;
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
	
	private void klickgast() {
		for(int i=0;i<5;i++) {
			if(handkarten[i].getI()==null) {
				new Spielzuege().gastkarteziehen(i);
			}
		}
	}
	
	protected static Kartenstapel getHandkarte(int n) {
		return handkarten[n];
	}

	protected void setHandkarten(Kartenstapel[] handkarten) {
		Spielkartenecke.handkarten = handkarten;
	}

	protected static int getAkthandkartnum() {
		return akthandkartnum;
	}

	public static void setAkthandkartnum(int akthandkartnum) {
		Spielkartenecke.akthandkartnum = akthandkartnum;
	}
}