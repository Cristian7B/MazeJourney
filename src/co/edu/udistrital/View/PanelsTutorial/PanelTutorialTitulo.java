package co.edu.udistrital.View.PanelsTutorial;

import co.edu.udistrital.Resources.Fonts.CabinetFont;
import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Clase encargada de mostrar el tutorial del juego Udistritalino.
 */
public class PanelTutorialTitulo extends JPanel {
	private JLabel labelTutorial;
	private JLabel labelTutorialNombre;
	private JButton atras;

	public PanelTutorialTitulo() throws IOException, FontFormatException {
		setLayout(new BorderLayout());
		setBackground(new Color(0x202020));
		inicializarComponentes();
	}

	public void inicializarComponentes() throws IOException, FontFormatException {
		JPanel tutorialPane = new JPanel(new FlowLayout());
		tutorialPane.setOpaque(false);

		labelTutorial = new JLabel("Tutorial de juego | ");
		labelTutorial.setFont(CabinetFont.getCabinetFont(50f));
		labelTutorial.setForeground(new Color(0xFFFECB));

		labelTutorialNombre = new JLabel("MazeJourney");
		labelTutorialNombre.setFont(CabinetFont.getCabinetFont(50f));
		labelTutorialNombre.setForeground(new Color(0x5448C8));

		atras = quitarEstilos("Atras", "ATRASTUTORIAL1");
		atras.setBackground(new Color(254, 168, 47));

		tutorialPane.add(labelTutorial);
		tutorialPane.add(atras);
		JPanel titlePanel = new JPanel(new FlowLayout());
		titlePanel.setBackground(new Color(0x202020));
		titlePanel.add(labelTutorialNombre);

		JTextArea textoTutorial = new JTextArea();
		textoTutorial.setText("Udistritalino es un emocionante juego de estrategia en el que debes mover un carrito\n " +
				"a través de un laberinto hasta alcanzar los puntos objetivo.\n " +
				"Sin embargo, el camino no será fácil, ya que hay obstáculos, reglas y peligros \n" +
				"que debes tener en cuenta para lograr tu objetivo sin perder la partida.\n\n" +
				"Objetivo del juego:\n" +
				"- Recorrer el laberinto recolectando los puntos objetivo en el orden determinado.\n" +
				"- No exceder el número máximo de movimientos permitidos.\n" +
				"- Evitar los obstáculos que se encuentran en tu camino.\n\n" +
				"Reglas del juego:\n" +
				"- Puedes moverte en direcciones vertical u horizontal, pero nunca en diagonal.\n" +
				"- Debes recolectar los puntos en el orden establecido.\n" +
				"- Encuentros con un 'Asesino Letal' terminan el juego.\n" +
				"- Encuentros con un 'Tormentoso' reducen tu número de movimientos en un 5%.\n" +
				"- Si intentas atravesar un muro, tu movimiento no será válido.\n" +
				"- Si quedas atrapado entre muros, recibirás una penalización basada en tu posición.\n" +
				"- Puedes revisar las reglas en cualquier momento, pero esto reducirá tus movimientos restantes.\n" +
				"- Si tus movimientos llegan a 0, pierdes el juego.\n\n" +
				"Consejos para ganar:\n" +
				"- Planea tus movimientos con anticipación.\n" +
				"- Evita los encuentros con bestias para conservar tus movimientos.\n" +
				"- Encuentra los caminos más eficientes antes de moverte.\n" +
				"- Usa la opción de recordar reglas solo cuando sea necesario.\n\n" +
				"¡Ahora que conoces las reglas, prepárate para la aventura y demuestra tu habilidad en Udistritalino!");
		textoTutorial.setFont(SatoshiFontBold.getSatoshiFontBold(25f));
		textoTutorial.setForeground(new Color(0xFFFECB));
		textoTutorial.setBackground(new Color(0x202020));
		textoTutorial.setEditable(false);


		atras.setVisible(true);
		add(textoTutorial, BorderLayout.CENTER);
		add(tutorialPane, BorderLayout.NORTH);
		revalidate();
		repaint();
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

	public JLabel getLabelTutorial() {
		return labelTutorial;
	}

	public void setLabelTutorial(JLabel labelTutorial) {
		this.labelTutorial = labelTutorial;
	}

	public JLabel getLabelTutorialNombre() {
		return labelTutorialNombre;
	}

	public void setLabelTutorialNombre(JLabel labelTutorialNombre) {
		this.labelTutorialNombre = labelTutorialNombre;
	}

	public JButton getAtras() {
		return atras;
	}

	public void setAtras(JButton buttonTutorial) {
		this.atras = buttonTutorial;
	}
}
