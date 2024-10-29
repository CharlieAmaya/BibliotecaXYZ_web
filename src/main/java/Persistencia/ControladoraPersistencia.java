/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Estudiante;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amaya
 */
public class ControladoraPersistencia {
    
    EstudianteJpaController estuJpa = new EstudianteJpaController();
    
    
    //Operacion CREATE
    public void crearEstudiante(Estudiante estu) {
        estuJpa.create(estu);
        
    }
    
    //Operacion READ
    public List<Estudiante> traerEstudiante (){
        return estuJpa.findEstudianteEntities();
    }

    public void borrarEstudiante(int id_eliminar) {
        try {
            estuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Estudiante traerEstudiante_s(int id_editar) {
        return estuJpa.findEstudiante(id_editar);
    }

    public void editarEstudiante(Estudiante estu) {
        try {
            estuJpa.edit(estu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
