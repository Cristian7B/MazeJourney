package co.edu.udistrital.View.PanelsTutorial;

import co.edu.udistrital.Resources.Fonts.CabinetFont;
import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelTutorialTitulo extends JPanel {
	private JLabel labelTutorial;
	private JLabel labelTutorialNombre;
	private JButton atras;
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

		atras = quitarEstilos("Atras", "ATRASTUTORIAL1");
		atras.setBackground(new Color(254, 168, 47));
		atras.setVisible(true);
		add(atras);

	}

	public JButton quitarEstilos(String labelText, String comandText) throws IOException, FontFormatException {
		JButton button = new JButton(labelText);
		button.setActionCommand(comandText);

		button.setBorderPainted(false);
		button.setFocusPainted(false);

		button.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
		button.setForeground(new Color(0xFFFECB));


		return button;
	}

	public JLabel getLabelTutorial() {
		return labelTutorial;
	}

	public void setLabelTutorial(JLabel labelTutorial) {
		this.labelTutorial = labelTutorial;
	}

	public JLabel getLabelTutorialNombre() {
		return labelTutorialNombre;
	}

	public void setLabelTutorialNombre(JLabel labelTutorialNombre) {
		this.labelTutorialNombre = labelTutorialNombre;
	}

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton buttonTutorial) {
		this.atras = buttonTutorial;
	}
}