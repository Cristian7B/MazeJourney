package co.edu.udistrital.View;

import java.awt.*;
import javax.swing.*;

public class PanelImagenMatriz extends JPanel {
	private int filasMatriz;
	private int columnasMatriz;
	public PanelImagenMatriz(int filas, int columnas) {
		filasMatriz = filas;
		columnasMatriz = columnas;
		setLayout(new GridLayout(filasMatriz, columnasMatriz)); // Diseño tipo matriz

		inicializarComponentes();
		colocarJugador();
		setVisible(false);
	}

	private void colocarJugador() {


	}

	public void inicializarComponentes() {
	}

	public int getFilasMatriz() {
		return filasMatriz;
	}

	public void setFilasMatriz(int filasMatriz) {
		this.filasMatriz = filasMatriz;
	}

	public int getColumnasMatriz() {
		return columnasMatriz;
	}

	public void setColumnasMatriz(int columnasMatriz) {
		this.columnasMatriz = columnasMatriz;
	}
}
