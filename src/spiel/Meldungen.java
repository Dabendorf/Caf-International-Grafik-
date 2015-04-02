package spiel;

import javax.swing.JOptionPane;

public class Meldungen {
	
	protected String programmname = "Café International";
	protected String nameerlaubtezeichen = "[a-zA-Z0-9ÄÖÜäöüß]*";
	protected String fragespielername = "Wie heißen die Spieler?";
	protected String spielernamevergessen = "Bitte gib beide Spielernamen ein!";
	protected String titelunvollstaendig = "Unvollständige Eingabe";
	protected String spielernamengleich = "Bitte benenne die Spieler unterschiedlich!";
	protected String titelnamensgleichheit = "Namensgleichheit";
	protected String endegastkarten = "Der letzte Gast hat das Café betreten.\n";
	protected String endelaenderkarten = "Alle Nationenkarten sind aufgebraucht.\n";
	protected String endebar = "Alle Barplätze sind besetzt.\n";
	protected String spielende = "Das Spiel ist vorbei";
	protected Object[] endoptionen = {"Neues Spiel", "Beenden"};
	protected String endetitel = "Möchtest Du eine neue Partie starten?";
	protected String endefrage = "Spielende";
	protected String gastlandfalsch = "Die Nationalität dieses Gastes stimmt nicht mit der Tischnationalität überein.";
	protected String gastzuvielemaenner = "Es sitzen zu viele Männer an diesem Tisch!";
	protected String gastzuvielefrauen = "Es sitzen zu viele Frauen an diesem Tisch!";
	protected String gastpartnerfalsch = "Dieser Gast würde allein sitzen. Du hast keine passenden Karten auf der Hand!";
	
	protected void windows() {
		JOptionPane.showMessageDialog(null, "Dein System ist hoffnungslos veraltet!\nWindoof ist nicht kompatibel mit diesem Spiel.\nSollte es zu Problemen bei der Ausführung kommen,\ndann öffne das Spiel bitte auf einem PC\nmit Mac OS oder Linux!", "System veraltet", JOptionPane.WARNING_MESSAGE);
	}
	
	protected String spielernameint(int n) {
		return "Name von Spieler "+n;
	}
	
	protected String siegermeldung(int ergebnis) {
		if(ergebnis == 0) {
			return CafeMain.getSpieler(0).getName()+" gewinnt die Partie hochverdient!\nEr gewinnt mit "+CafeMain.getSpieler(0).getPunkte()+" zu "+CafeMain.getSpieler(1).getPunkte()+" Punkten.\nHerzlichen Glückwunsch.";
		} else if(ergebnis == 1) {
			return CafeMain.getSpieler(0).getName()+" gewinnt die Partie mit knappem Vorsprung!\nEr gewinnt mit "+CafeMain.getSpieler(0).getPunkte()+" zu "+CafeMain.getSpieler(1).getPunkte()+" Punkten.\nHerzlichen Glückwunsch.";
		} else if(ergebnis == 2) {
			return "Diese Partie endet Unentschieden.\nBeide Spieler erreichten eine Punktzahl von "+CafeMain.getSpieler(0).getPunkte()+" Punkten.";
		} else if(ergebnis == 3) {
			return CafeMain.getSpieler(1).getName()+" gewinnt die Partie mit knappem Vorsprung!\nEr gewinnt mit "+CafeMain.getSpieler(1).getPunkte()+" zu "+CafeMain.getSpieler(0).getPunkte()+" Punkten.\nHerzlichen Glückwunsch.";
		} else {
			return CafeMain.getSpieler(1).getName()+" gewinnt die Partie hochverdient!\nEr gewinnt mit "+CafeMain.getSpieler(1).getPunkte()+" zu "+CafeMain.getSpieler(0).getPunkte()+" Punkten.\nHerzlichen Glückwunsch.";
		}
	}

}