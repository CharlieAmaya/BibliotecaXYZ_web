/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author amaya
 */
public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearEstudiante(Estudiante estu) {
        controlPersis.crearEstudiante(estu);
    }

    public List<Estudiante> traerEstudiante() {
        return controlPersis.traerEstudiante();
    }

    public void borrarEstudiante(int id_eliminar) {
        controlPersis.borrarEstudiante(id_eliminar);
    }

    public Estudiante traerEstudiante_s(int id_editar) {
        return controlPersis.traerEstudiante_s(id_editar);
        
    }

    public void editarEstudiante(Estudiante estu) {
    controlPersis.editarEstudiante (estu); 
    
    }

}
