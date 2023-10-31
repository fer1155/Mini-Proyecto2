/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import modelo.InstruccionesModel;
import modelo.InstruccionesModel2;
import modelo.PrincipalModel;
import vista.InstruccionesView;
import vista.InstruccionesView2;
import vista.PrincipalView;

public class InstruccionesController {
    private InstruccionesView vista;
    private InstruccionesModel modelo;
    private PrincipalView vistaPrincipal;
    private PrincipalModel modeloPrincipal;
    private PrincipalController controladorPrincipal;
    private InstruccionesView2 vistaInstrucciones;
    private InstruccionesModel2 modeloInstrucciones;
    private InstruccionesController2 controladorInstrucciones;
    
    public InstruccionesController(InstruccionesView vista, InstruccionesModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        this.vista.addBtnCerrarListener(new btnCerrarVentanaListener());
        this.vista.addBtnSiguienteListener(new btnSiguienteVentanaListener());
    }
    
    class btnCerrarVentanaListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            vistaPrincipal = new PrincipalView();
            modeloPrincipal = new PrincipalModel();
            controladorPrincipal = new PrincipalController(vistaPrincipal, modeloPrincipal);
            vista.dispose();
        }   
    }
    
    class btnSiguienteVentanaListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            vistaInstrucciones = new InstruccionesView2();
            modeloInstrucciones = new InstruccionesModel2();
            controladorInstrucciones = new InstruccionesController2(vistaInstrucciones, modeloInstrucciones);
            vista.dispose();
        }   
    }
}
