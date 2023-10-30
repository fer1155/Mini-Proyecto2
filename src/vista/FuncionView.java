package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class FuncionView extends JFrame {

    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private JLabel texto;
    private ImageIcon imagenBotonCerrar;
    private JLabel etiquetaBotonCerrar;
    
    //Constructor de la ventana Funcion
    public FuncionView(){
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
        establecerBotonCerrar();
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
        imagenFondo = new ImageIcon("fondo2.jpeg");
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
}