package spiel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Spielfeld extends JPanel {

	private Spielzelle spielfeldzelle[][] = new Spielzelle[11][11];
	private static JLabel meldungsbox = new JLabel();
	private static ArrayList<Spielzelle> spielfeldtisch = new ArrayList<Spielzelle>(12);
	private static ArrayList<Spielzelle> spielfeldstuhl = new ArrayList<Spielzelle>(24);
	private int aktstuhlnummer;

	public Spielfeld() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		
		for(int y=0;y<11;y++) {
			for(int x=0;x<11;x++) {
				gbc.gridx = x;
				gbc.gridy = y;

				if(y<10) {
					spielfeldzelle[x][y] = new Spielzelle(Spielzelle.Typ.Leer);
					spielfeldzelle[x][y].setBackground(new Color(0,255,255));
					spielfeldzelle[x][y].setOpaque(true);
					add(spielfeldzelle[x][y], gbc);
				} else if(y==10) {
					gbc.gridwidth = 11;
					meldungsbox.setBackground(new Color(0,255,255));
					meldungsbox.setOpaque(true);
					meldungsbox.setHorizontalAlignment(SwingConstants.CENTER);
					add(meldungsbox, gbc);
					break;
				}
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
	
	public static JLabel getMeldungsbox() {
		return meldungsbox;
	}
}