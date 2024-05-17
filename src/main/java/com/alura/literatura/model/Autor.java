package com.alura.literatura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int fechaNacimiento;
    private int fechaFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;
    public Autor() {
    }

    public Autor(String nombre, int fechaNacimiento, int fechaFallecimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        if (libros == null) {
            libros = new ArrayList<>();
        }
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(int fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

// Getters and setters

    @Override
    public String toString() {

        return "Autor: " +  nombre + '\n' +
                "Fecha de Nacimiento: " + fechaNacimiento +'\n'+
                "Fecha de Fallecimiento: " + fechaFallecimiento +'\n'+
                "Libros: "+libros.stream()
                    .map(l->l.getTitulo())
                    .collect(Collectors.toList())+'\n';

    }
}
