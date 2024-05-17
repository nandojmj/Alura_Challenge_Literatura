package com.alura.literatura.dto;

import com.alura.literatura.model.Autor;

public record LibroDTO(
        Long Id,
        String titulo,
        Autor autor,
        String idioma,
        Double descargas

) {
}
