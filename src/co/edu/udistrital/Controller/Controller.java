package co.edu.udistrital.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.udistrital.Model.MatrizDeJuego;
import co.edu.udistrital.View.VentanaMenu;
import co.edu.udistrital.View.VentanaPrincipal;
import co.edu.udistrital.View.VentanaTutorial;

import javax.swing.*;

public class Controller implements ActionListener{
    private MatrizDeJuego matriz;
    private VentanaMenu ventanaMenu;
    private VentanaPrincipal ventanaJuego;
    private VentanaTutorial emergenteTutorial; //al querer mostrar el tutorial saldra una ventana emergente mostrando el tutorial
    public Controller() {
        matriz = new MatrizDeJuego();
        ventanaMenu = new VentanaMenu();
        ventanaJuego = new VentanaPrincipal();
        emergenteTutorial = new VentanaTutorial();

        asignarOyentes();
    }

    public void asignarOyentes() {
        ventanaMenu.getMenu().getJugar().addActionListener(this);
        ventanaMenu.getMenu().getTutorial().addActionListener(this);
        ventanaMenu.getMenu().getSalir().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if(comando.equals("SALIR")) {
            JOptionPane.showMessageDialog(null, "Hasta pronto, gracias por jugar", "Salir", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }else if (comando.equals("JUGAR")) {
            ventanaMenu.setVisible(false);
            ventanaJuego.setVisible(true);
        }


    }

}
