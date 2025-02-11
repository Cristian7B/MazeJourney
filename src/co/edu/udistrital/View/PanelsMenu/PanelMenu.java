package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;
import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;

import java.awt.*;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase encargada de administrar el panel principal de la ventana de inicio.
 */

public class PanelMenu extends JPanel {
	/**
	 * Atributo que almacena el boton encargado de iniciar el juego.
	 */
	private JButton jugar; 
	/*
	 * Atributo que almacena el boton encargado de iniciar el tutorial.
	 */
	private JButton tutorial; 
	/**
	 * Atributo que almacena el boto encargado de salir del programa.
	 */
	private JButton salir;
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
	private JButton atras;
	public PanelMenu() throws IOException, FontFormatException {
		setLayout(new GridLayout(3,1, 5, 5));

		inicializarComponentes();
	}

 /**
     * Metodo encargado de inicializar los componentes de la clase
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
     * @throws IOException
     * @throws FontFormatException
     */
	public void inicializarComponentes() throws IOException, FontFormatException {
		jugar = quitarEstilos("Jugar", "JUGAR");
		jugar.setBackground(new Color(84, 72, 200));

		tutorial = quitarEstilos("Tutorial", "TUTORIAL1");
		tutorial.setBackground(new Color(254, 168, 47));

		salir = quitarEstilos("Salir", "SALIR");
		salir.setBackground(new Color(255, 46, 0));


		add(jugar);
		add(tutorial);
		add(salir);
	}
	/**
	 * Metodo que agrega el estilo deseado a los botones
	 * este metodo regresa un boton con el estilo deseado.
	 * @param labelText Nombre del boton.
	 * @param comandText Comando del boton.
	 * @return 
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
	 * Metodo encargado acceder a un atributo.
	 * regresa el boton de jugar.
	 * @return
	 */

	public JButton getJugar() {
		return jugar;
	}
	/**
	 * Metodo que cambia el valor del atributo jugar
	 * @param jugar	El valor deseado del atributo jugar
	 */
	public void setJugar(JButton jugar) {
		this.jugar = jugar;
	}

	/**
	 * Metodo encargado acceder a un atributo.
	 * regresa el boton de tutorial.
	 * @return
	 */
	public JButton getTutorial() {
		return tutorial;
	}
	/**
	 * Metodo que cambia el valor del atributo tutorial
	 * @param tutorial	El valor deseado del atributo tutorial
	 */
	public void setTutorial(JButton tutorial) {
		this.tutorial = tutorial;
	}

	/**
	 * Metodo encargado acceder a un atributo.
	 * regresa el boton de salir.
	 * @return
	 */
	public JButton getSalir() {
		return salir;
	}
	/**
	 * Metodo que cambia el valor del atributo salir
	 * @param salir	El valor deseado del atributo salir
	 */
	public void setSalir(JButton salir) {
		this.salir = salir;
	}

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton atras) {
		this.atras = atras;
	}
}
