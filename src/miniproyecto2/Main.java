/*
Miniproyecto No. 2

Fernando Cardona - 2241381
Oscar Mario Muñoz - 2242481

Grupo de FPOE: 80
*/

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
