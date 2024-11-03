/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author amaya
 */
@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudiante;
    private String nombre;
    private String edad;
    private String correo;
    private String num_contacto;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "estu", fetch = FetchType.EAGER)
    private List<Pedido_nuevolibro> listaPedidosNL;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "estu", fetch = FetchType.EAGER)
    private List<Prestamo> listaPrestamo;

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String nombre, String edad, String correo, String num_contacto, List<Pedido_nuevolibro> listaPedidosNL, List<Prestamo> listaPrestamo) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.num_contacto = num_contacto;
        this.listaPedidosNL = listaPedidosNL;
        this.listaPrestamo = listaPrestamo;
    }

    public List<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public List<Pedido_nuevolibro> getListaPedidosNL() {
        return listaPedidosNL;
    }

    public void setListaPedidosNL(List<Pedido_nuevolibro> listaPedidosNL) {
        this.listaPedidosNL = listaPedidosNL;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNum_contacto() {
        return num_contacto;
    }

    public void setNum_contacto(String num_contacto) {
        this.num_contacto = num_contacto;
    }

}
