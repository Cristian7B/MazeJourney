package co.edu.udistrital.View;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Clase encargada de gestionar tanto la eleccion de dificultad como la eleccion de dificultad e iniciar el juego
 */

public class VentanaPrincipal extends JFrame {
	/**
	 * Atributo instancia de PanelDificultad
	 * Encargado de la eleccion de dificultad.
	 */
	private PanelDificultad panelDificultad;
	/**
	 * Atributo instancia de PanelImagenMatriz.
	 * Muestra la matriz de juego.
	 */
	private PanelImagenMatriz panelImagenMatriz;
	/**
	 * Metodo constructor de la clase.
	 */
	public VentanaPrincipal() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(10, 10));
		
		inicializarComponentes();

		setVisible(false);
	}
	
	/**
	 * Metodo encargado de inicializar los componentes de la ventana principal.
	 */
	public void inicializarComponentes() {
		panelDificultad = new PanelDificultad();
		add(panelDificultad, BorderLayout.CENTER);
	}


	public void agregarPanelImagenMatriz(int filas, int columnas) {
		panelImagenMatriz = new PanelImagenMatriz(filas, columnas);
		add(panelImagenMatriz, BorderLayout.CENTER);
	}
	/**
	 * Metodo encargado acceder a un atributo.
	 * regresa el PanelDifucultad panelDificultad.
	 * @return
	 */
	public PanelDificultad getPanelDificultad() {
		return panelDificultad;
	}

	/**
	 * Metodo que cambia el valor del atributo panelDifitultad.
	 * @param panelDificultad	El valor deseado del atributo panelDifitultad.
	 */
	public void setPanelDificultad(PanelDificultad panelDificultad) {
		this.panelDificultad = panelDificultad;
	}
	/**
	 * Metodo encargado acceder a un atributo.
	 * regresa el PanelImagenMatriz panelImagenMatriz.
	 * @return
	 */
	public PanelImagenMatriz getPanelImagenMatriz() {
		return panelImagenMatriz;
	}
	/**
	 * Metodo que cambia el valor del atributo panelImagenMatriz.
	 * @param panelImagenMatriz	El valor deseado del atributo panelImagenMatriz.
	 */
	public void setPanelImagenMatriz(PanelImagenMatriz panelImagenMatriz) {
		this.panelImagenMatriz = panelImagenMatriz;
	}

}
