package com.aluracursos.desafio.repository;

import com.aluracursos.desafio.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Método para encontrar autores vivos por año
    List<Autor> findByFechaDeNacimientoBeforeAndFechaDeFallecimientoAfter(String fechaNacimiento, String fechaFallecimiento);
}
