package co.edu.udistrital.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.udistrital.Model.ControlDeMovimientos;
import co.edu.udistrital.View.VentanaMenu;
import co.edu.udistrital.View.VentanaPrincipal;

import javax.swing.*;

public class Controller implements ActionListener{
    private VentanaMenu ventanaMenu;
    private VentanaPrincipal ventanaJuego;
    private int[] informacionParaGenerarMatriz;
    private String configPuntos;
    private static int numMovimientos;


    public Controller() throws IOException, FontFormatException {
        ventanaMenu = new VentanaMenu();
        ventanaJuego = new VentanaPrincipal();

        informacionParaGenerarMatriz = new int[5];

        asignarOyentes();
    }

    public void asignarOyentes() {
        ventanaMenu.getMenu().getJugar().addActionListener(this);
        ventanaMenu.getMenu().getTutorial().addActionListener(this);
        ventanaMenu.getMenu().getSalir().addActionListener(this);

        ventanaJuego.getPanelDificultad().getCheckpoints2().addActionListener(this);
        ventanaJuego.getPanelDificultad().getCheckpoints3().addActionListener(this);
        ventanaJuego.getPanelDificultad().getCheckpoints4().addActionListener(this);
        ventanaJuego.getPanelDificultad().getCheckpoints5().addActionListener(this);
        ventanaJuego.getPanelDificultad().getEnviar().addActionListener(this);
        ventanaJuego.getPanelDificultad().getVolver().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        String[] comandoArray = e.getActionCommand().split(" ");
        String comando = comandoArray[0];
        switch (comando) {
            case "JUGAR":
                jugar();
                break;
            case "TUTORIAL1":
                tutorial1();
                break;
            case "TUTORIAL2":
                try {
                    tutorial2();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "ATRASTUTORIAL1":
                atrasTutorial1();
                break;
            case "ATRASTUTORIAL2":
                try {
                    atrasTutorial2();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "SALIR":
                salir();
                break;
            case "FACIL":
                try {
                    facil();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "MEDIO":
                try {
                    medio();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "DIFICIL":
                try {
                    dificil();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "CHECKPOINTS2":
                checkpoints2();
                break;
            case "CHECKPOINTS3":
                checkpoints3();
                break;
            case "CHECKPOINTS4":
                checkpoints4();
                break;
            case "CHECKPOINTS5":
                checkpoints5();
                break;
            case "ENVIAR":
                enviar();
                break;
            case "BOTON":
                modificarPosicion(Integer.parseInt(comandoArray[1]), Integer.parseInt(comandoArray[2]));
                break;
            case "VOLVER":
                volver();
                break;
        }

    }
    /**
     * Metodo encargado de mostrar la ventana de juego
     */
    public void jugar() {
        ventanaMenu.setVisible(false);
        ventanaJuego.setVisible(true);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().setVisible(false);
        ventanaJuego.getPanelDificultad().getFacil().addActionListener(this);
        ventanaJuego.getPanelDificultad().getMedio().addActionListener(this);
        ventanaJuego.getPanelDificultad().getDificil().addActionListener(this);
    }


    /**
     * Metodo encargado de mostrar el tutorial en el menu
     */
    public void tutorial1()   {
        ventanaMenu.mostrarTutorial();
        ventanaMenu.getPanelTutorialTitulo1().getAtras().addActionListener(this);
    }

    /**
     * Metodo encargado de mostrar el tutorial en el juego
     */
    public void tutorial2() throws IOException, FontFormatException {
        ventanaJuego.mostrarTutorial();
        ventanaJuego.getPanelTutorialTitulo2().getAtras().addActionListener(this);
    }
    /**
     * Metodo encargado de salir del tutorial en el menu
     */
    public void atrasTutorial1(){
        ventanaMenu.cerrarTutorial();
    }

    /**
     * Metodo encargado de salir del tutorial en el juego
     */
    public void atrasTutorial2() throws IOException, FontFormatException {
        ventanaJuego.cerrarTutorial();
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
    }

    public void facil() throws IOException, FontFormatException {
        informacionParaGenerarMatriz[0] = 5;  //filas
        informacionParaGenerarMatriz[1] = 5;  //columnas
        configPuntos = "orden";
        informacionParaGenerarMatriz[3] = 2;   //cantidad puntos
        informacionParaGenerarMatriz[2] = 1;   //orden de puntos
        informacionParaGenerarMatriz[4] = 1;    //bestias
        ventanaJuego.getPanelDificultad().setVisible(false);
        ventanaJuego.agregarPanelImagenMatriz(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        for(int i = 0; i < ventanaJuego.getLaberinto().getMazeModel().getGrid().length; i++){
            for(int j = 0; j < ventanaJuego.getLaberinto().getMazeModel().getGrid()[0].length; j++){
                ventanaJuego.getLaberinto().getMazeModel().getGrid()[i][j].addActionListener(this);
            }
        }
        ControlDeMovimientos.asignarJugadorPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        ControlDeMovimientos.asignarCarroPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        ControlDeMovimientos.asignarCheckPoints(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1],informacionParaGenerarMatriz[3]);
        ControlDeMovimientos.asignarOrdenCheckPoints(informacionParaGenerarMatriz[2]);
        ventanaJuego.getReiniciar().setVisible(true);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().addActionListener(this);
    }

    public void medio() throws IOException, FontFormatException {

        informacionParaGenerarMatriz[0] = 12;
        informacionParaGenerarMatriz[1] = 12;
        informacionParaGenerarMatriz[3] = 4;
        informacionParaGenerarMatriz[2] = 1;
        informacionParaGenerarMatriz[4] = 4;
        ventanaJuego.getPanelDificultad().setVisible(false);
        ventanaJuego.agregarPanelImagenMatriz(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        for(int i = 0; i < ventanaJuego.getLaberinto().getMazeModel().getGrid().length; i++){
            for(int j = 0; j < ventanaJuego.getLaberinto().getMazeModel().getGrid()[0].length; j++){
                ventanaJuego.getLaberinto().getMazeModel().getGrid()[i][j].addActionListener(this);
            }
        }
        ControlDeMovimientos.asignarJugadorPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        ControlDeMovimientos.asignarCarroPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        ControlDeMovimientos.asignarCheckPoints(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1],informacionParaGenerarMatriz[3]);
        ControlDeMovimientos.asignarOrdenCheckPoints(informacionParaGenerarMatriz[2]);
        ventanaJuego.getReiniciar().setVisible(true);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().addActionListener(this);

    }
    public void dificil() throws IOException, FontFormatException {
        informacionParaGenerarMatriz[0] = 20;
        informacionParaGenerarMatriz[1] = 20;
        informacionParaGenerarMatriz[3] = 5;
        informacionParaGenerarMatriz[2] = 2;
        informacionParaGenerarMatriz[4] = 10;
        ventanaJuego.getPanelDificultad().setVisible(false);
        ventanaJuego.agregarPanelImagenMatriz(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        for(int i = 0; i < ventanaJuego.getLaberinto().getMazeModel().getGrid().length; i++){
            for(int j = 0; j < ventanaJuego.getLaberinto().getMazeModel().getGrid()[0].length; j++){
                ventanaJuego.getLaberinto().getMazeModel().getGrid()[i][j].addActionListener(this);
            }
        }
        ControlDeMovimientos.asignarJugadorPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        ControlDeMovimientos.asignarCarroPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
        ControlDeMovimientos.asignarCheckPoints(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1],informacionParaGenerarMatriz[3]);
        ControlDeMovimientos.asignarOrdenCheckPoints(informacionParaGenerarMatriz[2]);
        ventanaJuego.getReiniciar().setVisible(true);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().addActionListener(this);

    }
    public void reiniciar() {}


    public void salir() {
        JOptionPane.showMessageDialog(null, "Gracias por jugar");
        System.exit(0);
    }

    public void checkpoints2() {
        informacionParaGenerarMatriz[3] = 2;
    }

    public void checkpoints3() {
        informacionParaGenerarMatriz[3] = 3;
    }

    public void checkpoints4() {
        informacionParaGenerarMatriz[3] = 4;
    }

    public void checkpoints5() {
        informacionParaGenerarMatriz[3] = 5;
    }

    public void enviar() {
        try {
            informacionParaGenerarMatriz[0] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtdimensionMatrizFilas().getText());
            informacionParaGenerarMatriz[1] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtdimensionMatrizColumnas().getText());
            configPuntos = ventanaJuego.getPanelDificultad().getComboConfiguracionPuntos().getSelectedItem().toString();
            if (configPuntos.equals("orden")){
                informacionParaGenerarMatriz[2]=1;
            }else{
                informacionParaGenerarMatriz[2]=2;
            }
            informacionParaGenerarMatriz[4] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtcantidadBestias().getText());
            if(informacionParaGenerarMatriz[0]>4 && informacionParaGenerarMatriz[1]>4 && informacionParaGenerarMatriz[0]<21 && informacionParaGenerarMatriz[1]<21) {
                ventanaJuego.getPanelDificultad().setVisible(false);
                ventanaJuego.agregarPanelImagenMatriz(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
                for(int i = 0; i < ventanaJuego.getLaberinto().getMazeModel().getGrid().length; i++){
                    for(int j = 0; j < ventanaJuego.getLaberinto().getMazeModel().getGrid()[0].length; j++){
                        ventanaJuego.getLaberinto().getMazeModel().getGrid()[i][j].addActionListener(this);
                    }
                }
                ControlDeMovimientos.asignarJugadorPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
                ControlDeMovimientos.asignarCarroPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
                ControlDeMovimientos.asignarCheckPoints(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1],informacionParaGenerarMatriz[3]);
                ControlDeMovimientos.asignarOrdenCheckPoints(informacionParaGenerarMatriz[2]);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al generar la matriz");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Todos los valores ingresados deben ser números");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }

    }

    public void volver() {
        ventanaJuego.setVisible(false);
        ventanaMenu.setVisible(true);
    }

    public void modificarPosicion(int x, int y) {
        int jugadorX = ControlDeMovimientos.getPosicionJugador()[0];
        int jugadorY = ControlDeMovimientos.getPosicionJugador()[1];

        if ((Math.abs(jugadorX - x) == 1 && jugadorY == y) ||
            (Math.abs(jugadorY - y) == 1 && jugadorX == x)) {
            numMovimientos = ventanaJuego.getPanelInformacion().modificarMovimientosPenalizacion(ControlDeMovimientos.moverJugador(x, y));
            numMovimientos = ventanaJuego.getPanelInformacion().modificarMovimientos();
        }
    }

    public VentanaMenu getVentanaMenu() {
        return ventanaMenu;
    }

    public void setVentanaMenu(VentanaMenu ventanaMenu) {
        this.ventanaMenu = ventanaMenu;
    }

    public VentanaPrincipal getVentanaJuego() {
        return ventanaJuego;
    }

    public void setVentanaJuego(VentanaPrincipal ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    public int[] getInformacionParaGenerarMatriz() {
        return informacionParaGenerarMatriz;
    }

    public void setInformacionParaGenerarMatriz(int[] informacionParaGenerarMatriz) {
        this.informacionParaGenerarMatriz = informacionParaGenerarMatriz;
    }
}
