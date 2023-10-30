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
        texto = new JLabel("<html>Este juego pone en acción la habilidad para comparar patrones visuales, entrenando además la atención a los detalles y la velocidad perceptiva. Estas capacidades son relevantes cuando hay que decidir entre estímulos semejantes y hay que hacerlo de forma rápida, por ejemplo, al reconocer fotografías, caras, objetos cotidianos o palabras escritas.</html>");
        texto.setBounds(125, 165, 600, 250);
        //titulo.setOpaque(true); 
        //titulo.setBackground(Color.WHITE);
        Color colorLetra = new Color(0, 0, 0);
        texto.setForeground(colorLetra);
        texto.setFont(new Font("Book Antiqua", 1, 25));
        layeredPane.add(texto, JLayeredPane.MODAL_LAYER);    
    }
    
    private void establecerBotonCerrar() {
        imagenBotonCerrar = new ImageIcon("tornillo.png");
        etiquetaBotonCerrar = new JLabel();
        etiquetaBotonCerrar.setBounds(723, 105, 65, 65);
        etiquetaBotonCerrar.setIcon(new ImageIcon(imagenBotonCerrar.getImage().getScaledInstance(etiquetaBotonCerrar.getWidth(), etiquetaBotonCerrar.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaBotonCerrar, JLayeredPane.MODAL_LAYER);
    }
    
    public void addBtnCerrarListener(MouseListener listenControl){
        etiquetaBotonCerrar.addMouseListener(listenControl);
    }
}