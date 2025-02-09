package co.edu.udistrital.View;

import co.edu.udistrital.View.Maze.MazeMatriz;

import java.awt.*;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	private PanelDificultad panelDificultad;
	private MazeMatriz laberinto;

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
	}

	public void agregarPanelImagenMatriz(int filas, int columnas) {
		this.laberinto = new MazeMatriz(filas,columnas);
		add(laberinto, BorderLayout.CENTER);
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
}
