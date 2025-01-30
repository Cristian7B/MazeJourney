package co.edu.udistrital.View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	private JButton botonJugar; // inicia accion botonJugar
	private JButton botonTutorial; //abre botonTutorial
	private JButton botonSalir;
	public PanelMenu() {
		setLayout(new GridLayout(3,1));
		setVisible(true);
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		botonJugar = new JButton("JUGAR");
		botonJugar.setActionCommand("JUGAR");
		add(botonJugar);

		botonTutorial = new JButton("TUTORIAL");
		botonTutorial.setActionCommand("TUTORIAL");
		add(botonTutorial);

		botonSalir = new JButton("SALIR");
		botonSalir.setActionCommand("SALIR");
		add(botonSalir);
	}

	public JButton getJugar() {
		return botonJugar;
	}

	public void setJugar(JButton botonJugar) {
		this.botonJugar = botonJugar;
	}

	public JButton getTutorial() {
		return botonTutorial;
	}

	public void setTutorial(JButton botonTutorial) {
		this.botonTutorial = botonTutorial;
	}

	public JButton getSalir() {
		return botonSalir;
	}

	public void setSalir(JButton botonSalir) {
		this.botonSalir = botonSalir;
	}
	
	
	
}
