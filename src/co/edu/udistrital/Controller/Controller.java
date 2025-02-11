package co.edu.udistrital.Controller;

import co.edu.udistrital.View.VentanaMenu;
import co.edu.udistrital.View.VentanaPrincipal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

/** 
 * Clase encargada de gestionar la union 
 * entre la logica e interfaz del programa.
 */
public class Controller implements ActionListener{

    /**
     * Atributo que instancia de VentanaMenu.
     * 
     * Se encarga de mostrar el menu principal del 
     * programa y elegir el tipo de proceso. 
     */
    private VentanaMenu ventanaMenu;
    /**
     * Atributo que instancia VentanaPrincipal.
     * 
     * Se encarga de mostrar el panel de juego y 
     * el panel de eleccion de dificultad.
     */
    private VentanaPrincipal ventanaJuego;

    /**
     * Atributo que determina las caracteristias del laberinto.
     * 
     * Tiene 5 indices los cuales se utilizan para:
     * 
     * {@code informacionParaGenerarMatriz[0]} para la cantidad de filas.
     * {@code informacionParaGenerarMatriz[1]} para la cantidad de columnas.
     * {@code informacionParaGenerarMatriz[2]} para el orden en el que se recorrera la matriz.
     * {@code informacionParaGenerarMatriz[3]} para la cantidad de puntos de control.
     * {@code informacionParaGenerarMatriz[4]} para la cantidad de bestias en el laberinto.
     */
    private int[] informacionParaGenerarMatriz;
    /**
     * Atributo encargado de determinar el orden en el que se 
     * recorrera la matriz.
     */
    private String configPuntos;

    /**
     * Metodo constructor de la clase.
     * 
     * Este metodo lanza un {@code IOException} si un archivo seleccionado
     * como fuente de texto no se encuentra.
     * Este metodo lanza un {@code FontFormatException} si el tipo de formato 
     * de la fuente de texto no es el correcto.
     * @throws IOException
     * @throws FontFormatException
     */
    public Controller() throws IOException, FontFormatException {
        ventanaMenu = new VentanaMenu();
        ventanaJuego = new VentanaPrincipal();

        informacionParaGenerarMatriz = new int[5];

        asignarOyentes();
    }
    /**
     * Metodo encargado de asignar metodos de escucha a los 
     * elementos que interactuan directamente con el usuario
     */
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
        ventanaJuego.getPanelDificultad().getFacil().addActionListener(this);
        ventanaJuego.getPanelDificultad().getMedio().addActionListener(this);
        ventanaJuego.getPanelDificultad().getDificil().addActionListener(this);

    }
    
    @Override
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
                atrasTutorial2();
                break;
            case "FACIL":
                facil();
                break;
            case "MEDIO":
                medio();
                break;
            case "DIFICIL":
                dificil();
                break;
            case "REINICIARJUEGO":
                    reiniciar();
            case "SALIR":
                salir();
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
                System.out.println("Celda (" + comandoArray[1] + ", " + comandoArray[2] + ") ha sido presionada");
                System.out.println(ventanaJuego.getLaberinto().getMazeModel().getGrid()[Integer.parseInt(comandoArray[1])][Integer.parseInt(comandoArray[2])].getWalls());
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
    public void atrasTutorial2(){
        ventanaJuego.cerrarTutorial();
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
    }

    public void facil() {
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
        ventanaJuego.getReiniciar().setVisible(true);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().addActionListener(this);

    }

    public void medio(){

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
        ventanaJuego.getReiniciar().setVisible(true);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().addActionListener(this);

    }
    public void dificil(){
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
        ventanaJuego.getReiniciar().setVisible(true);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getReiniciar().addActionListener(this);

    }
    public void reiniciar() {

    }

    public void salir () {
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
            ventanaJuego.getReiniciar().setVisible(true);
            ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
            ventanaJuego.getSalir().addActionListener(this);
            ventanaJuego.getReiniciar().addActionListener(this);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al generar la matriz");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Todos los valores ingresados deben ser números");
        }

    }

    public void volver() {
        ventanaJuego.setVisible(false);
        ventanaMenu.setVisible(true);
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
