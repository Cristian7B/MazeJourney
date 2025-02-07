package co.edu.udistrital.View;

import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;
/**
 * Clase encargade el manejo del tutorial del programa
 */
public class VentanaTutorial extends JFrame {
	/** 
	 * Atributo que gestiona los titulos de VentanaTutorial
	 */
	private PanelTutorialTitulo panelTutorialTitulo;
	/**
	 * Metodo constructor de la clase
	 * @throws IOException
	 * @throws FontFormatException
	 */
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
	/**
	 * Metodo que inicializa los componentes dentro de la clase
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public void inicializarComponentes() throws IOException, FontFormatException {
		panelTutorialTitulo = new PanelTutorialTitulo();
		add(panelTutorialTitulo, BorderLayout.NORTH);
	}
}
