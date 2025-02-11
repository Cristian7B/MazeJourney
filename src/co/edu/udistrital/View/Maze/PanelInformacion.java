package co.edu.udistrital.View.Maze;

import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;
import co.edu.udistrital.View.PanelDificultad;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelInformacion extends JPanel {
    private JLabel movimientos;
    private JButton tutorial;
    private JLabel aviso;
    private JProgressBar barraVida;
    public PanelInformacion(int numero) throws IOException, FontFormatException {
        setSize(getWidth(),500);
        setLayout(new GridLayout(1,2,5,5));
        setBackground(new Color(0x202020));

        inicializarComponentes(numero);
    }

    public void inicializarComponentes(int numero) throws IOException, FontFormatException {
        String nMov = String.valueOf(numero);

        barraVida = new JProgressBar(0,numero);
        barraVida.setValue(numero);
        barraVida.setForeground(new Color(84, 72, 200));
        barraVida.setFont(SatoshiFontBold.getSatoshiFontBold(20f));
        barraVida.setStringPainted(true);
        barraVida.setString("Movimientos restantes: "+nMov);
        add(barraVida);

        tutorial = quitarEstilos("Tutorial", "TUTORIAL2");
        tutorial.setBackground(new Color(254, 168, 47));

        add(tutorial);

    }
    public int modificarMovimientos() {
        int numero = barraVida.getValue();
        numero = numero - 1;
        if(numero <= 0) {
            barraVida.setValue(0);
            barraVida.setForeground(Color.red);
            numero = 0;
        } else {
            barraVida.setValue(numero);
        }
        barraVida.setString("Movimientos restantes: "+numero);
        return numero;
    }

    public JButton quitarEstilos(String labelText, String comandText) throws IOException, FontFormatException {
        JButton button = new JButton(labelText);
        button.setActionCommand(comandText);

        button.setBorderPainted(false);
        button.setFocusPainted(false);

        button.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
        button.setForeground(new Color(0xFFFECB));


        return button;
    }

    public int modificarMovimientosPenalizacion(int penalizacion) {
        int numero = barraVida.getValue();
        numero = numero - penalizacion;
        if(numero <= 0) {
            barraVida.setValue(0);
            barraVida.setForeground(Color.red);
            numero = 0;
        } else {
            barraVida.setValue(numero);
        }
        barraVida.setString("Movimientos restantes: "+numero);
        return numero;
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
