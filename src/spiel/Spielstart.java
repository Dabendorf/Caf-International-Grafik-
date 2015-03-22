package spiel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import spiel.Gastkarte.Geschlecht;
import spiel.Gastkarte.Land;

public class Spielstart {
	
	private String OS = System.getProperty("os.name").toLowerCase();

	public void namensfrage() {
		Meldungen msgbox = new Meldungen();
		
		JTextField spielername00 = new JTextField(new Feldbegrenzung(12), "", 0);
		JTextField spielername01 = new JTextField(new Feldbegrenzung(12), "", 0);
		
		Object[] namensfrage = {msgbox.spielernameint(1), spielername00, msgbox.spielernameint(2), spielername01};
	    JOptionPane pane = new JOptionPane(namensfrage, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
	    pane.createDialog(null, msgbox.fragespielername).setVisible(true);
	    
	    CafeMain.setSpielername(0, spielername00.getText());
	    CafeMain.setSpielername(1, spielername01.getText());
	    
	    if(CafeMain.getSpielername(0).equals("") || CafeMain.getSpielername(1).equals("")) {
	    	JOptionPane.showMessageDialog(null, msgbox.spielernamevergessen, msgbox.titelunvollstaendig, JOptionPane.ERROR_MESSAGE);
	    	namensfrage();
	    } else if(CafeMain.getSpielername(0).equalsIgnoreCase(CafeMain.getSpielername(1))) {
	    	JOptionPane.showMessageDialog(null, msgbox.spielernamengleich, msgbox.titelnamensgleichheit, JOptionPane.ERROR_MESSAGE);
	    	namensfrage();
	    } else {
	    	CafeMain.setSpielernamenkorrekt(true);
	    }
	}
	
	public static void gastkartenmischen() {
		for(int j=0;j<2;j++){
	    	for(Land land : Land.values()) {
	            int anzahl = 2;
	            if(land == Land.JOKER) {
	               anzahl = 1;
	            }
	            for(int i=0;i<anzahl;i++) {
	                for(Geschlecht geschlecht : Geschlecht.values()) {
	                    CafeMain.getGastkarten().add(new Gastkarte(geschlecht, land));
	                }    
	            }
	        }
	    }
		Collections.shuffle(CafeMain.getGastkarten());
		
		for(int p=0;p<5;p++) {
	    	CafeMain.getKartenspieler0().add(CafeMain.getGastkarten().get(0));
	    	CafeMain.getKartenspieler1().add(CafeMain.getGastkarten().get(1));
	    	CafeMain.getGastkarten().remove(0);
	    	CafeMain.getGastkarten().remove(0);
	    }
	}
	
	public static void laenderkartenmischen() {
		for(int n=0;n<2;n++) {
			 for(Land land : Land.values()) {
				 if(land != Land.JOKER) {
					CafeMain.getLaenderkarten().add(new Laenderkarte(land));
				 }
			 }
		}
		Collections.shuffle(CafeMain.getLaenderkarten());
	}
	
	public void bilderladen() {
    	String key = null;
    	BufferedImage bitisch = null;
		BufferedImage bistuhl = null;
		
		//12 Laender + 2 Platzhalter
        for(Land land : Land.values()) {
        	try {
        		key = "./tisch_"+land+".png";
                URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
                bitisch = ImageIO.read(url);
                CafeMain.getTischcache().put(key, bitisch);
            } catch (MalformedURLException e) {} catch (IOException e) {}
        }
        
    	try {
    		key = "./tisch_leer.png";
            URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
            bitisch = ImageIO.read(url);
            CafeMain.getTischcache().put(key, bitisch); 
        } catch (MalformedURLException e) {} catch (IOException e) {}
    	
    	try {
			key = "./stapel_tische.png";
            URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
            bistuhl = ImageIO.read(url);
            CafeMain.getTischcache().put(key, bistuhl);
        } catch (MalformedURLException e) {} catch (IOException e) {}
    	
    	//13*2 = 26 Gäste + 2 Platzhalter
    	for(Land land : Land.values()) {
    		for(Geschlecht geschlecht : Geschlecht.values()) {
    			try {
    				key = "./gast_"+land+"_"+geschlecht+".png";
	                URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
	                bistuhl = ImageIO.read(url);
	                CafeMain.getStuhlcache().put(key, bistuhl);
	            } catch (MalformedURLException e) {} catch (IOException e) {}
    		}
    	}
    	
    	try {
    		key = "./stuhl_leer.png";
            URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
            bistuhl = ImageIO.read(url);
            CafeMain.getStuhlcache().put(key, bistuhl);
        } catch (MalformedURLException e) {} catch (IOException e) {}
        
        try {
        	key = "./stapel_gaeste.png";
            URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
            bitisch = ImageIO.read(url);
            CafeMain.getStuhlcache().put(key, bitisch);
        } catch (MalformedURLException e) {} catch (IOException e) {}
    }
	
	public static void spielfeldgenerieren() {
		for(int n=0;n<12;n++) {
			CafeMain.getTische().add(new Tisch());
			Spielzuege.legetischkarte(n);
		}
		for(int n=0;n<24;n++) {
			CafeMain.getStuehle().add(new Stuhl());
		}
	}
	
	public static void zellelementzuordnung() {
		for(int n=0;n<Spielfeld.getSpielfeldtisch().size();n++) {
			Spielfeld.getSpielfeldtisch().get(n).setTi(CafeMain.getTische().get(n));
			CafeMain.getTische().get(n).setSz(Spielfeld.getSpielfeldtisch().get(n));
		}
		for(int n=0;n<Spielfeld.getSpielfeldstuhl().size();n++) {
			Spielfeld.getSpielfeldstuhl().get(n).setSt(CafeMain.getStuehle().get(n));
			CafeMain.getStuehle().get(n).setSz(Spielfeld.getSpielfeldstuhl().get(n));
		}
	}
	
	public static void tischstuhlzuordnung() {
		CafeMain.getTische().get(0).setStuehle(CafeMain.getStuehle().get(11),CafeMain.getStuehle().get(12),CafeMain.getStuehle().get(13),CafeMain.getStuehle().get(0));
		CafeMain.getTische().get(1).setStuehle(CafeMain.getStuehle().get(1),CafeMain.getStuehle().get(2),CafeMain.getStuehle().get(12),CafeMain.getStuehle().get(13));
		CafeMain.getTische().get(2).setStuehle(CafeMain.getStuehle().get(2),CafeMain.getStuehle().get(3),CafeMain.getStuehle().get(13),CafeMain.getStuehle().get(14));
		CafeMain.getTische().get(3).setStuehle(CafeMain.getStuehle().get(3),CafeMain.getStuehle().get(4),CafeMain.getStuehle().get(5),CafeMain.getStuehle().get(14));
		CafeMain.getTische().get(4).setStuehle(CafeMain.getStuehle().get(4),CafeMain.getStuehle().get(5),CafeMain.getStuehle().get(15),CafeMain.getStuehle().get(16));
		CafeMain.getTische().get(5).setStuehle(CafeMain.getStuehle().get(5),CafeMain.getStuehle().get(6),CafeMain.getStuehle().get(16),CafeMain.getStuehle().get(17));
		CafeMain.getTische().get(6).setStuehle(CafeMain.getStuehle().get(6),CafeMain.getStuehle().get(7),CafeMain.getStuehle().get(17),CafeMain.getStuehle().get(18));
		CafeMain.getTische().get(7).setStuehle(CafeMain.getStuehle().get(7),CafeMain.getStuehle().get(18),CafeMain.getStuehle().get(19),CafeMain.getStuehle().get(20));
		CafeMain.getTische().get(8).setStuehle(CafeMain.getStuehle().get(7),CafeMain.getStuehle().get(8),CafeMain.getStuehle().get(20),CafeMain.getStuehle().get(21));
		CafeMain.getTische().get(9).setStuehle(CafeMain.getStuehle().get(8),CafeMain.getStuehle().get(9),CafeMain.getStuehle().get(21),CafeMain.getStuehle().get(22));
		CafeMain.getTische().get(10).setStuehle(CafeMain.getStuehle().get(9),CafeMain.getStuehle().get(10),CafeMain.getStuehle().get(22),CafeMain.getStuehle().get(23));
		CafeMain.getTische().get(11).setStuehle(CafeMain.getStuehle().get(9),CafeMain.getStuehle().get(10),CafeMain.getStuehle().get(11),CafeMain.getStuehle().get(0));
		CafeMain.getStuehle().get(0).setTische(CafeMain.getTische().get(11),CafeMain.getTische().get(0));
		CafeMain.getStuehle().get(1).setTische(CafeMain.getTische().get(1));
		CafeMain.getStuehle().get(2).setTische(CafeMain.getTische().get(1),CafeMain.getTische().get(2));
		CafeMain.getStuehle().get(3).setTische(CafeMain.getTische().get(2),CafeMain.getTische().get(3));
		CafeMain.getStuehle().get(4).setTische(CafeMain.getTische().get(3),CafeMain.getTische().get(4));
		CafeMain.getStuehle().get(5).setTische(CafeMain.getTische().get(3),CafeMain.getTische().get(4),CafeMain.getTische().get(5));
		CafeMain.getStuehle().get(6).setTische(CafeMain.getTische().get(5),CafeMain.getTische().get(6));
		CafeMain.getStuehle().get(7).setTische(CafeMain.getTische().get(6),CafeMain.getTische().get(7),CafeMain.getTische().get(8));
		CafeMain.getStuehle().get(8).setTische(CafeMain.getTische().get(8),CafeMain.getTische().get(9));
		CafeMain.getStuehle().get(9).setTische(CafeMain.getTische().get(9),CafeMain.getTische().get(10),CafeMain.getTische().get(11));
		CafeMain.getStuehle().get(10).setTische(CafeMain.getTische().get(10),CafeMain.getTische().get(11));
		CafeMain.getStuehle().get(11).setTische(CafeMain.getTische().get(11),CafeMain.getTische().get(0));
		CafeMain.getStuehle().get(12).setTische(CafeMain.getTische().get(0),CafeMain.getTische().get(1));
		CafeMain.getStuehle().get(13).setTische(CafeMain.getTische().get(1),CafeMain.getTische().get(2),CafeMain.getTische().get(0));
		CafeMain.getStuehle().get(14).setTische(CafeMain.getTische().get(2),CafeMain.getTische().get(3));
		CafeMain.getStuehle().get(15).setTische(CafeMain.getTische().get(4));
		CafeMain.getStuehle().get(16).setTische(CafeMain.getTische().get(4),CafeMain.getTische().get(5));
		CafeMain.getStuehle().get(17).setTische(CafeMain.getTische().get(5),CafeMain.getTische().get(6));
		CafeMain.getStuehle().get(18).setTische(CafeMain.getTische().get(6),CafeMain.getTische().get(7));
		CafeMain.getStuehle().get(19).setTische(CafeMain.getTische().get(7));
		CafeMain.getStuehle().get(20).setTische(CafeMain.getTische().get(7),CafeMain.getTische().get(8));
		CafeMain.getStuehle().get(21).setTische(CafeMain.getTische().get(8),CafeMain.getTische().get(9));
		CafeMain.getStuehle().get(22).setTische(CafeMain.getTische().get(9),CafeMain.getTische().get(10));
		CafeMain.getStuehle().get(23).setTische(CafeMain.getTische().get(10));
	}
	
	public boolean SysWin() {
        return (OS.indexOf("win") >= 0);
    }

}