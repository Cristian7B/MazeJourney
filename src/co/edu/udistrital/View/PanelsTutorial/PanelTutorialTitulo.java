package co.edu.udistrital.View.PanelsTutorial;

import co.edu.udistrital.Fonts.CabinetFont;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase encargada de administrar los titulos que se pueden ver en el tutorial
 */

public class PanelTutorialTitulo extends JPanel {
	/**
	 * Atributo encargado de mostrar el titulo del tutorial
	 */
	private JLabel labelTutorial;
	/**
	 * Atributo encargado de mostrar el nombre del programa en el tutorial
	 */
	private JLabel labelTutorialNombre;

	/**
	 * Metodo construtor de la clase 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public PanelTutorialTitulo() throws IOException, FontFormatException {
		setLayout(new FlowLayout());
		setVisible(true);
		inicializarComponentes();
		setBackground(new Color(0x202020));
	}
	/**
	 * Metodo encargado de inicializar los componentes del panel 
	 * @throws IOException
	 * @throws FontFormatException
	 */
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
