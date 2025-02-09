package co.edu.udistrital.View;

import co.edu.udistrital.Model.MatrizDeJuego;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class PanelImagenMatriz extends JPanel {
	private int filasMatriz;
	private int columnasMatriz;
	private MatrizDeJuego matriz;
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
		matriz = new MatrizDeJuego();
		for (int i = 0; i < filasMatriz; i++) {
			for (int j = 0; j < columnasMatriz; j++) {
				add(matriz.getMatrizDeJuego().get(i).get(j));
			}
		}
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
