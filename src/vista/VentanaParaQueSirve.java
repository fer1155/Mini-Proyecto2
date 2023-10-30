package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class VentanaParaQueSirve extends JFrame {
       
    private JLayeredPane layeredPane;
    private JPanel panel;
    private ImageIcon imagenFondo;
    private JLabel texto;
    private ImageIcon imagenSoldador;
    private JButton boton;
    
     //Constructor de la ventana Principal
    public VentanaParaQueSirve(){
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
        
       // establecerSoldador();
        establecerBoton();
        //establecerBoton2();
       // establecerBoton3();
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
        imagenFondo = new ImageIcon("fondo2.png");
        JLabel etiquetaFondo = new JLabel();
        etiquetaFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiquetaFondo.setIcon(new ImageIcon(imagenFondo.getImage().getScaledInstance(etiquetaFondo.getWidth(), etiquetaFondo.getHeight(), Image.SCALE_SMOOTH)));
        layeredPane.add(etiquetaFondo, JLayeredPane.PALETTE_LAYER);
    }
    
     private void establecerTexto() {
        texto = new JLabel("<html>Este juego pone en acción la habilidad para comparar patrones visuales, entrenando además la atención a los detalles y la velocidad perceptiva. Estas capacidades son relevantes cuando hay que decidir entre estímulos semejantes y hay que hacerlo de forma rápida, por ejemplo, al reconocer fotografías, caras, objetos cotidianos o palabras escritas.</html>");
        texto.setBounds(100, 105, 600, 250);
        //titulo.setOpaque(true); 
        //titulo.setBackground(Color.WHITE);
        Color colorLetra = new Color(0, 0, 0);
        texto.setForeground(colorLetra);
        texto.setFont(new Font("Book Antiqua", 1, 25));
        layeredPane.add(texto, JLayeredPane.MODAL_LAYER);    
    }
    
 private void establecerBoton() {
        boton = new JButton("¿PARA QUE SIRVE?");
        boton.setBounds(550, 350, 230, 60); 
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Bernard MT Condensed", 0, 28));
        Color colorFondoBtn3 = new Color(78, 39, 0);
        boton.setBackground(colorFondoBtn3);
        Color colorBorde2 = new Color(94, 94, 94);
        boton.setBorder(BorderFactory.createLineBorder(colorBorde2,3,true));
        layeredPane.add(boton, JLayeredPane.MODAL_LAYER);
        boton.setFocusPainted(false);
        
        ImageIcon icono = new ImageIcon("tornillo.jpg");

        // Establece el icono en el botón
        boton.setIcon(icono);
    
    
    ActionListener oyenteDeAccion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                //Cierra la ventana introduccion
                dispose();
                
                //Abre la ventana principal
                PrincipalView principalView = new PrincipalView();
                principalView.setVisible(true);
            }
        };
        boton.addActionListener(oyenteDeAccion);
    }
}
   
    
    
    

