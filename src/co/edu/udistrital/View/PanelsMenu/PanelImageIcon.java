package co.edu.udistrital.View.PanelsMenu;

import javax.swing.*;
import java.awt.*;

public class PanelImageIcon extends JPanel {
    private ImageIcon im;
    public PanelImageIcon() {
        setPreferredSize(new Dimension(62, 70));
    }

    public void paint(Graphics g) {
        im = new ImageIcon(getClass().getResource("../../Imagenes/favicon.png"));
        g.drawImage(im.getImage(), 0 , 0, 50, 62, null);
        setOpaque(false);
        super.paint(g);
    }
}
