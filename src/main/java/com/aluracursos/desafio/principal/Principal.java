package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Autor;
import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosLibro;
import com.aluracursos.desafio.model.Libro;
import com.aluracursos.desafio.repository.AutorRepository;
import com.aluracursos.desafio.repository.LibroRepository;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Principal {

    private final AutorRepository autorRepository;
    private final LibroRepository libroRepository;
    private final ConsumoAPI consumoAPI;
    private final ConvierteDatos conversor;
    private final String URL_BASE = "https://gutendex.com/books/";
    private final Scanner teclado = new Scanner(System.in);

    @Autowired
    public Principal(AutorRepository autorRepository, LibroRepository libroRepository,
                     ConsumoAPI consumoAPI, ConvierteDatos conversor) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;
        this.consumoAPI = consumoAPI;
        this.conversor = conversor;
    }

    public void muestraElMenu() {
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Consultar y guardar libros desde la API");
            System.out.println("2. Mostrar autores registrados con sus años de nacimiento y fallecimiento");
            System.out.println("3. Mostrar autores vivos en un determinado año");
            System.out.println("4. Buscar libros por idioma");
            System.out.println("5. Buscar Top 10 libros más descargados de la API");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    buscarYGuardarLibroWeb();
                    break;
                case 2:
                    mostrarLibrosGuardados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    buscarLibrosPorIdioma();
                    break;
                case 5:
                    top10LibrosApi();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }





//    public void buscarYGuardarLibroWeb() {
//        Libro libro = obtenerLibro();
//
//        Optional<Libro> libroExistente = libroRepository.findByTitulo(libro.getTitulo());
//
//        if (libroExistente.isPresent()) {
//            System.out.println("El libro ya existe en la base de datos: " + libroExistente.get());
//        } else {
//            libro.getAutor().forEach(entityManager::merge);
//            entityManager.persist(libro);
//            entityManager.flush();
//            entityManager.detach(libro);
//            System.out.println("Libro guardado en la base de datos: " + libro);
//        }
//    }

    private void buscarYGuardarLibroWeb() {
        Libro libro = obtenerLibro();

        if (libro != null) {
            libroRepository.save(libro);
            System.out.println("Libro guardado correctamente.");
        } else {
            System.out.println("Libro no encontrado.");
        }
    }


//    private void buscarYGuardarLibroWeb() {
//        Libro libro = obtenerLibro();
//        librosGuardados.add(libro);
//        libroRepository.save(libro);
//        System.out.println("Libro guardado correctamente.");
//    }

    private Libro obtenerLibro() {
        System.out.println("---------------------------------");
        System.out.println("Ingrese el nombre del libro que desea buscar");
        teclado.nextLine(); // Limpia el buffer
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        return datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst()
                .map(Libro::new)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

//    private void mostrarLibrosGuardados() {
//        List<Libro> librosGuardados = libroRepository.findAll();
//        librosGuardados.forEach(System.out::println);
//    }
//    private void mostrarLibrosBuscados() {
//        List<Libro> libros = new ArrayList<>();
//        libros = datosLibro.stream()
//                .map(d-> new Libro(d))
//                .collect(Collectors.toList());
//        libros.forEach(System.out::println);
//        // datosLibro.forEach(System.out::println);
//    }

    public void mostrarLibrosGuardados() {
        List<Libro> librosGuardados = libroRepository.findAll();
        if (librosGuardados.isEmpty()) {
            System.out.println("No hay libros guardados en la base de datos.");
        } else {
            System.out.println("Libros guardados en la base de datos:");
            System.out.println("---------------------------------");
            for (Libro libro : librosGuardados) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Autor: " + libro.getAutor().getNombre());
                System.out.println("Idiomas: " + String.join(", ", libro.getIdiomas()));
                System.out.println("---------------------------------");
            }
        }
    }

    private void mostrarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }


    public void buscarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma que desea buscar:");
        teclado.nextLine(); // Limpia el buffer
        String idioma = teclado.nextLine();

        List<Libro> libros = libroRepository.findByIdiomasContaining(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos con el idioma " + idioma);
        } else {
            System.out.println("Libros registrados en la base de datos con el idioma " + idioma + ":");
            System.out.println("---------------------------------");
            for (Libro libro : libros) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("---------------------------------");
            }
        }
    }

        private void top10LibrosApi() {
            var json = consumoAPI.obtenerDatos(URL_BASE);
            var datos = conversor.obtenerDatos(json, Datos.class);

            System.out.println("Top 10 libros más descargados");
            System.out.println("---------------------------------");
            datos.resultados().stream()
                    .sorted(Comparator.comparing(DatosLibro::numeroDeDescargas).reversed())
                    .limit(10)
                    .map(l -> l.titulo().toUpperCase())
                    .forEach(System.out::println);

        }



}
