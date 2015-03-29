package spiel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Barzelle extends JPanel {
	
	private BufferedImage i;
	private Gastkarte gast = null;
	private String key = null;
	private int punkte;
	private String num;
	private Font font = new Font("Arial", Font.BOLD,16);
	private FontMetrics fm;
	
	public Barzelle(int punkte) {
		this.punkte = punkte;
	}

	@Override
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);

		if(gast != null) {
	        gr.drawImage(i, 0, 0, getWidth(), getHeight(), null);
		} else {
			fm = gr.getFontMetrics(font);
			if(punkte > 0) {
				gr.setColor(Color.white);
			} else {
				gr.setColor(Color.red);
			}
			gr.drawString(num,this.getWidth()/2-fm.stringWidth(num)/2,this.getHeight()/2);
		}
	}
	
	private void loadImage() {
		if(gast!=null) {
			key = "./gast_"+this.gast.getLand()+"_"+this.gast.getGeschlecht()+".png";
			i = CafeMain.getStuhlcache().get(key);
		}
	}
	
	public void zelltext() {
		this.setBackground(new Color(0x20324F));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		num = Integer.toString(punkte);
	}
	
	public void setGast(Gastkarte gast) {
		this.gast = gast;
		if(gast!=null) {
			loadImage();
		}
	}
	
	public int getPunkte() {
		return punkte;
	}
	
}