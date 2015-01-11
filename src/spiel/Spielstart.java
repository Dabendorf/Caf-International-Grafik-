package spiel;

import java.io.IOException;
import java.util.Collections;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import spiel.Gastkarte.Geschlecht;
import spiel.Gastkarte.Land;

public class Spielstart extends CafeMain {
	
	public Spielstart() throws IOException {
		super();
	}

	public static void namensfrage() {
		JTextField spielername01 = new JTextField(new Feldbegrenzung(12), "", 0);
		JTextField spielername02 = new JTextField(new Feldbegrenzung(12), "", 0);
		
		Object[] namensfrage = {"Name von Spieler 1", spielername01, "Name von Spieler 2", spielername02};
	    JOptionPane pane = new JOptionPane(namensfrage, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION);
	    pane.createDialog(null, "Wie heißen die Spieler?").setVisible(true);
	    
	    spielername[0] = spielername01.getText();
	    spielername[1] = spielername02.getText();
	    
	    if(spielername[0].equals("") || spielername[1].equals("")) {
	    	JOptionPane.showMessageDialog(null, "Bitte gib beide Spielernamen ein!", "Unvollständige Eingabe", JOptionPane.ERROR_MESSAGE);
	    	namensfrage();
	    } else if(spielername[0].equalsIgnoreCase(spielername[1])) {
	    	JOptionPane.showMessageDialog(null, "Bitte benenne die Spieler unterschiedlich!", "Namensgleichheit", JOptionPane.ERROR_MESSAGE);
	    	namensfrage();
	    } else {
	    	spielernamenkorrekt = true;
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
	                    gastkarten.add(new Gastkarte(geschlecht, land));
	                }    
	            }
	        }
	    }
		Collections.shuffle(gastkarten);
		for(int p=0;p<5;p++) {
	    	kartenspieler1.add(gastkarten.get(0));
	    	kartenspieler2.add(gastkarten.get(1));
	    	gastkarten.remove(0);
	    	gastkarten.remove(0);
	    }
	}
	
	public static void laenderkartenmischen() {
		for(int n=0;n<2;n++) {
			 for(Land land : Land.values()) {
				 if(land != Land.JOKER) {
					laenderkarten.add(new Laenderkarte(land));
				 }
			 }
		}
		Collections.shuffle(laenderkarten);
	}
	
	public static void spielfeldgenerieren() {
		for(int n=0;n<12;n++) {
			tische.add(new Tisch());
			tische.get(n).setLand(laenderkarten.get(0));
			laenderkarten.remove(0);
		}
		for(int n=0;n<24;n++) {
			stuehle.add(new Stuhl());
		}
		tische.get(0).setStuehle(stuehle.get(11),stuehle.get(12),stuehle.get(13),stuehle.get(0));
		tische.get(1).setStuehle(stuehle.get(1),stuehle.get(2),stuehle.get(12),stuehle.get(13));
		tische.get(2).setStuehle(stuehle.get(2),stuehle.get(3),stuehle.get(13),stuehle.get(14));
		tische.get(3).setStuehle(stuehle.get(3),stuehle.get(4),stuehle.get(5),stuehle.get(14));
		tische.get(4).setStuehle(stuehle.get(4),stuehle.get(5),stuehle.get(15),stuehle.get(16));
		tische.get(5).setStuehle(stuehle.get(5),stuehle.get(6),stuehle.get(16),stuehle.get(17));
		tische.get(6).setStuehle(stuehle.get(6),stuehle.get(7),stuehle.get(17),stuehle.get(18));
		tische.get(7).setStuehle(stuehle.get(7),stuehle.get(18),stuehle.get(19),stuehle.get(20));
		tische.get(8).setStuehle(stuehle.get(7),stuehle.get(8),stuehle.get(20),stuehle.get(21));
		tische.get(9).setStuehle(stuehle.get(8),stuehle.get(9),stuehle.get(21),stuehle.get(22));
		tische.get(10).setStuehle(stuehle.get(9),stuehle.get(10),stuehle.get(22),stuehle.get(23));
		tische.get(11).setStuehle(stuehle.get(9),stuehle.get(10),stuehle.get(11),stuehle.get(0));
		stuehle.get(0).setTische(tische.get(11),tische.get(0));
		stuehle.get(1).setTische(tische.get(1));
		stuehle.get(2).setTische(tische.get(1),tische.get(2));
		stuehle.get(3).setTische(tische.get(2),tische.get(3));
		stuehle.get(4).setTische(tische.get(3),tische.get(4));
		stuehle.get(5).setTische(tische.get(3),tische.get(4),tische.get(5));
		stuehle.get(6).setTische(tische.get(5),tische.get(6));
		stuehle.get(7).setTische(tische.get(6),tische.get(7),tische.get(8));
		stuehle.get(8).setTische(tische.get(8),tische.get(9));
		stuehle.get(9).setTische(tische.get(9),tische.get(10),tische.get(11));
		stuehle.get(10).setTische(tische.get(10),tische.get(11));
		stuehle.get(11).setTische(tische.get(11),tische.get(0));
		stuehle.get(12).setTische(tische.get(0),tische.get(1));
		stuehle.get(13).setTische(tische.get(1),tische.get(2),tische.get(0));
		stuehle.get(14).setTische(tische.get(2),tische.get(3));
		stuehle.get(15).setTische(tische.get(4));
		stuehle.get(16).setTische(tische.get(4),tische.get(5));
		stuehle.get(17).setTische(tische.get(5),tische.get(6));
		stuehle.get(18).setTische(tische.get(6),tische.get(7));
		stuehle.get(19).setTische(tische.get(7));
		stuehle.get(20).setTische(tische.get(7),tische.get(8));
		stuehle.get(21).setTische(tische.get(8),tische.get(9));
		stuehle.get(22).setTische(tische.get(9),tische.get(10));
		stuehle.get(23).setTische(tische.get(10));
	 }

}
