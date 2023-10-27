/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miniproyecto2;
import vista.PrincipalView;
import modelo.PrincipalModel;
import controlador.PrincipalController;
/**
 *
 * @author Fernando
 */
public class Main {
    public static void main(String[] args) {
        PrincipalView vista = new PrincipalView();
        PrincipalModel modelo = new PrincipalModel();
        PrincipalController controlador = new PrincipalController(vista, modelo);
    }
    
}
