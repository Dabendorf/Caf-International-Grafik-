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
		int[] tischkoordx = {4,5,6,7,8,7,6,5,4,3,2,3};
		int[] tischkoordy = {3,2,3,4,5,6,7,8,7,6,5,4};
		for(int i=0;i<12;i++) {
			spielfeldtisch.add(spielfeldzelle[tischkoordx[i]][tischkoordy[i]]);
			spielfeldzelle[tischkoordx[i]][tischkoordy[i]].setTyp(Spielzelle.Typ.Tisch);
		}
		
		int[] stuhlkoordx = {4,5,6,7,8,7,6,5,4,3,2,3,4,5,6,9,8,7,6,5,4,3,2,1};
		int[] stuhlkoordy = {4,1,2,3,4,5,6,7,6,5,4,3,2,3,4,5,6,7,8,9,8,7,6,5};
		for(int i=0;i<24;i++) {
			spielfeldstuhl.add(spielfeldzelle[stuhlkoordx[i]][stuhlkoordy[i]]);
			spielfeldzelle[stuhlkoordx[i]][stuhlkoordy[i]].setTyp(Spielzelle.Typ.Stuhl);
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