package co.edu.udistrital.Model;

import javax.swing.*;
import java.util.Stack;

public class MazeCell extends JButton {
    private int fila, columna;
    private boolean visited = false;
    // Las paredes se almacenan en un arreglo: índice 0 = ARRIBA, 1 = DERECHA, 2 = ABAJO, 3 = IZQUIERDA
    private boolean[] walls = {true, true, true, true};

    public MazeCell(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        // Opcional: quitar el foco visual del botón
        setFocusable(false);
    }


    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean getWalls(int indice) {
        return walls[indice];

    }

    public void setWalls(int indice, boolean valor) {
        if (indice >= 0 && indice < walls.length) {
            walls[indice] = valor;
        }
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
}

