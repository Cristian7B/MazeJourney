package co.edu.udistrital.View;

import javax.swing.*;
import java.util.List;

public class celdaLaberinto extends JButton {
    private int fila, columna;
    private boolean visita = false;
    private boolean[] paredes = {true,true,true,true};

    public celdaLaberinto(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        setFocusable(false);
    }

    @SuppressWarnings("unchecked")
    public List<String> getWalls() {
        return (List<String>) this.getClientProperty("walls");
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
