package spiel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spielfeld extends JPanel {

	protected Spielzelle spielfeldzelle[][] = new Spielzelle[11][11];
	protected static ArrayList<Spielzelle> spielfeldtisch = new ArrayList<Spielzelle>(12);
	protected static ArrayList<Spielzelle> spielfeldstuhl = new ArrayList<Spielzelle>(24);
	protected int stuhlnummer;
	protected int tischnummer;
	
	public Spielfeld() {
		setLayout(new GridLayout(11,11));
		for(int i=0;i<11;i++) {
			for(int n=0;n<11;n++) {
				spielfeldzelle[n][i] = new Spielzelle();
				spielfeldzelle[n][i].setBackground(new Color(255,255,255));
				spielfeldzelle[n][i].setOpaque(true);
				add(spielfeldzelle[n][i]);
			}
		}
		feldmalen();
	}

	public void feldmalen() {
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
		
		Spielstart.laenderkartenmischen();
		Spielstart.spielfeldgenerieren();
		for(Spielzelle a:spielfeldtisch) {
            a.setTyp(Spielzelle.Typ.Tisch);
            final int tischindex = spielfeldtisch.indexOf(a);
            a.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		stuhlnummer = tischindex;
            	}
            });
        }
        for(Spielzelle b:spielfeldstuhl) {
            b.setBackground(Color.RED);
            b.setTyp(Spielzelle.Typ.Stuhl);
            final int stuhlindex = spielfeldstuhl.indexOf(b);
            b.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		tischnummer = stuhlindex;
            	}
            });
        }
   
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

class Kartenstapel extends JPanel {
	public Kartenstapel() {
		setLayout(new GridLayout(5,2));
		Random rand = new Random();
		for(int i=0;i<10;i++) {
			JLabel label = new JLabel();
		    label.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
		    label.setOpaque(true);
		    add(label);
		}
	}
}
 
class AufbauHilfe {
    public static GridBagConstraints createGridBagConstraints(int x, int y, int width, int height, int weightX, int weightY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.weightx = weightX;
        constraints.weighty = weightY;
 
        return constraints;
    }
 
    public static JLabel createRandomBackgroundLabel(String text) {
        Random rand = new Random();
        JLabel label = new JLabel(text);
        label.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        label.setOpaque(true);
 
        return label;
    }
}