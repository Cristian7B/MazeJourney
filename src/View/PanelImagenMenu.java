package View;

import javax.swing.*;
import java.awt.*;

public class PanelImagenMenu extends JPanel{
    private ImageIcon im;
    public PanelImagenMenu() {

    }
    public void paint(Graphics g) {
        Dimension tam = getSize();
        im = new ImageIcon(getClass().getResource("/Imagenes/logoJuego.jpeg"));
        g.drawImage(im.getImage(), 0 , 0, tam.width, tam.height, null);
        setOpaque(false);
        super.paint(g);
    }
}
