package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
    private ArrayList<ImageIcon> imagenesActivas;
    private ArrayList<Integer> numerosUsados = new ArrayList<>();
    private ArrayList<Integer> etiquetasConImagen;
    Random random = new Random();
    private Timer timer;
    private int indiceImagen = 0;
    private int indiceImagen2 = 0;
    private Figura figura1, figura2,figura3, figura4, figura5, figura6;
    private Figura figura1Id, figura2Id,figura3Id, figura4Id, figura5Id, figura6Id, figura7Id, figura8Id;
    //private int idFigura1, idFigura2, idFigura3, idFigura4, idFigura5, idFigura6;
    private boolean areEqual;
    private boolean areEqual2;
    private boolean areEqual3;
    private Ronda ronda;
    private boolean hayFallo;
    private int numFiguras = 3;
    private ImageIcon vidaPerdida;
    private EstadisticasView vistaEstadisticas;
    private EstadisticasModel modeloEstadisticas;
    private EstadisticasController controladorEstadisticas;
    private Figura figura7;
    private Figura figura8;
    private Figura figura9;
    private Figura figura10;
    private boolean ejecucionActiva = true;
    private ImageIcon figuraRepetida;

    public JuegoController(JuegoView vista, JuegoModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        //vidaPerdida = new ImageIcon("vidaPerdida.png");
        vista.setVisible(true);
        //ronda = new JuegoModel().crearRonda();
        this.vista.addBtnJuegoListener(new ventanaListener());
        crearImagenes();
        iniciarJuego();
    }

    private void iniciarJuego() {
        colocarImagenes(numFiguras, 0);
        transicionDeImagen(0); // Reinicia la transición de imágenes
    }
    
    private void iniciarJuegoOtraVezAcierto() {
        reproducirSonido("acierto.wav");
        if (timer != null && timer.isRunning()) {
            timer.stop(); // Detiene el temporizador si está en ejecución
        }
        crearImagenes();
        colocarImagenes(numFiguras, 1000);
        transicionDeImagen(2000); // Reinicia la transición de imágenes
    }
    
    private void iniciarJuegoOtraVezFallo() {
        //ronda.restarVida();
        reproducirSonido("fallo.wav");
        if (timer != null && timer.isRunning()) {
            timer.stop(); // Detiene el temporizador si está en ejecución
        }
        quitarVida();
        crearImagenes();
        colocarImagenes(numFiguras, 1000);
        
        /*for(ImageIcon elemento : listaDeFigurasTransicion) {
            System.out.println(elemento);
        }*/
        
        transicionDeImagen(2000); // Reinicia la transición de imágenes
        
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
        figura7 = new JuegoModel().crearFigura(7, "figura7.png");
        figura8 = new JuegoModel().crearFigura(8, "figura8.png");
        figura9 = new JuegoModel().crearFigura(9, "figura9.png");
        figura10 = new JuegoModel().crearFigura(10, "figura10.png");
        
        listaDeFigurasPrincipal.add(figura1);
        listaDeFigurasPrincipal.add(figura2);
        listaDeFigurasPrincipal.add(figura3);
        listaDeFigurasPrincipal.add(figura4);
        listaDeFigurasPrincipal.add(figura5);
        listaDeFigurasPrincipal.add(figura6);
        listaDeFigurasPrincipal.add(figura7);
        listaDeFigurasPrincipal.add(figura8);
        listaDeFigurasPrincipal.add(figura9);
        listaDeFigurasPrincipal.add(figura10);
               
        Collections.shuffle(listaDeFigurasPrincipal);
        
        for(ImageIcon elemento : listaDeFigurasPrincipal) {
            System.out.println(elemento);
        }
    }
    
    private void colocarImagenes(int numeroDeImagenes, long delayMillis){
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        listaDeFigurasUsadas = new ArrayList<>();
        listaDeFigurasTransicion = new ArrayList<>();
        
        System.out.println(numeroDeImagenes);
        
        for(int i = 0; i < numeroDeImagenes; i++){
            Figura imagen1 = (Figura) listaDeFigurasPrincipal.get(i);
            listaDeFigurasUsadas.add(imagen1.getImagen());
        }
                
        for(int i = 0; i < numeroDeImagenes+2; i++){
            Figura imagen2 = (Figura) listaDeFigurasPrincipal.get(i);
            listaDeFigurasTransicion.add(imagen2.getImagen());
        }
        
        for(ImageIcon elemento : listaDeFigurasUsadas) {
            System.out.println(elemento);
        }
        
        for(ImageIcon elemento : listaDeFigurasTransicion) {
            System.out.println(elemento);
        }
        
        
        int min = 1; // Número mínimo
        int max = 8; // Número máximo

        // Crea una lista de números en el rango especificado
        for (int i = min; i <= max; i++) {
            numerosUsados.add(i);
        }
        
        
        for(ImageIcon elemento : listaDeFigurasUsadas) {
            asignarImagenAEtiquetaRamdon(elemento);
        }
        
        asignarEtiquetasConEstadoTrue();
    }
    
    private void asignarImagenAEtiquetaRamdon(ImageIcon figura){
        
        while (!numerosUsados.isEmpty()) {
            // Genera un índice aleatorio dentro del rango de la lista
            int indiceAleatorio = random.nextInt(numerosUsados.size());

            // Obtiene y muestra el número aleatorio
            int numeroAleatorio = numerosUsados.get(indiceAleatorio);
            System.out.println(numeroAleatorio);
            
            switch(numeroAleatorio) { 
                case 1 -> {
                    vista.setIconEtiqueta1(figura);
                    System.out.println(figura);
                }
                case 2 -> {
                    vista.setIconEtiqueta2(figura);
                    System.out.println(figura);
                }
                case 3 -> {
                    vista.setIconEtiqueta3(figura);
                    System.out.println(figura);
                }
                case 4 -> {
                    vista.setIconEtiqueta4(figura);
                    System.out.println(figura);
                }
                case 5 -> {
                    vista.setIconEtiqueta5(figura);
                    System.out.println(figura);
                }
                case 6 -> {
                    vista.setIconEtiqueta6(figura);
                    System.out.println(figura);
                }
                case 7 -> {
                    vista.setIconEtiqueta7(figura);
                    System.out.println(figura);
                }
                case 8 -> {
                    vista.setIconEtiqueta8(figura);
                    System.out.println(figura);
                }
            }

            // Elimina el número de la lista para que no se repita
            numerosUsados.remove(indiceAleatorio);
            break;
        }        
        /*
        switch(numeroAleatorio){
            case 0 -> vista.setIconEtiqueta1(figura);
            case 1 -> vista.setIconEtiqueta2(figura);
            case 2 -> vista.setIconEtiqueta3(figura);
            case 3 -> vista.setIconEtiqueta4(figura);
            case 4 -> vista.setIconEtiqueta5(figura);
            case 5 -> vista.setIconEtiqueta6(figura);
            case 6 -> vista.setIconEtiqueta7(figura);
            case 7 -> vista.setIconEtiqueta8(figura);   
        }*/
    }   

    private void transicionDeImagen(long delayMillis) {
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Configura un temporizador para cambiar las imágenes cada 4 segundos        
        timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //determinarFallo();
                if(indiceImagen < etiquetasConImagen.size()) {
                    int elemento = etiquetasConImagen.get(indiceImagen);
                    quitarImagenRepetida(vista.getIconEtiqueta(etiquetasConImagen.get(indiceImagen)));
                    System.out.println(vista.getIconEtiqueta(etiquetasConImagen.get(indiceImagen)));
                    mostrarSiguienteImagen(elemento);
                    System.out.println(vista.getIconEtiqueta(etiquetasConImagen.get(indiceImagen)));
                    devolverImagenRepetida();
                    indiceImagen++;
                    indiceImagen2++;
                }else if(indiceImagen >= etiquetasConImagen.size()){
                    indiceImagen = 0;
                }
            }
        });
        timer.setRepeats(true); // Para que el temporizador se ejecute periódicamente
        timer.start();    
    }
    
    private void mostrarSiguienteImagen(int id) {
        reproducirSonido("cambio.wav");
        if (indiceImagen2 < listaDeFigurasTransicion.size()) {
            Collections.shuffle(listaDeFigurasTransicion);
            for(ImageIcon elemento : listaDeFigurasTransicion) {
                System.out.println(elemento);
            }
            vista.setIconEtiqueta(id, listaDeFigurasTransicion.get(indiceImagen2));
            System.out.println(id);
            System.out.println(listaDeFigurasTransicion.get(indiceImagen2));
            //verificarImagenes();
        }else{
            //Reinicia la transición cuando se han mostrado todas las imágenes
            indiceImagen2 = 0;
        }
    }
    
    private void quitarImagenRepetida(ImageIcon imagenActual) {
        for(ImageIcon elemento : listaDeFigurasTransicion){
            areEqual3 = areImageIconsEqual(imagenActual, elemento);
            if(areEqual3 == true){
                listaDeFigurasTransicion.remove(elemento);
                figuraRepetida = elemento;
            }
        }
    }
    
    private void devolverImagenRepetida() {
        listaDeFigurasTransicion.add(figuraRepetida);
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

    private void ejecutar() {
        if (!ejecucionActiva) {
            return; // Esto finalizará el método y, por lo tanto, la ejecución del controlador.
        }
    }
    
    
    class ventanaListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            ImageIcon figuraVacia = new ImageIcon("figuraTrasparente.png");
            vista.setIconEtiqueta1Finalizar(figuraVacia);
            vista.setIconEtiqueta2Finalizar(figuraVacia);
            vista.setIconEtiqueta3Finalizar(figuraVacia);
            vista.setIconEtiqueta4Finalizar(figuraVacia);
            vista.setIconEtiqueta5Finalizar(figuraVacia);
            vista.setIconEtiqueta6Finalizar(figuraVacia);
            vista.setIconEtiqueta7Finalizar(figuraVacia);
            vista.setIconEtiqueta8Finalizar(figuraVacia);
            colocarImagenes(numFiguras, 0);
            
            
            
            /*if(hayFallo == true){
                limpiar();
                switch (numFiguras) {
                    case 3 -> numFiguras = 4;
                    case 4 -> numFiguras = 5;
                    case 5 -> numFiguras = 6;
                    case 6 -> numFiguras = 7;
                    case 7 -> numFiguras = 8;
                    case 8 -> numFiguras = 8;
                }
                iniciarJuegoOtraVezAcierto();  // Agrega esta línea para reiniciar el juego
            }else{
                System.out.println("Aun no hay fallo");
            } */  
        }
    }
    
    private void verificarImagenes(){        
        imagenesActivas = new ArrayList<>();
        obtenerImagenesActivas();
        for(int i = 0; i < imagenesActivas.size(); i++) {
            for(int j = i + 1; j < imagenesActivas.size(); j++) {
                areEqual = areImageIconsEqual(imagenesActivas.get(i), imagenesActivas.get(j));
                if (areEqual){
                    hayFallo = true;
                    System.out.println("Hay fallo"); 
                }else{
                    hayFallo = false;
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

        /*
        // Comparar píxel por píxel.
        int width = bufferedImage1.getWidth();
        int height = bufferedImage1.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (bufferedImage1.getRGB(x, y) != bufferedImage2.getRGB(x, y)) {
                    return false;  // Si se encuentra un píxel diferente, las imágenes no son iguales.
                }
            }
        }*/

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
        
        //listaDeFigurasPrincipal.clear();
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
                if (timer != null && timer.isRunning()) {
                    timer.stop(); // Detiene el temporizador si está en ejecución
                }
                
                vistaEstadisticas = new EstadisticasView();
                modeloEstadisticas = new EstadisticasModel();
                controladorEstadisticas = new EstadisticasController(vistaEstadisticas, modeloEstadisticas);
                
                vista.dispose();
                ejecucionActiva = false;
                ejecutar();
            }
            default -> System.out.println("No te quedan vidas");
        }
    }
    
    //Reproduce un sonido
    private void reproducirSonido(String audio) {
        try {
            //Carga el archivo de sonido
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(audio));
            Clip clip = AudioSystem.getClip();

            //Abre el clip y lo reproduce
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
