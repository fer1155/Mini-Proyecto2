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
import modelo.InstruccionesModel3;
import modelo.PrincipalModel;
import vista.InstruccionesView;
import vista.InstruccionesView2;
import vista.InstruccionesView3;
import vista.PrincipalView;

public class InstruccionesController3 {
    private InstruccionesView3 vista;
    private InstruccionesModel3 modelo;
    private PrincipalView vistaPrincipal;
    private PrincipalModel modeloPrincipal;
    private PrincipalController controladorPrincipal;
    private InstruccionesController controladorInstrucciones;
    private InstruccionesView vistaInstrucciones;
    private InstruccionesModel modeloInstrucciones;
    private InstruccionesView2 vistaInstrucciones2;
    private InstruccionesModel2 modeloInstrucciones2;
    private InstruccionesController2 controladorInstrucciones2;

    public InstruccionesController3(InstruccionesView3 vista, InstruccionesModel3 modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        this.vista.addBtnCerrarListener(new btnCerrarVentanaListener());
        this.vista.addBtnAnteriorListener(new btnAnteriorVentanaListener());
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
    
    class btnAnteriorVentanaListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            vistaInstrucciones2 = new InstruccionesView2();
            modeloInstrucciones2 = new InstruccionesModel2();
            controladorInstrucciones2 = new InstruccionesController2(vistaInstrucciones2, modeloInstrucciones2);
            vista.dispose();
        }   
    }
}
