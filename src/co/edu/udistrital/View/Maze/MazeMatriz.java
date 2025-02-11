package co.edu.udistrital.View.Maze;

import co.edu.udistrital.Model.MazeModel;
import java.awt.*;
import javax.swing.*;
/**
 * Clase encargado 
 */
public class MazeMatriz extends JPanel {
    private int filas;
    private int columnas;
    private MazeModel mazeModel;
    private JPanel mazePanel;

    public MazeMatriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.mazeModel = new MazeModel(filas, columnas);

        mazePanel = new JPanel();
        mazePanel.setLayout(new GridLayout(filas, columnas));

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                CeldaLaberinto celda = mazeModel.getGrid()[i][j];
                mazePanel.add(celda);
            }
        }

        setLayout(new BorderLayout());
        add(mazePanel, BorderLayout.CENTER);
        setVisible(true);
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

    public MazeModel getMazeModel() {
        return mazeModel;
    }

    public void setMazeModel(MazeModel mazeModel) {
        this.mazeModel = mazeModel;
    }

    public JPanel getMazePanel() {
        return mazePanel;
    }

    public void setMazePanel(JPanel mazePanel) {
        this.mazePanel = mazePanel;
    }
}

