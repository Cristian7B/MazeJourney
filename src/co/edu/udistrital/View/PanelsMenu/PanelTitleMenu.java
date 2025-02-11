package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Resources.Fonts.CabinetFont;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelTitleMenu extends JPanel {
    private JLabel titleGeneral;
    private JLabel labelTutorialNombre;
    private JLabel mazeJourney;
    private JLabel exclamation;
    private JPanel upperPanel;
    private JPanel lowerPanel;

    public PanelTitleMenu() throws IOException, FontFormatException {
        setLayout(new BorderLayout(0, 0));
        setOpaque(false);
        inicializarComponentes();
    }

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