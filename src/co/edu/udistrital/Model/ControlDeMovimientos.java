package co.edu.udistrital.Model;

import java.util.Random;
import javax.swing.*;

/**
 * Clase encargada del control de movimientos
 * del jugador y los elementos dentro de la matriz de juego.
 */
public class ControlDeMovimientos {
    /**
     * Atributo que contiene la ubicacion de los checkpoints en el laberinto.
     */
    private static int[][] checkpointsPosicion;
    /**
     * Atributo que contiene la condicion de los 
     * checkpoints (encontrado o no encontrado).
     */
    private static boolean[] checkpointsEncontrados;
    /**
     * Atributo que contiene la ubicacion del jugador en el laberinto. 
     */
    private static int[] posicionJugador;
    /**
     * Atributo que contiene la ubicacion del carro en el laberinto.
     */
    private static int[] posicionCarro;
    /**
     * Atributo que contiene el numero de filas de la matriz.
     */
    private static int numeroFilasGlobal;
    /**
     * Atributo que contiene la condicion del carro
     * (en el carro o no).
     */
    private static boolean jugadorEnCarro = false;
    /**
     * Metodo que genera la posicion del jugador en el laberinto.
     * 
     * @param numeroFilas
     * Las filas de la matriz del laberinto.
     * @param numeroColumnas
     * Las columnas de la matriz del laberinto.
     */
    public static void asignarJugadorPosicion(int numeroFilas, int numeroColumnas) {
        Random rand = new Random();
        posicionJugador = new int[2];

        numeroFilasGlobal = numeroFilas;

        int x = rand.nextInt(numeroFilas);
        int y = rand.nextInt(numeroColumnas);

        posicionJugador[0] = x;
        posicionJugador[1] = y;

        String pathToGif =  pathToGifImageFunction(numeroFilas, "Personaje", ".gif");

        JButton botonJugador = MazeModel.getGrid()[x][y];
        setButtonGifJpg(botonJugador, pathToGif);
    }
    /**
     * Metodo que genera la posicion del carro en el laberinto.
     * 
     * @param numeroFilas
     * Numero de filas de la matriz del laberinto.
     * @param numeroColumnas
     * Numero de columnas de la matriz del laberinto
     */
    public static void asignarCarroPosicion(int numeroFilas, int numeroColumnas) {
        Random rand = new Random();
        posicionCarro = new int[2];

        int x = rand.nextInt(numeroFilas);
        int y = rand.nextInt(numeroColumnas);

        while(x == posicionCarro[0] || y == posicionCarro[1]) {
            x = rand.nextInt(numeroFilas);
            y = rand.nextInt(numeroColumnas);
        }

        posicionCarro[0] = x;
        posicionCarro[1] = y;

        String pathToGif =  pathToGifImageFunction(numeroFilas, "Carro", ".png");

        JButton botonCarro = MazeModel.getGrid()[x][y];
        setButtonGifJpg(botonCarro, pathToGif);
    }

    
    /**
     * Metodo que asigna la posicion y la cantidad de los checkpoints.
     * 
     * @param numeroFilas
     * Cantidad de filas en la matriz de juego.
     * @param numeroColumnas
     * Cantidad de columnas en la matriz de juego.
     * @param numeroCheckPoints
     * Cantidad de checkpoints en la matriz de juego.
     */
    public static void asignarCheckPoints(int numeroFilas, int numeroColumnas, int numeroCheckPoints) {
        checkpointsPosicion = new int[numeroCheckPoints][2];
        checkpointsEncontrados = new boolean[numeroCheckPoints];
        Random rand = new Random();
        for(int i = 0; i < numeroCheckPoints; i++) {
            int x = rand.nextInt(numeroFilas);
            int y = rand.nextInt(numeroColumnas);

            while(x == posicionJugador[0] || y == posicionJugador[1] || x == posicionCarro[0] || y == posicionCarro[1]) {
                x = rand.nextInt(numeroFilas);
                y = rand.nextInt(numeroColumnas);
            }

            JButton botonCheckPoint = MazeModel.getGrid()[x][y];
            String pathToImage = pathToGifImageFunction(numeroFilas, "Checkpoint", ".png");
            setButtonGifJpg(botonCheckPoint, pathToImage);

            checkpointsPosicion[i][0] = x;
            checkpointsPosicion[i][1] = y;
            checkpointsEncontrados[i] = false;
        }
        for(int i = 0; i < checkpointsPosicion.length; i++) {
            System.out.println("Checkpoints en: " + checkpointsPosicion[i][0] + ", " + checkpointsPosicion[i][1]);
        }

    }
    /**
     * Metodo encargado de gestionar el orden en el que se recorren los checkpoints.
     * 
     * @param ordenDefinido El orden por el que se recorren los checpoints
     *  Si tiene el valor de 1, se recorre en orden.
     *  Si tiene el valor de 2, se recorre en orden inverso.
     */
    public static void asignarOrdenCheckPoints(int ordenDefinido) {
        if(ordenDefinido != 1) {
            for (int i = 0; i < checkpointsEncontrados.length / 2; i++) {
                boolean temp = checkpointsEncontrados[i];
                checkpointsEncontrados[i] = checkpointsEncontrados[checkpointsEncontrados.length - 1 - i];
                checkpointsEncontrados[checkpointsEncontrados.length - 1 - i] = temp;

                int[] temp2 = checkpointsPosicion[i];
                checkpointsPosicion[i] = checkpointsPosicion[checkpointsPosicion.length - 1 - i];
                checkpointsPosicion[checkpointsPosicion.length - 1 - i] = temp2;
            }

        }
    }
    /**
     * Metodo encargado de colocar las imagenes a los checkpoints.
     */
    public static void renderizarCheckpoints() {
        for(int i = 0; i < checkpointsPosicion.length; i++) {
            if(!checkpointsEncontrados[i]) {
                JButton botonCheckPoint = MazeModel.getGrid()[checkpointsPosicion[i][0]][checkpointsPosicion[i][1]];
                String pathToImage = pathToGifImageFunction(numeroFilasGlobal, "Checkpoint", ".png");
                setButtonGifJpg(botonCheckPoint, pathToImage);
            }
        }
    }
    /**
     * Metodo encargado de colocar el tamaño de las imagenes, segun 
     * la cantidad de filas de la matriz.
     * 
     * @param numeroFilas
     * La cantidad de filas de la matriz.
     * @param fileName
     * El nombre del archivo de la imagen del personaje.
     * @param extension
     * El nombre de la extension del archivo.
     * @return  la imagen ajustada al tamaño correcto.
     */
    public static String pathToGifImageFunction(int numeroFilas, String fileName, String extension) {
        String pathToGif = "";
        if(numeroFilas >= 5 && numeroFilas < 10) {
            pathToGif = "/co/edu/udistrital/Resources/Personajes/" + fileName + "5" + extension;
        } if(numeroFilas >= 10 && numeroFilas < 15) {
            pathToGif = "/co/edu/udistrital/Resources/Personajes/"+ fileName + "10" + extension;
        } if(numeroFilas >= 15 && numeroFilas <= 20) {
            pathToGif = "/co/edu/udistrital/Resources/Personajes/"+ fileName + "15" + extension;
        }
        return pathToGif;
    }
    /**
     * 
     * @param button
     * @param gifPath
     */
    private static void setButtonGifJpg(JButton button, String gifPath) {
        ImageIcon gifIcon = new ImageIcon(ControlDeMovimientos.class.getResource(gifPath));
        button.setIcon(gifIcon);
        SwingUtilities.invokeLater(() -> {
            int width = button.getWidth();
            int height = button.getHeight();
        });
    }
    /**
     * Metodo encargado de cambiar la posicion del jugador.
     * @param x
     * La fila en la que se encuentra el jugador.
     * @param y
     * La columna en la que se encuentra el jugador.
     * @return
     * La nueva posicion del jugador.
     */
    public static int moverJugador(int x, int y) {
        JButton botonJugador = MazeModel.getGrid()[posicionJugador[0]][posicionJugador[1]];
        botonJugador.setIcon(null);
        JButton botonNuevo = MazeModel.getGrid()[x][y];
        int esPosible = determinarMurosPenalizacion(x, y);
        if(MazeModel.getGrid()[x][y].getIcon() != null) {
            if(MazeModel.getGrid()[x][y].getIcon().toString().contains("Checkpoint")) {
                if(jugadorEnCarro) {
                    for(int i = 0; i < checkpointsPosicion.length; i++) {
                        if(checkpointsPosicion[i][0] == x && checkpointsPosicion[i][1] == y) {
                            boolean allCheckpointsFound = true;
                            for(int j = 0; j < i; j++) {
                                if(!checkpointsEncontrados[j]) {
                                    allCheckpointsFound = false;
                                    break;
                                }
                            }
                            if(allCheckpointsFound) {
                                String pathToJpgInCar = pathToGifImageFunction(numeroFilasGlobal, "CheckpointCar+1-", ".png");
                                setButtonGifJpg(botonNuevo, pathToJpgInCar);
                                checkpointsEncontrados[i] = true;
                            } else {
                                String pathToJpgInCar = pathToGifImageFunction(numeroFilasGlobal, "InCar", ".png");
                                setButtonGifJpg(botonNuevo, pathToJpgInCar);
                            }
                        }
                    }
                } else {
                    String pathToGif = pathToGifImageFunction(numeroFilasGlobal, "Personaje", ".gif");
                    setButtonGifJpg(botonNuevo, pathToGif);
                }
            } else if(MazeModel.getGrid()[x][y].getIcon().toString().contains("Carro")) {
                String pathToJpgInCar = pathToGifImageFunction(numeroFilasGlobal, "InCar", ".png");
                System.out.println(pathToJpgInCar);
                setButtonGifJpg(botonNuevo, pathToJpgInCar);
                jugadorEnCarro = true;
            }
        } else {
            renderizarCheckpoints();
            if(jugadorEnCarro) {
                String pathToJpgInCar = pathToGifImageFunction(numeroFilasGlobal, "InCar", ".png");
                setButtonGifJpg(botonNuevo, pathToJpgInCar);
            } else {
                String pathToGif = pathToGifImageFunction(numeroFilasGlobal, "Personaje", ".gif");
                setButtonGifJpg(botonNuevo, pathToGif);
            }

        }
        posicionJugador[0] = x;
        posicionJugador[1] = y;

        return esPosible;
    }

    public static int determinarMurosPenalizacion(int x, int y) {
        int filasMovimiento = x - posicionJugador[0];
        int columnasMovimiento = y - posicionJugador[1];

        if(columnasMovimiento == 0) {
            if(filasMovimiento < x) {
                if(MazeModel.getGrid()[posicionJugador[0]][posicionJugador[1]].getWalls().contains("ARRIBA")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            } else if(filasMovimiento > x) {
                if(MazeModel.getGrid()[posicionJugador[0]][posicionJugador[1]].getWalls().contains("ABAJO")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            }
        } else if (filasMovimiento == 0) {
            if(y > posicionJugador[1]) {
                if(MazeModel.getGrid()[posicionJugador[0]][posicionJugador[1]].getWalls().contains("DERECHA")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            } else if (y < posicionJugador[1]) {
                if(MazeModel.getGrid()[posicionJugador[0]][posicionJugador[1]].getWalls().contains("IZQUIERDA")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            }
        }

        return 0;

    }

    public static int[][] getCheckpointsPosicion() {
        return checkpointsPosicion;
    }

    public static void setCheckpointsPosicion(int[][] checkpointsPosicion) {
        ControlDeMovimientos.checkpointsPosicion = checkpointsPosicion;
    }

    public static int[] getPosicionJugador() {
        return posicionJugador;
    }

    public static void setPosicionJugador(int[] posicionJugador) {
        ControlDeMovimientos.posicionJugador = posicionJugador;
    }
}