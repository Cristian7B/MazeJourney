package co.edu.udistrital.View;

import co.edu.udistrital.Model.MatrizDeJuego;

import java.awt.*;
import java.util.Random;

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
		Random rand = new Random();
		int filaJugador = rand.nextInt(filasMatriz);
		int columnaJugador = rand.nextInt(filasMatriz);
		MatrizDeJuego.getMatrizDeJuego().get(filaJugador).get(columnaJugador).setBackground(new Color(0x1385f0));
		MatrizDeJuego.getMatrizDeJuego().get(filaJugador).get(columnaJugador).setText("🤖");

	}

	public void inicializarComponentes() {
		for (int i = 0; i < filasMatriz; i++) {
			for (int j = 0; j < columnasMatriz; j++) {
				add(MatrizDeJuego.getMatrizDeJuego().get(i).get(j));
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
