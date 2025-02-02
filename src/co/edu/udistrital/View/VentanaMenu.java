package co.edu.udistrital.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VentanaMenu extends JFrame {
	private PanelMenu menu;
	private PanelImagenMenu imagenMenu;
	private JLayeredPane layeredPane;

	public VentanaMenu() {
		setTitle("MazeJourney");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.darkGray);
		getContentPane().setLayout(null);

		inicializarComponentes();

		setResizable(true);
		setVisible(true);
	}

	private void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, getWidth(), getHeight());
		getContentPane().add(layeredPane);

		imagenMenu = new PanelImagenMenu();
		imagenMenu.setBounds(0, 0, getWidth(), getHeight());
		imagenMenu.setOpaque(true);

		menu = new PanelMenu();
		menu.setBounds(getWidth() / 3, getHeight() / 3, 400, 300);
		menu.setOpaque(false);

		layeredPane.add(imagenMenu, Integer.valueOf(0));
		layeredPane.add(menu, Integer.valueOf(1));

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				ajustarTamaño();
			}
		});
	}

	private void ajustarTamaño() {
		int width = getWidth();
		int height = getHeight();

		layeredPane.setBounds(0, 0, width, height);
		imagenMenu.setBounds(0, 0, width, height);
		menu.setBounds(width / 3, height / 3, 400, 300);
	}

	public PanelMenu getMenu() {
		return menu;
	}

	public void setMenu(PanelMenu menu) {
		this.menu = menu;
	}
}
