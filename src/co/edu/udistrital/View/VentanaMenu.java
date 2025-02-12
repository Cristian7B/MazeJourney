package co.edu.udistrital.View;

import co.edu.udistrital.View.PanelsMenu.PanelIconNameMenu;
import co.edu.udistrital.View.PanelsMenu.PanelImagenMenu;
import co.edu.udistrital.View.PanelsMenu.PanelMenu;
import co.edu.udistrital.View.PanelsMenu.PanelTitleMenu;
import co.edu.udistrital.View.PanelsTutorial.PanelTutorialTitulo;
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
	private PanelTutorialTitulo panelTutorialTitulo1;

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
     * Metodo encargado de inicializar los componentes de la ventana.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
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

		panelTutorialTitulo1 = new PanelTutorialTitulo();

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
	 * Metodo encargado acceder a un atributo.
	 * regresa el PanelMenu llamado menu.
	 * @return
	 */
	public void mostrarTutorial()  {
		panelTutorialTitulo1.setBounds(0, 0, getWidth(), getHeight());
		panelTutorialTitulo1.setOpaque(false);
		layeredPane.removeAll();
		layeredPane.add(panelTutorialTitulo1, Integer.valueOf(0));
	}

	public void cerrarTutorial() {
		layeredPane.removeAll();
		layeredPane.add(imagenMenu, Integer.valueOf(0));
		layeredPane.add(panelIconNameMenu, Integer.valueOf(1));
		layeredPane.add(panelTitleMenu, Integer.valueOf(1));
		layeredPane.add(menu, Integer.valueOf(1));

	}


	/**
	 * Obtiene el menú actual.
	 *
	 * Este método devuelve la instancia de tipo {@link PanelMenu} que representa el menú actual.
	 *
	 * @return el menú actual.
	 */
	public PanelMenu getMenu() {
		return menu;
	}

	/**
	 * Establece el menú actual.
	 *
	 * Este método permite asignar un nuevo objeto de tipo {@link PanelMenu} como el menú actual. 
	 * Se utiliza para modificar la instancia del menú en la interfaz o aplicación.
	 *
	 * @param menu El nuevo objeto de tipo {@link PanelMenu} que se asignará como el menú actual.
	 */
	public void setMenu(PanelMenu menu) {
		this.menu = menu;
	}

	/**
	 * Obtiene el menú de imágenes actual.
	 *
	 * Este método devuelve la instancia de tipo {@link PanelImagenMenu} que representa el menú de imágenes actual.
	 *
	 * @return el menú de imágenes actual.
	 */
	public PanelImagenMenu getImagenMenu() {
		return imagenMenu;
	}

	/**
	 * Establece el menú de imágenes actual.
	 *
	 * Este método permite asignar un nuevo objeto de tipo {@link PanelImagenMenu} como el menú de imágenes actual.
	 * Se utiliza para modificar la instancia del menú de imágenes en la interfaz o aplicación.
	 *
	 * @param imagenMenu El nuevo objeto de tipo {@link PanelImagenMenu} que se asignará como el menú de imágenes actual.
	 */
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

	/**
	 * Obtiene el panel de título del menú.
	 *
	 * Este método devuelve la instancia de tipo {@link PanelTitleMenu} que representa el panel de título del menú.
	 *
	 * @return el panel de título del menú actual.
	 */
	public PanelTitleMenu getPanelTitleMenu() {
		return panelTitleMenu;
	}

	/**
	 * Establece el panel de título del menú.
	 *
	 * Este método permite asignar un nuevo objeto de tipo {@link PanelTitleMenu} como el panel de título del menú.
	 * Se utiliza para modificar el panel de título en la interfaz o aplicación.
	 *
	 * @param panelTitleMenu El nuevo objeto de tipo {@link PanelTitleMenu} que se asignará como el panel de título del menú.
	 */
	public void setPanelTitleMenu(PanelTitleMenu panelTitleMenu) {
		this.panelTitleMenu = panelTitleMenu;
	}

	/**
	 * Obtiene el panel de icono y nombre del menú.
	 *
	 * Este método devuelve la instancia de tipo {@link PanelIconNameMenu} que representa el panel que contiene el icono y nombre del menú.
	 *
	 * @return el panel de icono y nombre del menú actual.
	 */
	public PanelIconNameMenu getPanelIconNameMenu() {
		return panelIconNameMenu;
	}

	/**
	 * Establece el panel de icono y nombre del menú.
	 *
	 * Este método permite asignar un nuevo objeto de tipo {@link PanelIconNameMenu} como el panel de icono y nombre del menú.
	 * Se utiliza para modificar este panel en la interfaz o aplicación.
	 *
	 * @param panelIconNameMenu El nuevo objeto de tipo {@link PanelIconNameMenu} que se asignará como el panel de icono y nombre del menú.
	 */
	public void setPanelIconNameMenu(PanelIconNameMenu panelIconNameMenu) {
		this.panelIconNameMenu = panelIconNameMenu;
	}

	/**
	 * Obtiene el panel de tutorial del título.
	 *
	 * Este método devuelve la instancia de tipo {@link PanelTutorialTitulo} que representa el panel que muestra el título del tutorial.
	 *
	 * @return el panel de título del tutorial actual.
	 */
	public PanelTutorialTitulo getPanelTutorialTitulo1() {
		return panelTutorialTitulo1;
	}

	/**
	 * Establece el panel de tutorial del título.
	 *
	 * Este método permite asignar un nuevo objeto de tipo {@link PanelTutorialTitulo} como el panel de título del tutorial.
	 * Se utiliza para modificar el panel de título del tutorial en la interfaz o aplicación.
	 *
	 * @param panelTutorialTitulo1 El nuevo objeto de tipo {@link PanelTutorialTitulo} que se asignará como el panel de título del tutorial.
	 */
	public void setPanelTutorialTitulo1(PanelTutorialTitulo panelTutorialTitulo1) {
		this.panelTutorialTitulo1 = panelTutorialTitulo1;
	}

}
