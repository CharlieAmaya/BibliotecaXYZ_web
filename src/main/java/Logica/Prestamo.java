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
@Table(name = "prestamo")
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prestamo;

    @Temporal(TemporalType.DATE)
    private Date fecha_solicitud;
    @Temporal(TemporalType.DATE)
    private Date fecha_entrega;
    @Temporal(TemporalType.DATE)
    private Date fecha_inicio;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estu;

    @ManyToOne
    @JoinColumn(name = "id_libro")
    private Libro lib;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, Date fecha_solicitud, Date fecha_entrega, Date fecha_inicio, Estudiante estu, Libro lib) {
        this.id_prestamo = id_prestamo;
        this.fecha_solicitud = fecha_solicitud;
        this.fecha_entrega = fecha_entrega;
        this.fecha_inicio = fecha_inicio;
        this.estu = estu;
        this.lib = lib;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Estudiante getEstu() {
        return estu;
    }

    public void setEstu(Estudiante estu) {
        this.estu = estu;
    }

    public Libro getLib() {
        return lib;
    }

    public void setLib(Libro lib) {
        this.lib = lib;
    }
    
    

}
