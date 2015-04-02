package spiel;

import javax.swing.JOptionPane;

public class Spielende {
	
	protected void barvoll() {
		if(CafeMain.getBarkarten().size() == 21) {
			siegmeldung(2);//Wenn Bar voll ist. Und achte darauf, dass man die Bar nicht grundlos anklicken darf
		}
	}
	
	private void siegmeldung(int art) {
		Meldungen msgbox = new Meldungen();
		String grund;
		switch(art) {
		case 0:
			grund=msgbox.endegastkarten;
			break;
		case 1:
			grund=msgbox.endelaenderkarten;
			break;
		case 2:
			grund=msgbox.endebar;
			break;
		default:
			grund="";
			break;
		}
		
		int pkt0 = CafeMain.getSpieler(0).getPunkte();
		int pkt1 = CafeMain.getSpieler(1).getPunkte();
		
		if(pkt0 > pkt1+20) {
			JOptionPane.showMessageDialog(null, grund+msgbox.siegermeldung(0), msgbox.spielende, JOptionPane.INFORMATION_MESSAGE);
		} else if(pkt0 > pkt1) {
			JOptionPane.showMessageDialog(null, grund+msgbox.siegermeldung(1), msgbox.spielende, JOptionPane.INFORMATION_MESSAGE);
		} else if(pkt0 == pkt1) {
			JOptionPane.showMessageDialog(null, grund+msgbox.siegermeldung(2), msgbox.spielende, JOptionPane.INFORMATION_MESSAGE);
		} else if(pkt0 < pkt1) {
			JOptionPane.showMessageDialog(null, grund+msgbox.siegermeldung(3), msgbox.spielende, JOptionPane.INFORMATION_MESSAGE);
		} else if(pkt0+20 < pkt1) {
			JOptionPane.showMessageDialog(null, grund+msgbox.siegermeldung(4), msgbox.spielende, JOptionPane.INFORMATION_MESSAGE);
		}
		
        int menue = JOptionPane.showOptionDialog(null,msgbox.endetitel,msgbox.endefrage, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, msgbox.endoptionen, msgbox.endoptionen[0]);
        if(menue == 0) {
        	Spielstart spst = new Spielstart();
        	spst.neuesspiel();
        } else {
        	System.exit(0);
        }
	}

}