/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.EstadisticasModel;
import vista.EstadisticasView;

public class EstadisticasController {

    private EstadisticasView vista;
    private EstadisticasModel modelo;
    
    public EstadisticasController(EstadisticasView vista, EstadisticasModel modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
        vista.setVisible(true);
    }
    
}
