package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.PrincipalView;
import modelo.PrincipalModel;
import vista.FuncionView;
import modelo.FuncionModel;

public class PrincipalController {
    
    private PrincipalView vista;
    private PrincipalModel modelo;
    private FuncionView vistaFuncion;
    private FuncionModel modeloFuncion;
    private FuncionController controladorFuncion;

    public PrincipalController(PrincipalView vista, PrincipalModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
 
        this.vista.addBtnFuncionListener(new ventanaListener());
        this.vista.addBtnJuegoListener(new ventanaListener());
    }
    
    class ventanaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equalsIgnoreCase("¿Para que sirve?")){
                vistaFuncion = new FuncionView();
                modeloFuncion = new FuncionModel();
                controladorFuncion = new FuncionController(vistaFuncion, modeloFuncion);
                
                vista.dispose();
            }
            
            if(e.getActionCommand().equalsIgnoreCase("Jugar")){
                System.out.println("Holaa");
           }
        }
        
    }
}
