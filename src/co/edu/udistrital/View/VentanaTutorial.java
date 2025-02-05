package co.edu.udistrital.View;

import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class VentanaTutorial extends JFrame {
	private PanelTutorialTitulo panelTutorialTitulo;
	public VentanaTutorial() throws IOException, FontFormatException {
		setTitle("MazeJourney");
		setSize(new Dimension(800, 600));
		getContentPane().setBackground(new Color(0x202020));
		setLayout(new BorderLayout(20, 20));

		inicializarComponentes();
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(false);
	}

	public void inicializarComponentes() throws IOException, FontFormatException {
		panelTutorialTitulo = new PanelTutorialTitulo();
		add(panelTutorialTitulo, BorderLayout.NORTH);
	}
}
