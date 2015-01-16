package spiel;
 
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
 
public class CafeMain {
   
    // System
    protected static String OS = System.getProperty("os.name").toLowerCase();
    protected static String dateipfad = new File("").getAbsolutePath();
    protected static String programmname = "Café International";
    protected static JFrame spielframe = new JFrame(programmname);
   
    // Spieler
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
    protected static GridBagLayout gridlayout = new GridBagLayout();
   
    public CafeMain() throws IOException {
        spielframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        spielframe.setLocationRelativeTo(null);
        //Spielfeld spielfeld = new Spielfeld();
        //spielframe.add(spielfeld);
        spielframe.setPreferredSize(new Dimension(600, 600));
        //spielframe.setSize(600,600);
        spielframe.setResizable(false);
        spielframe.setIconImage(Toolkit.getDefaultToolkit().getImage("./resources/demo_DE.jpg"));
        spielframe.setVisible(false);
        
        //======
        Container contentPane = spielframe.getContentPane();
        contentPane.setLayout(gridlayout);
        //======
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("LINKSOBEN"), AufbauHilfe.createGridBagConstraints(0, 0, 1, 1, 1, 1));
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("LINKSUNTEN"), AufbauHilfe.createGridBagConstraints(0, 1, 1, 1, 1, 1));
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("RECHTSOBEN"), AufbauHilfe.createGridBagConstraints(2, 0, 1, 1, 1, 1));
        spielframe.add(AufbauHilfe.createRandomBackgroundLabel("RECHTSUNTEN"), AufbauHilfe.createGridBagConstraints(2, 1, 1, 1, 1, 1));
 
        Spielfeld spielpanel = new Spielfeld(4, 4);
        spielframe.add(spielpanel, AufbauHilfe.createGridBagConstraints(1, 0, 1, 2, 3, 3));
         
        spielframe.pack();
        
        ablauf();
    }
   
   
   
    public static void ablauf() {
        /*if(SysWin()) {
            JOptionPane.showMessageDialog(null, "Dein System ist hoffnungslos veraltet!\nWindoof ist nicht kompatibel mit diesem Spiel.\nSollte es zu Problemen bei der Ausführung kommen,\ndann öffne das Spiel bitte auf einem PC\nmit Mac OS oder Linux!", "System veraltet", JOptionPane.WARNING_MESSAGE);
        }
        do{
        Spielstart.namensfrage();
        } while(spielernamenkorrekt == false);*/
        Spielstart.gastkartenmischen();
        Spielstart.laenderkartenmischen();
        Spielstart.spielfeldgenerieren();
        spielframe.setVisible(true);
    }
 
    public static void main(String[] args) throws IOException {
        new CafeMain();
    }
   
    public static boolean SysWin() {
        return (OS.indexOf("win") >= 0);
    }
 
}