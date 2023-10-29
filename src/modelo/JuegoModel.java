package modelo;

import javax.swing.ImageIcon;

public class JuegoModel {  
    public JuegoModel() {
    }
    
    public Figura crearFigura(int id1, String imagen1){
        Figura figura = new Figura(id1, imagen1);
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
        
        public Figura(int id, String imagen){
            this.id = id;
            figura = new ImageIcon(imagen);
        }
        
        public Figura(int id, ImageIcon asignarId){
            this.id = id;
            figura2 = asignarId;
        }
        
        public int getId(){
            return id;
        }
        
        public ImageIcon getImagen(){
            return figura;
        }
    }
    
    public class Ronda{
        private int vidas;
        
        public Ronda() {
            vidas = 3;
        }
        
        public void restarVida(){
            if(vidas > 0){
                vidas = vidas-1;
            }
        }
        
        public int getVidas(){
            return vidas;
        }
    }
}
