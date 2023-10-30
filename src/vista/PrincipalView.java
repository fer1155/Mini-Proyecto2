package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    
    
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
        establecerSoldador();
        establecerBoton1();
        establecerBoton2();
        establecerBoton3();
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
    
     private void establecerSoldador() {
        imagenSoldador = new ImageIcon("soldador.png");
         JLabel etiquetaImg = new JLabel();
         etiquetaImg.setBounds(0, 200, 360, 390);
         etiquetaImg.setIcon(new ImageIcon(imagenSoldador.getImage().getScaledInstance(etiquetaImg.getWidth(), etiquetaImg.getHeight(), Image.SCALE_SMOOTH)));
         layeredPane.add(etiquetaImg, JLayeredPane.MODAL_LAYER);
    }  
    
    private void establecerTitulo() {
        titulo = new JLabel("ADOSADOS");
        titulo.setBounds(265, 20, 530, 120);
        //titulo.setOpaque(true); 
        //titulo.setBackground(Color.WHITE);
        Color colorLetra = new Color(78, 39, 0);
        titulo.setForeground(colorLetra);
        titulo.setFont(new Font("Bernard MT Condensed", 1, 85));
        layeredPane.add(titulo, JLayeredPane.MODAL_LAYER);    
    }
 
    private void establecerBoton1() {
        boton1 = new JButton("JUGAR");
        boton1.setBounds(455, 265, 180, 60); 
        boton1.setForeground(Color.WHITE);
        boton1.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn1 = new Color(78, 39, 0);
        boton1.setBackground(colorFondoBtn1);
        Color colorBorde2 = new Color(94, 94, 94);
        boton1.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(boton1, JLayeredPane.MODAL_LAYER);
        boton1.setFocusPainted(false);
    }
    
    private void establecerBoton2() {
        boton2 = new JButton("¿COMO JUGAR?");
        boton2.setBounds(310, 350, 230, 60); 
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn2 = new Color(78, 39, 0);
        boton2.setBackground(colorFondoBtn2);
        Color colorBorde2 = new Color(94, 94, 94);
        boton2.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(boton2, JLayeredPane.MODAL_LAYER);
        boton2.setFocusPainted(false);
    }
    
    private void establecerBoton3() {
        boton3 = new JButton("¿PARA QUE SIRVE?");
        boton3.setBounds(550, 350, 230, 60); 
        boton3.setForeground(Color.WHITE);
        boton3.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn3 = new Color(78, 39, 0);
        boton3.setBackground(colorFondoBtn3);
        Color colorBorde2 = new Color(94, 94, 94);
        boton3.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(boton3, JLayeredPane.MODAL_LAYER);
        boton3.setFocusPainted(false);
    }
}
