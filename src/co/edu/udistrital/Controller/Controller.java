package co.edu.udistrital.Controller;

import co.edu.udistrital.Model.ControlDeMovimientos;
import co.edu.udistrital.Model.MazeModel;
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
     * Atributo que contiene la cantidad de movimientos
     * del jugador en el laberinto.
     */
    private static int numMovimientos;

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
            case "REINICIARJUEGO":
                reiniciar();
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
     * Metodo encargado de mostrar la ventana de juego.
     */
    public void jugar() {
        ventanaMenu.setVisible(false);
        ventanaJuego.setVisible(true);
        ventanaJuego.getSalir().addActionListener(this);
        ventanaJuego.getPanelDificultad().getFacil().addActionListener(this);
        ventanaJuego.getPanelDificultad().getMedio().addActionListener(this);
        ventanaJuego.getPanelDificultad().getDificil().addActionListener(this);
    }


    /**
     * Metodo encargado de mostrar el tutorial en el menu.
     */
    public void tutorial1()   {
        ventanaMenu.mostrarTutorial();
        ventanaMenu.getPanelTutorialTitulo1().getAtras().addActionListener(this);
    }

    /**
     * Metodo encargado de mostrar el tutorial en el juego.
     */
    public void tutorial2() throws IOException, FontFormatException {
        ventanaJuego.mostrarTutorial();
        ventanaJuego.getPanelTutorialTitulo2().getAtras().addActionListener(this);
    }
    /**
     * Metodo encargado de salir del tutorial en el menu.
     */
    public void atrasTutorial1(){
        ventanaMenu.cerrarTutorial();
    }

    /**
     * Metodo encargado de salir del tutorial en el juego.
     */
    public void atrasTutorial2() throws IOException, FontFormatException {
        ventanaJuego.cerrarTutorial();
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
    }

    /**
     * Metodo encargado de gestionar la dificultad "Facil".
     */
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
        ControlDeMovimientos.asignarBestias(informacionParaGenerarMatriz[0], informacionParaGenerarMatriz[1], informacionParaGenerarMatriz[4]);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);
    }
    /**
     * Metodo encargado de gestionar la dificultad "Media".
     */
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
        ControlDeMovimientos.asignarBestias(informacionParaGenerarMatriz[0], informacionParaGenerarMatriz[1], informacionParaGenerarMatriz[4]);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);

    }

    /**
     * Metodo encargado de gestionar la dificultad "Dificil".
     */
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
        ControlDeMovimientos.asignarBestias(informacionParaGenerarMatriz[0], informacionParaGenerarMatriz[1], informacionParaGenerarMatriz[4]);
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
        ventanaJuego.getSalir().addActionListener(this);

    }
    
    
    public void reiniciar() {

    }
    /**
     * Metodo encargado de dar la opcion de salir del programa.
     */
    public void salir () {
        JOptionPane.showMessageDialog(null, "Gracias por jugar");
        System.exit(0);
    }
    /**
     * Metodo encargado de generar un cantidad determinada
     * de checkpoints.
     * 
     * En este caso la cantidad de checkpoints es de 2.
     */
    public void checkpoints2() {
        informacionParaGenerarMatriz[3] = 2;
    }
    /**
     * Metodo encargado de generar un cantidad determinada
     * de checkpoints.
     * 
     * En este caso la cantidad de checkpoints es de 3.
     */
    public void checkpoints3() {
        informacionParaGenerarMatriz[3] = 3;
    }
    /**
     * Metodo encargado de generar un cantidad determinada
     * de checkpoints.
     * 
     * En este caso la cantidad de checkpoints es de 4.
     */
    public void checkpoints4() {
        informacionParaGenerarMatriz[3] = 4;
    }
    /**
     * Metodo encargado de generar un cantidad determinada
     * de checkpoints.
     * 
     * En este caso la cantidad de checkpoints es de 5.
     */
    public void checkpoints5() {
        informacionParaGenerarMatriz[3] = 5;
    }
    /**
     * Metodo encargado de captar las entradas del
     * usuario, para posteriormente almacenarlos.
     */
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
                for(int i = 0; i < MazeModel.getGrid().length; i++){
                    for(int j = 0; j < MazeModel.getGrid()[0].length; j++){
                        ventanaJuego.getLaberinto().getMazeModel().getGrid()[i][j].addActionListener(this);
                    }
                }
                ControlDeMovimientos.asignarJugadorPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
                ControlDeMovimientos.asignarCarroPosicion(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1]);
                ControlDeMovimientos.asignarCheckPoints(informacionParaGenerarMatriz[0],informacionParaGenerarMatriz[1],informacionParaGenerarMatriz[3]);
                ControlDeMovimientos.asignarOrdenCheckPoints(informacionParaGenerarMatriz[2]);
                ControlDeMovimientos.asignarBestias(informacionParaGenerarMatriz[0], informacionParaGenerarMatriz[1], informacionParaGenerarMatriz[4]);
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
    /**
     * Metodo encargado de cambiar entre la ventana 
     * de juego y la ventada de menu.
     */
    public void volver() {
        ventanaJuego.setVisible(false);
        ventanaMenu.setVisible(true);
    }
    /**
     * Metodo encargado de modificar la posicion del jugador 
     * en la matriz del juego.
     * @param x
     * Fila en la que se encuentra el jugador.
     * @param y
     * Columna en la que se encuentra el jugador.
     */
    public void modificarPosicion(int x, int y) {
        int jugadorX = ControlDeMovimientos.getPosicionJugador()[0];
        int jugadorY = ControlDeMovimientos.getPosicionJugador()[1];

        if(jugadorY != y || jugadorX != x) {
            if ((Math.abs(jugadorX - x) == 1 && jugadorY == y) ||
                (Math.abs(jugadorY - y) == 1 && jugadorX == x)) {
                numMovimientos = ventanaJuego.getPanelInformacion().modificarMovimientosPenalizacion(ControlDeMovimientos.moverJugador(x, y));
                numMovimientos = ventanaJuego.getPanelInformacion().modificarMovimientos();
                if(numMovimientos <= 0) {
                    JOptionPane.showMessageDialog(null, "Te has quedado sin movimientos 😥.");
                    System.exit(0);
                }
                ControlDeMovimientos.verificarGanador();
                ControlDeMovimientos.moverBestiasUnaCasilla();
                numMovimientos = ventanaJuego.getPanelInformacion().modificarMovimientosPenalizacion(ControlDeMovimientos.verificarSiEstaEnCasillaAdyacenteBestiayJugador());
            }
        }
    }

    /**
     * Obtiene el valor del atributo `ventanaMenu`.
     * 
     * @return La ventana del menú actual (de tipo `VentanaMenu`).
     */
    public VentanaMenu getVentanaMenu() {
        return ventanaMenu;
    }

    /**
     * Establece el valor del atributo `ventanaMenu`.
     * 
     * @param ventanaMenu El valor deseado para la ventana del menú.
     */
    public void setVentanaMenu(VentanaMenu ventanaMenu) {
        this.ventanaMenu = ventanaMenu;
    }

    /**
     * Obtiene el valor del atributo `ventanaJuego`.
     * 
     * @return La ventana del juego actual (de tipo `VentanaPrincipal`).
     */
    public VentanaPrincipal getVentanaJuego() {
        return ventanaJuego;
    }

    /**
     * Establece el valor del atributo `ventanaJuego`.
     * 
     * @param ventanaJuego El valor deseado para la ventana del juego.
     */
    public void setVentanaJuego(VentanaPrincipal ventanaJuego) {
        this.ventanaJuego = ventanaJuego;
    }

    /**
     * Obtiene el valor del atributo `informacionParaGenerarMatriz`.
     * 
     * @return Un arreglo de enteros que contiene la información necesaria para generar la matriz.
     */
    public int[] getInformacionParaGenerarMatriz() {
        return informacionParaGenerarMatriz;
    }

    /**
     * Establece el valor del atributo `informacionParaGenerarMatriz`.
     * 
     * @param informacionParaGenerarMatriz Un arreglo de enteros con la información para generar la matriz.
     */
    public void setInformacionParaGenerarMatriz(int[] informacionParaGenerarMatriz) {
        this.informacionParaGenerarMatriz = informacionParaGenerarMatriz;
    }

}
