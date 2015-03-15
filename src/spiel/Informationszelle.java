package spiel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Informationszelle extends JPanel {
	
	private int spieler;
	
	public Informationszelle(int spielernum) {
		this.spieler = spielernum;
	}
	
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		Font font = new Font("Arial", Font.BOLD,16);
		FontMetrics fm = gr.getFontMetrics(font);
		
		if(spieler == 0) {
			String spnm = CafeMain.getSpielername(0);
			String pkt = Integer.toString(CafeMain.getPunktespieler(0));
			String ges = spnm+"\n"+pkt;
			gr.drawString(ges,this.getWidth()/2-fm.stringWidth(ges)/2,this.getHeight()/2);
			//gr.drawString(spnm,this.getWidth()/2-fm.stringWidth(spnm)/2,this.getHeight()/2);
			/*gr.drawString(pkt,this.getWidth()/2-fm.stringWidth(pkt)/2,this.getHeight()/2);*/
		} else {
			CafeMain.getSpielername(1);
		}
	}
}