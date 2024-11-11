/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Logica.Estudiante;
import Logica.Usuario;
import Logica.Libro;
import Logica.Pedido_nuevolibro;
import Logica.Prestamo;
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
    UsuarioJpaController usuJpa = new UsuarioJpaController();
    LibroJpaController libJpa = new LibroJpaController();
    Pedido_nuevolibroJpaController pNLJpa = new Pedido_nuevolibroJpaController();
    PrestamoJpaController prestJpa = new PrestamoJpaController();

    public ControladoraPersistencia() {
    }
    
    
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
    
    //Usuarios
    //Operacion CREATE
    public void crearUsuario (Usuario usu) {
        usuJpa.create(usu);

    }

    //Operacion READ
    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }
    //Operacion Eliminar

    public void borrarUsuario(int id_eliminar) {
        try {
            usuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Operacion editar

    public Usuario traerUsuario (int id_editar) {
        return usuJpa.findUsuario(id_editar);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
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

    //Pedido Nuevo Libro
    //Operacion CREATE
    public void crearPedidoNuevoLibro(Pedido_nuevolibro pNL) {
        pNLJpa.create(pNL);

    }

    //Operacion READ
    public List<Pedido_nuevolibro> traerPedidoNuevoLibros() {
        return pNLJpa.findPedido_nuevolibroEntities();
    }
    //Operacion Eliminar

    public void borrarPedidoNuevoLibro(int id_eliminar) {
        try {
            pNLJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Operacion editar

    public Pedido_nuevolibro traerPedidoNuevoLibro(int id_editar) {
        return pNLJpa.findPedido_nuevolibro(id_editar);
    }

    public void editarPedidoNuevoLibro(Pedido_nuevolibro pNL) {
        try {
            pNLJpa.edit(pNL);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //Prestamo
    //Operacion CREATE
    public void crearPrestamo(Prestamo prest) {
        prestJpa.create(prest);

    }

    //Operacion READ
    public List<Prestamo> traerPrestamos() {
        return prestJpa.findPrestamoEntities();
    }
    //Operacion Eliminar

    public void borrarPrestamo(int id_eliminar) {
        try {
            prestJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Operacion editar

    public Prestamo traerPrestamo(int id_editar) {
        return prestJpa.findPrestamo(id_editar);
    }

    public void editarPrestamo(Prestamo prest) {
        try {
            prestJpa.edit(prest);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
