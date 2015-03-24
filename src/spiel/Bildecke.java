package spiel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public final class Bildecke extends JPanel {
	protected void paintComponent(Graphics gr) {
		super.paintComponent(gr);
		try{
			URL url = new URL(BaseURL.getJarBase(Spielfeld.class), "./icon.png");
			BufferedImage i = ImageIO.read(url);
			if(i!=null) {
		    	gr.drawImage(i,0,0, getWidth(), getHeight(), null);
		    }
		}catch(MalformedURLException e) {
		}catch(IOException e) { }
	}
}