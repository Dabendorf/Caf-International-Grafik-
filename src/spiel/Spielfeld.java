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

class Spielfeld extends JPanel {

	protected static JLabel spielfeldlabel[][] = new JLabel[11][11];
	protected static ArrayList<JLabel> spielfeldlabeltisch = new ArrayList<JLabel>(12);
	protected static ArrayList<JLabel> spielfeldlabelstuhl = new ArrayList<JLabel>(24);
	
	public Spielfeld() {
		setLayout(new GridLayout(11,11));
		for(int i=0;i<11;i++) {
			for(int n=0;n<11;n++) {
				spielfeldlabel[n][i] = new JLabel(n+","+i);
				
				spielfeldlabel[n][i].setBackground(new Color(255,255,255));
				spielfeldlabel[n][i].setOpaque(true);
				add(spielfeldlabel[n][i]);
			}
		}
		feldmalen();
	}
	
	public void feldmalen() {
		spielfeldlabeltisch.add(spielfeldlabel[4][3]);
		spielfeldlabeltisch.add(spielfeldlabel[5][2]);
		spielfeldlabeltisch.add(spielfeldlabel[6][3]);
		spielfeldlabeltisch.add(spielfeldlabel[7][4]);
		spielfeldlabeltisch.add(spielfeldlabel[8][5]);
		spielfeldlabeltisch.add(spielfeldlabel[7][6]);
		spielfeldlabeltisch.add(spielfeldlabel[6][7]);
		spielfeldlabeltisch.add(spielfeldlabel[5][8]);
		spielfeldlabeltisch.add(spielfeldlabel[4][7]);
		spielfeldlabeltisch.add(spielfeldlabel[3][6]);
		spielfeldlabeltisch.add(spielfeldlabel[2][5]);
		spielfeldlabeltisch.add(spielfeldlabel[3][4]);
		
		spielfeldlabelstuhl.add(spielfeldlabel[4][4]);
		spielfeldlabelstuhl.add(spielfeldlabel[5][1]);
		spielfeldlabelstuhl.add(spielfeldlabel[6][2]);
		spielfeldlabelstuhl.add(spielfeldlabel[7][3]);
		spielfeldlabelstuhl.add(spielfeldlabel[8][4]);
		spielfeldlabelstuhl.add(spielfeldlabel[7][5]);
		spielfeldlabelstuhl.add(spielfeldlabel[6][6]);
		spielfeldlabelstuhl.add(spielfeldlabel[5][7]);
		spielfeldlabelstuhl.add(spielfeldlabel[4][6]);
		spielfeldlabelstuhl.add(spielfeldlabel[3][5]);
		spielfeldlabelstuhl.add(spielfeldlabel[2][4]);
		spielfeldlabelstuhl.add(spielfeldlabel[3][3]);
		spielfeldlabelstuhl.add(spielfeldlabel[4][2]);
		spielfeldlabelstuhl.add(spielfeldlabel[5][3]);
		spielfeldlabelstuhl.add(spielfeldlabel[6][4]);
		spielfeldlabelstuhl.add(spielfeldlabel[9][5]);
		spielfeldlabelstuhl.add(spielfeldlabel[8][6]);
		spielfeldlabelstuhl.add(spielfeldlabel[7][7]);
		spielfeldlabelstuhl.add(spielfeldlabel[6][8]);
		spielfeldlabelstuhl.add(spielfeldlabel[5][9]);
		spielfeldlabelstuhl.add(spielfeldlabel[4][8]);
		spielfeldlabelstuhl.add(spielfeldlabel[3][7]);
		spielfeldlabelstuhl.add(spielfeldlabel[2][6]);
		spielfeldlabelstuhl.add(spielfeldlabel[1][5]);
		
		
		for(JLabel a:spielfeldlabeltisch) {
            a.setBackground(Color.ORANGE);
            final int tischindex = spielfeldlabeltisch.indexOf(a);
            a.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		System.out.println("Tisch: "+tischindex);
            	}
            });
        }
        for(JLabel b:spielfeldlabelstuhl) {
            b.setBackground(Color.RED);
            final int stuhlindex = spielfeldlabelstuhl.indexOf(b);
            b.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		System.out.println("Stuhl: "+stuhlindex);
            	}
            });
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