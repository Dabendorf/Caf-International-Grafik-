package spiel;

import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class CafeMain {
	
	protected static String OS = System.getProperty("os.name").toLowerCase();
	protected static String spielname = "Café International";
	protected static String[] spielername = new String[2];
	protected static List<Gastkarte> gastkarten = new ArrayList<Gastkarte>();
	protected static List<Laenderkarte> laenderkarten = new ArrayList<Laenderkarte>();
	protected static int anzahlbarplaetze = 21;
	protected static int[] punktespieler = new int[2];
	protected static int spieler = 1;
	protected static List<Gastkarte> kartenspieler1 = new ArrayList<Gastkarte>();
	protected static List<Gastkarte> kartenspieler2 = new ArrayList<Gastkarte>();
	protected static String filepath = new File("").getAbsolutePath();
	protected static Canvas spielfeld = new Canvas() {
	    public void paint(Graphics stift) {
	      Spielfeld.zeichne(stift);
	    }
	};
	protected static List<Tisch> tische = new ArrayList<Tisch>(12);
	protected static List<Stuhl> stuehle = new ArrayList<Stuhl>(24);
	protected static boolean spielernamenkorrekt = false;
	protected static JFrame spielframe = new JFrame(spielname);
	
	public CafeMain() throws IOException {
		int frameWidth = 600;
	    int frameHeight = 600;
	    spielframe.setSize(frameWidth, frameHeight);
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (d.width - spielframe.getSize().width) / 2;
	    int y = (d.height - spielframe.getSize().height) / 2;
	    spielframe.setLocation(x, y);
	    spielframe.setResizable(false);
	    spielframe.setLocationRelativeTo(null);
	    spielframe.setVisible(false);
	    spielframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    // === Komponenten ===
	    Container cp = spielframe.getContentPane();
	    cp.setLayout(null);
	    spielfeld.setBounds(1, 1, 599, 599);
	    cp.add(spielfeld);
	    // === Komponenten ===
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
