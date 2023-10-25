package controlador;

import vista.PrincipalView;

public class PrincipalController {
    
    private PrincipalView vista;

    public PrincipalController(PrincipalView vista) {
        this.vista = vista;
        vista.setVisible(true);
    }
    
    
}
