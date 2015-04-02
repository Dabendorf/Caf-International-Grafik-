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
		
		if(spieler == 0) {
			String spnm = CafeMain.getSpieler(0).getName();
			String pkt = Integer.toString(CafeMain.getSpieler(0).getPunkte());
			String ges = spnm+"\n"+pkt;
			gr.drawString(ges,this.getWidth()/2-fm.stringWidth(ges)/2,this.getHeight()/2);
			//gr.drawString(spnm,this.getWidth()/2-fm.stringWidth(spnm)/2,this.getHeight()/2);
			/*gr.drawString(pkt,this.getWidth()/2-fm.stringWidth(pkt)/2,this.getHeight()/2);*/
		} else {
			String spnm = CafeMain.getSpieler(1).getName();
			String pkt = Integer.toString(CafeMain.getSpieler(1).getPunkte());
			String ges = spnm+"\n"+pkt;
			gr.drawString(ges,this.getWidth()/2-fm.stringWidth(ges)/2,this.getHeight()/2);
			//gr.drawString(spnm,this.getWidth()/2-fm.stringWidth(spnm)/2,this.getHeight()/2);
			/*gr.drawString(pkt,this.getWidth()/2-fm.stringWidth(pkt)/2,this.getHeight()/2);*/
		}
	}
}