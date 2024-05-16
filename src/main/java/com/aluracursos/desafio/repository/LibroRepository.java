package com.aluracursos.desafio.repository;

import com.aluracursos.desafio.model.Libro;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @EntityGraph(attributePaths = {"autores"})
    Optional<Libro> findByTitulo(String titulo);
    List<Libro> findByIdiomasContaining(String idioma);
}

