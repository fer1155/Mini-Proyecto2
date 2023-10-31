/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.EstadisticasModel;
import modelo.PrincipalModel;
import vista.EstadisticasView;
import vista.PrincipalView;

public class EstadisticasController {

    private EstadisticasView vista;
    private EstadisticasModel modelo;
    
    public EstadisticasController(EstadisticasView vista, EstadisticasModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setAciertos(modelo.getAciertos());
        vista.setFallos(modelo.getFallos());
        vista.setPuntaje(modelo.getPuntaje());
        
        vista.setVisible(true);
        
        this.vista.addBtnSaliListener(new ventanaListener());
        this.vista.addBtnVolveraJugarListener(new ventanaListener2());
    }
    
    class ventanaListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
           System.exit(0);
        }
    }
    
    class ventanaListener2 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            PrincipalView vistaPrincipal = new PrincipalView();
            PrincipalModel modeloPrincipal = new PrincipalModel();
            PrincipalController controlador = new PrincipalController(vistaPrincipal, modeloPrincipal);
            vista.dispose();
        }
    }
}
