package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class JuegoView extends JFrame {
    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
    private JLabel etiqueta5;
    private JLabel etiqueta6;
    private JLabel etiqueta7;
    private JLabel etiqueta8;
    
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
        establecerEtiquetas();
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
    
    private void establecerEtiquetas(){
        etiqueta1 = new JLabel();
        etiqueta1.setBounds(100, 100, 100, 100);
        etiqueta1.setOpaque(true); 
        etiqueta1.setBackground(Color.RED);
        layeredPane.add(etiqueta1, JLayeredPane.MODAL_LAYER);
        
        etiqueta2 = new JLabel();
        etiqueta2.setBounds(100, 250, 100, 100);
        etiqueta2.setOpaque(true); 
        etiqueta2.setBackground(Color.RED);
        layeredPane.add(etiqueta2, JLayeredPane.MODAL_LAYER);
        
        etiqueta3 = new JLabel();
        etiqueta3.setBounds(300, 100, 100, 100);
        etiqueta3.setOpaque(true); 
        etiqueta3.setBackground(Color.RED);
        layeredPane.add(etiqueta3, JLayeredPane.MODAL_LAYER);
        
        etiqueta4 = new JLabel();
        etiqueta4.setBounds(300, 250, 100, 100);
        etiqueta4.setOpaque(true); 
        etiqueta4.setBackground(Color.RED);
        layeredPane.add(etiqueta4, JLayeredPane.MODAL_LAYER);
        
        etiqueta5 = new JLabel();
        etiqueta5.setBounds(500, 100, 100, 100);
        etiqueta5.setOpaque(true); 
        etiqueta5.setBackground(Color.RED);
        layeredPane.add(etiqueta5, JLayeredPane.MODAL_LAYER);
        
        etiqueta6 = new JLabel();
        etiqueta6.setBounds(500, 250, 100, 100);
        etiqueta6.setOpaque(true); 
        etiqueta6.setBackground(Color.RED);
        layeredPane.add(etiqueta6, JLayeredPane.MODAL_LAYER);
        
        etiqueta7 = new JLabel();
        etiqueta7.setBounds(700, 100, 100, 100);
        etiqueta7.setOpaque(true); 
        etiqueta7.setBackground(Color.RED);
        layeredPane.add(etiqueta7, JLayeredPane.MODAL_LAYER);
        
        etiqueta8 = new JLabel();
        etiqueta8.setBounds(700, 250, 100, 100);
        etiqueta8.setOpaque(true); 
        etiqueta8.setBackground(Color.RED);
        layeredPane.add(etiqueta8, JLayeredPane.MODAL_LAYER);   
    }
    
    public void setIconEtiqueta1(ImageIcon imagen){
        etiqueta1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta2(ImageIcon imagen){
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta3(ImageIcon imagen){
        etiqueta3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta4(ImageIcon imagen){
        etiqueta4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta5(ImageIcon imagen){
        etiqueta5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta6(ImageIcon imagen){
        etiqueta6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta7(ImageIcon imagen){
        etiqueta7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
    
    public void setIconEtiqueta8(ImageIcon imagen){
        etiqueta8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta1.getWidth(), etiqueta1.getHeight(), Image.SCALE_SMOOTH)));
    }
   
    public JLabel getEtiqueta1(){
        return etiqueta1;
    }
}
