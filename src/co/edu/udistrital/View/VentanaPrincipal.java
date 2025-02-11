package co.edu.udistrital.View;

import co.edu.udistrital.View.Maze.MazeMatriz;
import co.edu.udistrital.View.Maze.PanelInformacion;
import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	private JLayeredPane layeredPane;
	private PanelDificultad panelDificultad;
	private MazeMatriz laberinto;
	private PanelInformacion panelInformacion;
	private int numMovimientos;
	private PanelTutorialTitulo panelTutorialTitulo2;
	public VentanaPrincipal() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(10, 10));
		
		inicializarComponentes();

		setVisible(false);
	}
	
	public void inicializarComponentes() {
		panelDificultad = new PanelDificultad();
		add(panelDificultad, BorderLayout.CENTER);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, getWidth(), getHeight());

	}

	public void agregarPanelImagenMatriz(int filas, int columnas) {
		this.laberinto = new MazeMatriz(filas,columnas);
		add(laberinto, BorderLayout.CENTER);
		numMovimientos = Integer.parseInt(panelDificultad.getTxtdimensionMatrizColumnas().getText())*Integer.parseInt(panelDificultad.getTxtdimensionMatrizFilas().getText());
		panelInformacion = new PanelInformacion(numMovimientos);
		add(panelInformacion, BorderLayout.NORTH);
	}

	public int mostrarTutorial() throws IOException, FontFormatException {
		panelTutorialTitulo2 = new PanelTutorialTitulo();
		laberinto.setVisible(false);
		add(panelTutorialTitulo2, BorderLayout.CENTER);
		panelTutorialTitulo2.setVisible(true);
		numMovimientos = (numMovimientos - 5);
		panelTutorialTitulo2.getAtras().setActionCommand("ATRASTUTORIAL2");
		return numMovimientos;
	}
	public void cerrarTutorial() {
		panelTutorialTitulo2.setVisible(false);
		laberinto.setVisible(true);
		getContentPane().remove(panelInformacion);
		panelInformacion = new PanelInformacion(numMovimientos);
		add(panelInformacion, BorderLayout.NORTH);
	}
	public PanelDificultad getPanelDificultad() {
		return panelDificultad;
	}

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

}
