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
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author amaya
 */
@Entity
@Table(name = "libro")
public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_libro;
    private String nombre;
    private String autor;
    private String idioma;
    private String genero;
    private int inventario;
    private String editorial;
    @Temporal(TemporalType.DATE)
    private Date fecha_publicacion;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "lib", fetch = FetchType.EAGER)
    private List<Prestamo> listaPrestamo;

    public Libro() {
    }

    public Libro(int id_libro, String nombre, String autor, String idioma, String genero, int inventario, String editorial, Date fecha_publicacion, List<Prestamo> listaPrestamo) {
        this.id_libro = id_libro;
        this.nombre = nombre;
        this.autor = autor;
        this.idioma = idioma;
        this.genero = genero;
        this.inventario = inventario;
        this.editorial = editorial;
        this.fecha_publicacion = fecha_publicacion;
        this.listaPrestamo = listaPrestamo;
    }

    public List<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

}
