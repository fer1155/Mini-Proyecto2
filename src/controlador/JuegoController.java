package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import modelo.JuegoModel;
import modelo.JuegoModel.Figura;
import vista.JuegoView;

public class JuegoController {
    
    private JuegoView vista;
    private JuegoModel modelo;
    private ArrayList<ImageIcon> listaDeFigurasPrincipal;
    private ArrayList<ImageIcon> listaDeFigurasUsadas;
    private ArrayList<ImageIcon> listaDeFigurasTransicion;
    private ArrayList<Integer> etiquetasConImagen;
    private ArrayList<ImageIcon> imagenesActivas;
    private ArrayList<Integer> numerosUsados = new ArrayList<>();
    Random random = new Random();
    private Timer timer;
    private int indiceImagen = 0;
    private int indiceImagen2 = 0;
    private Figura figura1, figura2,figura3, figura4, figura5, figura6;
    private Figura figura1Id, figura2Id,figura3Id, figura4Id, figura5Id, figura6Id, figura7Id, figura8Id;
    //private int idFigura1, idFigura2, idFigura3, idFigura4, idFigura5, idFigura6;

    public JuegoController(JuegoView vista, JuegoModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        //this.vista.addBtnJuegoListener(new ventanaListener());
        iniciarJuego();
    }

    private void iniciarJuego() {
        crearImagenes();
        colocarImagenes(3);
        //obtenerImagenesActivas();
        transicionDeImagen();
    }
    
    private void crearImagenes() {
        listaDeFigurasPrincipal = new ArrayList<>();
        
        figura1 = new JuegoModel().crearFigura(1, "figura1.png");
        figura2 = new JuegoModel().crearFigura(2, "figura2.png");
        figura3 = new JuegoModel().crearFigura(3, "figura3.png");
        figura4 = new JuegoModel().crearFigura(4, "figura4.png");
        figura5 = new JuegoModel().crearFigura(5, "figura5.png");
        figura6 = new JuegoModel().crearFigura(6, "figura6.png");
        
        listaDeFigurasPrincipal.add(figura1);
        listaDeFigurasPrincipal.add(figura2);
        listaDeFigurasPrincipal.add(figura3);
        listaDeFigurasPrincipal.add(figura4);
        listaDeFigurasPrincipal.add(figura5);
        listaDeFigurasPrincipal.add(figura6);
        
        //System.out.println(figura1.getId());
        //System.out.println(figura1.getImagen().getId());
        
        
        Collections.shuffle(listaDeFigurasPrincipal);
    }
    
    private void colocarImagenes(int numeroDeImagenes){
        listaDeFigurasUsadas = new ArrayList<>();
        listaDeFigurasTransicion = new ArrayList<>();
        
        for(int  i = 0; i < numeroDeImagenes; i++){
            Figura imagen = (Figura) listaDeFigurasPrincipal.get(i);
            listaDeFigurasUsadas.add(imagen.getImagen());
        }
                
        for(int  i = 0; i < numeroDeImagenes+2; i++){
            Figura imagen = (Figura) listaDeFigurasPrincipal.get(i);
            listaDeFigurasTransicion.add(imagen.getImagen());
        }
        
        for(ImageIcon elemento : listaDeFigurasUsadas) {
            asignarImagenAEtiquetaRamdon(elemento);
        }
        
        asignarEtiquetasConEstadoTrue();
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

    private void transicionDeImagen() {
        // Configura un temporizador para cambiar las imágenes cada 3 segundos        
        System.out.println(etiquetasConImagen.get(0));
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceImagen < etiquetasConImagen.size()) {
                    int elemento = etiquetasConImagen.get(indiceImagen);
                    mostrarSiguienteImagen(elemento);
                    indiceImagen++;
                    indiceImagen2++;
                }
                
                if (indiceImagen >= etiquetasConImagen.size()){
                    indiceImagen = 0;
                }
            }
        });
        timer.setRepeats(true); // Para que el temporizador se ejecute periódicamente
        timer.start();    
    }
    
    private void mostrarSiguienteImagen(int id) {
        if (indiceImagen2 < listaDeFigurasTransicion.size()) {
            Collections.shuffle(listaDeFigurasTransicion);
            vista.setIconEtiqueta(id, listaDeFigurasTransicion.get(indiceImagen2));
            obtenerImagenesActivas();
            verificarImagenes();
        }else{
            // Reinicia la transición cuando se han mostrado todas las imágenes
            indiceImagen2 = 0;
            mostrarSiguienteImagen(id);
        }
    }
    
    private void asignarEtiquetasConEstadoTrue(){
        etiquetasConImagen = new ArrayList<>();
                
        if(vista.isEstadoEtq1() == true){
            etiquetasConImagen.add(1);
        }
        if(vista.isEstadoEtq2() == true){
            etiquetasConImagen.add(2);
        }
        if(vista.isEstadoEtq3() == true){
            etiquetasConImagen.add(3);
        }
        if(vista.isEstadoEtq4() == true){
            etiquetasConImagen.add(4);
        }
        if(vista.isEstadoEtq5() == true){
            etiquetasConImagen.add(5);
        }
        if(vista.isEstadoEtq6() == true){
            etiquetasConImagen.add(6);
        }
        if(vista.isEstadoEtq7() == true){
            etiquetasConImagen.add(7);
        }
         if(vista.isEstadoEtq8() == true){
            etiquetasConImagen.add(8);
        }
    }
    
    /*
    class ventanaListener extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e) {

                
        }   
    }*/ 
    
    
    private boolean verificarImagenes(){
        imagenesActivas = new ArrayList<>();
        for (int i = 0; i < imagenesActivas.size(); i++) {
            for (int j = i + 1; j < imagenesActivas.size(); j++) {
                if (imagenesActivas.get(i).equals(imagenesActivas.get(j))) {
                    System.out.println("ids[" + i + "] y ids[" + j + "] son iguales");
                }
            }
        }
        return true;
    }
    
    private void obtenerImagenesActivas(){
        imagenesActivas = new ArrayList<>();
        
        ImageIcon figruaa = vista.getIconEtiqueta1();
        figura1Id = new JuegoModel().crearFigura(1, figruaa);
                
        imagenesActivas.add(vista.getIconEtiqueta1());
        imagenesActivas.add(vista.getIconEtiqueta2());
        imagenesActivas.add(vista.getIconEtiqueta3());
        imagenesActivas.add(vista.getIconEtiqueta4());
        imagenesActivas.add(vista.getIconEtiqueta5());
        imagenesActivas.add(vista.getIconEtiqueta6());
        imagenesActivas.add(vista.getIconEtiqueta7());
        imagenesActivas.add(vista.getIconEtiqueta8());
        
        
        for(ImageIcon elemento : imagenesActivas) {
            System.out.println(elemento);
        }
    }
    
}
