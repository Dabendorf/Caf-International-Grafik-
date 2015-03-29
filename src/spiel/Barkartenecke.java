package spiel;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Barkartenecke extends JPanel {
	private static ArrayList<Barzelle> barzellen = new ArrayList<Barzelle>(21);
	private static int barpunkte[] = {1,2,3,4,5,-2,-4,-6,-8,-10,-4,-6,-8,-10,-12,-6,-8,-10,-12,-14,-16};
	
	public Barkartenecke() {
		setLayout(new GridLayout(7,3));
		for(int i=0;i<21;i++) {
			Barzelle bz = new Barzelle(barpunkte[i]);
			bz.setOpaque(true);
			bz.zelltext();
			bz.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            		Spielzuege.legebarkarte(Spielkartenecke.getAkthandkartnum());
            	}
            });
			barzellen.add(bz);
			add(bz);
		}
	}

	public static Barzelle getBarzellen(int num) {
		return barzellen.get(num);
	}
}