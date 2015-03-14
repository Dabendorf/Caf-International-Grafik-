package spiel;

import java.awt.GridBagConstraints;

public class GridBagFelder extends GridBagConstraints {
	
	public GridBagFelder(int x, int y, int width, int height, int weightX, int weightY) {
		this.fill = GridBagConstraints.BOTH;
	    this.gridx = x;
	    this.gridy = y;
	    this.gridwidth = width;
	    this.gridheight = height;
	    this.weightx = weightX;
	    this.weighty = weightY;
	}
}