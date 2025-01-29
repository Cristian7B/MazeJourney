package View;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	private JButton jugar; // inicia accion jugar
	private JButton tutorial; //abre tutorial
	private JButton salir;
	public PanelMenu() {
		setLayout(new GridLayout(3,1));
		
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		jugar = new JButton("JUGAR");
		jugar.setActionCommand("JUGAR");
		tutorial = new JButton("TUTORIAL");
		tutorial.setActionCommand("TUTORIAL");
		salir = new JButton("SALIR");
		salir.setActionCommand("SALIR");
		
		add(jugar);
		add(tutorial);
		add(salir);
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
