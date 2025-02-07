package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Fonts.SatoshiFontBold;
import java.awt.*;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase encargada de administrar el panel principal de la ventana de inicio
 */

public class PanelMenu extends JPanel {
	/**
	 * Variable que almacena el boton encargado de iniciar el juego
	 */
	private JButton jugar; 
	/*
	 * Variable que almacena el boton encargado de iniciar el tutorial
	 */
	private JButton tutorial; 
	/**
	 * Variable que almacena el boto encargado de salir del programa
	 */
	private JButton salir;
	/**
	 * Metodo constructor de la clase
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public PanelMenu() throws IOException, FontFormatException {
		setLayout(new GridLayout(3,1, 5, 5));

		inicializarComponentes();
	}

	/**
	 * Metodo que inicializa los componentes del panel 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	
	public void inicializarComponentes() throws IOException, FontFormatException {
		jugar = quitarEstilos("Jugar", "JUGAR");
		jugar.setBackground(new Color(84, 72, 200));

		tutorial = quitarEstilos("Tutorial", "TUTORIAL");
		tutorial.setBackground(new Color(254, 168, 47));

		salir = quitarEstilos("Salir", "SALIR");
		salir.setActionCommand("SALIR");
		salir.setBackground(new Color(255, 46, 0));


		add(jugar);
		add(tutorial);
		add(salir);
	}
	/**
	 * Metodo que agrega el estilo deseado a los botones 
	 * @param labelText Nombre del boton 
	 * @param comandText Comando del boton 
	 * @return Regresa el boton deseado 
	 * @throws IOException
	 * @throws FontFormatException
	 */
	public JButton quitarEstilos(String labelText, String comandText) throws IOException, FontFormatException {
		JButton button = new JButton(labelText);
		button.setActionCommand(comandText);

		button.setBorderPainted(false);
		button.setFocusPainted(false);

		button.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
		button.setForeground(new Color(0xFFFECB));


		return button;
	}

	/**
	 * Metodo encargado de regresar la variable jugar
	 * @return La variable de tipo JButton jugar
	 */

	public JButton getJugar() {
		return jugar;
	}
	/**
	 * Metodo que cambia el valor de la variable jugar
	 * @param jugar	El valor deseado de la variable
	 */
	public void setJugar(JButton jugar) {
		this.jugar = jugar;
	}

	/**
	 * Metodo encargado de regresar la variable tutorial
	 * @return La variable de tipo JButton tutorial
	 */
	
	public JButton getTutorial() {
		return tutorial;
	}
	/**
	 * Metodo que cambia el valor de la variable tutorial
	 * @param tutorial El valor deseado de la variable
	 */
	public void setTutorial(JButton tutorial) {
		this.tutorial = tutorial;
	}

	/**
	 * Metodo encargado de regresar la variable salir
	 * @return La variable de tipo JButton salir
	 */

	public JButton getSalir() {
		return salir;
	}
	/**
	 * Metodo que cambia el valor de la variable salir
	 * @param salir	El valor deseado de la variable
	 */
	public void setSalir(JButton salir) {
		this.salir = salir;
	}
	
	
	
}
