/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import modelo.EstadisticasModel;
import modelo.JuegoModel;
import modelo.JuegoModel.Figura;
import modelo.JuegoModel.Ronda;
import vista.EstadisticasView;
import vista.JuegoView;

public class JuegoController {
    
    private JuegoView vista;
    private JuegoModel modelo;
    private EstadisticasView vistaEstadisticas;
    private EstadisticasModel modeloEstadisticas;
    private EstadisticasController controladorEstadisticas;
    private ArrayList<Figura> listaDeFigurasPrincipal, listaDeFigurasUsadas, listaDeFigurasTransicion;
    private ArrayList<Figura> imagenesActivas = new ArrayList<>();;
    private ArrayList<Integer> numerosUsados = new ArrayList<>();
    private ArrayList<Integer> etiquetasConImagen;
    private Figura figura1, figura2,figura3, figura4, figura5, figura6, figura7, figura8, figura9, figura10, figuraRepetida;
    private Ronda ronda;
    private int indiceImagen = 0, indiceImagen2 = 0;
    private int numFiguras = 3;
    private int tiempoDeterminarFallo = 5000, tiempoTransicion = 6000;
    private boolean hayFallo;
    private boolean quitarImagenRepetida = false;
    private boolean muted = false;
    private ImageIcon vidaPerdida;
    private Timer timer;
    private Timer timer2;
    private TimerTask tarea; 
    private TimerTask tarea2;
    Random random = new Random();

    public JuegoController(JuegoView vista, JuegoModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        ronda = new JuegoModel().crearRonda();
        this.vista.addBtnJuegoListener(new btonJuegoListener());
        this.vista.addBtnJuegoListener(new btonJuegoListener2());
        this.vista.addBtnSaliListener(new btonSalirListener());
        this.vista.addBtnSonidoListener(new btonSonidoListener());
        vidaPerdida = new ImageIcon("vidaPerdida.png");

        crearImagenes();
        iniciarJuego();
    }

    private void iniciarJuego() {
        colocarImagenes(numFiguras, 0);
        transicionDeImagen(0); 
    }
    
    private void iniciarJuegoOtraVezAcierto() {
        hayFallo = false;
        tarea2.cancel();
        timer2.cancel();
        if (muted == false) {
            reproducirSonido("acierto.wav");
        }
        colocarImagenes(numFiguras, 0);
        transicionDeImagen(0); 
    }
    
    private void iniciarJuegoOtraVezFallo() {
        hayFallo = false;
        tarea2.cancel();
        timer2.cancel();
        if (muted == false) {
            reproducirSonido("fallo.wav");
        }
        quitarVida();
        colocarImagenes(numFiguras, 0);
        transicionDeImagen(0);   
    }
    
    private void crearImagenes() {
        listaDeFigurasPrincipal = new ArrayList<>();
        
        figura1 = new JuegoModel().crearFigura("figura1.png", 1);
        figura2 = new JuegoModel().crearFigura("figura2.png", 2);
        figura3 = new JuegoModel().crearFigura("figura3.png", 3);
        figura4 = new JuegoModel().crearFigura("figura4.png", 4);
        figura5 = new JuegoModel().crearFigura("figura5.png", 5);
        figura6 = new JuegoModel().crearFigura("figura6.png", 6);
        figura7 = new JuegoModel().crearFigura("figura7.png", 7);
        figura8 = new JuegoModel().crearFigura("figura8.png", 8);
        figura9 = new JuegoModel().crearFigura("figura9.png", 9);
        figura10 = new JuegoModel().crearFigura("figura10.png", 10);
        
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
    }
    
    private void colocarImagenes(int numeroDeImagenes, long delayMillis){
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        listaDeFigurasUsadas = new ArrayList<>();
        listaDeFigurasTransicion = new ArrayList<>();
        
        for(int i = 0; i < numeroDeImagenes; i++){
            listaDeFigurasUsadas.add(listaDeFigurasPrincipal.get(i));
        }
                
        for(int i = 0; i < numeroDeImagenes+2; i++){
            listaDeFigurasTransicion.add(listaDeFigurasPrincipal.get(i));
        }
                
        int min = 1; // Número mínimo
        int max = 8; // Número máximo

        // Crea una lista de números en el rango especificado
        for (int i = min; i <= max; i++) {
            numerosUsados.add(i);
        }
        
        for(Figura elemento : listaDeFigurasUsadas) {
            asignarImagenAEtiquetaRamdon(elemento);
        }
        
        asignarEtiquetasConEstadoTrue();
    }
    
    private void asignarImagenAEtiquetaRamdon(Figura figura){
        while (!numerosUsados.isEmpty()) {
            // Genera un índice aleatorio dentro del rango de la lista
            int indiceAleatorio = random.nextInt(numerosUsados.size());

            // Obtiene y muestra el número aleatorio
            int numeroAleatorio = numerosUsados.get(indiceAleatorio);
            
            switch(numeroAleatorio) { 
                case 1 -> {
                    vista.setIconEtiqueta1(figura);
                }
                case 2 -> {
                    vista.setIconEtiqueta2(figura);
                }
                case 3 -> {
                    vista.setIconEtiqueta3(figura);
                }
                case 4 -> {
                    vista.setIconEtiqueta4(figura);
                }
                case 5 -> {
                    vista.setIconEtiqueta5(figura);
                }
                case 6 -> {
                    vista.setIconEtiqueta6(figura);
                }
                case 7 -> {
                    vista.setIconEtiqueta7(figura);
                }
                case 8 -> {
                    vista.setIconEtiqueta8(figura);
                }
            }

            // Elimina el número de la lista para que no se repita
            numerosUsados.remove(indiceAleatorio);
            break;
        }
    }   

    private void transicionDeImagen(long delayMillis) {
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(ronda.getVidas() != 0){
            timer = new Timer();
            tarea = new TimerTask() {
                @Override
                public void run() {
                    if(indiceImagen < etiquetasConImagen.size()) {
                        int elemento = etiquetasConImagen.get(indiceImagen);
                        quitarImagenRepetida(vista.getIconEtiqueta(etiquetasConImagen.get(indiceImagen)));
                        mostrarSiguienteImagen(elemento);
                        devolverImagenRepetida();
                        indiceImagen++;
                        indiceImagen2++;
                    }else if(indiceImagen >= etiquetasConImagen.size()){
                        indiceImagen = 0;
                        indiceImagen2 = 0;
                    }
                }
            };
            timer.schedule(tarea, 2000, tiempoTransicion);
            determinarFallo();
        }else{
            tarea2.cancel();
            timer2.cancel();
            vista.dispose();
                
            vistaEstadisticas = new EstadisticasView();
            modeloEstadisticas = new EstadisticasModel(ronda.getPuntaje(), ronda.getAciertos(), ronda.getFallos());
            controladorEstadisticas = new EstadisticasController(vistaEstadisticas, modeloEstadisticas);
        }
    }
    
    private void mostrarSiguienteImagen(int id) {
        if (muted == false) {
            reproducirSonido("cambio.wav");
        }
        if (indiceImagen2 < listaDeFigurasTransicion.size()) {
            Collections.shuffle(listaDeFigurasTransicion);
            vista.setIconEtiqueta(id, listaDeFigurasTransicion.get(indiceImagen2));
            verificarImagenes();
        }
    }
    
    private void quitarImagenRepetida(Figura imagenActual) {
        for(Figura elemento : listaDeFigurasTransicion){
            if(imagenActual.getID() == elemento.getID()){
                quitarImagenRepetida = true;
                figuraRepetida = elemento;
            }
        }
        
        if(quitarImagenRepetida == true){
            listaDeFigurasTransicion.remove(figuraRepetida);
        }
    }
    
    private void devolverImagenRepetida() {
        listaDeFigurasTransicion.add(figuraRepetida);
        quitarImagenRepetida = false;
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
         
        Collections.shuffle(etiquetasConImagen);
    }
    
    class btonJuegoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(hayFallo == true){
                limpiar();
                tarea.cancel();
                timer.cancel();
                
                switch(numFiguras) { 
                    case 3 -> {
                        numFiguras = 4;
                        aumentarPuntaje(5);
                        tiempoDeterminarFallo = 5000;
                        tiempoTransicion = 6000;
                    }
                    case 4 -> {
                        numFiguras = 5;
                        aumentarPuntaje(10);
                        tiempoDeterminarFallo = 4000;
                        tiempoTransicion = 5000;
                    }
                    case 5 -> {
                        numFiguras = 6;
                        aumentarPuntaje(15);
                        tiempoDeterminarFallo = 3000;
                        tiempoTransicion = 4000;
                    }
                    case 6 -> {
                        numFiguras = 7;
                        aumentarPuntaje(20);
                        tiempoDeterminarFallo = 3000;
                        tiempoTransicion = 4000;
                    }
                    case 7 -> {
                        numFiguras = 8;
                        aumentarPuntaje(25);
                        tiempoDeterminarFallo = 2000;
                        tiempoTransicion = 3000;
                    }
                    case 8 -> {
                        numFiguras = 8;
                        aumentarPuntaje(30);
                        tiempoDeterminarFallo = 1000;
                        tiempoTransicion = 2000;
                    }
                }
                ronda.aumentarAciertos();
                iniciarJuegoOtraVezAcierto();  //Agrege esta línea para reiniciar el juego
            }else if(hayFallo == false){
                tarea.cancel();
                timer.cancel();
                imagenesActivas.add(figura1);
                limpiar();
                
                switch(numFiguras) {
                    case 3 -> {
                        numFiguras = 3;
                        tiempoDeterminarFallo = 5000;
                        tiempoTransicion = 6000;
                    }
                    case 4 -> {
                        numFiguras = 3;
                        tiempoDeterminarFallo = 5000;
                        tiempoTransicion = 6000;
                    }
                    case 5 -> {
                        numFiguras = 4;
                        tiempoDeterminarFallo = 4000;
                        tiempoTransicion = 5000;
                    }
                    case 6 -> {
                        numFiguras = 5;
                        tiempoDeterminarFallo = 3000;
                        tiempoTransicion = 4000;
                    }
                    case 7 -> {
                        numFiguras = 6;
                        tiempoDeterminarFallo = 3000;
                        tiempoTransicion = 4000;
                    }
                    case 8 -> {
                        numFiguras = 7;
                        tiempoDeterminarFallo = 2000;
                        tiempoTransicion = 3000;
                    }
                }
                ronda.aumentarFallos();
                iniciarJuegoOtraVezFallo(); 
            }   
        }
    }
    
    class btonJuegoListener2 extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
        }
    }   
    
    class btonSalirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tarea.cancel();
            timer.cancel();
            tarea2.cancel();
            timer2.cancel();
            vista.dispose();
                
            vistaEstadisticas = new EstadisticasView();
            modeloEstadisticas = new EstadisticasModel(ronda.getPuntaje(), ronda.getAciertos(), ronda.getFallos());
            controladorEstadisticas = new EstadisticasController(vistaEstadisticas, modeloEstadisticas);
        }
    }
    
    class btonSonidoListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(muted == false) {
                muted = true;
                ImageIcon off = new ImageIcon ("off.png");
                vista.setIconMuteActivado(off);
            }else{
                muted = false;
                ImageIcon on = new ImageIcon ("on.png");
                vista.setIconMuteDesactivado(on);
            } 
        }
    }
    
    private void verificarImagenes(){        
        imagenesActivas = new ArrayList<>();
        obtenerImagenesActivas();
        for(int i = 0; i < imagenesActivas.size(); i++) {
            for(int j = i + 1; j < imagenesActivas.size(); j++) {
                if (imagenesActivas.get(i).getID() == imagenesActivas.get(j).getID() ){
                    hayFallo = true;
                }
            }
        }
    }
    
    private void obtenerImagenesActivas(){
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
    
    public void limpiar(){
        vista.setIconEtiqueta1Finalizar();
        vista.setIconEtiqueta2Finalizar();
        vista.setIconEtiqueta3Finalizar();
        vista.setIconEtiqueta4Finalizar();
        vista.setIconEtiqueta5Finalizar();
        vista.setIconEtiqueta6Finalizar();
        vista.setIconEtiqueta7Finalizar();
        vista.setIconEtiqueta8Finalizar();
        
        listaDeFigurasUsadas.clear();
        listaDeFigurasTransicion.clear();
        etiquetasConImagen.clear();
        imagenesActivas.clear();
        numerosUsados.clear();
        
        indiceImagen = 0;
        indiceImagen2 = 0;
    }
    
    public void determinarFallo(){
        timer2 = new Timer();
        tarea2 = new TimerTask() {
            @Override
            public void run() {
                if(hayFallo == true){
                    tarea.cancel();
                    timer.cancel();
                    limpiar();

                    switch(numFiguras) { 
                        case 3 -> {
                            numFiguras = 3;
                            tiempoDeterminarFallo = 5000;
                            tiempoTransicion = 6000;
                        }
                        case 4 -> {
                            numFiguras = 3;
                            tiempoDeterminarFallo = 5000;
                            tiempoTransicion = 6000;
                        }
                        case 5 -> {
                            numFiguras = 4;
                            tiempoDeterminarFallo = 4000;
                            tiempoTransicion = 5000;
                        }
                        case 6 -> {
                            numFiguras = 5;
                            tiempoDeterminarFallo = 3000;
                            tiempoTransicion = 4000;
                            
                        }
                        case 7 -> {
                            numFiguras = 6;
                            tiempoDeterminarFallo = 3000;
                            tiempoTransicion = 4000;
                            
                        }
                        case 8 -> {
                            numFiguras = 7;
                            tiempoDeterminarFallo = 2000;
                            tiempoTransicion = 3000;
                        }
                    }
                    ronda.aumentarFallos();
                    iniciarJuegoOtraVezFallo(); 
                }
            }
        };
        timer2.schedule(tarea2, 1000, tiempoDeterminarFallo);
    }
    
    public void quitarVida(){
        switch (ronda.getVidas()) {
            case 3 -> {
                ronda.restarVida();
                vista.setIconEtiquetaVida1(vidaPerdida);
            }
            case 2 -> {
                ronda.restarVida();
                vista.setIconEtiquetaVida2(vidaPerdida);
            }
            case 1 -> {
                ronda.restarVida();
                vista.setIconEtiquetaVida3(vidaPerdida);
            }
        }
    }
    
    public void aumentarPuntaje(int puntaje){
        ronda.aumetarPuntaje(puntaje);
        vista.setPuntaje(ronda.getPuntaje());
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
