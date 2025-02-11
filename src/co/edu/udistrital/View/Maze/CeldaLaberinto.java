package co.edu.udistrital.View.Maze;

import java.awt.*;
import java.util.List;
import javax.swing.*;
/**
 * Clase encargada de generar los botones que generan el laberinto
 * 
 * Se utilizan botones en una matriz 
 */
public class CeldaLaberinto extends JButton {
    /**
     * Atributo entero para las filas en el laberinto
     */
    private int fila;
    /**
     * Atributo entero para las columnas en el laberinto
     */
    private int columna;
    /**
     * Atributo booleano para definir si el algoritmo ya paso por una casilla
     */
    private boolean visita = false;
    /**
     * Atributo vector de 4 booleanos, true significa que no hay pared
     */
    private boolean[] wallsButton = {true,true,true,true};

    /**
     * Metodo constructor, inicializa fila y columna recibiendo como argumentos las filas y las columnas
     * @param fila
     * @param columna
     */
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

    /**
     * Metodo para poner las paredes en cada casilla graficamente, a cada posicion del vector se le asigna 3, el cual es el tamaño del border
     */
    public void setWalls() {
       /**
        * Variable tipo list que guarda en varios Strings las etiquetas de cada casilla
        */ 
       List<String> wallsButton = this.getWalls();
       /**
     * Variable tipo vector que guarda en que posiciones estan las paredes
     */
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

    /**
     * Obtiene el número de fila.
     *
     * Este método devuelve el valor de la fila actual. La fila representa la posición horizontal en una estructura 
     * de datos bidimensional, como un laberinto o una matriz.
     *
     * @return el número de fila.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Establece el número de fila.
     *
     * Este método permite asignar un nuevo valor a la fila. La fila es una coordenada que puede representar la 
     * posición horizontal en una estructura bidimensional.
     *
     * @param fila el nuevo valor para la fila.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Obtiene el número de columna.
     *
     * Este método devuelve el valor de la columna actual. La columna representa la posición vertical en una estructura 
     * de datos bidimensional, como un laberinto o una matriz.
     *
     * @return el número de columna.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Establece el número de columna.
     *
     * Este método permite asignar un nuevo valor a la columna. La columna es una coordenada que puede representar la 
     * posición vertical en una estructura bidimensional.
     *
     * @param columna el nuevo valor para la columna.
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Verifica si la celda ha sido visitada.
     *
     * Este método devuelve el estado de la variable `visita`, que indica si una celda ha sido visitada previamente. 
     * Un valor `true` significa que la celda ha sido visitada, y un valor `false` significa que no ha sido visitada.
     *
     * @return el estado de la celda: `true` si ha sido visitada, `false` si no ha sido visitada.
     */
    public boolean isVisita() {
        return visita;
    }

    /**
     * Establece el estado de la visita de la celda.
     *
     * Este método permite cambiar el estado de la variable `visita`, que indica si una celda ha sido visitada o no.
     * Un valor `true` indica que la celda ha sido visitada, y un valor `false` indica que no ha sido visitada.
     *
     * @param visita el nuevo estado de la visita de la celda.
     */
    public void setVisita(boolean visita) {
        this.visita = visita;
    }

    /**
     * Obtiene el estado de un botón de pared en una posición específica.
     *
     * Este método devuelve el valor de un botón de pared en un índice dado de la matriz `wallsButton`. 
     * Cada botón de pared puede indicar si una pared está presente o no en esa posición específica.
     *
     * @param indice el índice del botón de pared que se desea obtener.
     * @return el estado del botón de pared en el índice especificado: `true` si la pared está presente, `false` si no lo está.
     */
    public boolean getWallsButton(int indice) {
        return wallsButton[indice];
    }

    /**
     * Establece el estado de un botón de pared en una posición específica.
     *
     * Este método permite cambiar el valor de un botón de pared en el índice dado de la matriz `wallsButton`. 
     * El valor de `true` indica que la pared está presente, y `false` indica que la pared no está presente en esa posición.
     *
     * @param indice el índice del botón de pared que se desea modificar.
     * @param valor el nuevo valor para el botón de pared: `true` para indicar que la pared está presente, `false` para indicar lo contrario.
     */
    public void setWallsButton(int indice, boolean valor) {
        wallsButton[indice] = valor;
    }

    /**
     * Obtiene la matriz completa de botones de pared.
     *
     * Este método devuelve la matriz `wallsButton`, que contiene los estados de todos los botones de pared. 
     * Cada valor en la matriz indica si una pared está presente en esa posición específica.
     *
     * @return una matriz de tipo `boolean[]` que representa el estado de cada botón de pared.
     */
    public boolean[] getWallsButton() {
        return wallsButton;
    }

    /**
     * Establece la matriz de botones de pared.
     *
     * Este método permite asignar una nueva matriz `wallsButton` que representa los estados de todos los botones de pared.
     * Cada valor en la matriz indica si una pared está presente en la posición correspondiente.
     *
     * @param wallsButton la nueva matriz de botones de pared que se asignará.
     */
    public void setWallsButton(boolean[] wallsButton) {
        this.wallsButton = wallsButton;
    }

}
