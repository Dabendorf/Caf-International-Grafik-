package spiel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spielfeld extends CafeMain {
	public Spielfeld() throws IOException {
		super();
	}

	public static void zeichne(Graphics stift) {
		int[] arrayx = new int[4];
		int[] arrayy = new int[4];
	    
	    arrayx[0] = 10;
	    arrayx[1] = 100;
	    arrayx[2] = 100;
	    arrayx[3] = 20;
	    arrayy[0] = 10;
	    arrayy[1] = 30;
	    arrayy[2] = 70;
	    arrayy[3] = 80;
	    stift.draw3DRect(10, 10, 100, 100, true);
	    stift.fillPolygon(arrayx, arrayy, 4);
	   
		//tische.add(new Tisch()); tische.get(0).setLand(laenderkarten.get(0)); tische.get(0).setKoord(10, 10); tischzeichnen(stift,0);
		//tische.add(new Tisch()); tische.get(1).setLand(laenderkarten.get(1)); tische.get(1).setKoord(220, 10); tischzeichnen(stift,1);
		//tische.add(new Tisch()); tische.get(2).setLand(laenderkarten.get(2)); tische.get(2).setKoord(430, 10); tischzeichnen(stift,2);
		
	  }
	
	public static void tischzeichnen(Graphics stift, int tischnummer) {
		Image img2 = null;
		try {
			img2=ImageIO.read(new File("./src/spiel/demo_"+tische.get(tischnummer).getLand().land+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageObserver napoleon = null;
		stift.drawImage(img2, tische.get(tischnummer).getX(), tische.get(tischnummer).getY(), 200, 200, napoleon);
		System.out.println(tische.get(tischnummer).getLand().land);
	}

}
