package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class EstadisticasView extends JFrame{

    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private JLabel titulo;
    private JLabel aciertos;
    private JLabel fallos;
    private JLabel puntaje;
    private JButton botonSalir;
    private JButton botonVolverAJugar;
    
    //Constructor de la ventana Estadisticas
    public EstadisticasView(){
        this.setTitle("Adosados");
        this.setBounds(200, 50, 900, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        establecerLayeredPanel();
        establecerPanel();
        establecerFondo();
        establecerTitulo();
        establecerTxtAciertos();
        establecerTxtFallos();
        establecerTxtPuntaje();
        establecerBotonSalir();
        establecerBotonVolverAJugar();
    }
    
    private void establecerLayeredPanel() {
        layeredPane = new JLayeredPane();
        this.add(layeredPane);
    }
    
    private void establecerPanel() {
        panel = new JPanel();
        panel.setBounds(0, 0, this.getWidth(), this.getHeight());
        panel.setLayout(null);
        layeredPane.add(panel, JLayeredPane.DEFAULT_LAYER);
    }

    private void establecerFondo() {
        imagenFondo = new ImageIcon("fondo3.png");
        JLabel etiquetaFondo = new JLabel();
        etiquetaFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiquetaFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaFondo, JLayeredPane.PALETTE_LAYER);
    }
    
    private void establecerTitulo() {
        titulo = new JLabel("FIN DEL JUEGO");
        titulo.setBounds(350, 90, 520, 100);
        //titulo.setOpaque(true); 
        //titulo.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        titulo.setForeground(colorLetra);
        titulo.setFont(new Font("Bernard MT Condensed", 1, 40));
        layeredPane.add(titulo, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerTxtAciertos() {
        aciertos = new JLabel("");
        aciertos.setBounds(180, 160, 300, 100);
        //aciertos.setOpaque(true); 
        //aciertos.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        aciertos.setForeground(colorLetra);
        aciertos.setFont(new Font("Bernard MT Condensed", 1, 30));
        layeredPane.add(aciertos, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerTxtFallos() {
        fallos = new JLabel("");
        fallos.setBounds(180, 260, 300, 100);
        //fallos.setOpaque(true); 
        //fallos.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        fallos.setForeground(colorLetra);
        fallos.setFont(new Font("Bernard MT Condensed", 1, 30));
        layeredPane.add(fallos, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerTxtPuntaje() {
        puntaje = new JLabel("");
        puntaje.setBounds(180, 360, 300, 100);
        //puntaje.setOpaque(true); 
        //puntaje.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        puntaje.setForeground(colorLetra);
        puntaje.setFont(new Font("Bernard MT Condensed", 1, 30));
        layeredPane.add(puntaje, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerBotonSalir() {
        botonSalir = new JButton("Salir");
        botonSalir.setFocusPainted(false);
        botonSalir.setBounds(290, 460, 110, 45); 
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonSalir.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonSalir.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonSalir, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonVolverAJugar() {
        botonVolverAJugar = new JButton("Volver a Jugar");
        botonVolverAJugar.setFocusPainted(false);
        botonVolverAJugar.setBounds(440, 460, 210, 45); 
        botonVolverAJugar.setForeground(Color.WHITE);
        botonVolverAJugar.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonVolverAJugar.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonVolverAJugar.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonVolverAJugar, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnSaliListener(MouseListener listenControl){
        botonSalir.addMouseListener(listenControl);
    }
    
    public void addBtnVolveraJugarListener(MouseListener listenControl){
        botonVolverAJugar.addMouseListener(listenControl);
    }

    public void setAciertos(int numAciertos) {
        aciertos.setText("ACIERTOS:" + numAciertos);
    }

    public void setFallos(int numFallos) {
        fallos.setText("FALLOS: " + numFallos);
    }

    public void setPuntaje(int numPuntos) {
        puntaje.setText("PUNTAJE: " + numPuntos);
    }
}
