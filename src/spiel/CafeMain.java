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
import javax.swing.JOptionPane;
 
public class CafeMain {
   
    // System
    private static String programmname = "Café International";
    private static JFrame spielframe = new JFrame(programmname);
   
    // Spieler
    private static int spieler = 1;
    private static String[] spielername = new String[2];
    private static int[] punktespieler = new int[2];
    private static List<Gastkarte> kartenspieler1 = new ArrayList<Gastkarte>();
    private static List<Gastkarte> kartenspieler2 = new ArrayList<Gastkarte>();
   
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
        spielframe.setIconImage(Toolkit.getDefaultToolkit().getImage(new URL(BaseURL.getJarBase(Spielfeld.class), "./bilder/layout/icon.jpg")));
        spielframe.setVisible(false);
        
        Container contentPane = spielframe.getContentPane();
        contentPane.setLayout(gridlayout);
        
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("LINKSOBEN"), AufbauHilfe.createGridBagConstraints(0, 0, 1, 1, 1, 1));
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("LINKSUNTEN"), AufbauHilfe.createGridBagConstraints(0, 1, 1, 1, 1, 1));

        spielframe.add(new Kartenstapel(), AufbauHilfe.createGridBagConstraints(2, 0, 1, 1, 1, 1));
        //spielframe.add(AufbauHilfe.createRandomBackgroundLabel("RECHTSOBEN"), AufbauHilfe.createGridBagConstraints(2, 0, 1, 1, 1, 1));
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("RECHTSUNTEN"), AufbauHilfe.createGridBagConstraints(2, 1, 1, 1, 1, 1));
 
        spielframe.add(new Spielfeld(), AufbauHilfe.createGridBagConstraints(1, 0, 1, 2, 3, 3));
         
        spielframe.pack();
        spielframe.setLocationRelativeTo(null);
        
        ablauf();
    }
   
    public static void ablauf() {
        /*if(Spielstart.SysWin()) {
            JOptionPane.showMessageDialog(null, "Dein System ist hoffnungslos veraltet!\nWindoof ist nicht kompatibel mit diesem Spiel.\nSollte es zu Problemen bei der Ausführung kommen,\ndann öffne das Spiel bitte auf einem PC\nmit Mac OS oder Linux!", "System veraltet", JOptionPane.WARNING_MESSAGE);
        }
        do{
        Spielstart.namensfrage();
        } while(spielernamenkorrekt == false);*/
        Spielstart.gastkartenmischen();
        //Spielstart.laenderkartenmischen();
        //Spielstart.spielfeldgenerieren();
        spielframe.setVisible(true);
    }
 
    public static void main(String[] args) throws IOException {
        new CafeMain();
    }

    //BENUTZEN
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

	//BENUTZEN
	public static int[] getPunktespieler() {
		return punktespieler;
	}

	//BENUTZEN
	public static void setPunktespieler(int[] punktespieler) {
		CafeMain.punktespieler = punktespieler;
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

	public static List<Gastkarte> getKartenspieler1() {
		return kartenspieler1;
	}

	public static List<Gastkarte> getKartenspieler2() {
		return kartenspieler2;
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