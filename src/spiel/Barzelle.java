package spiel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Barzelle extends JPanel {
	
	private BufferedImage i;
	private int barplatznum;
	private Gastkarte gast;
	
	public Barzelle(int barplatznum) {
		this.barplatznum = barplatznum;
	}
	
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		URL url = null;
		Font font = new Font("Arial", Font.BOLD,16);
		FontMetrics fm = gr.getFontMetrics(font);
		
		if(this.gast == null) {
			this.setBackground(new Color(0x20324F));
			gr.setColor(Color.black);
			this.setBorder(BorderFactory.createLineBorder(Color.black));
			int punkte = new Barkartenecke().getBarpunkte(barplatznum);
			if(punkte > 0) {
				gr.setColor(Color.white);
			} else {
				gr.setColor(Color.red);
			}
			String num = Integer.toString(punkte);
			gr.drawString(num,this.getWidth()/2-fm.stringWidth(num)/2,this.getHeight()/2);
		} else {
			//Gast hierhin setzen, wenn Spielalgorithmus arbeitet
		}
	}
	
	public void setGast(Gastkarte gast) {
		this.gast = gast;
	}

}