package spiel;
 
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
    private static boolean spielernamenkorrekt = false;
    private static GridBagLayout gridlayout = new GridBagLayout();
   
	public CafeMain() throws IOException {
        spielframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spielframe.setPreferredSize(new Dimension(1200,800));
        spielframe.setMinimumSize(new Dimension(900,600));
        spielframe.setResizable(true);
        spielframe.setIconImage(Toolkit.getDefaultToolkit().getImage(new URL(BaseURL.getJarBase(Spielfeld.class), "./favicon.png")));
        spielframe.setVisible(false);
        
        Container contentPane = spielframe.getContentPane();
        contentPane.setLayout(gridlayout);
        
        spielframe.add(new Barkartenecke(), new GridBagFelder(0, 0, 1, 1, 1, 1));
        spielframe.add(new Uebersichtsecke(), new GridBagFelder(0, 1, 1, 1, 1, 1));
        spielframe.add(new Spielfeld(), new GridBagFelder(1, 0, 1, 2, 3, 3));
        spielframe.add(new Spielkartenecke(), new GridBagFelder(2, 0, 1, 1, 1, 1));
        spielframe.add(new Bildecke(), new GridBagFelder(2, 1, 1, 1, 1, 1));
        
        spielframe.pack();
        spielframe.setLocationRelativeTo(null);
        
        ablauf();
    }
   
    private void ablauf() {
        if(Spielstart.SysWin()) {
            msgbox.windows();
        }
        /*do{
        Spielstart.namensfrage();
        } while(spielernamenkorrekt == false);*/
        spielername[0] = "Lukas";
        spielername[1] = "Malte";
        spielframe.setVisible(true);
    }
 
    public static void main(String[] args) throws IOException {
        new CafeMain();
    }

	public static int getSpieler() {
		return spieler;
	}

	//BENUTZEN
	public static void setSpieler(int spieler) {
		CafeMain.spieler = spieler;
	}

	public static String getSpielername(int index) {
		return spielername[index];
	}

	public static void setSpielername(int index, String spielername) {
		CafeMain.spielername[index] = spielername;
	}

	public static int getPunktespieler(int index) {
		return punktespieler[index];
	}

	//BENUTZEN
	public static void setPunktespieler(int index, int punktespieler) {
		CafeMain.punktespieler[index] = punktespieler;
	}

	public static List<Tisch> getTische() {
		return tische;
	}
	
	public static void setTische(List<Tisch> tische) {
		CafeMain.tische = tische;
	}

	public static List<Stuhl> getStuehle() {
		return stuehle;
	}

	public static void setStuehle(List<Stuhl> stuehle) {
		CafeMain.stuehle = stuehle;
	}

	public static boolean isSpielernamenkorrekt() {
		return spielernamenkorrekt;
	}

	public static void setSpielernamenkorrekt(boolean spielernamenkorrekt) {
		CafeMain.spielernamenkorrekt = spielernamenkorrekt;
	}

	public static List<Gastkarte> getKartenspieler0() {
		return kartenspieler0;
	}

	public static List<Gastkarte> getKartenspieler1() {
		return kartenspieler1;
	}

	public static List<Gastkarte> getGastkarten() {
		return gastkarten;
	}

	public static List<Laenderkarte> getLaenderkarten() {
		return laenderkarten;
	}

	//BENUTZEN
	public static List<Gastkarte> getBarkarten() {
		return barkarten;
	}
}