package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import modelo.EstadisticasModel;
import modelo.JuegoModel;
import modelo.JuegoModel.Figura;
import modelo.JuegoModel.Ronda;
import vista.EstadisticasView;
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
    private boolean areEqual;
    private Ronda ronda;
    private boolean hayFallo;
    private int numFiguras;
    private ImageIcon vidaPerdida;
    private EstadisticasView vistaEstadisticas;
    private EstadisticasModel modeloEstadisticas;
    private EstadisticasController controladorEstadisticas;

    public JuegoController(JuegoView vista, JuegoModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vidaPerdida = new ImageIcon("vidaPerdida.png");
        vista.setVisible(true);
        numFiguras = 3;
        ronda = new JuegoModel().crearRonda();
        this.vista.addBtnJuegoListener(new ventanaListener());
        iniciarJuego();
    }

    private void iniciarJuego() {
        crearImagenes();
        colocarImagenes(numFiguras);
        transicionDeImagen(); // Reinicia la transición de imágenes
    }
    
    private void iniciarJuegoOtraVezAcierto() {
        crearImagenes();
        numFiguras = numFiguras + 1;
        colocarImagenes(numFiguras);
        if (timer != null && timer.isRunning()) {
            timer.stop(); // Detiene el temporizador si está en ejecución
        }
        transicionDeImagen(); // Reinicia la transición de imágenes
    }
    
    private void iniciarJuegoOtraVezFallo() {
        //ronda.restarVida();
        quitarVida();
        crearImagenes();
        colocarImagenes(numFiguras);
        if (timer != null && timer.isRunning()) {
            timer.stop(); // Detiene el temporizador si está en ejecución
        }
        transicionDeImagen(); // Reinicia la transición de imágenes
    }
    
    private void crearImagenes() {
        hayFallo = false;
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
        vista.setIconEtiquetaPonerBorde(etiquetasConImagen.get(indiceImagen));
        
        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                determinarFallo();
                if(indiceImagen < etiquetasConImagen.size()) {
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
            verificarImagenes();
            //vista.setIconEtiquetaQuitarBorde(id);
        }else{
            // Reinicia la transición cuando se han mostrado todas las imágenes
            indiceImagen2 = 0;
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
    
    
    class ventanaListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(hayFallo == true){
                limpiar();
                iniciarJuegoOtraVezAcierto();  // Agrega esta línea para reiniciar el juego
            }else{
                System.out.println("Aun no hay fallo");
            }   
        }
    }
    
    
    private void verificarImagenes(){        
        imagenesActivas = new ArrayList<>();
        obtenerImagenesActivas();
        for (int i = 0; i < imagenesActivas.size(); i++) {
            for (int j = i + 1; j < imagenesActivas.size(); j++) {
                areEqual= areImageIconsEqual(imagenesActivas.get(i), imagenesActivas.get(j));
                if (areEqual){
                    hayFallo = true;
                    System.out.println("Los íconos son iguales: ");
                    
                }else{
                    System.out.println("Los íconos no iguales");
                }
            }
        }
    }
    
    
    private void obtenerImagenesActivas(){
        imagenesActivas = new ArrayList<>();

        imagenesActivas.add(vista.getIconEtiqueta1());
        imagenesActivas.add(vista.getIconEtiqueta2());
        imagenesActivas.add(vista.getIconEtiqueta3());
        imagenesActivas.add(vista.getIconEtiqueta4());
        imagenesActivas.add(vista.getIconEtiqueta5());
        imagenesActivas.add(vista.getIconEtiqueta6());
        imagenesActivas.add(vista.getIconEtiqueta7());
        imagenesActivas.add(vista.getIconEtiqueta8());
        
        for (int i = 0; i < imagenesActivas.size(); i++) {
            if (imagenesActivas.get(i) == null) {
                imagenesActivas.remove(i);
                i--; // Reduce el índice para seguir comprobando el siguiente elemento.
            }
        }
    }
    
    public static boolean areImageIconsEqual(ImageIcon icon1, ImageIcon icon2) {
        Image image1 = icon1.getImage();
        Image image2 = icon2.getImage();

        if (image1.getWidth(null) != image2.getWidth(null) || image1.getHeight(null) != image2.getHeight(null)) {
            return false;  // Si las dimensiones son diferentes, las imágenes no son iguales.
        }

        // Convertir ambas imágenes en BufferedImage para facilitar la comparación.
        BufferedImage bufferedImage1 = toBufferedImage(image1);
        BufferedImage bufferedImage2 = toBufferedImage(image2);

        // Comparar píxel por píxel.
        int width = bufferedImage1.getWidth();
        int height = bufferedImage1.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (bufferedImage1.getRGB(x, y) != bufferedImage2.getRGB(x, y)) {
                    return false;  // Si se encuentra un píxel diferente, las imágenes no son iguales.
                }
            }
        }

        return true;  // Si no se encontraron diferencias en los píxeles, las imágenes son iguales.
    }
    
    public static BufferedImage toBufferedImage(Image image) {
        if(image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        return bufferedImage;
    }
    
    public void limpiar(){
        ImageIcon figuraVacia = new ImageIcon("figuraTrasparente.png");
        vista.setIconEtiqueta1Finalizar(figuraVacia);
        vista.setIconEtiqueta2Finalizar(figuraVacia);
        vista.setIconEtiqueta3Finalizar(figuraVacia);
        vista.setIconEtiqueta4Finalizar(figuraVacia);
        vista.setIconEtiqueta5Finalizar(figuraVacia);
        vista.setIconEtiqueta6Finalizar(figuraVacia);
        vista.setIconEtiqueta7Finalizar(figuraVacia);
        vista.setIconEtiqueta8Finalizar(figuraVacia);
        
        listaDeFigurasPrincipal.clear();
        listaDeFigurasUsadas.clear();
        listaDeFigurasTransicion.clear();
        etiquetasConImagen.clear();
        imagenesActivas.clear();
        numerosUsados.clear();
    }
    
    public void determinarFallo(){
        if(hayFallo == true){
            limpiar();
            switch (numFiguras) {
                case 3 -> numFiguras = 3;
                case 4 -> numFiguras = 3;
                case 5 -> numFiguras = 4;
                case 6 -> numFiguras = 5;
                case 7 -> numFiguras = 6;
                case 8 -> numFiguras = 7;
                default -> {
                }
            }
            iniciarJuegoOtraVezFallo();
        }else{
            System.out.println("No hay fallo aun ");
        }   
    }
    
    public void quitarVida(){
        switch (ronda.getVidas()) {
            case 3 -> {
                ronda.restarVida();
                vista.setIconEtiquetaVida1(vidaPerdida);
                System.out.println("Se resto una vida");
            }
            case 2 -> {
                ronda.restarVida();
                vista.setIconEtiquetaVida2(vidaPerdida);
                System.out.println("Se resto dos vidas");
            }
            case 1 -> {
                ronda.restarVida();
                vista.setIconEtiquetaVida3(vidaPerdida);

                vistaEstadisticas = new EstadisticasView();
                modeloEstadisticas = new EstadisticasModel();
                controladorEstadisticas = new EstadisticasController(vistaEstadisticas, modeloEstadisticas);
                
                vista.dispose();
            }
            default -> System.out.println("No te quedan vidas");
        }
    }

}
