package spiel;
 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static spiel.CafeMain.*;
 
public class Spielfeld extends JPanel {
	//ImageIcon icon[] = new ImageIcon[12];
	//ImageIcon icon;
	JLabel[] label57 = new JLabel[12];
	//JLabel label57 = new JLabel();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();
        int width = getWidth();
        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
        zeichnen();
        for (int i = 0; i < label57.length; i++) {
        	  label57[i] = new JLabel();
        }
        
        for(int n=0;n<12;n++) {
        	try {
				Image img = ImageIO.read(this.getClass().getResource("/./spiel/stuhl.png"));
				ImageIcon icon = new ImageIcon(img);
	        	tische.get(n).setKoord(tischex[n], tischey[n]);
	        	label57[n].setBounds(tische.get(n).getX(),tische.get(n).getY(), tische.get(n).getX()+100, tische.get(n).getY()+100);
	        	label57[n].setIcon(icon);
	        	label57[n].setVisible(true);
	        	add(label57[n]);
	        	/*Image img = ImageIO.read(this.getClass().getResource("/./spiel/demo_"+tische.get(n).getLand().land+".jpg"));
				ImageIcon icon = new ImageIcon(img);
				System.out.println(this.getClass().getResource("/./spiel/demo_"+tische.get(n).getLand().land+".jpg"));
	        	tische.get(n).setKoord(tischex[n], tischey[n]);
	        	label57[n].setBounds(tische.get(n).getX(),tische.get(n).getY(), tische.get(n).getX()+100, tische.get(n).getY()+100);
	        	label57[n].setIcon(icon);
	        	label57[n].setVisible(true);
	        	add(label57[n]);*/
	        	System.out.println(tische.get(n).getLand()+": "+tische.get(n).getX()+","+tische.get(n).getY());
			} catch (IOException e) {
				e.printStackTrace();
			}
        	
        }
    }
   
    public static void zeichnen() {
        tischex[0] = 100; tischey[0] = 100;
        tischex[1] = 100; tischey[1] = 200;
        tischex[2] = 100; tischey[2] = 300;
        tischex[3] = 100; tischey[3] = 250;
        tischex[4] = 200; tischey[4] = 100;
        tischex[5] = 200; tischey[5] = 200;
        tischex[6] = 200; tischey[6] = 300;
        tischex[7] = 200; tischey[7] = 250;
        tischex[8] = 300; tischey[8] = 300;
        tischex[9] = 400; tischey[9] = 300;
        tischex[10] = 500; tischey[10] = 300;
        tischex[11] = 550; tischey[11] = 300;
       
        //tische.add(new Tisch()); tische.get(0).setLand(laenderkarten.get(0)); tische.get(0).setKoord(10, 10); tischzeichnen(stift,0);
        //tische.add(new Tisch()); tische.get(1).setLand(laenderkarten.get(1)); tische.get(1).setKoord(220, 10); tischzeichnen(stift,1);
        //tische.add(new Tisch()); tische.get(2).setLand(laenderkarten.get(2)); tische.get(2).setKoord(430, 10); tischzeichnen(stift,2);
       
    }
   
}