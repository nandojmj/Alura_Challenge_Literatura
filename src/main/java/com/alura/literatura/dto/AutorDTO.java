package com.alura.literatura.dto;

public record AutorDTO(
        Long Id,
        String nombre,
        int fechaNacimiento,
        int fechaFallecimiento) {
}
