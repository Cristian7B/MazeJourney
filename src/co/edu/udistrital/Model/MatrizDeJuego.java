package co.edu.udistrital.Model;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class MatrizDeJuego {
    private static ArrayList<ArrayList<JButton>> matrizDeJuego;
    private static JButton boton;
    private static MazeCell[][] grid;
    private static int filas;
    private static int columnas;
    private static Random random = new Random();

    public MatrizDeJuego() {
        inicializarComponentes();
    }

    public MatrizDeJuego(int filas, int columnas) {
        inicializarComponentes(filas, columnas);
    }

    public void inicializarComponentes(){

        boton = new JButton();
        matrizDeJuego = new ArrayList<>();
    }

    public void inicializarComponentes(int filas, int columnas){
        this.filas  = filas;
        this.columnas = columnas;
        grid = new MazeCell[filas][columnas];
        boton = new JButton();
        matrizDeJuego = new ArrayList<>();
        GenerarMatriz(this.filas, this.columnas,3,3,1);
    }

    public static boolean GenerarMatriz(int fila, int columna, int puntos, int bestias, int configPuntos) {
        grid = new MazeCell[filas][columnas];
        if(puntos!=0) {


            //
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    MazeCell cell = new MazeCell(filas, columnas);
                    grid[fila][columna] = cell;
                }
            }
            generateMaze();
            updateCellClientProperties();
            return true;

        }

        return false;
    }



    private static MazeCell getUnvisitedNeighbor(MazeCell cell) {
        ArrayList<MazeCell> neighbors = new ArrayList<>();
        int fila = cell.getFila();
        int columna = cell.getColumna();
        // Arriba
        if (fila > 0 && !MatrizDeJuego.grid[fila - 1][columna].isVisited()) {
            neighbors.add(MatrizDeJuego.grid[fila - 1][columna]);
        }
        // Derecha
        if (columna < columnas - 1 && !MatrizDeJuego.grid[fila][columna + 1].isVisited()) {
            neighbors.add(MatrizDeJuego.grid[fila][columna + 1]);
        }
        // Abajo
        if (fila < filas - 1 && !grid[fila + 1][columna].isVisited()) {
            neighbors.add(grid[fila + 1][columna]);
        }
        // Izquierda
        if (columna > 0 && !grid[fila][columna - 1].isVisited()) {
            neighbors.add(grid[fila][columna - 1]);
        }

        if (!neighbors.isEmpty()) {
            return neighbors.get(random.nextInt(neighbors.size()));
        } else {
            return null;
        }
    }

// Elimina las paredes entre la celda actual y la vecina seleccionada
// El orden de las paredes en el arreglo es: [ARRIBA, DERECHA, ABAJO, IZQUIERDA]
    private static void removeWalls(MazeCell actual, MazeCell siguiente) {
        int dx = siguiente.getColumna() - actual.getColumna();
        int dy = siguiente.getFila() - actual.getFila();
        if (dx == 1) { // next está a la derecha
            actual.setWalls( 1,false); // quitar pared derecha de current
            siguiente.setWalls(3,false);    // quitar pared izquierda de next
        }
        if (dx == -1) { // next está a la izquierda
            actual.setWalls(3,false); // quitar pared izquierda de current
            siguiente.setWalls(1,false); ;    // quitar pared derecha de next
        }
        if (dy == 1) { // next está abajo
            actual.setWalls(2,false);    //quitar pared inferior de current
            siguiente.setWalls(0,false);    // quitar pared superior de next
        }
        if (dy == -1) { // next está arriba
            actual.setWalls(0,false); // quitar pared superior de current
            siguiente.setWalls(2,false);    // quitar pared inferior de next
        }
    }

// Para cada celda, se almacena en su propiedad interna ("walls") la lista de etiquetas de las paredes que le quedan
    private static void updateCellClientProperties() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                MazeCell cell = grid[filas][columnas];
                List<String> wallsList = new ArrayList<>();
                if (cell.getWalls(0)) wallsList.add("ARRIBA");
                if (cell.getWalls(1)) wallsList.add("DERECHA");
                if (cell.getWalls(2)) wallsList.add("ABAJO");
                if (cell.getWalls(3)) wallsList.add("IZQUIERDA");

                // Se almacena la lista en la propiedad "walls" del botón
                cell.putClientProperty("walls", wallsList);

                // (Opcional) Agregar un listener para que al hacer clic se muestre por consola la propiedad interna
                cell.addActionListener(e -> {
                    @SuppressWarnings("unchecked")
                    List<String> props = (List<String>) ((JButton)e.getSource()).getClientProperty("walls");
                    System.out.println("Celda (" + cell.getFila() + ", " + cell.getColumna() + ") tiene paredes: " + props);
                });

                // (Opcional) Para depuración se puede mostrar la lista en el botón:
                // cell.setText(wallsList.toString());
            }
        }
    }
    public static String MostrarMatriz() {
        String matriz = "";

        for (int i = 0; i < MatrizDeJuego.getMatrizDeJuego().size(); i++) {
            for (int j = 0; j < MatrizDeJuego.getMatrizDeJuego().get(i).size(); j++) {
                matriz += MatrizDeJuego.getMatrizDeJuego().get(i).get(j);
            }
            matriz += "\n";
        }

        return matriz;
    }
    private static void generateMaze() {
        Stack<MazeCell> stack = new Stack<>();
        MazeCell start = grid[filas-1][columnas-1];
        start.setVisited(true);
        stack.push(start);

        while (!stack.isEmpty()) {
            MazeCell actual = stack.peek();
            MazeCell siguiente = getUnvisitedNeighbor(actual);
            if (siguiente != null) {
                siguiente.setVisited(true);
                removeWalls(actual, siguiente);
                stack.push(siguiente);
            } else {
                stack.pop();
            }
        }
    }

// Clase interna que representa cada celda del laberinto (botón)

    public static void crearJugador(int filas, int columnas) {
        Random rand = new Random();
        int filaJugador = rand.nextInt(filas);
        int columnaJugador = rand.nextInt(columnas);
        getMatrizDeJuego().get(filaJugador).get(columnaJugador).setBackground(new Color(0x1385f0));
        getMatrizDeJuego().get(filaJugador).get(columnaJugador).setText("🤖");
    }

    public static void crearMonedas(int filas, int columnas, int puntos) {
        for (int i = 0; i < puntos; i++) {
            int ran1 = 0;
            int ran2 = 0;
            ran1 = (int) (Math.random() * (filas));
            ran2 = (int) (Math.random() * (columnas));
            matrizDeJuego.get(ran1).get(ran2).setBackground(new Color(254, 168, 47));
        }
    }

    public static void crearBestias(int filas, int columnas, int bestias) {
        for (int i = 0; i < bestias; i++) {
            int ran1 = 0;
            int ran2 = 0;
            ran1 = (int) (Math.random() * (filas));
            ran2 = (int) (Math.random() * (columnas));
            if (i % 2 == 0) {
                matrizDeJuego.get(ran1).get(ran2).setBackground(new Color(254, 16, 47));
            } else {
                matrizDeJuego.get(ran1).get(ran2).setBackground(new Color(200, 110, 100));
            }
        }
    }

    public static void crearCarro(int filas, int columnas) {
        Random rand = new Random();
        int filaJugador = rand.nextInt(filas);
        int columnaJugador = rand.nextInt(columnas);
        getMatrizDeJuego().get(filaJugador).get(columnaJugador).setBackground(new Color(200, 100, 250));
        getMatrizDeJuego().get(filaJugador).get(columnaJugador).setText("carrito");
    }

    public static ArrayList<ArrayList<JButton>> getMatrizDeJuego() {
        return matrizDeJuego;
    }

    public static void setMatrizDeJuego(ArrayList<ArrayList<JButton>> matrizDeJuego) {
        MatrizDeJuego.matrizDeJuego = matrizDeJuego;
    }

    public int getFila() {
        return filas;
    }

    public void setFila(int fila) {
        this.filas = fila;
    }

    public int getColumna() {
        return columnas;
    }

    public void setColumna(int columna) {
        this.columnas = columna;
    }

    public static JButton getBoton() {
        return boton;
    }

    public static void setBoton(JButton boton) {
        MatrizDeJuego.boton = boton;
    }

    public static MazeCell[][] getGrid() {
        return grid;
    }

    public static void setGrid(MazeCell[][] grid) {
        MatrizDeJuego.grid = grid;
    }

    public static int getFilas() {
        return filas;
    }

    public static void setFilas(int filas) {
        MatrizDeJuego.filas = filas;
    }

    public static int getColumnas() {
        return columnas;
    }

    public static void setColumnas(int columnas) {
        MatrizDeJuego.columnas = columnas;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        MatrizDeJuego.random = random;
    }
}

