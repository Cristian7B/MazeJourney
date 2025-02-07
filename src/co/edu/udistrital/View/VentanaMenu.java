package co.edu.udistrital.View;

import co.edu.udistrital.View.PanelsMenu.PanelIconNameMenu;
import co.edu.udistrital.View.PanelsMenu.PanelImagenMenu;
import co.edu.udistrital.View.PanelsMenu.PanelMenu;
import co.edu.udistrital.View.PanelsMenu.PanelTitleMenu;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase encargada tratar las demas ventanas 
 */

public class VentanaMenu extends JFrame {
	/**
	 * Atributo encargado de gestionar la accesibilidad del usuario
	 */
	private PanelMenu menu;
	/**
	 * Atributo encargado de mostrar el fondo de pantalla
	 */
	private PanelImagenMenu imagenMenu;
	/**
	 * Atributo encargado de organizar los paneles
	 */
	private JLayeredPane layeredPane;
	/**
	 * Atributo encargado de mostrar el titulo del programa 
	 */
	private PanelTitleMenu panelTitleMenu;
	/**
	 * Atributo encargado de mostrar el nombre del programa y su icono
	 */
	private PanelIconNameMenu panelIconNameMenu;

	/**
	 * Metodo contructor de la clase
	 * @throws IOException
	 * @throws FontFormatException
	 */

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

	/**
	 * Metodo encargado de inicializar los componentes de la ventana
	 * @throws IOException
	 * @throws FontFormatException
	 */

	private void inicializarComponentes() throws IOException, FontFormatException {
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, getWidth(), getHeight());
		getContentPane().add(layeredPane);

		imagenMenu = new PanelImagenMenu();
		imagenMenu.setBounds(0, 0, getWidth(), getHeight());
		imagenMenu.setOpaque(true);

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
	/**
	 * Metodo encargado de ajustar el tamaño de la ventana 
	 */
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

	/**
	 * Metodo encargado de acceder a la variable menu
	 * @return Regresa la variable menu
	 */
	public PanelMenu getMenu() {
		return menu;
	}
	/**
	 * Metodo encargado de cambiar el valor del atributo menu
	 * @param menu El valor que cambia el atributo menu
	 */
	public void setMenu(PanelMenu menu) {
		this.menu = menu;
	}
}
