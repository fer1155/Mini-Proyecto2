package controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import vista.FuncionView;
import modelo.FuncionModel;
import modelo.PrincipalModel;
import vista.PrincipalView;

public class FuncionController {
    
    private FuncionView vista;
    private FuncionModel modelo;
    private PrincipalView vistaPrincipal;
    private PrincipalModel modeloPrincipal;
    private PrincipalController controladorPrincipal;

    public FuncionController(FuncionView vista, FuncionModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
        
        this.vista.addBtnCerrarListener(new ventanaListener());
    }
    
    class ventanaListener extends MouseAdapter{
        
        @Override
        public void mouseClicked(MouseEvent e) {
            vistaPrincipal = new PrincipalView();
            modeloPrincipal = new PrincipalModel();
            controladorPrincipal = new PrincipalController(vistaPrincipal, modeloPrincipal);
                
            vista.dispose();
        }   
    }
}