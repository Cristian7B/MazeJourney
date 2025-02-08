package co.edu.udistrital.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MatrizDeJuego {
    private static ArrayList<ArrayList<JButton>> matrizDeJuego;
    private static JButton boton;

    public static boolean GenerarMatriz(int filas, int columnas, int puntos, int bestias, int configPuntos) {
        if(puntos!=0) {
            matrizDeJuego = new ArrayList<>();
            if (filas > 4 && columnas > 4 && filas < 21 && columnas < 21) {
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
                crearJugador(filas,columnas);
                crearMonedas(filas,columnas,puntos);
                crearBestias(filas,columnas,bestias);
                crearCarro(filas,columnas);
                return true;
            }


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

    public static void crearJugador(int filas, int columnas){
        Random rand = new Random();
        int filaJugador = rand.nextInt(filas);
        int columnaJugador = rand.nextInt(columnas);
        MatrizDeJuego.getMatrizDeJuego().get(filaJugador).get(columnaJugador).setBackground(new Color(0x1385f0));
        MatrizDeJuego.getMatrizDeJuego().get(filaJugador).get(columnaJugador).setText("🤖");
    }
    public static void crearMonedas(int filas, int columnas, int puntos){
        for (int i = 0; i < puntos; i++) {
            int ran1 = 0;
            int ran2 = 0;
            ran1 = (int)(Math.random() * (filas)) ;
            ran2 = (int)(Math.random() * (columnas)) ;
            matrizDeJuego.get(ran1).get(ran2).setBackground(new Color(254, 168, 47));
        }
    }
    public static void crearBestias(int filas, int columnas, int bestias){
        for (int i = 0; i < bestias; i++) {
            int ran1 = 0;
            int ran2 = 0;
            ran1 = (int)(Math.random() * (filas)) ;
            ran2 = (int)(Math.random() * (columnas)) ;
            if (i%2==0){
                matrizDeJuego.get(ran1).get(ran2).setBackground(new Color(254, 16, 47));
            }else{
                matrizDeJuego.get(ran1).get(ran2).setBackground(new Color(200, 110, 100));
            }
        }
    }

    public static void crearCarro(int filas, int columnas){
        Random rand = new Random();
        int filaJugador = rand.nextInt(filas);
        int columnaJugador = rand.nextInt(columnas);
        MatrizDeJuego.getMatrizDeJuego().get(filaJugador).get(columnaJugador).setBackground(new Color(200,100,250));
        MatrizDeJuego.getMatrizDeJuego().get(filaJugador).get(columnaJugador).setText("carrito");
    }
    public static ArrayList<ArrayList<JButton>> getMatrizDeJuego() {
        return matrizDeJuego;
    }

    public static void setMatrizDeJuego(ArrayList<ArrayList<JButton>> matrizDeJuego) {
        MatrizDeJuego.matrizDeJuego = matrizDeJuego;
    }
}
