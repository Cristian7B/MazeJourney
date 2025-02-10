package co.edu.udistrital.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.udistrital.View.VentanaMenu;
import co.edu.udistrital.View.VentanaPrincipal;

import javax.swing.*;

public class Controller implements ActionListener{
    private VentanaMenu ventanaMenu;
    private VentanaPrincipal ventanaJuego;
    private int[] informacionParaGenerarMatriz;
    private String configPuntos;


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
                atrasTutorial2();
                break;
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


    public void jugar() {
        ventanaMenu.setVisible(false);
        ventanaJuego.setVisible(true);
    }

    public void tutorial1()   {
        ventanaMenu.mostrarTutorial();
        ventanaMenu.getPanelTutorialTitulo1().getAtras().addActionListener(this);
    }

    public void tutorial2() throws IOException, FontFormatException {
        int num = ventanaJuego.mostrarTutorial();
        ventanaJuego.getPanelTutorialTitulo2().getAtras().addActionListener(this);
    }

    public void atrasTutorial1(){
        ventanaMenu.cerrarTutorial();
    }

    public void atrasTutorial2(){
        ventanaJuego.cerrarTutorial();
        ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
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
            ventanaJuego.getPanelInformacion().getTutorial().addActionListener(this);
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
