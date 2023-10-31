package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.Border;
import modelo.JuegoModel.Figura;

public class JuegoView extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private ImageIcon imagenBotonJuego;
    private JLabel etiquetaBotonJuego;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
    private JLabel etiqueta5;
    private JLabel etiqueta6;
    private JLabel etiqueta7;
    private JLabel etiqueta8;
    private boolean estadoEtq1;
    private boolean estadoEtq2;
    private boolean estadoEtq3;
    private boolean estadoEtq4;
    private boolean estadoEtq5;
    private boolean estadoEtq6;
    private boolean estadoEtq7;
    private boolean estadoEtq8;
    private int idEtiqueta1, idEtiqueta2, idEtiqueta3, idEtiqueta4, idEtiqueta5, idEtiqueta6, idEtiqueta7, idEtiqueta8;
    private ImageIcon imagenVida1;
    private JLabel etiquetaVida1;
    private ImageIcon imagenVida2;
    private JLabel etiquetaVida2;
    private ImageIcon imagenVida3;
    private JLabel etiquetaVida3;
    private Border bordeLineaNegra;
    private Figura figuraEtq1;
    private Figura figuraEtq2;
    private Figura figuraEtq3;
    private Figura figuraEtq4;
    private Figura figuraEtq5;
    private Figura figuraEtq6;
    private Figura figuraEtq7;
    private Figura figuraEtq8;
    private JLabel etiqueta9;
    private int puntaje = 0;
    
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
        imagenFondo = new ImageIcon("");
        JLabel etiquetaFondo = new JLabel();
        etiquetaFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiquetaFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaFondo, JLayeredPane.PALETTE_LAYER);
    }
    
    private void establecerBotonDelJuego() {
        imagenBotonJuego = new ImageIcon("fondo1.png");
        etiquetaBotonJuego = new JLabel();
        etiquetaBotonJuego.setBounds(100, 40, 50, 50);
        etiquetaBotonJuego.setIcon(new ImageIcon(imagenBotonJuego.getImage().getScaledInstance(etiquetaBotonJuego.getWidth(), etiquetaBotonJuego.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaBotonJuego, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnJuegoListener(MouseListener listenControl){
        etiquetaBotonJuego.addMouseListener(listenControl);
    }
    
    private void establecerVidas() {
        imagenVida1 = new ImageIcon("vida.png");
        etiquetaVida1 = new JLabel();
        etiquetaVida1.setBounds(220, 40, 50, 50);
        etiquetaVida1.setIcon(new ImageIcon(imagenVida1.getImage().getScaledInstance(etiquetaVida1.getWidth(), etiquetaVida1.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaVida1, JLayeredPane.MODAL_LAYER);
        
        imagenVida2 = new ImageIcon("vida.png");
        etiquetaVida2 = new JLabel();
        etiquetaVida2.setBounds(300, 40, 50, 50);
        etiquetaVida2.setIcon(new ImageIcon(imagenVida2.getImage().getScaledInstance(etiquetaVida2.getWidth(), etiquetaVida2.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaVida2, JLayeredPane.MODAL_LAYER);
        
        imagenVida3 = new ImageIcon("vida.png");
        etiquetaVida3 = new JLabel();
        etiquetaVida3.setBounds(380, 40, 50, 50);
        etiquetaVida3.setIcon(new ImageIcon(imagenVida3.getImage().getScaledInstance(etiquetaVida3.getWidth(), etiquetaVida3.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaVida3, JLayeredPane.MODAL_LAYER);
    }
    
    private void establecerEtiquetas(){
        etiqueta1 = new JLabel();
        etiqueta1.setBounds(100, 100, 100, 100);
        etiqueta1.setOpaque(true); 
        etiqueta1.setBackground(Color.RED);
        estadoEtq1 = false;
        idEtiqueta1 = 1;
        layeredPane.add(etiqueta1, JLayeredPane.MODAL_LAYER);
        
        etiqueta2 = new JLabel();
        etiqueta2.setBounds(100, 250, 100, 100);
        etiqueta2.setOpaque(true); 
        etiqueta2.setBackground(Color.RED);
        estadoEtq2 = false;
        idEtiqueta2 = 2;
        layeredPane.add(etiqueta2, JLayeredPane.MODAL_LAYER);
        
        etiqueta3 = new JLabel();
        etiqueta3.setBounds(300, 100, 100, 100);
        etiqueta3.setOpaque(true); 
        etiqueta3.setBackground(Color.RED);
        estadoEtq3 = false;
        idEtiqueta3 = 3;
        layeredPane.add(etiqueta3, JLayeredPane.MODAL_LAYER);
        
        etiqueta4 = new JLabel();
        etiqueta4.setBounds(300, 250, 100, 100);
        etiqueta4.setOpaque(true); 
        etiqueta4.setBackground(Color.RED);
        estadoEtq4 = false;
        idEtiqueta4 = 4;
        layeredPane.add(etiqueta4, JLayeredPane.MODAL_LAYER);
        
        etiqueta5 = new JLabel();
        etiqueta5.setBounds(500, 100, 100, 100);
        etiqueta5.setOpaque(true); 
        etiqueta5.setBackground(Color.RED);
        estadoEtq5 = false;
        idEtiqueta5 = 5;
        layeredPane.add(etiqueta5, JLayeredPane.MODAL_LAYER);
        
        etiqueta6 = new JLabel();
        etiqueta6.setBounds(500, 250, 100, 100);
        etiqueta6.setOpaque(true); 
        etiqueta6.setBackground(Color.RED);
        estadoEtq6 = false;
        idEtiqueta6 = 6;
        layeredPane.add(etiqueta6, JLayeredPane.MODAL_LAYER);
        
        etiqueta7 = new JLabel();
        etiqueta7.setBounds(700, 100, 100, 100);
        etiqueta7.setOpaque(true); 
        etiqueta7.setBackground(Color.RED);
        estadoEtq7 = false;
        idEtiqueta7 = 7;
        layeredPane.add(etiqueta7, JLayeredPane.MODAL_LAYER);
        
        etiqueta8 = new JLabel();
        etiqueta8.setBounds(700, 250, 100, 100);
        etiqueta8.setOpaque(true); 
        etiqueta8.setBackground(Color.RED);
        estadoEtq8 = false;
        idEtiqueta8 = 8;
        layeredPane.add(etiqueta8, JLayeredPane.MODAL_LAYER);   
    }
    
    private void establecerPuntaje() {
        etiqueta9 = new JLabel("Score: " + puntaje);
        etiqueta9.setBounds(180, 400, 150, 50);
        etiqueta9.setOpaque(true); 
        etiqueta9.setBackground(Color.WHITE);
        Color colorLetra = new Color(40, 28, 5);
        etiqueta9.setForeground(colorLetra);
        etiqueta9.setFont(new Font("Verdana", 1, 20));
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
        /*switch(id){
            case 1 -> etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 2 -> etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
            case 3 -> etiqueta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta3.getWidth(), etiqueta3.getHeight(), Image.SCALE_SMOOTH)));
            case 4 -> etiqueta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta4.getWidth(), etiqueta4.getHeight(), Image.SCALE_SMOOTH)));
            case 5 -> etiqueta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta5.getWidth(), etiqueta5.getHeight(), Image.SCALE_SMOOTH)));
            case 6 -> etiqueta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta6.getWidth(), etiqueta6.getHeight(), Image.SCALE_SMOOTH)));
            case 7 -> etiqueta7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta7.getWidth(), etiqueta7.getHeight(), Image.SCALE_SMOOTH)));
            case 8 -> etiqueta8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta8.getWidth(), etiqueta8.getHeight(), Image.SCALE_SMOOTH)));  
        }*/
        
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
    
}
