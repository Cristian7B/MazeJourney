package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Fonts.CabinetFont;
import co.edu.udistrital.Fonts.CabinetFontExtraBold;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelIconNameMenu extends JPanel {
    private JLabel labelIcon;
    private PanelImageIcon panelImageIcon;
    public PanelIconNameMenu() throws IOException, FontFormatException {
        setLayout(new FlowLayout());
        setOpaque(false);
        inicializarComponentes();
    }

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
