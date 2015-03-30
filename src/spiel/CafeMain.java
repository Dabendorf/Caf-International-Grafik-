package spiel;
 
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
 
public class CafeMain {
	
    // System
	private Meldungen msgbox = new Meldungen();
    private JFrame spielframe = new JFrame(msgbox.programmname);
   
    // Spieler
    private static int spieler = 0;
    private static String[] spielername = new String[2];
    private static int[] punktespieler = new int[2];
    private static List<Gastkarte> kartenspieler0 = new ArrayList<Gastkarte>();
    private static List<Gastkarte> kartenspieler1 = new ArrayList<Gastkarte>();
   
    // Spielkarten
    private static List<Gastkarte> gastkarten = new ArrayList<Gastkarte>();
    private static List<Laenderkarte> laenderkarten = new ArrayList<Laenderkarte>();
    private static List<Gastkarte> barkarten = new ArrayList<Gastkarte>();
   
    // Spielfeld
    private static List<Tisch> tische = new ArrayList<Tisch>(12);
    private static List<Stuhl> stuehle = new ArrayList<Stuhl>(24);
   
    // Sonstiges
    private static Map<String, BufferedImage> tischcache = new TreeMap<>();
    private static Map<String, BufferedImage> stuhlcache = new TreeMap<>();
   
	protected CafeMain() throws IOException {
        spielframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spielframe.setPreferredSize(new Dimension(1400,800));
        spielframe.setMinimumSize(new Dimension(1050,600));
        spielframe.setResizable(true);
        spielframe.setIconImage(Toolkit.getDefaultToolkit().getImage(new URL(BaseURL.getJarBase(Spielfeld.class), "./favicon.png")));
        spielframe.setVisible(false);
        
        Container contentPane = spielframe.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        spielframe.add(new Barkartenecke(), new GridBagFelder(0, 0, 1, 1, 0.15, 0.5));
        spielframe.add(new Uebersichtsecke(), new GridBagFelder(0, 1, 1, 1, 0.15, 0.5));
        spielframe.add(new Spielfeld(), new GridBagFelder(1, 0, 1, 2, 0.7, 1.0));
        spielframe.add(new Spielkartenecke(), new GridBagFelder(2, 0, 1, 1, 0.15, 0.5));
        spielframe.add(new Bildecke(), new GridBagFelder(2, 1, 1, 1, 0.15, 0.5));
        
        spielframe.pack();
        spielframe.setLocationRelativeTo(null);
        
        ablauf();
    }
   
    private void ablauf() throws IOException {
    	Spielstart spst = new Spielstart();
        if(spst.SysWin()) {
            msgbox.windows();
        }
        //spst.namensfrage();
        spielername[0] = "Lukas"; //Kurzweg
        spielername[1] = "Malte"; //Kurzweg
        long zeit1 = Debug.zeitnehmen(); //DEBUG
        spst.bilderladen();
        spielframe.setVisible(true);
        long zeit2 = Debug.zeitnehmen(); //DEBUG
        Debug.laufzeitschreiben(zeit2-zeit1); //DEBUG
        Spielfeld.getMeldungsbox().setText("Startzeit: "+(zeit2-zeit1)); //DEBUG
    }
 
    public static void main(String[] args) throws IOException {
        new CafeMain();
    }

	protected static int getSpieler() {
		return spieler;
	}

	protected static void setSpieler(int spieler) {
		CafeMain.spieler = spieler;
	}

	protected static String getSpielername(int index) {
		return spielername[index];
	}

	protected static void setSpielername(int index, String spielername) {
		CafeMain.spielername[index] = spielername;
	}

	protected static int getPunktespieler(int index) {
		return punktespieler[index];
	}

	protected static void setPunktespieler(int index, int punktespieler) {
		CafeMain.punktespieler[index] = punktespieler;
	}

	protected static Tisch getTisch(int index) {
		return tische.get(index);
	}

	protected static List<Tisch> getTische() {
		return tische;
	}

	protected static void setTische(List<Tisch> tische) {
		CafeMain.tische = tische;
	}
	
	protected static Stuhl getStuhl(int index) {
		return stuehle.get(index);
	}

	protected static List<Stuhl> getStuehle() {
		return stuehle;
	}

	protected static void setStuehle(List<Stuhl> stuehle) {
		CafeMain.stuehle = stuehle;
	}

	protected static List<Gastkarte> getKartenspieler0() {
		return kartenspieler0;
	}

	protected static List<Gastkarte> getKartenspieler1() {
		return kartenspieler1;
	}

	protected static List<Gastkarte> getGastkarten() {
		return gastkarten;
	}

	protected static List<Laenderkarte> getLaenderkarten() {
		return laenderkarten;
	}

	protected static List<Gastkarte> getBarkarten() {
		return barkarten;
	}
	
	protected static Map<String, BufferedImage> getTischcache() {
		return tischcache;
	}

	protected static Map<String, BufferedImage> getStuhlcache() {
		return stuhlcache;
	}
}