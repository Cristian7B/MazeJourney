package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Resources.Fonts.CabinetFontExtraBold;
import co.edu.udistrital.Resources.Fonts.CabinetFontExtraBold;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase encargada de agregar el titulo e icono del programa en la ventana principal.
 */

public class PanelIconNameMenu extends JPanel {
    /**
     * Atributo que contiene el nombre del programa.
     */
    private JLabel labelIcon;
    /**
     * Atributo que contiene el icono del programa.
     */
    private PanelImageIcon panelImageIcon;

    /**
     * Metodo constructor de la clase.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
     * @throws IOException
     * @throws FontFormatException
     */
    public PanelIconNameMenu() throws IOException, FontFormatException {
        setLayout(new FlowLayout());
        setOpaque(false);
        inicializarComponentes();
    }

   /**
     * Metodo encargado de inicializar los compenentes de la clase.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
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
