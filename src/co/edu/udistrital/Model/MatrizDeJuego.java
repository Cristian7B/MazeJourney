package co.edu.udistrital.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MatrizDeJuego {
    private static ArrayList<ArrayList<JButton>> matrizDeJuego;
    private static JButton boton;

    public static boolean GenerarMatriz(int filas, int columnas) {
        matrizDeJuego = new ArrayList<>();
        if(filas > 4 && columnas > 4) {
            try {
                for (int i = 0; i < filas; i++) {
                    ArrayList<JButton> fila = new ArrayList<>();
                    for (int j = 0; j < columnas; j++) {
                        boton = new JButton("Celda " + (i + 1) + ", " + (j + 1));
                        boton.setBackground(new Color(0x5448C8));
                        fila.add(boton);
                    }
                    matrizDeJuego.add(fila);
                }
            } catch (NumberFormatException e) {
                return false;
            }
            return true;
        }

        return false;
    }

    public static String MostrarMatriz() {
        String matriz = "";

        for(int i = 0; i < matrizDeJuego.size(); i++) {
            for(int j = 0; j < matrizDeJuego.get(i).size(); j++) {
                matriz += matrizDeJuego.get(i).get(j);
            }
            matriz += "\n";
        }

        return matriz;
    }

    public static ArrayList<ArrayList<JButton>> getMatrizDeJuego() {
        return matrizDeJuego;
    }

    public static void setMatrizDeJuego(ArrayList<ArrayList<JButton>> matrizDeJuego) {
        MatrizDeJuego.matrizDeJuego = matrizDeJuego;
    }
}
