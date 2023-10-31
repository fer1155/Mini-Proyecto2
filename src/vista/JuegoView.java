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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import modelo.JuegoModel.Figura;

public class JuegoView extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private JButton etiquetaBotonJuego;
    private JButton botonSalir;
    private JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4, etiqueta5, etiqueta6, etiqueta7, etiqueta8, etiqueta9;
    private JLabel etiquetaVida1, etiquetaVida2, etiquetaVida3;
    private JLabel etiquetaSonido;
    private ImageIcon imagenFondo;
    private ImageIcon imagenBotonJuego;
    private ImageIcon imagenVida1, imagenVida2, imagenVida3;
    private ImageIcon sonido;
    private Figura figuraEtq1, figuraEtq2, figuraEtq3, figuraEtq4, figuraEtq5, figuraEtq6, figuraEtq7, figuraEtq8;
    private boolean estadoEtq1, estadoEtq2, estadoEtq3, estadoEtq4, estadoEtq5, estadoEtq6, estadoEtq7, estadoEtq8;
    
    //Constructor de la ventana Juego
    public JuegoView(){
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
        establecerBotonDelJuego();
        establecerEtiquetas();
        establecerVidas();
        establecerPuntaje();
        establecerBotonSalir();
        establecerBotonSonido();
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
        imagenFondo = new ImageIcon("fondojuego.jpg");
        JLabel etiquetaFondo = new JLabel();
        etiquetaFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiquetaFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaFondo, JLayeredPane.PALETTE_LAYER);
    }
    
    private void establecerBotonDelJuego() {
        imagenBotonJuego = new ImageIcon("botonjuego.png");
        etiquetaBotonJuego = new JButton();
        etiquetaBotonJuego.setBounds(410, 400, 80, 80);
        etiquetaBotonJuego.setIcon(new ImageIcon(imagenBotonJuego.getImage().getScaledInstance(etiquetaBotonJuego.getWidth(), etiquetaBotonJuego.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaBotonJuego, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonSalir() {
        botonSalir = new JButton("Salir");
        botonSalir.setFocusPainted(false);
        botonSalir.setBounds(700, 490, 110, 45); 
        botonSalir.setForeground(Color.WHITE);
        botonSalir.setFont(new Font("Britannic Bold", 0, 22));
        Color colorFondoBtn2 = new Color(232, 19, 19);
        botonSalir.setBackground(colorFondoBtn2);
        Color colorBorde = new Color(94, 94, 94);
        botonSalir.setBorder(BorderFactory.createLineBorder(colorBorde,3,true));
        layeredPane.add(botonSalir, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerBotonSonido() {
        sonido = new ImageIcon("on.png");
        etiquetaSonido = new JLabel();
        etiquetaSonido.setBounds(100, 490, 50, 50);
        etiquetaSonido.setIcon(new ImageIcon(sonido.getImage().getScaledInstance(etiquetaSonido.getWidth(), etiquetaSonido.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaSonido, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnJuegoListener(ActionListener listenControl){
        etiquetaBotonJuego.addActionListener(listenControl);
    }
    
    public void addBtnJuegoListener(KeyListener listenControl){
        etiquetaBotonJuego.addKeyListener(listenControl);
    }
    
    public void addBtnSaliListener(ActionListener listenControl){
        botonSalir.addActionListener(listenControl);
    }
    
    public void addBtnSonidoListener(MouseListener listenControl){
        etiquetaSonido.addMouseListener(listenControl);
    }

    private void establecerEtiquetas(){
        etiqueta1 = new JLabel();
        etiqueta1.setBounds(100, 100, 100, 100);
        etiqueta1.setOpaque(true); 
        Color colorFondoEtiq = new Color(100, 89, 89);
        etiqueta1.setBackground(colorFondoEtiq);
        estadoEtq1 = false;
        layeredPane.add(etiqueta1, JLayeredPane.MODAL_LAYER);
        
        etiqueta2 = new JLabel();
        etiqueta2.setBounds(100, 250, 100, 100);
        etiqueta2.setOpaque(true); 
        etiqueta2.setBackground(colorFondoEtiq);
        estadoEtq2 = false;
        layeredPane.add(etiqueta2, JLayeredPane.MODAL_LAYER);
        
        etiqueta3 = new JLabel();
        etiqueta3.setBounds(300, 100, 100, 100);
        etiqueta3.setOpaque(true); 
        etiqueta3.setBackground(colorFondoEtiq);
        estadoEtq3 = false;
        layeredPane.add(etiqueta3, JLayeredPane.MODAL_LAYER);
        
        etiqueta4 = new JLabel();
        etiqueta4.setBounds(300, 250, 100, 100);
        etiqueta4.setOpaque(true); 
        etiqueta4.setBackground(colorFondoEtiq);
        estadoEtq4 = false;
        layeredPane.add(etiqueta4, JLayeredPane.MODAL_LAYER);
        
        etiqueta5 = new JLabel();
        etiqueta5.setBounds(500, 100, 100, 100);
        etiqueta5.setOpaque(true); 
        etiqueta5.setBackground(colorFondoEtiq);
        estadoEtq5 = false;
        layeredPane.add(etiqueta5, JLayeredPane.MODAL_LAYER);
        
        etiqueta6 = new JLabel();
        etiqueta6.setBounds(500, 250, 100, 100);
        etiqueta6.setOpaque(true); 
        etiqueta6.setBackground(colorFondoEtiq);
        estadoEtq6 = false;
        layeredPane.add(etiqueta6, JLayeredPane.MODAL_LAYER);
        
        etiqueta7 = new JLabel();
        etiqueta7.setBounds(700, 100, 100, 100);
        etiqueta7.setOpaque(true); 
        etiqueta7.setBackground(colorFondoEtiq);
        estadoEtq7 = false;
        layeredPane.add(etiqueta7, JLayeredPane.MODAL_LAYER);
        
        etiqueta8 = new JLabel();
        etiqueta8.setBounds(700, 250, 100, 100);
        etiqueta8.setOpaque(true); 
        etiqueta8.setBackground(colorFondoEtiq);
        estadoEtq8 = false;
        layeredPane.add(etiqueta8, JLayeredPane.MODAL_LAYER);   
    }
    
    private void establecerVidas() {
        imagenVida1 = new ImageIcon("vida.png");
        etiquetaVida1 = new JLabel();
        etiquetaVida1.setBounds(590, 40, 50, 50);
        etiquetaVida1.setIcon(new ImageIcon(imagenVida1.getImage().getScaledInstance(etiquetaVida1.getWidth(), etiquetaVida1.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaVida1, JLayeredPane.MODAL_LAYER);
        
        imagenVida2 = new ImageIcon("vida.png");
        etiquetaVida2 = new JLabel();
        etiquetaVida2.setBounds(670, 40, 50, 50);
        etiquetaVida2.setIcon(new ImageIcon(imagenVida2.getImage().getScaledInstance(etiquetaVida2.getWidth(), etiquetaVida2.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaVida2, JLayeredPane.MODAL_LAYER);
        
        imagenVida3 = new ImageIcon("vida.png");
        etiquetaVida3 = new JLabel();
        etiquetaVida3.setBounds(750, 40, 50, 50);
        etiquetaVida3.setIcon(new ImageIcon(imagenVida3.getImage().getScaledInstance(etiquetaVida3.getWidth(), etiquetaVida3.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaVida3, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerPuntaje() {
        etiqueta9 = new JLabel("Score: " + "0");
        etiqueta9.setBounds(100, 45, 150, 50);
        //etiqueta9.setOpaque(true); 
        //etiqueta9.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        etiqueta9.setForeground(colorLetra);
        etiqueta9.setFont(new Font("Bernard MT Condensed", 1, 20));
        layeredPane.add(etiqueta9, JLayeredPane.MODAL_LAYER);   
    }
    
    
    public void setIconEtiqueta1(Figura imagen){
        etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq1 = imagen;
        estadoEtq1 = true;
    }
    
    public void setIconEtiqueta2(Figura imagen){
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq2 = imagen;
        estadoEtq2 = true;
    }
    
    public void setIconEtiqueta3(Figura imagen){
        etiqueta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq3 = imagen;
        estadoEtq3 = true;
    }
    
    public void setIconEtiqueta4(Figura imagen){
        etiqueta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq4 = imagen;
        estadoEtq4 = true;
    }
    
    public void setIconEtiqueta5(Figura imagen){
        etiqueta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq5 = imagen;
        estadoEtq5 = true;
    }
    
    public void setIconEtiqueta6(Figura imagen){
        etiqueta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq6 = imagen;
        estadoEtq6 = true;
    }
    
    public void setIconEtiqueta7(Figura imagen){
        etiqueta7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq7 = imagen;
        estadoEtq7 = true;
    }
    
    public void setIconEtiqueta8(Figura imagen){
        etiqueta8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        figuraEtq8 = imagen;
        estadoEtq8 = true;
    }
    
    public void setIconEtiqueta1Finalizar(){
        etiqueta1.setIcon(null);
        figuraEtq1 = null;
        estadoEtq1 = false;
    }
    
    public void setIconEtiqueta2Finalizar(){
        etiqueta2.setIcon(null);
        figuraEtq2 = null;
        estadoEtq2 = false;
    }
    
    public void setIconEtiqueta3Finalizar(){
        etiqueta3.setIcon(null);
        figuraEtq3 = null;
        estadoEtq3 = false;
    }
    
    public void setIconEtiqueta4Finalizar(){
        etiqueta4.setIcon(null);
        figuraEtq4 = null;
        estadoEtq4 = false;
    }
    
    public void setIconEtiqueta5Finalizar(){
        etiqueta5.setIcon(null);
        figuraEtq5 = null;
        estadoEtq5 = false;
    }
    
    public void setIconEtiqueta6Finalizar(){
        etiqueta6.setIcon(null);
        figuraEtq6 = null;
        estadoEtq6 = false;
    }
    
    public void setIconEtiqueta7Finalizar(){
        etiqueta7.setIcon(null);
        figuraEtq7 = null;
        estadoEtq7 = false;
    }
    
    public void setIconEtiqueta8Finalizar(){
        etiqueta8.setIcon(null);
        figuraEtq8 = null;
        estadoEtq8 = false;
    }
    
    public void setIconEtiqueta(int id, Figura imagen){
        switch(id) { 
            case 1 -> {
                etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq1 = imagen;
            }
            case 2 -> {
                etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq2 = imagen;
            }
            case 3 -> {
                etiqueta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta3.getWidth(), etiqueta3.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq3 = imagen;
            }
            case 4 -> {
                etiqueta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta4.getWidth(), etiqueta4.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq4 = imagen;
            }
            case 5 -> {
                etiqueta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta5.getWidth(), etiqueta5.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq5 = imagen;
            }
            case 6 -> {
                etiqueta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta6.getWidth(), etiqueta6.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq6 = imagen;
            }
            case 7 -> {
                etiqueta7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta7.getWidth(), etiqueta7.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq7 = imagen;
            }
            case 8 -> {
                etiqueta8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta8.getWidth(), etiqueta8.getHeight(), Image.SCALE_SMOOTH)));
                figuraEtq8 = imagen;
            }
        }
    }
    
    public Figura getIconEtiqueta(int id){
        switch(id) { 
            case 1 -> {
                return figuraEtq1;
            }
            case 2 -> {
                return figuraEtq2;
            }
            case 3 -> {
                return figuraEtq3;
            }
            case 4 -> {
                return figuraEtq4;
            }
            case 5 -> {
                return figuraEtq5;
            }
            case 6 -> {
                return figuraEtq6;
            }
            case 7 -> {
                return figuraEtq7;
            }
            case 8 -> {
                return figuraEtq8;
            }
        }
        return null;
    }
    
    public boolean isEstadoEtq1() {
        return estadoEtq1;
    }

    public boolean isEstadoEtq2() {
        return estadoEtq2;
    }

    public boolean isEstadoEtq3() {
        return estadoEtq3;
    }

    public boolean isEstadoEtq4() {
        return estadoEtq4;
    }

    public boolean isEstadoEtq5() {
        return estadoEtq5;
    }

    public boolean isEstadoEtq6() {
        return estadoEtq6;
    }

    public boolean isEstadoEtq7() {
        return estadoEtq7;
    }

    public boolean isEstadoEtq8() {
        return estadoEtq8;
    }
    
    public Figura getIconEtiqueta1(){
        return figuraEtq1;
    }
    
    public Figura getIconEtiqueta2(){
        return figuraEtq2;
    }
    
    public Figura getIconEtiqueta3(){
        return figuraEtq3;
    }
    
    public Figura getIconEtiqueta4(){
        return figuraEtq4;
    }
    
    public Figura getIconEtiqueta5(){
        return figuraEtq5;
    }
    
    public Figura getIconEtiqueta6(){
        return figuraEtq6;
    }
    
    public Figura getIconEtiqueta7(){
        return figuraEtq7;
    }
    
    public Figura getIconEtiqueta8(){
        return figuraEtq8;
    }
    
    public void setIconEtiquetaVida1(ImageIcon imagen){
        etiquetaVida1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida1.getWidth(), etiquetaVida1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiquetaVida2(ImageIcon imagen){
        etiquetaVida2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida2.getWidth(), etiquetaVida2.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiquetaVida3(ImageIcon imagen){
        etiquetaVida3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida3.getWidth(), etiquetaVida3.getHeight(), Image.SCALE_SMOOTH)));
    }

    public void setPuntaje(int puntajeNuevo){
        etiqueta9.setText("Puntaje: " + puntajeNuevo);
    }
    
    public void setIconMuteActivado(ImageIcon imagen){
        etiquetaSonido.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida3.getWidth(), etiquetaVida3.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconMuteDesactivado(ImageIcon imagen){
        etiquetaSonido.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida3.getWidth(), etiquetaVida3.getHeight(), Image.SCALE_SMOOTH)));
    }
}
