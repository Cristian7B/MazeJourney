package co.edu.udistrital.View;


import java.awt.*;
import javax.swing.JFrame;

import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;
import co.edu.udistrital.View.Maze.MazeMatriz;
import co.edu.udistrital.View.Maze.PanelInformacion;
import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

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
	 * Metodo constructor de la clase.
	 */
	private JLayeredPane layeredPane;
	private MazeMatriz laberinto;
	private PanelInformacion panelInformacion;
	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenuItem reiniciar;
	private JMenuItem salir;

	private int numMovimientosMax;
	private static int numMovimientos;
	private PanelTutorialTitulo panelTutorialTitulo2;
	public VentanaPrincipal() throws IOException, FontFormatException {
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
	public void inicializarComponentes() throws IOException, FontFormatException {
		panelDificultad = new PanelDificultad();
		add(panelDificultad, BorderLayout.CENTER);

		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0x202020));
		menuBar.setForeground(new Color(0x202020));

		menuOpciones = new JMenu("Opciones");
		menuOpciones.setForeground(new Color(0xFFFECB));
		menuOpciones.setFont(SatoshiFontBold.getSatoshiFontBold(15f));

		salir = new JMenuItem("Salir");
		salir.setForeground(new Color(0x202020));
		salir.setFont(SatoshiFontBold.getSatoshiFontBold(15f));
		salir.setBorderPainted(false);
		salir.setOpaque(false);
		salir.setActionCommand("SALIR");
		salir.setBackground(Color.red);
		menuOpciones.add(salir);

		menuBar.add(menuOpciones);
		setJMenuBar(menuBar);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, getWidth(), getHeight());

	}


	public void agregarPanelImagenMatriz(int filas, int columnas) throws IOException, FontFormatException {
		this.laberinto = new MazeMatriz(filas,columnas);
		add(laberinto, BorderLayout.CENTER);
		numMovimientosMax = filas*columnas;
		numMovimientos = numMovimientosMax;
		panelInformacion = new PanelInformacion(numMovimientosMax);
		add(panelInformacion, BorderLayout.NORTH);
	}
	/**
	 * Metodo encargado acceder a un atributo.
	 * regresa el PanelDifucultad panelDificultad.
	 * @return
	 */

	public void mostrarTutorial() throws IOException, FontFormatException {
		panelTutorialTitulo2 = new PanelTutorialTitulo();
		laberinto.setVisible(false);
		add(panelTutorialTitulo2, BorderLayout.CENTER);
		panelTutorialTitulo2.setVisible(true);
		numMovimientos = panelInformacion.getBarraVida().getValue();
		numMovimientos -= 5;

		panelInformacion.getBarraVida().setValue(numMovimientos);
		panelInformacion.getBarraVida().setString("Movimientos restantes: " + numMovimientos);

		panelTutorialTitulo2.getAtras().setActionCommand("ATRASTUTORIAL2");
	}

	public void cerrarTutorial() throws IOException, FontFormatException {
		panelTutorialTitulo2.setVisible(false);
		laberinto.setVisible(true);
		getContentPane().remove(panelInformacion);
		panelInformacion = new PanelInformacion(numMovimientosMax);
		panelInformacion.getBarraVida().setValue(numMovimientos);
		panelInformacion.getBarraVida().setString("Movimientos restantes: "+numMovimientos);
		add(panelInformacion, BorderLayout.NORTH);
	}
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

	public MazeMatriz getLaberinto() {
		return laberinto;
	}

	public void setLaberinto(MazeMatriz laberinto) {
		this.laberinto = laberinto;
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

	public static int getNumMovimientos() {
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
