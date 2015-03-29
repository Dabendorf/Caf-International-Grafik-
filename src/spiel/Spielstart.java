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
	
	public void gastkartenmischen() {
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
	
	public void laenderkartenmischen() {
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
            bitisch = ImageIO.read(url);
            CafeMain.getTischcache().put(key, bitisch);
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
            bistuhl = ImageIO.read(url);
            CafeMain.getStuhlcache().put(key, bistuhl);
        } catch (MalformedURLException e) {} catch (IOException e) {}
        
        //Bild unten Rechts in Tischcache
        try {
        	key = "./icon.png";
            URL url = new URL(BaseURL.getJarBase(Spielfeld.class), key);
            bitisch = ImageIO.read(url);
            CafeMain.getTischcache().put(key, bitisch);
        } catch (MalformedURLException e) {} catch (IOException e) {}
    }
	
	public void spielfeldgenerieren() {
		for(int n=0;n<12;n++) {
			CafeMain.getTische().add(new Tisch());
			Spielzuege.legetischkarte(n);
		}
		for(int n=0;n<24;n++) {
			CafeMain.getStuehle().add(new Stuhl());
		}
	}
	
	public void zellelementzuordnung() {
		for(int n=0;n<Spielfeld.getSpielfeldtisch().size();n++) {
			Spielfeld.getSpielfeldtisch().get(n).setTisch(CafeMain.getTisch(n));
			CafeMain.getTisch(n).setSpielzelle(Spielfeld.getSpielfeldtisch().get(n));
		}
		for(int n=0;n<Spielfeld.getSpielfeldstuhl().size();n++) {
			Spielfeld.getSpielfeldstuhl().get(n).setStuhl(CafeMain.getStuhl(n));
			CafeMain.getStuhl(n).setSpielzelle(Spielfeld.getSpielfeldstuhl().get(n));
		}
	}
	
	public void tischstuhlzuordnung() {
		CafeMain.getTisch(0).setStuehle(11,12,13,0);
		CafeMain.getTisch(1).setStuehle(1,2,12,13);
		CafeMain.getTisch(2).setStuehle(2,3,13,14);
		CafeMain.getTisch(3).setStuehle(3,4,5,14);
		CafeMain.getTisch(4).setStuehle(4,5,15,16);
		CafeMain.getTisch(5).setStuehle(5,6,16,17);
		CafeMain.getTisch(6).setStuehle(6,7,17,18);
		CafeMain.getTisch(7).setStuehle(7,18,19,20);
		CafeMain.getTisch(8).setStuehle(7,8,20,21);
		CafeMain.getTisch(9).setStuehle(8,9,21,22);
		CafeMain.getTisch(10).setStuehle(9,10,22,23);
		CafeMain.getTisch(11).setStuehle(9,10,11,0);
		CafeMain.getStuhl(0).setTische(11,0);
		CafeMain.getStuhl(1).setTische(1);
		CafeMain.getStuhl(2).setTische(1,2);
		CafeMain.getStuhl(3).setTische(2,3);
		CafeMain.getStuhl(4).setTische(3,4);
		CafeMain.getStuhl(5).setTische(3,4,5);
		CafeMain.getStuhl(6).setTische(5,6);
		CafeMain.getStuhl(7).setTische(6,7,8);
		CafeMain.getStuhl(8).setTische(8,9);
		CafeMain.getStuhl(9).setTische(9,10,11);
		CafeMain.getStuhl(10).setTische(10,11);
		CafeMain.getStuhl(11).setTische(11,0);
		CafeMain.getStuhl(12).setTische(0,1);
		CafeMain.getStuhl(13).setTische(0,1,2);
		CafeMain.getStuhl(14).setTische(2,3);
		CafeMain.getStuhl(15).setTische(4);
		CafeMain.getStuhl(16).setTische(4,5);
		CafeMain.getStuhl(17).setTische(5,6);
		CafeMain.getStuhl(18).setTische(6,7);
		CafeMain.getStuhl(19).setTische(7);
		CafeMain.getStuhl(20).setTische(7,8);
		CafeMain.getStuhl(21).setTische(8,9);
		CafeMain.getStuhl(22).setTische(9,10);
		CafeMain.getStuhl(23).setTische(10);
	}
	
	public boolean SysWin() {
        return (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0);
    }

}