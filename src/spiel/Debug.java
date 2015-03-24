package spiel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 
 * @anmerkung: Diese Klasse ist zum Testen. Bei Fertigstellung löschen
 *
 */
public class Debug {
	
	public static long zeitnehmen() {
		long zeit = System.currentTimeMillis();
		return zeit;
	}
	
	public static void laufzeitschreiben(long zeit) throws IOException{
        try {
            FileReader fr = new FileReader("laufzeit.txt");
            Properties prop = new Properties();
   			prop.load(fr);

   			Date zeitstempel = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy-HH:mm:ss");
            
   			prop.setProperty("Laufzeit am:"+simpleDateFormat.format(zeitstempel), zeit+"");
   			prop.store(new FileWriter("laufzeit.txt"),"Gespeicherte Laufzeiten");
            fr.close();
        }
        catch (IOException e){}
	}
}