package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.MatrizDeJuego;
import View.VentanaMenu;
import View.VentanaPrincipal;
import View.VentanaTutorial;

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
		
		
	}

}
