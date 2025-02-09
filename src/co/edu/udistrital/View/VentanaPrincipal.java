package co.edu.udistrital.View;

import java.awt.*;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {
	private PanelDificultad panelDificultad;
	private PanelImagenMatriz panelImagenMatriz;
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
		generacionMatriz laberinto = new generacionMatriz(filas,columnas);
		add(laberinto, BorderLayout.CENTER);
	}

	public PanelDificultad getPanelDificultad() {
		return panelDificultad;
	}

	public void setPanelDificultad(PanelDificultad panelDificultad) {
		this.panelDificultad = panelDificultad;
	}

	public PanelImagenMatriz getPanelImagenMatriz() {
		return panelImagenMatriz;
	}

	public void setPanelImagenMatriz(PanelImagenMatriz panelImagenMatriz) {
		this.panelImagenMatriz = panelImagenMatriz;
	}



}
