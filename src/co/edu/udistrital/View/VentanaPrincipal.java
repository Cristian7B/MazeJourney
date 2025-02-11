package co.edu.udistrital.View;


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
	 * Atributo encargado de organizar el contenido de los paneles.
	 */
	private JLayeredPane layeredPane;
	/**
	 * Atributo encargado de generar el 
	 */
	private MazeMatriz laberinto;
	private PanelInformacion panelInformacion;
	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenuItem reiniciar;
	private JMenuItem salir;

	private int numMovimientosMax;
	private int numMovimientos;
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
		menuOpciones.setForeground(new Color(0xFFECB));
		//menuOpciones.setFont;
		reiniciar = new JMenuItem("Reiniciar");
		reiniciar.setActionCommand("REINICIAR");
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
	 * Establece el valor del atributo `panelDificultad`.
	 * 
	 * @param panelDificultad El valor deseado para el atributo `panelDificultad`.
	 */
	public void setPanelDificultad(PanelDificultad panelDificultad) {
		this.panelDificultad = panelDificultad;
	}

	/**
	 * Obtiene el valor del atributo `laberinto`.
	 * 
	 * @return El laberinto actual (de tipo `MazeMatriz`).
	 */
	public MazeMatriz getLaberinto() {
		return laberinto;
	}

	/**
	 * Establece el valor del atributo `laberinto`.
	 * 
	 * @param laberinto El valor deseado para el atributo `laberinto`.
	 */
	public void setLaberinto(MazeMatriz laberinto) {
		this.laberinto = laberinto;
	}

	/**
	 * Obtiene el valor del atributo `panelInformacion`.
	 * 
	 * @return El panel de información actual (de tipo `PanelInformacion`).
	 */
	public PanelInformacion getPanelInformacion() {
		return panelInformacion;
	}

	/**
	 * Establece el valor del atributo `panelInformacion`.
	 * 
	 * @param panelInformacion El valor deseado para el atributo `panelInformacion`.
	 */
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

	/**
	 * Obtiene el valor del atributo `numMovimientos`.
	 * 
	 * @return El número actual de movimientos.
	 */
	public int getNumMovimientos() {
		return numMovimientos;
	}

	/**
	 * Establece el valor del atributo `numMovimientos`.
	 * 
	 * @param numMovimientos El valor deseado para el número de movimientos.
	 */
	public void setNumMovimientos(int numMovimientos) {
		this.numMovimientos = numMovimientos;
	}

	/**
	 * Obtiene el valor del atributo `panelTutorialTitulo2`.
	 * 
	 * @return El panel del tutorial con el título actual (de tipo `PanelTutorialTitulo`).
	 */
	public PanelTutorialTitulo getPanelTutorialTitulo2() {
		return panelTutorialTitulo2;
	}

	/**
	 * Establece el valor del atributo `panelTutorialTitulo2`.
	 * 
	 * @param panelTutorialTitulo2 El valor deseado para el panel del tutorial con el título.
	 */
	public void setPanelTutorialTitulo2(PanelTutorialTitulo panelTutorialTitulo2) {
		this.panelTutorialTitulo2 = panelTutorialTitulo2;
	}

	/**
	 * Establece el valor del atributo `menuBar`.
	 * 
	 * @param menuBar El valor deseado para la barra de menú (de tipo `JMenuBar`).
	 */
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	/**
	 * Obtiene el valor del atributo `menuOpciones`.
	 * 
	 * @return El menú de opciones actual (de tipo `JMenu`).
	 */
	public JMenu getMenuOpciones() {
		return menuOpciones;
	}

	/**
	 * Establece el valor del atributo `menuOpciones`.
	 * 
	 * @param menuOpciones El valor deseado para el menú de opciones.
	 */
	public void setMenuOpciones(JMenu menuOpciones) {
		this.menuOpciones = menuOpciones;
	}

	/**
	 * Obtiene el valor del atributo `reiniciar`.
	 * 
	 * @return El menú item de reiniciar (de tipo `JMenuItem`).
	 */
	public JMenuItem getReiniciar() {
		return reiniciar;
	}

	/**
	 * Establece el valor del atributo `reiniciar`.
	 * 
	 * @param reiniciar El valor deseado para el menú item de reiniciar.
	 */
	public void setReiniciar(JMenuItem reiniciar) {
		this.reiniciar = reiniciar;
	}

	/**
	 * Obtiene el valor del atributo `salir`.
	 * 
	 * @return El menú item de salir (de tipo `JMenuItem`).
	 */
	public JMenuItem getSalir() {
		return salir;
	}

	/**
	 * Establece el valor del atributo `salir`.
	 * 
	 * @param salir El valor deseado para el menú item de salir.
	 */
	public void setSalir(JMenuItem salir) {
		this.salir = salir;
	}

	/**
	 * Obtiene el valor del atributo `numMovimientosMax`.
	 * 
	 * @return El número máximo de movimientos permitido.
	 */
	public int getNumMovimientosMax() {
		return numMovimientosMax;
	}

	/**
	 * Establece el valor del atributo `numMovimientosMax`.
	 * 
	 * @param numMovimientosMax El valor deseado para el número máximo de movimientos.
	 */
	public void setNumMovimientosMax(int numMovimientosMax) {
		this.numMovimientosMax = numMovimientosMax;
	}

}
