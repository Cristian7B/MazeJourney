package co.edu.udistrital.View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDificultad extends JPanel{
   
    
    private JPanel configuracion;
    private JPanel matriz;
    private JPanel bestias;
    private JPanel muros;
    private JPanel checkpoints;
    private JPanel botones;
    private JButton enviar;
    private JButton volver;
    private JButton checkpoints2;
    private JButton checkpoints3;
    private JButton checkpoints4;
    private JButton checkpoints5;
    private JLabel lbldimensionMatriz;
    private JLabel lblcantidadBestias;
    private JLabel lblcantidadMuros;
    private JTextField txtdimensionMatriz;
    private JTextField txtcantidadBestias;
    private JTextField txtcantidadMuros;

    public PanelDificultad(){
        setLayout(new BorderLayout());
        setVisible(false);

        inicializarComponentes();
    }

    public void inicializarComponentes(){

        botones = new JPanel();
        botones.setLayout(new FlowLayout());
        
        enviar = new JButton("Enviar");
        enviar.setActionCommand("ENVIAR");
        botones.add(enviar);

        volver = new JButton("Volver");
        volver.setActionCommand("VOLVER");
        botones.add(volver);

        botones.setVisible(true);
        add(botones,BorderLayout.SOUTH);    
        

        configuracion = new JPanel();
        configuracion.setBorder(BorderFactory.createTitledBorder("Configuracion"));
        configuracion.setLayout(new GridLayout(4,0));

        matriz = new JPanel();
        matriz.setLayout(new FlowLayout());

        lbldimensionMatriz = new JLabel("Numero de filas y columnas");
        matriz.add(lbldimensionMatriz);

        txtdimensionMatriz = new JTextField();
        matriz.add(txtdimensionMatriz);

        matriz.setVisible(true);
        configuracion.add(matriz);

        bestias = new JPanel();
        bestias.setLayout(new FlowLayout());

        lblcantidadBestias = new JLabel("La cantidad de Bestias en el laberinto");
        bestias.add(lblcantidadBestias);

        txtcantidadBestias = new JTextField();
        bestias.add(txtcantidadBestias);

        bestias.setVisible(true);
        configuracion.add(bestias);

        muros = new JPanel();
        muros.setLayout(new FlowLayout());

        lblcantidadMuros = new JLabel("La candidad de muros en el laberinto");
        muros.add(lblcantidadMuros);

        txtcantidadMuros = new JTextField();
        muros.add(txtcantidadMuros);

        muros.setVisible(true);
        configuracion.add(muros);

        checkpoints = new JPanel();
        checkpoints.setLayout(new GridLayout());
        checkpoints.setBorder(BorderFactory.createTitledBorder("Cantidad de checkponits"));

        checkpoints2 = new JButton("2");
        checkpoints2.setActionCommand("CHECKPOINTS2");
        checkpoints.add(checkpoints2);

        checkpoints3 = new JButton("3");
        checkpoints3.setActionCommand("CHECKPOINTS3");
        checkpoints.add(checkpoints3);

        checkpoints4 = new JButton("4");
        checkpoints4.setActionCommand("CHECKPOINTS4");
        checkpoints.add(checkpoints4);

        checkpoints5 = new JButton("5");
        checkpoints5.setActionCommand("CHECKPOINTS5");
        checkpoints.add(checkpoints5);

        checkpoints.setVisible(true);
        configuracion.add(checkpoints);

        configuracion.setVisible(true);
        add(configuracion,BorderLayout.CENTER);
    }

    public JPanel getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(JPanel configuracion) {
        this.configuracion = configuracion;
    }

    public JPanel getMatriz() {
        return matriz;
    }

    public void setMatriz(JPanel matriz) {
        this.matriz = matriz;
    }

    public JPanel getBestias() {
        return bestias;
    }

    public void setBestias(JPanel bestias) {
        this.bestias = bestias;
    }

    public JPanel getMuros() {
        return muros;
    }

    public void setMuros(JPanel muros) {
        this.muros = muros;
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

    public JLabel getLbldimensionMatriz() {
        return lbldimensionMatriz;
    }

    public void setLbldimensionMatriz(JLabel lbldimensionMatriz) {
        this.lbldimensionMatriz = lbldimensionMatriz;
    }

    public JLabel getLblcantidadBestias() {
        return lblcantidadBestias;
    }

    public void setLblcantidadBestias(JLabel lblcantidadBestias) {
        this.lblcantidadBestias = lblcantidadBestias;
    }

    public JLabel getLblcantidadMuros() {
        return lblcantidadMuros;
    }

    public void setLblcantidadMuros(JLabel lblcantidadMuros) {
        this.lblcantidadMuros = lblcantidadMuros;
    }

    public JTextField getTxtdimensionMatriz() {
        return txtdimensionMatriz;
    }

    public void setTxtdimensionMatriz(JTextField txtdimensionMatriz) {
        this.txtdimensionMatriz = txtdimensionMatriz;
    }

    public JTextField getTxtcantidadBestias() {
        return txtcantidadBestias;
    }

    public void setTxtcantidadBestias(JTextField txtcantidadBestias) {
        this.txtcantidadBestias = txtcantidadBestias;
    }

    public JTextField getTxtcantidadMuros() {
        return txtcantidadMuros;
    }

    public void setTxtcantidadMuros(JTextField txtcantidadMuros) {
        this.txtcantidadMuros = txtcantidadMuros;
    }
}
