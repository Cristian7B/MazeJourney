package co.edu.udistrital.View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class celdaLaberinto extends JButton {
    private int fila, columna;
    private boolean visita = false;
    private boolean[] paredes = {true,true,true,true};

    public celdaLaberinto(int fila, int columna) {
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
       System.out.println(wallsButton + "Llamada función");
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

    public boolean getParedes(int indice) {
        return paredes[indice];
    }

    public void setParedes(int indice, boolean valor) {
        paredes[indice] = valor;
    }

    public boolean[] getParedes() {
        return paredes;
    }

    public void setParedes(boolean[] paredes) {
        this.paredes = paredes;
    }
}
