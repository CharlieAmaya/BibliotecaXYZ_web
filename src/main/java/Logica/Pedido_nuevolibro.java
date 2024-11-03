/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author amaya
 */
@Entity
@Table(name = "pedido_nuevolibro")
public class Pedido_nuevolibro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedidoNuevoLibro;
    
    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estu;
    //private int id_estudiante;
    
    private String estado;
    private String nombreLibro;
    private String editorial;
    private String autor;
    
    @Temporal(TemporalType.DATE)
    private Date fecha_solicitud;

    public Pedido_nuevolibro() {
    }

    public Pedido_nuevolibro(int id_pedidoNuevoLibro, Estudiante estu, String estado, String nombreLibro, String editorial, String autor, Date fecha_solicitud) {
        this.id_pedidoNuevoLibro = id_pedidoNuevoLibro;
        this.estu = estu;
        this.estado = estado;
        this.nombreLibro = nombreLibro;
        this.editorial = editorial;
        this.autor = autor;
        this.fecha_solicitud = fecha_solicitud;
    }

    public int getId_pedidoNuevoLibro() {
        return id_pedidoNuevoLibro;
    }

    public void setId_pedidoNuevoLibro(int id_pedidoNuevoLibro) {
        this.id_pedidoNuevoLibro = id_pedidoNuevoLibro;
    }

    public Estudiante getEstu() {
        return estu;
    }

    public void setEstu(Estudiante estu) {
        this.estu = estu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }


}
