package spiel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Informationszelle extends JPanel {
	
	private int spieler;
	
	protected Informationszelle(int spielernum) {
		this.spieler = spielernum;
	}
	
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		Font font = new Font("Arial", Font.BOLD,16);
		FontMetrics fm = gr.getFontMetrics(font);
		
		String spnm = CafeMain.getSpieler(spieler).getName();
		String pkt = Integer.toString(CafeMain.getSpieler(spieler).getPunkte());
		String ges = spnm+"\n"+pkt;
		gr.drawString(ges,this.getWidth()/2-fm.stringWidth(ges)/2,this.getHeight()/2);
	}
}