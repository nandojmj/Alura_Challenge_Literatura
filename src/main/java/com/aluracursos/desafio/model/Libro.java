package com.aluracursos.desafio.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(unique = true) // Restricción única en el título
   private String titulo;

   @ManyToOne(cascade = CascadeType.ALL)
   private Autor autor;
//   @ManyToOne
//   @JoinColumn(name = "autor_id") // Columna que establece la relación con Autor
//   private Autor autor;

   @Column
   private String idiomas;

   private Double numeroDeDescargas;

   public Libro() {
   }

   public Libro(DatosLibro datosLibro) {
      this.titulo = datosLibro.titulo();
      this.idiomas = String.join(", ", datosLibro.idiomas());
      this.autor = convertirDatosAutor(datosLibro.autor().get(0)); // Tomar el primer autor
      this.numeroDeDescargas = datosLibro.numeroDeDescargas();
   }

   private Autor convertirDatosAutor(DatosAutor datosAutor) {
      Autor autor = new Autor();
      autor.setNombre(datosAutor.nombre());
      autor.setFechaDeNacimiento(datosAutor.fechaDeNacimiento());
      autor.setFechaDeFallecimiento(datosAutor.fechaDeMuerte());
      return autor;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitulo() {
      return titulo;
   }

   public void setTitulo(String titulo) {
      this.titulo = titulo;
   }

   public Autor getAutor() {
      return autor;
   }

   public void setAutor(Autor autor) {
      this.autor = autor;
   }

   public String getIdiomas() {
      return idiomas;
   }

   public void setIdiomas(String idiomas) {
      this.idiomas = idiomas;
   }

   public Double getNumeroDeDescargas() {
      return numeroDeDescargas;
   }

   public void setNumeroDeDescargas(Double numeroDeDescargas) {
      this.numeroDeDescargas = numeroDeDescargas;
   }

   @Override
   public String toString() {
      return "Libro{" +
              "id=" + id +
              ", titulo='" + titulo + '\'' +
              ", autor=" + autor +
              ", idiomas=" + idiomas +
              ", numeroDeDescargas=" + numeroDeDescargas +
              '}';
   }
}