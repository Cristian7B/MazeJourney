package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Fonts.CabinetFontExtraBold;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase encargada de agregar el titulo e icono del programa en la ventana principal
 */

public class PanelIconNameMenu extends JPanel {
    /**
     * Variable que contiene el nombre del programa
     */
    private JLabel labelIcon;
    /**
     * Variable que contiene el icono del programa
     */
    private PanelImageIcon panelImageIcon;

    /**
     * Funcion constructora de la clase 
     * @throws IOException 
     * @throws FontFormatException
     */

    public PanelIconNameMenu() throws IOException, FontFormatException {
        setLayout(new FlowLayout());
        setOpaque(false);
        inicializarComponentes();
    }

    /**
     * Funcion encargada de inicializar los componentes que estaran dentro del panel
     * @throws IOException
     * @throws FontFormatException
     */

    public void inicializarComponentes() throws IOException, FontFormatException {
        labelIcon = new JLabel("MazeJourney");
        labelIcon.setFont(CabinetFontExtraBold.getCabinetFontExtraBold(35f));
        labelIcon.setForeground(new Color(0xFFFECB));

        panelImageIcon = new PanelImageIcon();
        panelImageIcon.setBounds(0, 0, 62, 70);
        panelImageIcon.setOpaque(false);

        add(panelImageIcon);
        add(labelIcon);
    }
}
