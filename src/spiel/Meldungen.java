package spiel;

import javax.swing.JOptionPane;

public class Meldungen {
	
	public String programmname = "Café International";
	public String nameerlaubtezeichen = "[a-zA-Z0-9ÄÖÜäöüß]*";
	public String fragespielername = "Wie heißen die Spieler?";
	public String spielernamevergessen = "Bitte gib beide Spielernamen ein!";
	public String titelunvollstaendig = "Unvollständige Eingabe";
	public String spielernamengleich = "Bitte benenne die Spieler unterschiedlich!";
	public String titelnamensgleichheit = "Namensgleichheit";
	public String endegastkarten = "Der letzte Gast hat das Café betreten.\n";
	public String endelaenderkarten = "Alle Nationenkarten sind aufgebraucht.\n";
	public String endebar = "Alle Barplätze sind besetzt.\n";
	public String spielende = "Das Spiel ist vorbei";
	public Object[] endoptionen = {"Neues Spiel", "Beenden"};
	public String endetitel = "Möchtest Du eine neue Partie starten?";
	public String endefrage = "Spielende";
	
	public void windows() {
		JOptionPane.showMessageDialog(null, "Dein System ist hoffnungslos veraltet!\nWindoof ist nicht kompatibel mit diesem Spiel.\nSollte es zu Problemen bei der Ausführung kommen,\ndann öffne das Spiel bitte auf einem PC\nmit Mac OS oder Linux!", "System veraltet", JOptionPane.WARNING_MESSAGE);
	}
	
	public String spielernameint(int n) {
		return "Name von Spieler "+n;
	}
	
	public String siegermeldung(int ergebnis) {
		if(ergebnis == 0) {
			return CafeMain.getSpielername(0)+" gewinnt die Partie hochverdient!\nEr gewinnt mit "+CafeMain.getPunktespieler(0)+" zu "+CafeMain.getPunktespieler(1)+" Punkten.\nHerzlichen Glückwunsch.";
		} else if(ergebnis == 1) {
			return CafeMain.getSpielername(0)+" gewinnt die Partie mit knappem Vorsprung!\nEr gewinnt mit "+CafeMain.getPunktespieler(0)+" zu "+CafeMain.getPunktespieler(1)+" Punkten.\nHerzlichen Glückwunsch.";
		} else if(ergebnis == 2) {
			return "Diese Partie endet Unentschieden.\nBeide Spieler erreichten eine Punktzahl von "+CafeMain.getPunktespieler(0)+" Punkten.";
		} else if(ergebnis == 3) {
			return CafeMain.getSpielername(1)+" gewinnt die Partie mit knappem Vorsprung!\nEr gewinnt mit "+CafeMain.getPunktespieler(1)+" zu "+CafeMain.getPunktespieler(0)+" Punkten.\nHerzlichen Glückwunsch.";
		} else {
			return CafeMain.getSpielername(1)+" gewinnt die Partie hochverdient!\nEr gewinnt mit "+CafeMain.getPunktespieler(1)+" zu "+CafeMain.getPunktespieler(0)+" Punkten.\nHerzlichen Glückwunsch.";
		}
	}

}