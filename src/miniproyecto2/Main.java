package miniproyecto2;

import vista.PrincipalView;
import modelo.PrincipalModel;
import controlador.PrincipalController;

public class Main {
    public static void main(String[] args) {
        PrincipalView vista = new PrincipalView();
        PrincipalModel modelo = new PrincipalModel();
        PrincipalController controlador = new PrincipalController(vista, modelo);
    }
}
