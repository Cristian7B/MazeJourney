package co.edu.udistrital.View;

import java.awt.*;

import javax.swing.*;

public class VentanaMenu extends JFrame {
	private PanelMenu menu;
	private PanelImagenMenu imagenMenu;
	private JLayeredPane layeredPane;
	public VentanaMenu() {
		setTitle("MazeJourney");
		setPreferredSize(new Dimension(900, 600));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.darkGray);
		inicializarComponentes();

		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		imagenMenu = new PanelImagenMenu();
		imagenMenu.setBounds(0, 0, 500, 600);
		imagenMenu.setOpaque(true);

		menu = new PanelMenu();
		menu.setBounds(500, 140, 400, 300);
		menu.setOpaque(false);

		layeredPane.add(imagenMenu,0,0);
		layeredPane.add(menu,1,0);
	}

	public PanelMenu getMenu() {
		return menu;
	}

	public void setMenu(PanelMenu menu) {
		this.menu = menu;
	}
	
}
