/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package modelo;

public class EstadisticasModel {
    private int puntaje;
    private int aciertos;
    private int fallos;
    
    public EstadisticasModel(int puntaje, int aciertos, int fallos) {
        this.puntaje = puntaje;
        this.aciertos = aciertos;
        this.fallos = fallos;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getFallos() {
        return fallos;
    }
}
