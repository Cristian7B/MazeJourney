package co.edu.udistrital.Model;

import co.edu.udistrital.View.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Clase encargada de el control de movimientos
 * del jugador y los elementos dentro de la matriz de juego.
 */
public class ControlDeMovimientos {
    private static int[][] checkpointsPosicion;
    private static int[][] bestiasPosicionMover;
    private static boolean[] checkpointsEncontrados;
    private static int[] posicionJugador;
    private static int[] posicionCarro;
    private static int numeroFilasGlobal;
    private static boolean jugadorEnCarro = false;

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

    public static void verificarGanador() {
        boolean variable = true;
        for (int i = 0; i < checkpointsEncontrados.length;i++) {
            if(!checkpointsEncontrados[i]) {
                variable = false;
            }
        }

        if(variable) {
            JOptionPane.showMessageDialog(null, "Has ganado 😃");
            System.exit(0);
        }
    }


    public static void asignarCheckPoints(int numeroFilas, int numeroColumnas, int numeroCheckPoints) {
        checkpointsPosicion = new int[numeroCheckPoints][2];
        checkpointsEncontrados = new boolean[numeroCheckPoints];
        Random rand = new Random();
        for(int i = 0; i < numeroCheckPoints; i++) {
            int x = rand.nextInt(numeroFilas);
            int y = rand.nextInt(numeroColumnas);

            while((x == posicionJugador[0] && y == posicionJugador[1]) || (x == posicionCarro[0] && y == posicionCarro[1])) {
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

    public static void asignarBestias(int numeroFilas, int numeroColumnas, int numeroBestias) {
        Random rand = new Random();
        bestiasPosicionMover = new int[numeroBestias][2];
        for(int i = 0; i < numeroBestias; i++) {
            int x = rand.nextInt(numeroFilas);
            int y = rand.nextInt(numeroColumnas);

            while((x == posicionJugador[0] && y == posicionJugador[1]) || (x == posicionCarro[0] && y == posicionCarro[1])) {
                x = rand.nextInt(numeroFilas);
                y = rand.nextInt(numeroColumnas);
            }

            JButton botonBestia = MazeModel.getGrid()[x][y];
            String pathToImage = "";
            if(i%2 == 0) {
                pathToImage = pathToGifImageFunction(numeroFilas, "Letal", ".png");
            } else {
                pathToImage = pathToGifImageFunction(numeroFilas, "Tormentoso", ".png");
            }
            setButtonGifJpg(botonBestia, pathToImage);
            bestiasPosicionMover[i][0] = x;
            bestiasPosicionMover[i][1] = y;
        }
    }

    public static void moverBestiasUnaCasilla() {
        Random rand = new Random();
        for(int i = 0; i < bestiasPosicionMover.length; i++) {

            int x = bestiasPosicionMover[i][0];
            int y = bestiasPosicionMover[i][1];

            JButton botonBestia = MazeModel.getGrid()[x][y];
            botonBestia.setIcon(null);

            int num = rand.nextInt(3) - 1;
            if(x+num > 0 && x+num < numeroFilasGlobal) {
                bestiasPosicionMover[i][0] = x + num;
            }
            if(y+num > 0 && y+num < numeroFilasGlobal) {
                bestiasPosicionMover[i][1] = y + num;
            }
            botonBestia = MazeModel.getGrid()[bestiasPosicionMover[i][0]][bestiasPosicionMover[i][1]];

            String pathToImage = "";
            if(i%2 == 0) {
                pathToImage = pathToGifImageFunction(numeroFilasGlobal, "Letal", ".png");
            } else {
                pathToImage = pathToGifImageFunction(numeroFilasGlobal, "Tormentoso", ".png");
            }
            setButtonGifJpg(botonBestia, pathToImage);
        }
    }

    public static int verificarSiEstaEnCasillaAdyacenteBestiayJugador() {
        for(int i = 0; i < bestiasPosicionMover.length; i++) {
            if ((Math.abs(bestiasPosicionMover[i][0] - posicionJugador[0]) == 1 && bestiasPosicionMover[i][1] == posicionJugador[1]) ||
                    (Math.abs(bestiasPosicionMover[i][1] - posicionJugador[1]) == 1 && bestiasPosicionMover[i][0] == posicionJugador[0])) {
                if(MazeModel.getGrid()[bestiasPosicionMover[i][0]][bestiasPosicionMover[i][1]].getIcon().toString().contains("Letal")) {
                    JOptionPane.showMessageDialog(null, "Has sido atrapado por una bestia, has perdido");
                    System.exit(0);
                } else {
                    return (int) Math.floor(0.95 * VentanaPrincipal.getNumMovimientos());
                }
            }

        }
        return 0;
    }

    public static void renderizarCheckpoints() {
        for(int i = 0; i < checkpointsPosicion.length; i++) {
            if(!checkpointsEncontrados[i]) {
                JButton botonCheckPoint = MazeModel.getGrid()[checkpointsPosicion[i][0]][checkpointsPosicion[i][1]];
                String pathToImage = pathToGifImageFunction(numeroFilasGlobal, "Checkpoint", ".png");
                setButtonGifJpg(botonCheckPoint, pathToImage);
            }
        }
    }

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

    private static void setButtonGifJpg(JButton button, String gifPath) {
        ImageIcon gifIcon = new ImageIcon(ControlDeMovimientos.class.getResource(gifPath));
        button.setIcon(gifIcon);
        SwingUtilities.invokeLater(() -> {
            int width = button.getWidth();
            int height = button.getHeight();
        });
    }

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
        int jugadorX = posicionJugador[0];
        int jugadorY = posicionJugador[1];

        if (y == jugadorY) {
            if (x < jugadorX) {
                if (MazeModel.getGrid()[x][y].getWalls().contains("ABAJO")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            } else if (x > jugadorX) {
                if (MazeModel.getGrid()[jugadorX][jugadorY].getWalls().contains("ABAJO")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            }
        }
        else if (x == jugadorX) {
            if (y > jugadorY) {
                if (MazeModel.getGrid()[jugadorX][jugadorY].getWalls().contains("DERECHA")) {
                    return posicionJugador[1] + posicionJugador[0];
                }
            } else if (y < jugadorY) {
                if (MazeModel.getGrid()[jugadorX][jugadorY].getWalls().contains("IZQUIERDA")) {
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