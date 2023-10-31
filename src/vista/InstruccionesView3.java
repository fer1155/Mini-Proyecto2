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

public class InstruccionesView3 extends JFrame {
    
    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private ImageIcon imagenBotonCerrar;
    private JLabel etiquetaBotonCerrar;
    private JLabel texto;
    private JLabel texto2;
    private ImageIcon imagen;
    private JLabel etiquetaImagen;
    private JButton botonAnterior;
    
    //Constructor de la ventana Principal
    public InstruccionesView3(){
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
        establecerTexto();
        establecerNumVentana();
        establecerBotonAnterior();
        establecerBotonCerrar();
        establecerImg();
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
    
    private void establecerTexto() {
        texto = new JLabel("ADOSADOS");
        texto.setBounds(180, 20, 520, 100);
        texto.setOpaque(true); 
        texto.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        texto.setForeground(colorLetra);
        texto.setFont(new Font("Verdana", 1, 80));
        layeredPane.add(texto, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerNumVentana() {
        texto2 = new JLabel("ADOSADOS");
        texto2.setBounds(300, 20, 520, 100);
        texto2.setOpaque(true); 
        texto2.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        texto2.setForeground(colorLetra);
        texto2.setFont(new Font("Verdana", 1, 80));
        layeredPane.add(texto2, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerBotonAnterior() {
        botonAnterior = new JButton("Anterior");
        botonAnterior.setFocusPainted(false);
        botonAnterior.setBounds(580, 400, 110, 45); 
        botonAnterior.setForeground(Color.WHITE);
        botonAnterior.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonAnterior.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonAnterior.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonAnterior, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonCerrar() {
        imagenBotonCerrar = new ImageIcon("fondo1.png");
        etiquetaBotonCerrar = new JLabel();
        etiquetaBotonCerrar.setBounds(100, 100, 50, 50);
        etiquetaBotonCerrar.setIcon(new ImageIcon(imagenBotonCerrar.getImage().getScaledInstance(etiquetaBotonCerrar.getWidth(), etiquetaBotonCerrar.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaBotonCerrar, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnCerrarListener(MouseListener listenControl){
        etiquetaBotonCerrar.addMouseListener(listenControl);
    }

    public void addBtnAnteriorListener(MouseListener listenControl){
        botonAnterior.addMouseListener(listenControl);
    }
    
    private void establecerImg() {
        imagen = new ImageIcon("vida.png");
        etiquetaImagen = new JLabel();
        etiquetaImagen.setBounds(220, 200, 50, 50);
        etiquetaImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImagen, JLayeredPane.MODAL_LAYER);

    }
}
