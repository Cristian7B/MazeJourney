package co.edu.udistrital.View;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
    private PanelImagenMatriz matriz;

    public VentanaPrincipal() {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout());

        setVisible(true);
        setResizable(false);

        inicializarComponentes();
    }

    public void inicializarComponentes() {

    }
}