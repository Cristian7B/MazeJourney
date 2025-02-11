package co.edu.udistrital.View.Maze;

import co.edu.udistrital.View.PanelDificultad;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    private JLabel movimientos;
    private JButton tutorial;
    private JLabel aviso;
    private JProgressBar barraVida;
    public PanelInformacion(int numero){
        setSize(getWidth(),500);
        setLayout(new GridLayout(1,3,5,5));

        inicializarComponentes(numero);
    }

    public void inicializarComponentes(int numero){
        String nMov = String.valueOf(numero);

        barraVida = new JProgressBar(0,numero);
        barraVida.setValue(numero);
        barraVida.setForeground(Color.GREEN);
        barraVida.setStringPainted(true);
        barraVida.setString("Movimientos restantes: "+nMov);
        add(barraVida);

        aviso = new JLabel("Cada vez que abras el tutorial tendras una penalización de 5 movimientos");
        add(aviso);

        tutorial = new JButton("Tutorial");
        tutorial.setActionCommand("TUTORIAL2");
        add(tutorial);
    }


    public JLabel getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(JLabel movimientos) {
        this.movimientos = movimientos;
    }

    public JButton getTutorial() {
        return tutorial;
    }

    public void setTutorial(JButton tutorial) {
        this.tutorial = tutorial;
    }

    public JLabel getAviso() {
        return aviso;
    }

    public void setAviso(JLabel aviso) {
        this.aviso = aviso;
    }

    public JProgressBar getBarraVida() {
        return barraVida;
    }

    public void setBarraVida(JProgressBar barraVida) {
        this.barraVida = barraVida;
    }
}
