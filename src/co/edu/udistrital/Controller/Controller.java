package co.edu.udistrital.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.udistrital.Model.MatrizDeJuego;
import co.edu.udistrital.View.VentanaMenu;
import co.edu.udistrital.View.VentanaPrincipal;
import co.edu.udistrital.View.VentanaTutorial;

import javax.swing.*;

public class Controller implements ActionListener{
    private VentanaMenu ventanaMenu;
    private VentanaPrincipal ventanaJuego;
    private VentanaTutorial ventanaEmeregenteTutorial;
    private int[] informacionParaGenerarMatriz;


    public Controller() throws IOException, FontFormatException {
        ventanaMenu = new VentanaMenu();
        ventanaJuego = new VentanaPrincipal();
        ventanaEmeregenteTutorial = new VentanaTutorial();

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
        String comando = e.getActionCommand();
        switch (comando) {
            case "JUGAR":
                jugar();
                break;
            case "TUTORIAL":
                tutorial();
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
            case "VOLVER":
                volver();
                break;
        }

    }


    public void jugar() {
        ventanaMenu.setVisible(false);
        ventanaJuego.setVisible(true);
    }

    public void tutorial() {
        ventanaEmeregenteTutorial.setVisible(true);
    }

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
        informacionParaGenerarMatriz[0] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtdimensionMatrizFilas().getText());
        informacionParaGenerarMatriz[1] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtdimensionMatrizColumnas().getText());
        informacionParaGenerarMatriz[2] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtcantidadMuros().getText());
        informacionParaGenerarMatriz[4] = Integer.parseInt(ventanaJuego.getPanelDificultad().getTxtcantidadBestias().getText());

        if(MatrizDeJuego.GenerarMatriz(informacionParaGenerarMatriz[0], informacionParaGenerarMatriz[1])) {
            ventanaJuego.getPanelDificultad().setVisible(false);
            ventanaJuego.agregarPanelImagenMatriz(informacionParaGenerarMatriz[0], informacionParaGenerarMatriz[1]);
            ventanaJuego.getPanelImagenMatriz().setFilasMatriz(informacionParaGenerarMatriz[0]);
            ventanaJuego.getPanelImagenMatriz().setColumnasMatriz(informacionParaGenerarMatriz[1]);
            ventanaJuego.getPanelImagenMatriz().setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al generar la matriz");
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

    public VentanaTutorial getEmergenteTutorial() {
        return ventanaEmeregenteTutorial;
    }

    public void setEmergenteTutorial(VentanaTutorial ventanaEmeregenteTutorial) {
        this.ventanaEmeregenteTutorial = ventanaEmeregenteTutorial;
    }

    public int[] getInformacionParaGenerarMatriz() {
        return informacionParaGenerarMatriz;
    }

    public void setInformacionParaGenerarMatriz(int[] informacionParaGenerarMatriz) {
        this.informacionParaGenerarMatriz = informacionParaGenerarMatriz;
    }
}
