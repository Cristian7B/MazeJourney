package View;

import java.awt.*;

import javax.swing.*;

public class PanelImagenMatriz extends JPanel {
	private int FILAS = 5;
	private int COLUMNAS = 5;
	private JButton[][] matriz;
	public PanelImagenMatriz() {
		setLayout(new GridLayout(FILAS, COLUMNAS)); // Diseño tipo matriz

		inicializarComponentes();
		colocarJugador(3,3);
	}

	private void colocarJugador(int fila, int columna) {
		matriz[fila][columna].setBackground(Color.BLUE);
		matriz[fila][columna].setText("🤖");

	}

	public void inicializarComponentes() {
		matriz = new JButton[FILAS][COLUMNAS];

		// Crear la matriz de botones
		for (int i = 0; i < FILAS; i++) {
			for (int j = 0; j < COLUMNAS; j++) {
				matriz[i][j] = new JButton("Celda "+(i+1)+", "+(j+1) );
				matriz[i][j].setBackground(Color.green); // Fondo blanco
				add(matriz[i][j]); // Agregar cada botón al panel
			}

		}
	}
}
