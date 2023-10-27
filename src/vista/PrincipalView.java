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
    private ImageIcon imagen1;
    private JButton botonFuncion;
    private JButton botonJuego;
    
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
        titulo.setBounds(180, 20, 520, 100);
        titulo.setOpaque(true); 
        titulo.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        titulo.setForeground(colorLetra);
        titulo.setFont(new Font("Verdana", 1, 80));
        layeredPane.add(titulo, JLayeredPane.MODAL_LAYER);    
    }

    private void establecerImagen() {
        imagen1 = new ImageIcon("");
        JLabel etiquetaImg1 = new JLabel();
        etiquetaImg1.setBounds(10, 10, 10, 10);
        etiquetaImg1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(etiquetaImg1.getWidth(), etiquetaImg1.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImg1, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonFuncion() {
        botonFuncion = new JButton("¿Para que sirve?");
        botonFuncion.setFocusPainted(false);
        botonFuncion.setBounds(290, 140, 300, 60); 
        botonFuncion.setForeground(Color.WHITE);
        botonFuncion.setFont(new Font("Kristen ITC", 0, 30));
        Color colorFondoBtn = new Color(16, 113, 229);
        botonFuncion.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        botonFuncion.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonFuncion, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonJuego() {
        botonJuego = new JButton("Jugar");
        botonJuego.setFocusPainted(false);
        botonJuego.setBounds(290, 220, 300, 60); 
        botonJuego.setForeground(Color.WHITE);
        botonJuego.setFont(new Font("Kristen ITC", 0, 30));
        Color colorFondoBtn = new Color(16, 113, 229);
        botonJuego.setBackground(colorFondoBtn);
        Color colorBorde = new Color(94, 94, 94);
        botonJuego.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonJuego, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnFuncionListener(ActionListener listenControl){
        botonFuncion.addActionListener(listenControl);
    }
    
    public void addBtnJuegoListener(ActionListener listenControl){
        botonJuego.addActionListener(listenControl);
    }
}
