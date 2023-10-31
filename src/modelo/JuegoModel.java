package modelo;

import javax.swing.ImageIcon;

public class JuegoModel {  
    public JuegoModel() {
    }
    
    public Figura crearFigura(String imagen1, int id1){
        Figura figura = new Figura(imagen1, id1);
        return figura;         
    }
    
    public Figura crearFigura(int id2, ImageIcon imagen2){
        Figura figura = new Figura(id2, imagen2);
        return figura;         
    }
    
    public Ronda crearRonda(){
        Ronda ronda = new Ronda();
        return ronda;         
    }
    
    public class Figura extends ImageIcon{
        private int id;
        private ImageIcon figura;
        private ImageIcon figura2;
        
        public Figura(String filename, int id) {
            super(filename);
            this.id = id;
        }
        
        public Figura(int id, ImageIcon asignarId){
            this.id = id;
            figura2 = asignarId;
        }

        public int getID() {
            return id;
        }

        public void setID(int id) {
            this.id = id;
        }
    }
    
    public class Ronda{
        private int vidas;
        private int puntaje;
        
        public Ronda() {
            vidas = 3;
            puntaje = 0;
        }
        
        public void restarVida(){
            if(vidas > 0){
                vidas = vidas-1;
            }
        }
        
        public void aumetarPuntaje(int puntajeAsumar){
            puntaje += puntajeAsumar;
        }
        
        public int getVidas(){
            return vidas;
        }
        
        public int getPuntaje(){
            return puntaje;
        }
    }
}
