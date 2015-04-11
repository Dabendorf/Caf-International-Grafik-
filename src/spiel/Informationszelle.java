package spiel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Informationszelle extends JPanel {
	
	private int spieler;
	private JLabel labelname = new JLabel();
	private JLabel labelpunkte = new JLabel();
	
	protected Informationszelle(int spielernum) {
		this.spieler = spielernum;
		
		setLayout(new GridLayout(2,1));
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setOpaque(true);
		add(labelname);
		
		labelpunkte.setHorizontalAlignment(SwingConstants.CENTER);
		labelpunkte.setOpaque(true);
		add(labelpunkte);
	}
	
	protected void punktzahlschreiben() {
		String spnm = CafeMain.getSpieler(spieler).getName();
		String pkt = Integer.toString(CafeMain.getSpieler(spieler).getPunkte());
		labelname.setText(spnm);
		labelpunkte.setText(pkt);
	}
}