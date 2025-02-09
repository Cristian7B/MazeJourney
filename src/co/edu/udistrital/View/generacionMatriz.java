package co.edu.udistrital.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class generacionMatriz extends JPanel {

    private int filas;
    private int columnas;
    private celdaLaberinto[][] grid;
    private JPanel mazePanel;
    private Random random = new Random();

    public generacionMatriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        grid = new celdaLaberinto[filas][columnas];
        mazePanel = new JPanel();
        mazePanel.setLayout(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdaLaberinto celda = new celdaLaberinto(i, j);
                grid[i][j] = celda;
                List<String> walls = celda.getWalls();
                System.out.println("Celda (" + i + ", " + j + ") tiene paredes: " + walls);
                mazePanel.add(celda);
            }
        }
        add(mazePanel);
        setVisible(true);

        generarLaberinto();
        updateCellClientProperties();
    }

    private void generarLaberinto() {
        Stack<celdaLaberinto> stack = new Stack<>();
        celdaLaberinto start = grid[0][0];
        start.setVisita(true);
        stack.push(start);

        while (!stack.isEmpty()) {
            celdaLaberinto actual = stack.peek();
            celdaLaberinto siguiente = getUnvisitedNeighbor(actual);
            if (siguiente != null) {
                siguiente.setVisita(true);
                removeWalls(actual, siguiente);
                stack.push(siguiente);
            } else {
                stack.pop();
            }
        }
    }

    private celdaLaberinto getUnvisitedNeighbor(celdaLaberinto cell) {
        ArrayList<celdaLaberinto> neighbors = new ArrayList<>();
        int fila = cell.getFila();
        int columna = cell.getColumna();

        // Arriba
        if (fila > 0 && !grid[fila - 1][columna].isVisita()) {
            neighbors.add(grid[fila - 1][columna]);
        }
        // Derecha
        if (columna < columnas - 1 && !grid[fila][columna + 1].isVisita()) {
            neighbors.add(grid[fila][columna + 1]);
        }
        // Abajo
        if (fila < filas - 1 && !grid[fila + 1][columna].isVisita()) {
            neighbors.add(grid[fila + 1][columna]);
        }
        // Izquierda
        if (columna > 0 && !grid[fila][columna - 1].isVisita()) {
            neighbors.add(grid[fila][columna - 1]);
        }

        if (!neighbors.isEmpty()) {
            return neighbors.get(random.nextInt(neighbors.size()));
        } else {
            return null;
        }
    }

    private void removeWalls(celdaLaberinto actual, celdaLaberinto siguiente) {
        int dx = siguiente.getColumna() - actual.getColumna();
        int dy = siguiente.getFila() - actual.getFila();

        if (dx == 1) { // next está a la derecha
            actual.setParedes(1, false); // quitar pared derecha de current
            siguiente.setParedes(3, false);    // quitar pared izquierda de next
        }
        if (dx == -1) { // next está a la izquierda
            actual.setParedes(3, false); // quitar pared izquierda de current
            siguiente.setParedes(1, false);     // quitar pared derecha de next
        }
        if (dy == 1) { // next está abajo
            actual.setParedes(2, false);  // quitar pared inferior de current
            siguiente.setParedes(0, false);    // quitar pared superior de next
        }
        if (dy == -1) { // next está arriba
            actual.setParedes(0, false); // quitar pared superior de current
            siguiente.setParedes(2, false);    // quitar pared inferior de next
        }
    }

    private void updateCellClientProperties() {
        for (int row = 0; row < filas; row++) {
            for (int col = 0; col < columnas; col++) {
                celdaLaberinto cell = grid[row][col];
                java.util.List<String> wallsList = new ArrayList<>();
                if (cell.getParedes(0)) wallsList.add("ARRIBA");
                if (cell.getParedes(1)) wallsList.add("DERECHA");
                if (cell.getParedes(2)) wallsList.add("ABAJO");
                if (cell.getParedes(3)) wallsList.add("IZQUIERDA");

                // Se almacena la lista en la propiedad "walls" del botón
                cell.putClientProperty("walls", wallsList);

                // (Opcional) Agregar un listener para que al hacer clic se muestre por consola la propiedad interna
                cell.addActionListener(e -> {
                    @SuppressWarnings("unchecked")
                    java.util.List<String> props = (List<String>)  ((JButton) e.getSource()).getClientProperty("walls");
                    System.out.println("Celda (" + cell.getFila() + ", " + cell.getColumna() + ") tiene paredes: " + props);
                });

                // (Opcional) Para depuración se puede mostrar la lista en el botón:
                // cell.setText(wallsList.toString());
            }
        }
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public celdaLaberinto[][] getGrid() {
        return grid;
    }

    public void setGrid(celdaLaberinto[][] grid) {
        this.grid = grid;
    }

    public JPanel getMazePanel() {
        return mazePanel;
    }

    public void setMazePanel(JPanel mazePanel) {
        this.mazePanel = mazePanel;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}


