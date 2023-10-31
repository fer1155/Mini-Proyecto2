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
<<<<<<< HEAD
<<<<<<< HEAD
    private JButton boton2;
>>>>>>> develop
=======
    private JButton botonInstrucciones;
>>>>>>> develop
    
=======
    private JButton botonInstrucciones;

>>>>>>> develop
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

        establecerSoldador();
        establecerBoton1();
        establecerBoton2(); 
        establecerBoton3();

       
=======
        establecerBoton2();
=======
        establecerBotonInstrucciones();
>>>>>>> develop
=======
        establecerBotonInstrucciones();
>>>>>>> develop
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
  
<<<<<<< HEAD
<<<<<<< HEAD
    private void establecerBoton2() {
        boton2 = new JButton("¿COMO JUGAR?");
        boton2.setFocusPainted(false);
>>>>>>> develop
        boton2.setBounds(310, 350, 230, 60); 
        boton2.setForeground(Color.WHITE);
        boton2.setFont(new Font("Bernard MT Condensed", 0, 28));
=======
=======
>>>>>>> develop
    private void establecerBotonInstrucciones() {
        botonInstrucciones = new JButton("¿COMO JUGAR?");
        botonInstrucciones.setFocusPainted(false);
        botonInstrucciones.setBounds(310, 350, 230, 60); 
        botonInstrucciones.setForeground(Color.WHITE);
        botonInstrucciones.setFont(new Font("Bernard MT Condensed", 0, 28));
<<<<<<< HEAD
>>>>>>> develop
        Color colorFondoBtn2 = new Color(78, 39, 0);
        botonInstrucciones.setBackground(colorFondoBtn2);
        Color colorBorde2 = new Color(94, 94, 94);
<<<<<<< HEAD
        boton2.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
<<<<<<< HEAD
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
    
    
    ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                //Cierra la ventana introduccion
                dispose();
                
                //Abre la ventana principal
                VentanaParaQueSirve ventanaParaQueSirve = new VentanaParaQueSirve();
                ventanaParaQueSirve.setVisible(true);
            }
        };
        boton3.addActionListener(oyenteDeAccion);

=======
        layeredPane.add(boton2, JLayeredPane.MODAL_LAYER); 
=======
        botonInstrucciones.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(botonInstrucciones, JLayeredPane.MODAL_LAYER); 
>>>>>>> develop
    }
=======
        Color colorFondoBtn2 = new Color(78, 39, 0);
        botonInstrucciones.setBackground(colorFondoBtn2);
        Color colorBorde2 = new Color(94, 94, 94);
        botonInstrucciones.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(botonInstrucciones, JLayeredPane.MODAL_LAYER); 
>>>>>>> develop
    
    public void addBtnFuncionListener(ActionListener listenControl){
        botonFuncion.addActionListener(listenControl);
    }
    
    public void addBtnJuegoListener(ActionListener listenControl){
        botonJuego.addActionListener(listenControl);
    }
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
    
=======

>>>>>>> develop
    public void addBtnInstruccionesListener(ActionListener listenControl){
        botonInstrucciones.addActionListener(listenControl);
    }
}
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
