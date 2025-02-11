package co.edu.udistrital.View;

import co.edu.udistrital.Resources.Fonts.CabinetFont;
import co.edu.udistrital.Resources.Fonts.CabinetFontExtraBold;
import co.edu.udistrital.Resources.Fonts.SatoshiFontBold;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * Clase encargada de la gestion de dificultad al crear el laberinto.
 */

public class PanelDificultad extends JPanel{
    private JLabel titleGeneral;
    
    private JPanel bestias;
    private JPanel botones;

    private JPanel checkpoints;
    private JPanel configuracion;

    private JPanel matriz1;
    private JPanel matriz2;
    private JPanel configuracionPuntos;

    private JPanel panelDificultadPredeterminada;
    private JPanel configuracionGeneral;

    private JButton enviar;
    private JButton volver;

    private JButton facil;
    private JButton medio;
    private JButton dificil;

    private JButton checkpoints2;
    private JButton checkpoints3;
    private JButton checkpoints4;
    private JButton checkpoints5;

    private JLabel lbldimensionMatrizFilas;
    private JLabel lbldimensionMatrizColumnas;
    private JLabel lblcantidadBestias;
    private JLabel lblConfiguracionPuntos;

    private JTextField txtdimensionMatrizFilas;
    private JTextField txtdimensionMatrizColumnas;
    private JTextField txtcantidadBestias;
    private JComboBox<String> comboConfiguracionPuntos;
    private String[] opciones = {"Orden", "Orden Inverso"};

    public PanelDificultad() throws IOException, FontFormatException {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(80, 0, 80, 0));
        setVisible(true);

        setBackground(new Color(0x202020));

        inicializarComponentes();
    }

    public void inicializarComponentes() throws IOException, FontFormatException {
        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setOpaque(false);

        titleGeneral = new JLabel("¡Configura tu experiencia!", SwingConstants.CENTER);
        titleGeneral.setFont(CabinetFont.getCabinetFont(60f));
        titleGeneral.setForeground(new Color(0xFFFECB));
        panelTitulo.add(titleGeneral, BorderLayout.NORTH);

        JPanel panelDificultad = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelDificultad.setOpaque(false);
        facil = quitarEstilos("Fácil", "FACIL");
        facil.setBackground(new Color(84, 72, 200));
        medio = quitarEstilos("Medio", "MEDIO");
        medio.setBackground(new Color(254, 168, 47));
        dificil = quitarEstilos("Díficil", "DIFICIL");
        dificil.setBackground(new Color(255, 46, 0));
        panelDificultad.add(facil);
        panelDificultad.add(medio);
        panelDificultad.add(dificil);

        panelTitulo.add(panelDificultad, BorderLayout.SOUTH);
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(0x202020));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 0, 10, 0);

        matriz1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        matriz1.setBackground(new Color(0x202020));
        lbldimensionMatrizFilas = new JLabel("Número de filas (5-20): ");
        lbldimensionMatrizFilas.setFont(CabinetFontExtraBold.getCabinetFontExtraBold(18f));
        lbldimensionMatrizFilas.setForeground(new Color(0xFFFECB));

        txtdimensionMatrizFilas = new JTextField(12);
        txtdimensionMatrizFilas.setBorder(BorderFactory.createEmptyBorder());
        txtdimensionMatrizFilas.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
        txtdimensionMatrizFilas.setForeground(new Color(0x202020));
        txtdimensionMatrizFilas.setBackground(new Color(0xFFFECB));

        matriz1.add(lbldimensionMatrizFilas);
        matriz1.add(txtdimensionMatrizFilas);
        panelCentral.add(matriz1, gbc);

        matriz2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        matriz2.setBackground(new Color(0x202020));
        lbldimensionMatrizColumnas = new JLabel("Número de columnas (5-20): ");
        lbldimensionMatrizColumnas.setFont(CabinetFontExtraBold.getCabinetFontExtraBold(18f));
        lbldimensionMatrizColumnas.setForeground(new Color(0xFFFECB));

        txtdimensionMatrizColumnas = new JTextField(12);
        txtdimensionMatrizColumnas.setBorder(BorderFactory.createEmptyBorder());
        txtdimensionMatrizColumnas.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
        txtdimensionMatrizColumnas.setForeground(new Color(0x202020));
        txtdimensionMatrizColumnas.setBackground(new Color(0xFFFECB));

        matriz2.add(lbldimensionMatrizColumnas);
        matriz2.add(txtdimensionMatrizColumnas);
        panelCentral.add(matriz2, gbc);

        bestias = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bestias.setBackground(new Color(0x202020));
        lblcantidadBestias = new JLabel("Cantidad de Bestias en el laberinto: ");
        lblcantidadBestias.setFont(CabinetFontExtraBold.getCabinetFontExtraBold(18f));
        lblcantidadBestias.setForeground(new Color(0xFFFECB));

        txtcantidadBestias = new JTextField(12);
        txtcantidadBestias.setBorder(BorderFactory.createEmptyBorder());
        txtcantidadBestias.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
        txtcantidadBestias.setForeground(new Color(0x202020));
        txtcantidadBestias.setBackground(new Color(0xFFFECB));

        bestias.add(lblcantidadBestias);
        bestias.add(txtcantidadBestias);
        panelCentral.add(bestias, gbc);

        configuracionPuntos = new JPanel();
        configuracionPuntos.setLayout(new FlowLayout());
        configuracionPuntos.setBackground(new Color(0x202020));

        lblConfiguracionPuntos = new JLabel("Configuracion de recolección de puntos ");
        lblConfiguracionPuntos.setFont(CabinetFontExtraBold.getCabinetFontExtraBold(18f));
        lblConfiguracionPuntos.setForeground(new Color(0xFFFECB));
        configuracionPuntos.add(lblConfiguracionPuntos);

        comboConfiguracionPuntos = new JComboBox<>(opciones);
        comboConfiguracionPuntos.setFont(SatoshiFontBold.getSatoshiFontBold(18f));
        comboConfiguracionPuntos.setForeground(new Color(0x202020));
        comboConfiguracionPuntos.setBackground(new Color(0xFFFECB));
        configuracionPuntos.add(comboConfiguracionPuntos);

        panelCentral.add(configuracionPuntos, gbc);

        checkpoints = new JPanel(new FlowLayout(FlowLayout.CENTER));
        checkpoints.setBackground(new Color(0x202020));

        checkpoints2 = quitarEstilos("Checkpoints 2", "CHECKPOINTS2");
        checkpoints2.setBackground(new Color(0xCCAD8F));
        checkpoints.add(checkpoints2);

        checkpoints3 = quitarEstilos("Checkpoints 3", "CHECKPOINTS3");
        checkpoints3.setBackground(new Color(0xCCAD8F));
        checkpoints.add(checkpoints3);

        checkpoints4 = quitarEstilos("Checkpoints 4", "CHECKPOINTS4");
        checkpoints4.setBackground(new Color(0xCCAD8F));
        checkpoints.add(checkpoints4);

        checkpoints5 = quitarEstilos("Checkpoints 5", "CHECKPOINTS5");
        checkpoints5.setBackground(new Color(0xCCAD8F));
        checkpoints.add(checkpoints5);

        checkpoints.setVisible(true);
        panelCentral.add(checkpoints, gbc);

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(new Color(0x202020));

        enviar = quitarEstilos("Enviar", "ENVIAR");
        enviar.setBackground(new Color(0x7FC6A4));
        panelBotones.add(enviar);

        volver = quitarEstilos("Volver", "VOLVER");
        volver.setBackground(new Color(0xB3001B));
        panelBotones.add(volver);

        add(panelBotones, BorderLayout.SOUTH);
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

    public JPanel getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(JPanel configuracion) {
        this.configuracion = configuracion;
    }

    public JPanel getMatriz1() {
        return matriz1;
    }

    public void setMatriz1(JPanel matriz1) {
        this.matriz1 = matriz1;
    }

    public JPanel getBestias() {
        return bestias;
    }

    public void setBestias(JPanel bestias) {
        this.bestias = bestias;
    }


    public JPanel getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(JPanel checkpoints) {
        this.checkpoints = checkpoints;
    }

    public JPanel getBotones() {
        return botones;
    }

    public void setBotones(JPanel botones) {
        this.botones = botones;
    }

    public JButton getEnviar() {
        return enviar;
    }

    public void setEnviar(JButton enviar) {
        this.enviar = enviar;
    }

    public JButton getVolver() {
        return volver;
    }

    public void setVolver(JButton volver) {
        this.volver = volver;
    }

    public JButton getCheckpoints2() {
        return checkpoints2;
    }

    public void setCheckpoints2(JButton checkpoints2) {
        this.checkpoints2 = checkpoints2;
    }

    public JButton getCheckpoints3() {
        return checkpoints3;
    }

    public void setCheckpoints3(JButton checkpoints3) {
        this.checkpoints3 = checkpoints3;
    }

    public JButton getCheckpoints4() {
        return checkpoints4;
    }

    public void setCheckpoints4(JButton checkpoints4) {
        this.checkpoints4 = checkpoints4;
    }

    public JButton getCheckpoints5() {
        return checkpoints5;
    }

    public void setCheckpoints5(JButton checkpoints5) {
        this.checkpoints5 = checkpoints5;
    }

    public JLabel getLbldimensionMatrizFilas() {
        return lbldimensionMatrizFilas;
    }

    public void setLbldimensionMatrizFilas(JLabel lbldimensionMatrizFilas) {
        this.lbldimensionMatrizFilas = lbldimensionMatrizFilas;
    }

    public JLabel getLbldimensionMatrizColumnas() {
        return lbldimensionMatrizColumnas;
    }

    public void setLbldimensionMatrizColumnas(JLabel lbldimensionMatrizColumnas) {
        this.lbldimensionMatrizColumnas = lbldimensionMatrizColumnas;
    }

    public JTextField getTxtdimensionMatrizFilas() {
        return txtdimensionMatrizFilas;
    }

    public void setTxtdimensionMatrizFilas(JTextField txtdimensionMatrizFilas) {
        this.txtdimensionMatrizFilas = txtdimensionMatrizFilas;
    }

    public JTextField getTxtdimensionMatrizColumnas() {
        return txtdimensionMatrizColumnas;
    }

    public void setTxtdimensionMatrizColumnas(JTextField txtdimensionMatrizColumnas) {
        this.txtdimensionMatrizColumnas = txtdimensionMatrizColumnas;
    }

    public JLabel getLblcantidadBestias() {
        return lblcantidadBestias;
    }

    public void setLblcantidadBestias(JLabel lblcantidadBestias) {
        this.lblcantidadBestias = lblcantidadBestias;
    }


    public JTextField getTxtcantidadBestias() {
        return txtcantidadBestias;
    }

    public void setTxtcantidadBestias(JTextField txtcantidadBestias) {
        this.txtcantidadBestias = txtcantidadBestias;
    }

    public JPanel getMatriz2() {
        return matriz2;
    }

    public void setMatriz2(JPanel matriz2) {
        this.matriz2 = matriz2;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public JPanel getConfiguracionPuntos() {
        return configuracionPuntos;
    }

    public void setConfiguracionPuntos(JPanel configuracionPuntos) {
        this.configuracionPuntos = configuracionPuntos;
    }

    public JLabel getLblConfiguracionPuntos() {
        return lblConfiguracionPuntos;
    }

    public void setLblConfiguracionPuntos(JLabel lblConfiguracionPuntos) {
        this.lblConfiguracionPuntos = lblConfiguracionPuntos;
    }

    public JComboBox<String> getComboConfiguracionPuntos() {
        return comboConfiguracionPuntos;
    }

    public void setComboConfiguracionPuntos(JComboBox<String> comboConfiguracionPuntos) {
        this.comboConfiguracionPuntos = comboConfiguracionPuntos;
    }

    public JButton getFacil() {
        return facil;
    }

    public void setFacil(JButton facil) {
        this.facil = facil;
    }

    public JButton getMedio() {
        return medio;
    }

    public void setMedio(JButton medio) {
        this.medio = medio;
    }

    public JButton getDificil() {
        return dificil;
    }

    public void setDificil(JButton dificil) {
        this.dificil = dificil;
    }


}

