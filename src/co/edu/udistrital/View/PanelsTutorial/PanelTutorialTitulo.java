package co.edu.udistrital.View.PanelsTutorial;

import co.edu.udistrital.Fonts.CabinetFont;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelTutorialTitulo extends JPanel {
	private JLabel labelTutorial;
	private JLabel labelTutorialNombre;
	public PanelTutorialTitulo() throws IOException, FontFormatException {
		setLayout(new FlowLayout());
		setVisible(true);
		inicializarComponentes();
		setBackground(new Color(0x202020));
	}

	public void inicializarComponentes() throws IOException, FontFormatException {
		labelTutorial = new JLabel("Tutorial de juego | ");
		labelTutorial.setFont(CabinetFont.getCabinetFont(50f));
		labelTutorial.setForeground(new Color(0xFFFECB));
		add(labelTutorial);

		labelTutorialNombre = new JLabel("MazeJourney");
		labelTutorialNombre.setFont(CabinetFont.getCabinetFont(50f));
		labelTutorialNombre.setForeground(new Color(0x5448C8));
		add(labelTutorialNombre);

	}
}
