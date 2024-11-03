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

    // Estudiante
    
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

    
    // Libro
    
    public void crearLibro(Libro Lib) {
        controlPersis.crearLibro(Lib);
    }

    public List<Libro> traerLibros() {
        return controlPersis.traerLibros();
    }

    public void borrarLibro(int id_eliminar) {
        controlPersis.borrarLibro(id_eliminar);
    }

    public Libro traerLibro(int id_editar) {
        return controlPersis.traerLibro(id_editar);
        
    }

    public void editarLibro(Libro Lib) {
    controlPersis.editarLibro (Lib); 
    
    }
    
    // Pedido Nuevo Libro
    
    public void crearPedidoNuevoLibro(Pedido_nuevolibro pNL) {
        controlPersis.crearPedidoNuevoLibro(pNL);
    }

    public List<Pedido_nuevolibro> traerPedidoNuevoLibros() {
        return controlPersis.traerPedidoNuevoLibros();
    }

    public void borrarPedidoNuevoLibro(int id_eliminar) {
        controlPersis.borrarPedidoNuevoLibro(id_eliminar);
    }

    public Pedido_nuevolibro traerPedidoNuevoLibro(int id_editar) {
        return controlPersis.traerPedidoNuevoLibro(id_editar);
        
    }

    public void editarPedidoNuevoLibro(Pedido_nuevolibro pNL) {
    controlPersis.editarPedidoNuevoLibro(pNL); 
    
    }
// Prestamo
    
    public void crearPrestamo(Prestamo prest) {
        controlPersis.crearPrestamo(prest);
    }

    public List<Prestamo> traerPrestamos() {
        return controlPersis.traerPrestamos();
    }

    public void borrarPrestamo(int id_eliminar) {
        controlPersis.borrarPrestamo(id_eliminar);
    }

    public Prestamo traerPrestamo(int id_editar) {
        return controlPersis.traerPrestamo(id_editar);
        
    }

    public void editarPrestamo(Prestamo prest) {
    controlPersis.editarPrestamo(prest);
    
    }
    
}
