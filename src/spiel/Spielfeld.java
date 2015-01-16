package spiel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

class Spielfeld extends JPanel {
    public Spielfeld(int rows, int columns) {
        setLayout(new GridLayout(rows, columns));
 
        for (int i=0; i<rows*columns; i++) {
            add(AufbauHilfe.createRandomBackgroundLabel(String.valueOf(i)));
        }
    }
}
 
class AufbauHilfe {
    public static GridBagConstraints createGridBagConstraints(int x, int y, int width, int height, int weightX, int weightY) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = width;
        constraints.gridheight = height;
        constraints.weightx = weightX;
        constraints.weighty = weightY;
 
        return constraints;
    }
 
    public static JLabel createRandomBackgroundLabel(String text) {
        Random rand = new Random();
        JLabel label = new JLabel(text);
        label.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        label.setOpaque(true);
 
        return label;
    }
}