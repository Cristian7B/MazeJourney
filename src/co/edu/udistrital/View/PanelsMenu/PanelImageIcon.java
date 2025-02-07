package co.edu.udistrital.View.PanelsMenu;

import java.awt.*;
import javax.swing.*;

/**
 * Clase encargada de gestionar el icono del programa
 */

public class PanelImageIcon extends JPanel {
    /**
     * Variable que contiene el icono del programa
     */
    private ImageIcon im;

    /**
     * Funcion constructora de la clase
     */
    public PanelImageIcon() {
        setPreferredSize(new Dimension(62, 70));
    }


    @Override
        /**
         * Funcion que imprime la imagen
         */
        public void paint(Graphics g) {
            im = new ImageIcon(getClass().getResource("../../Imagenes/favicon.png"));
            g.drawImage(im.getImage(), 0 , 0, 50, 62, null);
            setOpaque(false);
            super.paint(g);
        }
}
