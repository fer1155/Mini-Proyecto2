package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class PrincipalView extends JFrame {

    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private JLabel titulo;
    private ImageIcon imagenSoldador;
    private JButton botonFuncion;
    private JButton botonJuego;
    private JButton botonInstrucciones;

    //Constructor de la ventana Principal
    public PrincipalView(){
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
        establecerBotonInstrucciones();
        establecerImagen();
        establecerBotonFuncion();
        establecerBotonJuego();
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
        imagenFondo = new ImageIcon("fondo1.png");
        JLabel etiquetaFondo = new JLabel();
        etiquetaFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiquetaFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaFondo, JLayeredPane.PALETTE_LAYER);
    }
        
    private void establecerTitulo() {
        titulo = new JLabel("ADOSADOS");
        titulo.setBounds(265, 20, 530, 120);
        Color colorLetra = new Color(78, 39, 0);
        titulo.setForeground(colorLetra);
        titulo.setFont(new Font("Bernard MT Condensed", 1, 85));
        layeredPane.add(titulo, JLayeredPane.MODAL_LAYER);    
    }

    private void establecerImagen() {
        imagenSoldador = new ImageIcon("soldador.png");
        JLabel etiquetaImg1 = new JLabel();
        etiquetaImg1.setBounds(0, 200, 360, 390);
        etiquetaImg1.setIcon(new ImageIcon(imagenSoldador.getImage().getScaledInstance(etiquetaImg1.getWidth(), etiquetaImg1.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg1, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonFuncion() {
        botonFuncion = new JButton("¿PARA QUE SIRVE?");
        botonFuncion.setFocusPainted(false);
        botonFuncion.setBounds(550, 350, 230, 60);  
        botonFuncion.setForeground(Color.WHITE);
        botonFuncion.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn = new Color(78, 39, 0);
        botonFuncion.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        botonFuncion.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonFuncion, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonJuego() {
        botonJuego = new JButton("JUGAR");
        botonJuego.setFocusPainted(false);
        botonJuego.setBounds(455, 265, 180, 60);
        botonJuego.setForeground(Color.WHITE);
        botonJuego.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn = new Color(78, 39, 0);
        botonJuego.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        botonJuego.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonJuego, JLayeredPane.MODAL_LAYER);
    }
  
    private void establecerBotonInstrucciones() {
        botonInstrucciones = new JButton("¿COMO JUGAR?");
        botonInstrucciones.setFocusPainted(false);
        botonInstrucciones.setBounds(310, 350, 230, 60); 
        botonInstrucciones.setForeground(Color.WHITE);
        botonInstrucciones.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn2 = new Color(78, 39, 0);
        botonInstrucciones.setBackground(colorFondoBtn2);
        Color colorBorde2 = new Color(94, 94, 94);
        botonInstrucciones.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(botonInstrucciones, JLayeredPane.MODAL_LAYER); 
    }
    public void addBtnFuncionListener(ActionListener listenControl){
        botonFuncion.addActionListener(listenControl);
    }
    
    public void addBtnJuegoListener(ActionListener listenControl){
        botonJuego.addActionListener(listenControl);
    }

    public void addBtnInstruccionesListener(ActionListener listenControl){
        botonInstrucciones.addActionListener(listenControl);
    }
}
