package spiel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public final class Bildecke extends JPanel {
	private BufferedImage i;
	
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		
		loadImage();
		if(i!=null) {
	    	gr.drawImage(i,0,0, getWidth(), getHeight(), null);
	    }
	}
	
	private void loadImage() {
		if(i==null) {
			String key = "./icon.png";
			i = CafeMain.getTischcache().get(key);
		}
	}
}