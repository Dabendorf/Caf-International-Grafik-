package spiel;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Feldbegrenzung extends PlainDocument {
	private int maxlaenge;
	
	public Feldbegrenzung(int maxlaenge) {
		this.maxlaenge = maxlaenge;
	}
	
	@Override
	public void insertString (final int offset, final String text, final AttributeSet attributeSet) throws BadLocationException {
		if(laengeokay(text)) {
			super.insertString(offset, text, attributeSet);
		} else {
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	private boolean laengeokay(final String text) {
		if((getLength() + text.length() <= maxlaenge) && text.matches("[a-zA-Z0-9ÄÖÜäöüß]*")) {
			return true;
		} else { 
			return false;
		}
	}
	
	public static void main(final String [] ignored) {
		//Quelle: http://javawiki.sowas.com/doku.php?id=swing:jtextfield-size
		//Funktion abgewandelt
	}
}