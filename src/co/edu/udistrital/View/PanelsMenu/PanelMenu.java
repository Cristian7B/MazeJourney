package co.edu.udistrital.View.PanelsMenu;

import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;

import java.awt.*;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	private JButton jugar; // inicia accion jugar
	private JButton tutorial; //abre tutorial
	private JButton salir;
	public PanelMenu() throws IOException, FontFormatException {
		setLayout(new GridLayout(3,1, 5, 5));

		inicializarComponentes();
	}
	
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

	public JButton quitarEstilos(String labelText, String comandText) throws IOException, FontFormatException {
		JButton button = new JButton(labelText);
		button.setActionCommand(comandText);

		button.setBorderPainted(false);
		button.setFocusPainted(false);

		button.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
		button.setForeground(new Color(0xFFFECB));


		return button;
	}

	public JButton getJugar() {
		return jugar;
	}

	public void setJugar(JButton jugar) {
		this.jugar = jugar;
	}

	public JButton getTutorial() {
		return tutorial;
	}

	public void setTutorial(JButton tutorial) {
		this.tutorial = tutorial;
	}

	public JButton getSalir() {
		return salir;
	}

	public void setSalir(JButton salir) {
		this.salir = salir;
	}
	
	
	
}
