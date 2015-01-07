package spiel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CafeMain {
	
	// System Variablen
	protected static String OS = System.getProperty("os.name").toLowerCase();
	protected static String dateipfad = new File("").getAbsolutePath();
	protected static String programmname = "Café International";
	protected static JFrame spielframe = new JFrame(programmname);
	
	// Spieler Variablen
	protected static int spieler = 1;
	protected static String[] spielername = new String[2];
	protected static int[] punktespieler = new int[2];
	protected static List<Gastkarte> kartenspieler1 = new ArrayList<Gastkarte>();
	protected static List<Gastkarte> kartenspieler2 = new ArrayList<Gastkarte>();
	
	// Spielkarten
	protected static List<Gastkarte> gastkarten = new ArrayList<Gastkarte>();
	protected static List<Laenderkarte> laenderkarten = new ArrayList<Laenderkarte>();
	
	// Spielfeld
	protected static List<Tisch> tische = new ArrayList<Tisch>(12);
	protected static List<Stuhl> stuehle = new ArrayList<Stuhl>(24);
	protected static int[] tischex = new int[12];
	protected static int[] tischey = new int[12];
	protected static int anzahlbarplaetze = 21;
	
	// Sonstiges
	protected static boolean spielernamenkorrekt = false;
	
	
	public CafeMain() throws IOException {
        spielframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spielframe.setLocationRelativeTo(null);
        Spielfeld spielfeld = new Spielfeld();
        spielframe.add(spielfeld);
        spielframe.setSize(600,600);
        spielframe.setResizable(false);
        spielframe.setVisible(false);
        ablauf();
	}
	
	
	
	public static void ablauf() {
		if(SysWin()) {
			JOptionPane.showMessageDialog(null, "Dein System ist hoffnungslos veraltet!\nWindoof ist nicht kompatibel mit diesem Spiel.\nSollte es zu Problemen bei der Ausführung kommen,\ndann öffne das Spiel bitte auf einem PC\nmit Mac OS oder Linux!", "System veraltet", JOptionPane.WARNING_MESSAGE);
		}
		do{
		Spielstart.namensfrage();
		} while(spielernamenkorrekt == false);
		spielframe.setVisible(true);
		Spielfeld.zeichnen();
		Spielstart.gastkartenmischen();
        Spielstart.laenderkartenmischen();
        Spielstart.spielfeldgenerieren();
	}

	public static void main(String[] args) throws IOException {
		new CafeMain();
	}
	
	public static boolean SysWin() {
		return (OS.indexOf("win") >= 0);
	}

}
