package co.edu.udistrital.Model;

import java.util.ArrayList;

public class MatrizDeJuego {
    private static ArrayList<ArrayList<Integer>> matrizDeJuego;

    public static boolean GenerarMatriz(int filas, int columnas) {
        matrizDeJuego = new ArrayList<>();
        if(filas > 4 && columnas > 4) {
            try {
                for (int i = 0; i < filas; i++) {
                    ArrayList<Integer> fila = new ArrayList<>();
                    for (int j = 0; j < columnas; j++) {
                        fila.add(0);
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

    public static ArrayList<ArrayList<Integer>> getMatrizDeJuego() {
        return matrizDeJuego;
    }

    public static void setMatrizDeJuego(ArrayList<ArrayList<Integer>> matrizDeJuego) {
        MatrizDeJuego.matrizDeJuego = matrizDeJuego;
    }
}
