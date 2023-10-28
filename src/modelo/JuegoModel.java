package modelo;

import javax.swing.ImageIcon;

public class JuegoModel {  
    public JuegoModel() {
    }
    
    public Figura crearFigura(int id, String imagen){
        Figura figura = new Figura(id, imagen);
        return figura;         
    }
    
    public Figura crearFigura(int id, ImageIcon imagen){
        Figura figura = new Figura(id, imagen);
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
        
        public Figura(int id,ImageIcon asignarId){
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
