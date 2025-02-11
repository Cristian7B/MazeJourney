package co.edu.udistrital.View;

<<<<<<< HEAD
import java.awt.*;
import javax.swing.JFrame;
=======
import co.edu.udistrital.View.Maze.MazeMatriz;
import co.edu.udistrital.View.Maze.PanelInformacion;
import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a

/**
 * Clase encargada de gestionar tanto la eleccion de dificultad como la eleccion de dificultad e iniciar el juego
 */

public class VentanaPrincipal extends JFrame {
<<<<<<< HEAD
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
=======
	private JLayeredPane layeredPane;
	private PanelDificultad panelDificultad;
	private MazeMatriz laberinto;
	private PanelInformacion panelInformacion;
	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenuItem reiniciar;
	private JMenuItem salir;

	private int numMovimientosMax;
	private int numMovimientos;
	private PanelTutorialTitulo panelTutorialTitulo2;
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
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

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.CYAN);
		menuBar.setForeground(Color.WHITE);

		menuOpciones = new JMenu("Opciones");
		reiniciar = new JMenuItem("Reiniciar");
		reiniciar.setActionCommand("REINICIARJUEGO");
		reiniciar.setBackground(Color.green);

		salir = new JMenuItem("Salir");
		salir.setActionCommand("SALIR");
		salir.setBackground(Color.red);
		menuOpciones.add(reiniciar);
		menuOpciones.add(salir);

		menuBar.add(menuOpciones);
		setJMenuBar(menuBar);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, getWidth(), getHeight());

	}


	public void agregarPanelImagenMatriz(int filas, int columnas) {
		this.laberinto = new MazeMatriz(filas,columnas);
		add(laberinto, BorderLayout.CENTER);
		numMovimientosMax = Integer.parseInt(panelDificultad.getTxtdimensionMatrizColumnas().getText())*Integer.parseInt(panelDificultad.getTxtdimensionMatrizFilas().getText());
		numMovimientos = Integer.parseInt(panelDificultad.getTxtdimensionMatrizColumnas().getText())*Integer.parseInt(panelDificultad.getTxtdimensionMatrizFilas().getText());
		panelInformacion = new PanelInformacion(numMovimientosMax);
		add(panelInformacion, BorderLayout.NORTH);
	}
<<<<<<< HEAD
	/**
	 * Metodo encargado acceder a un atributo.
	 * regresa el PanelDifucultad panelDificultad.
	 * @return
	 */
=======

	public void mostrarTutorial() throws IOException, FontFormatException {
		panelTutorialTitulo2 = new PanelTutorialTitulo();
		laberinto.setVisible(false);
		add(panelTutorialTitulo2, BorderLayout.CENTER);
		panelTutorialTitulo2.setVisible(true);
		numMovimientos = (numMovimientos - 5);
		panelInformacion.getBarraVida().setValue(numMovimientos);
		panelInformacion.getBarraVida().setString("Movimientos restantes: "+numMovimientos);
		panelTutorialTitulo2.getAtras().setActionCommand("ATRASTUTORIAL2");

	}
	public void cerrarTutorial() {
		panelTutorialTitulo2.setVisible(false);
		laberinto.setVisible(true);
		getContentPane().remove(panelInformacion);
		panelInformacion = new PanelInformacion(numMovimientosMax);
		panelInformacion.getBarraVida().setValue(numMovimientos);
		panelInformacion.getBarraVida().setString("Movimientos restantes: "+numMovimientos);
		add(panelInformacion, BorderLayout.NORTH);
	}
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
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
<<<<<<< HEAD
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
=======

	public MazeMatriz getLaberinto() {
		return laberinto;
	}

	public void setLaberinto(MazeMatriz laberinto) {
		this.laberinto = laberinto;
>>>>>>> 85107bdceed95ee9da1e3c30c6be632f9032de7a
	}

	public PanelInformacion getPanelInformacion() {
		return panelInformacion;
	}

	public void setPanelInformacion(PanelInformacion panelInformacion) {
		this.panelInformacion = panelInformacion;
	}

	@Override
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	@Override
	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public int getNumMovimientos() {
		return numMovimientos;
	}

	public void setNumMovimientos(int numMovimientos) {
		this.numMovimientos = numMovimientos;
	}

	public PanelTutorialTitulo getPanelTutorialTitulo2() {
		return panelTutorialTitulo2;
	}

	public void setPanelTutorialTitulo2(PanelTutorialTitulo panelTutorialTitulo2) {
		this.panelTutorialTitulo2 = panelTutorialTitulo2;
	}


	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMenuOpciones() {
		return menuOpciones;
	}

	public void setMenuOpciones(JMenu menuOpciones) {
		this.menuOpciones = menuOpciones;
	}

	public JMenuItem getReiniciar() {
		return reiniciar;
	}

	public void setReiniciar(JMenuItem reiniciar) {
		this.reiniciar = reiniciar;
	}

	public JMenuItem getSalir() {
		return salir;
	}

	public void setSalir(JMenuItem salir) {
		this.salir = salir;
	}

	public int getNumMovimientosMax() {
		return numMovimientosMax;
	}

	public void setNumMovimientosMax(int numMovimientosMax) {
		this.numMovimientosMax = numMovimientosMax;
	}
}
