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

public class InstruccionesController2 {
    private InstruccionesView2 vista;
    private InstruccionesModel2 modelo;
    private PrincipalView vistaPrincipal;
    private PrincipalModel modeloPrincipal;
    private PrincipalController controladorPrincipal;
    private InstruccionesController controladorInstrucciones;
    private InstruccionesView vistaInstrucciones;
    private InstruccionesModel modeloInstrucciones;
    private InstruccionesController3 controladorInstrucciones3;
    private InstruccionesView3 vistaInstrucciones3;
    private InstruccionesModel3 modeloInstrucciones3;

    public InstruccionesController2(InstruccionesView2 vista, InstruccionesModel2 modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        this.vista.addBtnCerrarListener(new btnCerrarVentanaListener());
        this.vista.addBtnSiguienteListener(new btnSiguienteVentanaListener());
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
    
    class btnSiguienteVentanaListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            vistaInstrucciones3 = new InstruccionesView3();
            modeloInstrucciones3 = new InstruccionesModel3();
            controladorInstrucciones3 = new InstruccionesController3(vistaInstrucciones3, modeloInstrucciones3);
            vista.dispose();
        }   
    }
    
    class btnAnteriorVentanaListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            vistaInstrucciones = new InstruccionesView();
            modeloInstrucciones = new InstruccionesModel();
            controladorInstrucciones = new InstruccionesController(vistaInstrucciones, modeloInstrucciones);
            vista.dispose();
        }   
    }
}
