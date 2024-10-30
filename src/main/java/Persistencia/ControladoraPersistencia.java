/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Estudiante;
import Logica.Libro;
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
    LibroJpaController libJpa = new LibroJpaController();

    
    //Estudiante
    
    //Operacion CREATE
    public void crearEstudiante(Estudiante estu) {
        estuJpa.create(estu);

    }

    //Operacion READ
    public List<Estudiante> traerEstudiante() {
        return estuJpa.findEstudianteEntities();
    }
    //Operacion Eliminar

    public void borrarEstudiante(int id_eliminar) {
        try {
            estuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Operacion editar

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
    
    //Libro
    
     //Operacion CREATE
    public void crearLibro(Libro Lib) {
        libJpa.create(Lib);

    }

    //Operacion READ
    public List<Libro> traerLibros() {
        return libJpa.findLibroEntities();
    }
    //Operacion Eliminar

    public void borrarLibro(int id_eliminar) {
        try {
            libJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Operacion editar

    public Libro traerLibro(int id_editar) {
        return libJpa.findLibro(id_editar);
    }

    public void editarLibro(Libro estu) {
        try {
            libJpa.edit(estu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
