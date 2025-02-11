package co.edu.udistrital.View.PanelsMenu;

<<<<<<< HEAD
import co.edu.udistrital.Fonts.CabinetFont;
=======
import co.edu.udistrital.Resources.Fonts.CabinetFont;

import javax.swing.*;
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
import java.awt.*;
import java.io.IOException;
import javax.swing.*;
/**
 * Clase encargada de mostrar el titulo del programa.
 */

public class PanelTitleMenu extends JPanel {
    /**
     * Atributo que almacena la primera linea del titulo del programa.
     */
    private JLabel titleGeneral;
    /**
     * Atributo que almacena la segunda linea del titulo del programa.
     */
    private JLabel labelTutorialNombre;
    /**
     * Atributo que almacena el nombre del programa.
     */
    private JLabel mazeJourney;
    /** 
     * Atributo que almacena un signo de exclamacion.
     */
    private JLabel exclamation;
    /**
     * Atributo que distribuye de manera apropiada el titulo del panel principal. 
     */
    private JPanel upperPanel;
    /**
     * Atributo que distribuye de manera apropiada el titulo del panel principal.
     */
    private JPanel lowerPanel;

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
    public PanelTitleMenu() throws IOException, FontFormatException {
        setLayout(new BorderLayout(0, 0));
        setOpaque(false);
        inicializarComponentes();
    }
     /**
     * Metodo que inicializa los componentes de la clase.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
     * @throws IOException
     * @throws FontFormatException
     */
    public void inicializarComponentes() throws IOException, FontFormatException {
        upperPanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout());
        lowerPanel.setLayout(new FlowLayout());

        upperPanel.setOpaque(false);
        lowerPanel.setOpaque(false);

        upperPanel.setBorder(BorderFactory.createEmptyBorder(-10, -10, -10, -10));
        lowerPanel.setBorder(BorderFactory.createEmptyBorder(-10, -10, -10, -10));

        titleGeneral = new JLabel("¡Descubre el impresionante");
        titleGeneral.setFont(CabinetFont.getCabinetFont(60f));
        titleGeneral.setForeground(new Color(0xFFFECB));
        upperPanel.add(titleGeneral);

        labelTutorialNombre = new JLabel("mundo en");
        labelTutorialNombre.setFont(CabinetFont.getCabinetFont(60f));
        labelTutorialNombre.setForeground(new Color(0xFFFECB));
        lowerPanel.add(labelTutorialNombre);

        mazeJourney = new JLabel(" MazeJourney");
        mazeJourney.setFont(CabinetFont.getCabinetFont(60f));
        mazeJourney.setForeground(new Color(0x5448C8));
        lowerPanel.add(mazeJourney);

        exclamation = new JLabel("!");
        exclamation.setFont(CabinetFont.getCabinetFont(60f));
        exclamation.setForeground(new Color(0xFFFECB));
        lowerPanel.add(exclamation);

        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.CENTER);
    }
}