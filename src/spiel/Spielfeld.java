package spiel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import static spiel.CafeMain.*;

public class Spielfeld extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
    }
    
    public static void zeichnen() {
    	tischex[0] = 100; tischey[0] = 100;
    	tischex[1] = 100; tischey[1] = 200;
    	tischex[2] = 100; tischey[2] = 300;
    	tischex[3] = 100; tischey[3] = 400;
    	tischex[4] = 200; tischey[4] = 100;
    	tischex[5] = 200; tischey[5] = 200;
    	tischex[6] = 200; tischey[6] = 300;
    	tischex[7] = 200; tischey[7] = 400;
    	tischex[8] = 300; tischey[8] = 300;
    	tischex[9] = 400; tischey[9] = 300;
    	tischex[10] = 500; tischey[10] = 300;
    	tischex[11] = 550; tischey[11] = 300;
	   
		//tische.add(new Tisch()); tische.get(0).setLand(laenderkarten.get(0)); tische.get(0).setKoord(10, 10); tischzeichnen(stift,0);
		//tische.add(new Tisch()); tische.get(1).setLand(laenderkarten.get(1)); tische.get(1).setKoord(220, 10); tischzeichnen(stift,1);
		//tische.add(new Tisch()); tische.get(2).setLand(laenderkarten.get(2)); tische.get(2).setKoord(430, 10); tischzeichnen(stift,2);
	    
    }
    
    public static void tischzeichnen(int tischnummer) {
    	Image tischbild = null;
    	try{
    		tischbild = ImageIO.read(new File("./src/spiel/demo_"+tische.get(tischnummer).getLand().land+".jpg"));
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	ImageObserver tischweg = null;
    	Graphics2D g2d = (Graphics2D) spielframe.getGraphics();
    	g2d.drawImage(tischbild, tische.get(tischnummer).getX(), tische.get(tischnummer).getY(), 200, 200, tischweg);
    	System.out.println(tische.get(tischnummer).getLand().land);
    }
    
}