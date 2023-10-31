/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

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

public class InstruccionesView2 extends JFrame {
    
    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private ImageIcon imagenBotonCerrar;
    private JLabel etiquetaBotonCerrar;
    private JLabel texto;
    private JLabel texto2;
    private JButton botonSiguiente;
    private ImageIcon imagen;
    private JLabel etiquetaImagen;
    private JButton botonAnterior;
    
    //Constructor de la ventana Principal
    public InstruccionesView2(){
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
        establecerBotonSiguiente();
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
        imagenFondo = new ImageIcon("fondoinstrucciones.png");
        JLabel etiquetaFondo = new JLabel();
        etiquetaFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiquetaFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaFondo, JLayeredPane.PALETTE_LAYER);
    }
    
    private void establecerTexto() {
        texto = new JLabel("<html> Hay dos formas de presionar el pulsador, pulsar directamente el boton blanco en pantalla o pulsar la barra de espacio del teclado</html>");
        texto.setBounds(180, 230, 520, 500);
        //texto.setOpaque(true); 
        //texto.setBackground(Color.WHITE);
        Color colorLetra = new Color(241, 237, 237 );
        texto.setForeground(colorLetra);
        texto.setFont(new Font("Bernard MT Condensed", 1, 20));
        layeredPane.add(texto, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerNumVentana() {
        texto2 = new JLabel("2/3");
        texto2.setBounds(30, 2, 520, 100);
        //texto2.setOpaque(true); 
        //texto2.setBackground(Color.WHITE);
        Color colorLetra = new Color(213, 211, 211);
        texto2.setForeground(colorLetra);
        texto2.setFont(new Font("Bernard MT Condensed", 1, 30));
        layeredPane.add(texto2, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerBotonSiguiente() {
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setFocusPainted(false);
        botonSiguiente.setBounds(730, 195, 110, 45); 
        botonSiguiente.setForeground(Color.WHITE);
        botonSiguiente.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonSiguiente.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonSiguiente.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonSiguiente, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonAnterior() {
        botonAnterior = new JButton("Anterior");
        botonAnterior.setFocusPainted(false);
        botonAnterior.setBounds(40, 195, 110, 45); 
        botonAnterior.setForeground(Color.WHITE);
        botonAnterior.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonAnterior.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonAnterior.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonAnterior, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonCerrar() {
        imagenBotonCerrar = new ImageIcon("tornillo2.png");
        etiquetaBotonCerrar = new JLabel();
        etiquetaBotonCerrar.setBounds(765, 35, 60, 60);
        etiquetaBotonCerrar.setIcon(new ImageIcon(imagenBotonCerrar.getImage().getScaledInstance(etiquetaBotonCerrar.getWidth(), etiquetaBotonCerrar.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaBotonCerrar, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnCerrarListener(MouseListener listenControl){
        etiquetaBotonCerrar.addMouseListener(listenControl);
    }
    
    public void addBtnSiguienteListener(MouseListener listenControl){
        botonSiguiente.addMouseListener(listenControl);
    }
    
    public void addBtnAnteriorListener(MouseListener listenControl){
        botonAnterior.addMouseListener(listenControl);
    }
    
    private void establecerImg() {
        imagen = new ImageIcon("gameplay1.png");
        etiquetaImagen = new JLabel();
        etiquetaImagen.setBounds(165, 50, 550, 350);
        etiquetaImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaImagen.getWidth(), etiquetaImagen.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaImagen, JLayeredPane.MODAL_LAYER);

    }
}
