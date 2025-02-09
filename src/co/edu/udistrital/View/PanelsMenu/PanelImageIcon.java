package co.edu.udistrital.View.PanelsMenu;

import java.awt.*;
import javax.swing.*;

/**
 * Clase encargada de gestionar el icono del programa.
 */

public class PanelImageIcon extends JPanel {
    /**
     * Atributo que contiene el icono del programa.
     */
    private ImageIcon im;

    /**
     * Metodo constructor de la clase.
     * 
     * Determina un tamaño preferido para el icono.
     */
    public PanelImageIcon() {
        setPreferredSize(new Dimension(62, 70));
    }


    @Override
        public void paint(Graphics g) {
            im = new ImageIcon(getClass().getResource("../../Imagenes/favicon.png"));
            g.drawImage(im.getImage(), 0 , 0, 50, 62, null);
            setOpaque(false);
            super.paint(g);
        }
}
