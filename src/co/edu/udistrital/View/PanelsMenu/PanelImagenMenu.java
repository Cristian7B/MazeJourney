package co.edu.udistrital.View.PanelsMenu;

import java.awt.*;
import javax.swing.*;

/**
 * Clase encargada de colocar un fondo de pantalla para la ventana principal
 */

public class PanelImagenMenu extends JPanel{
    /**
     * atributo encargada de almacenar el fondo de pantalla de la ventana principal
     */
    private ImageIcon im;

    /**
     * Metodo constructor de la clase
     */
    public PanelImagenMenu() {

    }
<<<<<<< HEAD


    @Override
        public void paint(Graphics g) {
            Dimension tam = getSize();
            im = new ImageIcon(getClass().getResource("../../Imagenes/Wallpaper.png"));
            g.drawImage(im.getImage(), 0 , 0, tam.width, tam.height, null);
            setOpaque(false);
            super.paint(g);
        }
    
=======
    public void paint(Graphics g) {
        Dimension tam = getSize();
        im = new ImageIcon(getClass().getResource("../../Resources/Imagenes/Wallpaper.png"));
        g.drawImage(im.getImage(), 0 , 0, tam.width, tam.height, null);
        setOpaque(false);
        super.paint(g);
    }
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
}
