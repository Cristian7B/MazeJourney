package co.edu.udistrital.View;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaMenu extends JFrame {
	private PanelMenu menu;
	public VentanaMenu() {
		getContentPane().setLayout(new GridLayout());
		setVisible(true);
		setResizable(false);
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		menu = new PanelMenu();
		getContentPane().add(menu);
	}

	public PanelMenu getMenu() {
		return menu;
	}

	public void setMenu(PanelMenu menu) {
		this.menu = menu;
	}
	
}
