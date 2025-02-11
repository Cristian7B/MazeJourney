package co.edu.udistrital.View.PanelsTutorial;

import java.awt.*;
import javax.swing.*;

/**
 * Clase encargada de gestionar los textos que aparecen en el tutorial.
 */

public class PanelTutorialTexto extends JPanel {
    /**
     * Atributo que contiene el subtitulo en el tutorial.
     */
    private JLabel subtitulo;
    /**
     * Atributo que contiene ??? 
     */
    private JLabel bulleted;
    public PanelTutorialTexto() {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(new Color(0x202020));
    }
}
