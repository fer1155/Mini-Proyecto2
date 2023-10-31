/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package modelo;

import javax.swing.ImageIcon;

public class JuegoModel {  
    public JuegoModel() {
    }
    
    public Figura crearFigura(String imagen1, int id1){
        Figura figura = new Figura(imagen1, id1);
        return figura;         
    }
    
    public Ronda crearRonda(){
        Ronda ronda = new Ronda();
        return ronda;         
    }
    
    public class Figura extends ImageIcon{
        private int id;
        
        public Figura(String filename, int id) {
            super(filename);
            this.id = id;
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
        private int aciertos;
        private int fallos;
        
        public Ronda() {
            vidas = 3;
            puntaje = 0;
            aciertos = 0;
            fallos = 0;
        }
        
        public void restarVida(){
            if(vidas > 0){
                vidas = vidas-1;
            }
        }
        
        public void aumetarPuntaje(int puntajeAsumar){
            puntaje += puntajeAsumar;
        }
        
        public void aumentarAciertos(){
            aciertos = aciertos + 1;
        }
        
        public void aumentarFallos(){
            fallos = fallos + 1;
        }
        
        public int getVidas(){
            return vidas;
        }
        
        public int getPuntaje(){
            return puntaje;
        }
        
        public int getAciertos(){
            return aciertos;
        }
        
        public int getFallos(){
            return fallos;
        }
    }
}
