package co.edu.udistrital.View.PanelsTutorial;

<<<<<<< HEAD
import co.edu.udistrital.Fonts.CabinetFont;
=======
import co.edu.udistrital.Resources.Fonts.CabinetFont;
import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;

import javax.swing.*;
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase encargada de administrar los titulos que se pueden ver en el tutorial.
 */
public class PanelTutorialTitulo extends JPanel {
	/**
	 * Atributo encargado de mostrar el titulo del tutorial.
	 */
	private JLabel labelTutorial;
	/**
	 * Atributo encargado de mostrar el nombre del programa en el tutorial.
	 */
	private JLabel labelTutorialNombre;
<<<<<<< HEAD

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
=======
	private JButton atras;
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
	public PanelTutorialTitulo() throws IOException, FontFormatException {
		setLayout(new FlowLayout());
		setVisible(true);
		inicializarComponentes();
		setBackground(new Color(0x202020));
	}
	/**
     * Metodo encargado de inicializar los componentes de la clase.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
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
