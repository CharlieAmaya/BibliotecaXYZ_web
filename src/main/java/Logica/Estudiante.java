/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import jakarta.persistence.Id;

/**
 *
 * @author amaya
 */
@Entity
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_estudiante;
    private String nombre;
    private String edad;
    private String correo;
    private String num_contacto;

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String nombre, String edad, String correo, String num_contacto) {
        this.id_estudiante = id_estudiante;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.num_contacto = num_contacto;
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
