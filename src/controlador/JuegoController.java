package controlador;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelo.JuegoModel;
import vista.JuegoView;

public class JuegoController {
    
    private JuegoView vista;
    private JuegoModel modelo;
    private ArrayList<ImageIcon> listaDeFigurasPrincipal;
    private ArrayList<ImageIcon> listaDeFigurasSecundaria;
    private ArrayList<Integer> numerosUsados = new ArrayList<>();
    Random random = new Random();

    public JuegoController(JuegoView vista, JuegoModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        iniciarJuego();
    }

    private void iniciarJuego() {
        listaDeFigurasPrincipal = new ArrayList<>();
        
        ImageIcon figura1 = new ImageIcon("figura1.png");
        ImageIcon figura2 = new ImageIcon("figura2.png");
        ImageIcon figura3 = new ImageIcon("figura3.png");
        ImageIcon figura4 = new ImageIcon("figura4.png");
        ImageIcon figura5 = new ImageIcon("figura5.png");
        ImageIcon figura6 = new ImageIcon("figura6.png");
        
        listaDeFigurasPrincipal.add(figura1);
        listaDeFigurasPrincipal.add(figura2);
        listaDeFigurasPrincipal.add(figura3);
        listaDeFigurasPrincipal.add(figura4);
        listaDeFigurasPrincipal.add(figura5);
        listaDeFigurasPrincipal.add(figura6);
        
        Collections.shuffle(listaDeFigurasPrincipal);
        
        colocarImagenes(3);
    }
    
    private void colocarImagenes(int numeroDeImagenes){
        listaDeFigurasSecundaria = new ArrayList<>();
        
        for(int  i = 0; i < numeroDeImagenes; i++){
            listaDeFigurasSecundaria.add(listaDeFigurasPrincipal.get(i));
        }
        
        for(ImageIcon elemento : listaDeFigurasSecundaria) {
            asignarImagenAEtiquetaRamdon(elemento);
        }
    }
    
    private void asignarImagenAEtiquetaRamdon(ImageIcon figura){
         
        if (numerosUsados.size() == 8) {
        // Se han utilizado todos los números, se puede reinicar la lista
            numerosUsados.clear();
        }
        
        int numeroAleatorio;
        
        do {
            numeroAleatorio = random.nextInt(8);
        } while (numerosUsados.contains(numeroAleatorio));

        numerosUsados.add(numeroAleatorio);
       
        switch(numeroAleatorio){
            case 0 -> vista.setIconEtiqueta1(figura);
            case 1 -> vista.setIconEtiqueta2(figura);
            case 2 -> vista.setIconEtiqueta3(figura);
            case 3 -> vista.setIconEtiqueta4(figura);
            case 4 -> vista.setIconEtiqueta5(figura);
            case 5 -> vista.setIconEtiqueta6(figura);
            case 6 -> vista.setIconEtiqueta7(figura);
            case 7 -> vista.setIconEtiqueta8(figura);   
        }
    }   
}
