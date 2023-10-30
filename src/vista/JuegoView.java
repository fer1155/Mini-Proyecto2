package vista;

import java.awt.Color;
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
    
    public void setIconEtiqueta1(ImageIcon imagen){
        etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq1 = true;
    }
    
    public void setIconEtiqueta2(ImageIcon imagen){
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq2 = true;
    }
    
    public void setIconEtiqueta3(ImageIcon imagen){
        etiqueta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq3 = true;
    }
    
    public void setIconEtiqueta4(ImageIcon imagen){
        etiqueta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq4 = true;
    }
    
    public void setIconEtiqueta5(ImageIcon imagen){
        etiqueta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq5 = true;
    }
    
    public void setIconEtiqueta6(ImageIcon imagen){
        etiqueta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq6 = true;
    }
    
    public void setIconEtiqueta7(ImageIcon imagen){
        etiqueta7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq7 = true;
    }
    
    public void setIconEtiqueta8(ImageIcon imagen){
        etiqueta8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
        estadoEtq8 = true;
    }
    
    public void setIconEtiqueta1Finalizar(ImageIcon imagen){
        etiqueta1.setIcon(null);
        estadoEtq1 = false;
    }
    
    public void setIconEtiqueta2Finalizar(ImageIcon imagen){
        etiqueta2.setIcon(null);
        estadoEtq2 = false;
    }
    
    public void setIconEtiqueta3Finalizar(ImageIcon imagen){
        etiqueta3.setIcon(null);
        estadoEtq3 = false;
    }
    
    public void setIconEtiqueta4Finalizar(ImageIcon imagen){
        etiqueta4.setIcon(null);
        estadoEtq4 = false;
    }
    
    public void setIconEtiqueta5Finalizar(ImageIcon imagen){
        etiqueta5.setIcon(null);
        estadoEtq5 = false;
    }
    
    public void setIconEtiqueta6Finalizar(ImageIcon imagen){
        etiqueta6.setIcon(null);
        estadoEtq6 = false;
    }
    
    public void setIconEtiqueta7Finalizar(ImageIcon imagen){
        etiqueta7.setIcon(null);
        estadoEtq7 = false;
    }
    
    public void setIconEtiqueta8Finalizar(ImageIcon imagen){
        etiqueta8.setIcon(null);
        estadoEtq8 = false;
    }
    
    public void setIconEtiqueta(int id, ImageIcon imagen){
        switch(id){
            case 1 -> etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 2 -> etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 3 -> etiqueta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 4 -> etiqueta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 5 -> etiqueta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 6 -> etiqueta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 7 -> etiqueta7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
            case 8 -> etiqueta8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));  
        }
    }
    
    public void setIconEtiquetaPonerBorde(int id){
        bordeLineaNegra = BorderFactory.createLineBorder(Color.BLACK, 6);
        
        switch(id) { 
            case 1 -> {
                etiqueta1.setBorder(bordeLineaNegra);
            }
            case 2 -> {
                etiqueta2.setBorder(bordeLineaNegra);
            }
            case 3 -> {
                etiqueta3.setBorder(bordeLineaNegra);
            }
            case 4 -> {
                etiqueta4.setBorder(bordeLineaNegra);
            }
            case 5 -> {
                etiqueta5.setBorder(bordeLineaNegra);
            }
            case 6 -> {
                etiqueta6.setBorder(bordeLineaNegra);
            }
            case 7 -> {
                etiqueta7.setBorder(bordeLineaNegra);
            }
            case 8 -> {
                etiqueta8.setBorder(bordeLineaNegra);
            }
        }
    }
    
    public void setIconEtiquetaQuitarBorde(int id){
        
        switch(id) { 
            case 1 -> {
                etiqueta1.setBorder(null);
            }
            case 2 -> {
                etiqueta2.setBorder(null);
            }
            case 3 -> {
                etiqueta3.setBorder(null);
            }
            case 4 -> {
                etiqueta4.setBorder(null);
            }
            case 5 -> {
                etiqueta5.setBorder(null);
            }
            case 6 -> {
                etiqueta6.setBorder(null);
            }
            case 7 -> {
                etiqueta7.setBorder(null);
            }
            case 8 -> {
                etiqueta8.setBorder(null);
            }
        }
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
    
    public ImageIcon getIconEtiqueta1(){
        return (ImageIcon) etiqueta1.getIcon();
    }
    
    public ImageIcon getIconEtiqueta2(){
        return (ImageIcon) etiqueta2.getIcon();
    }
    
    public ImageIcon getIconEtiqueta3(){
        return (ImageIcon) etiqueta3.getIcon();
    }
    
    public ImageIcon getIconEtiqueta4(){
        return (ImageIcon) etiqueta4.getIcon();
    }
    
    public ImageIcon getIconEtiqueta5(){
        return (ImageIcon) etiqueta5.getIcon();
    }
    
    public ImageIcon getIconEtiqueta6(){
        return (ImageIcon) etiqueta6.getIcon();
    }
    
    public ImageIcon getIconEtiqueta7(){
        return (ImageIcon) etiqueta7.getIcon();
    }
    
    public ImageIcon getIconEtiqueta8(){
        return (ImageIcon) etiqueta8.getIcon();
    }
    
    public void setIconEtiquetaVida1(ImageIcon imagen){
        etiquetaVida1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida1.getWidth(), etiquetaVida1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiquetaVida2(ImageIcon imagen){
        etiquetaVida2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida1.getWidth(), etiquetaVida1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiquetaVida3(ImageIcon imagen){
        etiquetaVida3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiquetaVida1.getWidth(), etiquetaVida1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    
}
