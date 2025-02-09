package co.edu.udistrital.View.Maze;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CeldaLaberinto extends JButton {
    private int fila, columna;
    private boolean visita = false;
    private boolean[] wallsButton = {true,true,true,true};

    public CeldaLaberinto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;

        setFocusable(false);
        setFocusPainted(false);
        setBackground(new Color(0xFFFECB));
    }

    @SuppressWarnings("unchecked")
    public List<String> getWalls() {
        return (List<String>) this.getClientProperty("walls");
    }

    public void setWalls() {
       List<String> wallsButton = this.getWalls();
       int[] numbers = {0, 0, 0, 0};
       for (int i = 0; i < wallsButton.size(); i++) {
            if(wallsButton.get(i).equals("ARRIBA")) {
                numbers[0] = 3;
            } else if(wallsButton.get(i).equals("IZQUIERDA")) {
                numbers[1] = 3;
            } else if(wallsButton.get(i).equals("ABAJO")) {
                numbers[2] = 3;
            } else if(wallsButton.get(i).equals("DERECHA")) {
                numbers[3] = 3;
            }
       }
        setBorder(BorderFactory.createMatteBorder(numbers[0], numbers[1], numbers[2], numbers[3], new Color(84, 72, 200)));
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isVisita() {
        return visita;
    }

    public void setVisita(boolean visita) {
        this.visita = visita;
    }

    public boolean getWallsButton(int indice) {
        return wallsButton[indice];
    }

    public void setWallsButton(int indice, boolean valor) {
        wallsButton[indice] = valor;
    }

    public boolean[] getWallsButton() {
        return wallsButton;
    }

    public void setWallsButton(boolean[] wallsButton) {
        this.wallsButton = wallsButton;
    }
}
