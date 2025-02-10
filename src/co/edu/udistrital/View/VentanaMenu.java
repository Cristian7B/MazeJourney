package co.edu.udistrital.View;

import co.edu.udistrital.View.PanelsMenu.PanelIconNameMenu;
import co.edu.udistrital.View.PanelsMenu.PanelImagenMenu;
import co.edu.udistrital.View.PanelsMenu.PanelMenu;
import co.edu.udistrital.View.PanelsMenu.PanelTitleMenu;
import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class VentanaMenu extends JFrame {
	private PanelMenu menu;
	private PanelImagenMenu imagenMenu;
	private JLayeredPane layeredPane;
	private PanelTitleMenu panelTitleMenu;
	private PanelIconNameMenu panelIconNameMenu;
	private PanelTutorialTitulo panelTutorialTitulo;

	public VentanaMenu() throws IOException, FontFormatException {
		setTitle("MazeJourney");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(0x202020));
		getContentPane().setLayout(null);

		inicializarComponentes();

		setResizable(false);
		setVisible(true);
	}

	private void inicializarComponentes() throws IOException, FontFormatException {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, getWidth(), getHeight());
		getContentPane().add(layeredPane);

		imagenMenu = new PanelImagenMenu();
		imagenMenu.setBounds(0, 0, getWidth(), getHeight());
		imagenMenu.setOpaque(true);

		panelTutorialTitulo = new PanelTutorialTitulo();

		panelIconNameMenu = new PanelIconNameMenu();
		panelIconNameMenu.setBounds(27, 15, 300, 200);
		panelIconNameMenu.setOpaque(false);

		panelTitleMenu = new PanelTitleMenu();
		panelTitleMenu.setBounds(getWidth()/4, getHeight()/4, 840, 200);
		panelTitleMenu.setOpaque(false);

		menu = new PanelMenu();
		menu.setBounds(getWidth() / 4, getHeight() / 4, 350, 200);
		menu.setOpaque(false);


		layeredPane.add(imagenMenu, Integer.valueOf(0));
		layeredPane.add(panelIconNameMenu, Integer.valueOf(1));
		layeredPane.add(panelTitleMenu, Integer.valueOf(1));
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

		int menuWidth = menu.getWidth();
		int menuHeight = menu.getHeight();

		int titleWidth = panelTitleMenu.getWidth();
		int titleHeight = panelTitleMenu.getHeight();

		int menuX = (width - menuWidth) / 2;
		int menuY = ((height - menuHeight) / 2)*4/3;

		int titleX = (width - titleWidth) / 2;
		int titleY = ((height - titleHeight) / 2)*4/5;

		menu.setBounds(menuX, menuY, menuWidth, menuHeight);
		panelTitleMenu.setBounds(titleX, titleY, titleWidth, titleHeight);
	}

	public void mostrarTutorial()  {
		panelTutorialTitulo.setBounds(0, 0, getWidth(), getHeight());
		panelTutorialTitulo.setOpaque(false);
		layeredPane.removeAll();
		layeredPane.add(panelTutorialTitulo, Integer.valueOf(0));

	}

	public void cerrarTutorial() {
		layeredPane.removeAll();
		layeredPane.add(imagenMenu, Integer.valueOf(0));
		layeredPane.add(panelIconNameMenu, Integer.valueOf(1));
		layeredPane.add(panelTitleMenu, Integer.valueOf(1));
		layeredPane.add(menu, Integer.valueOf(1));

	}


	public PanelMenu getMenu() {
		return menu;
	}

	public void setMenu(PanelMenu menu) {
		this.menu = menu;
	}

	public PanelImagenMenu getImagenMenu() {
		return imagenMenu;
	}

	public void setImagenMenu(PanelImagenMenu imagenMenu) {
		this.imagenMenu = imagenMenu;
	}

	@Override
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	@Override
	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public PanelTitleMenu getPanelTitleMenu() {
		return panelTitleMenu;
	}

	public void setPanelTitleMenu(PanelTitleMenu panelTitleMenu) {
		this.panelTitleMenu = panelTitleMenu;
	}

	public PanelIconNameMenu getPanelIconNameMenu() {
		return panelIconNameMenu;
	}

	public void setPanelIconNameMenu(PanelIconNameMenu panelIconNameMenu) {
		this.panelIconNameMenu = panelIconNameMenu;
	}

	public PanelTutorialTitulo getPanelTutorialTitulo() {
		return panelTutorialTitulo;
	}

	public void setPanelTutorialTitulo(PanelTutorialTitulo panelTutorialTitulo) {
		this.panelTutorialTitulo = panelTutorialTitulo;
	}
}
