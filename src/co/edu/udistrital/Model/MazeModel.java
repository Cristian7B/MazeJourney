package co.edu.udistrital.Model;

import co.edu.udistrital.View.Maze.CeldaLaberinto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MazeModel {
    private int filas;
    private int columnas;
    private static CeldaLaberinto[][] grid;
    private Random random = new Random();

    public MazeModel(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        grid = new CeldaLaberinto[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                grid[i][j] = new CeldaLaberinto(i, j);
            }
        }
        generarLaberinto();
        updateCellClientProperties();
    }

    private void generarLaberinto() {
        Stack<CeldaLaberinto> stack = new Stack<>();
        CeldaLaberinto start = grid[0][0];
        start.setVisita(true);
        stack.push(start);

        while (!stack.isEmpty()) {
            CeldaLaberinto actual = stack.peek();
            CeldaLaberinto siguiente = getUnvisitedNeighbor(actual);
            if (siguiente != null) {
                siguiente.setVisita(true);
                removeWalls(actual, siguiente);
                stack.push(siguiente);
            } else {
                stack.pop();
            }
        }
    }

    private CeldaLaberinto getUnvisitedNeighbor(CeldaLaberinto cell) {
        List<CeldaLaberinto> neighbors = new ArrayList<>();
        int fila = cell.getFila();
        int columna = cell.getColumna();

        if (fila > 0 && !grid[fila - 1][columna].isVisita()) neighbors.add(grid[fila - 1][columna]);
        if (columna < columnas - 1 && !grid[fila][columna + 1].isVisita()) neighbors.add(grid[fila][columna + 1]);
        if (fila < filas - 1 && !grid[fila + 1][columna].isVisita()) neighbors.add(grid[fila + 1][columna]);
        if (columna > 0 && !grid[fila][columna - 1].isVisita()) neighbors.add(grid[fila][columna - 1]);

        return neighbors.isEmpty() ? null : neighbors.get(random.nextInt(neighbors.size()));
    }

    private void removeWalls(CeldaLaberinto actual, CeldaLaberinto siguiente) {
        int dx = siguiente.getColumna() - actual.getColumna();
        int dy = siguiente.getFila() - actual.getFila();

        if (dx == 1) { actual.setWallsButton(1, false); siguiente.setWallsButton(3, false); }
        if (dx == -1) { actual.setWallsButton(3, false); siguiente.setWallsButton(1, false); }
        if (dy == 1) { actual.setWallsButton(2, false); siguiente.setWallsButton(0, false); }
        if (dy == -1) { actual.setWallsButton(0, false); siguiente.setWallsButton(2, false); }
    }

    private void updateCellClientProperties() {
        for (int row = 0; row < filas; row++) {
            for (int col = 0; col < columnas; col++) {
                CeldaLaberinto cell = getCeldaLaberinto(row, col);
                cell.setActionCommand("BOTON " + row + " " + col);
                cell.setWalls();
            }
        }
    }

    private CeldaLaberinto getCeldaLaberinto(int row, int col) {
        CeldaLaberinto cell = grid[row][col];
        List<String> wallsList = new ArrayList<>();
        if (cell.getWallsButton(0)) wallsList.add("ARRIBA");
        if (cell.getWallsButton(1)) wallsList.add("DERECHA");
        if (cell.getWallsButton(2)) wallsList.add("ABAJO");
        if (cell.getWallsButton(3)) wallsList.add("IZQUIERDA");

        cell.putClientProperty("walls", wallsList);
        return cell;
    }

    public static CeldaLaberinto[][] getGrid() {
        return grid;
    }
}
