package com.alura.literatura.principal;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.DatosAutor;
import com.alura.literatura.model.DatosLibro;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import com.alura.literatura.service.ConsumoAPI;
import com.alura.literatura.service.ConvierteDatos;
import com.alura.literatura.service.ConvierteDatosAutor;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private ConvierteDatosAutor conversorAutor = new ConvierteDatosAutor();
    private final String URL_BASE = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    private LibroRepository libRepositorio;
    private AutorRepository autorRepository;
    private List<Libro> libros;
    private List<Autor> autores;
    private Optional<Autor> autorBuscado;
    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija la tarea a través de su número:
                    1- Consultar y guardar libros desde la API 
                    2- listar libros registrados en la BD
                    3- listar autores registrados en la BD
                    4- listar autores vivos en un determinado año de la BD
                    5- listar libros registrados en la BD por idioma
                    6- buscar autores por nombre en la BD
                    7- Buscar Top 10 libros más descargados de la API
                    8- top 5 libros en la DB
                    9- Buscar Autores fallecidos antes de una fecha en la API                              
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    buscarYGuardarLibroAPI();
                    break;
                case 2:
                    mostrarLibrosBaseDatos();
                    break;
                case 3:
                    mostrarAutorxsRegistradxs();
                    break;
                case 4:
                    mostrarAutorxsVivxsEnUnDeterminadoAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    buscarAutorPorNombre();
                    break;
                case 7:
                    top10LibrosEnLaAPI();
                    break;
                case 8:
                    top5LibrosEnLaDB();
                    break;
                case 9:
                    buscarAutoresFallecidosAntesDeFecha();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        System.exit(0);
    }
    public Principal(LibroRepository libRepository, AutorRepository autRepository) {
        this.libRepositorio = libRepository;
        this.autorRepository = autRepository;
    }
    private DatosLibro obtenerDatosLibroAPI(String nombreLibro) {
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+ nombreLibro.replace(" ", "+"));
        DatosLibro datos = conversor.obtenerDatos(json, DatosLibro.class);
        return datos;
    }
    private DatosAutor obtenerDatosAutorAPI(String nombreLibro) {
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search="+ nombreLibro.replace(" ", "+"));
        DatosAutor datos = conversorAutor.obtenerDatos(json, DatosAutor.class);
        return datos;
    }


    public void buscarYGuardarLibroAPI() {
        System.out.println("¿Cuál es el título del libro que desea buscar en la API Gutendex?");
        String libroBuscado = teclado.nextLine();
        libros = libros != null ? libros : new ArrayList<>();

        Optional<Libro> optionalLibro = libros.stream()
                .filter(l -> l.getTitulo().toLowerCase().contains(libroBuscado.toLowerCase()))
                .findFirst();

        if (optionalLibro.isPresent()) {
            var libroEncontrado = optionalLibro.get();
            System.out.println("Este libro ya ha sido cargado previamente:");
            System.out.println(libroEncontrado);
            System.out.println("Por favor, pruebe con otro título.");
        } else {
            try {
                DatosLibro datosLibro = obtenerDatosLibroAPI(libroBuscado);

                if (datosLibro != null) {
                    DatosAutor datosAutor = obtenerDatosAutorAPI(libroBuscado);

                    if (datosAutor != null) {
                        List<Autor> autores = autorRepository.findAll();
                        autores = autores != null ? autores : new ArrayList<>();

                        Optional<Autor> autorOptional = autores.stream()
                                .filter(a -> datosAutor.nombre() != null &&
                                        a.getNombre().toLowerCase().contains(datosAutor.nombre().toLowerCase()))
                                .findFirst();

                        Autor autor;
                        if (autorOptional.isPresent()) {
                            autor = autorOptional.get();
                        } else {
                            autor = new Autor(
                                    datosAutor.nombre(),
                                    datosAutor.fechaNacimiento(),
                                    datosAutor.fechaFallecimiento()
                            );
                            autorRepository.save(autor);
                        }

                        Libro libro = new Libro(
                                datosLibro.titulo(),
                                autor,
                                datosLibro.idioma() != null ? datosLibro.idioma() : Collections.emptyList(),
                                datosLibro.descargas()
                        );

                        libros.add(libro);
                        autor.setLibros(libros);

                        System.out.println("Se ha encontrado el siguiente libro:");
                        System.out.println(libro);
                        libRepositorio.save(libro);

                        System.out.println("El libro ha sido guardado exitosamente.");
                    } else {
                        System.out.println("No se encontró información sobre el autor para este libro.");
                    }
                } else {
                    System.out.println("No se encontró el libro con el título proporcionado.");
                }
            } catch (Exception e) {
                System.out.println("Se produjo una excepción: " + e.getMessage());
            }
        }
    }

//    public void buscarYGuardarLibroAPI() {
//        System.out.println("Digite el titulo del libro que desea buscar en la API Gutendex");
//        //teclado.nextLine(); // Limpia el buffer
//        String libroBuscado = teclado.nextLine();
//        libros = libros != null ? libros : new ArrayList<>();
//
//        Optional<Libro> optionalLibro = libros.stream()
//                .filter(l -> l.getTitulo().toLowerCase()
//                        .contains(libroBuscado.toLowerCase()))
//                .findFirst();
//
//        if(optionalLibro.isPresent()) {
//            var libroEncontrado = optionalLibro.get();
//            System.out.println(libroEncontrado);
//            System.out.println("El libro ya fue cargado, pruebe con otro");
//        }else{
//            try {
//                DatosLibro datosLibro = obtenerDatosLibroAPI(libroBuscado);
//                System.out.println(datosLibro);
//
//                if (datosLibro != null) {
//                    DatosAutor datosAutor = obtenerDatosAutorAPI(libroBuscado);
//                    if (datosAutor != null) {
//                        List<Autor> autores = autorRepository.findAll();
//                        autores = autores != null ? autores : new ArrayList<>();
//
//                        Optional<Autor> autorOptional = autores.stream()
//                                .filter(a -> datosAutor.nombre() != null &&
//                                        a.getNombre().toLowerCase().contains(datosAutor.nombre().toLowerCase()))
//                                .findFirst();
//
//                        Autor autor;
//                        if (autorOptional.isPresent()) {
//                            autor = autorOptional.get();
//                        } else {
//                            autor = new Autor(
//                                    datosAutor.nombre(),
//                                    datosAutor.fechaNacimiento(),
//                                    datosAutor.fechaFallecimiento()
//                            );
//                            autorRepository.save(autor);
//                        }
//
//                        Libro libro = new Libro(
//                                datosLibro.titulo(),
//                                autor,
//                                datosLibro.idioma() != null ? datosLibro.idioma() : Collections.emptyList(),
//                                datosLibro.descargas()
//                        );
//
//                        libros.add(libro);
//                        autor.setLibros(libros);
//
//                        System.out.println(libro);
//                        libRepositorio.save(libro);
//
//                        System.out.println("Libro guardado exitosamente");
//                    } else {
//                        System.out.println("No se encontró el autor para el libro");
//                    }
//
//                } else {
//                    System.out.println("No se encontró el libro");
//                }
//            } catch (Exception e) {
//                System.out.println("excepción: " + e.getMessage());
//            }
//        }
//    }

    private void mostrarLibrosBaseDatos(){
        try{
            List<Libro> libros = libRepositorio.findAll();
            libros.stream()
                    .sorted(Comparator.comparing(Libro::getDescargas))
                    .forEach(System.out::println);
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            libros = new ArrayList<>();
        }
    }


    public void mostrarAutorxsRegistradxs(){
        autores = autorRepository.findAll();
        autores.stream()
                .forEach(System.out::println);
    }

    public void mostrarAutorxsVivxsEnUnDeterminadoAno(){
        System.out.println("Ingrese un año");
        int anio = teclado.nextInt();
        autores = autorRepository.findAll();
        List<String> autoresNombre = autores.stream()
                .filter(a-> (a.getFechaFallecimiento() >= anio) && (a.getFechaNacimiento() <= anio))
                .map(a->a.getNombre())
                .collect(Collectors.toList());
        autoresNombre.forEach(System.out::println);
    }

    public void listarLibrosPorIdioma() {
        libros = libRepositorio.findAll();

        System.out.println("Ingrese el idioma del que desea buscar los libros: en (english) o es (español)");
        String idiomaBuscado = teclado.nextLine();

        List<Libro> librosBuscados = libros.stream()
                .filter(l -> l.getIdioma().contains(idiomaBuscado))
                .collect(Collectors.toList());

        librosBuscados.forEach(System.out::println);
    }


//    public void listarLibrosPorIdioma(){
//        libros = libRepositorio.findAll();
//        List<String> idiomasUnicos = libros.stream()
//                .map(Libro::getIdioma)
//                .distinct()
//                .collect(Collectors.toList());
//        idiomasUnicos.forEach(idioma -> {
//            switch (idioma){
//                case "en":
//                    System.out.println("en - english");
//                    break;
//                case "es":
//                    System.out.println("es - español");
//                    break;
//            }
//        });
//        System.out.println("");
//        System.out.println("Ingrese el idioma del que desea buscar los libros");
//        String idiomaBuscado = teclado.nextLine();
//        List<Libro> librosBuscados = libros.stream()
//                .filter(l->l.getIdioma().contains(idiomaBuscado))
//                .collect(Collectors.toList());
//        librosBuscados.forEach(System.out::println);
//
//    }

    /*
    EXTRAS:
    - Top 10 libros más descargados en la base de datos y en la API
    - Buscar autor por nombre
    - Listar autores con otras consultas.
    Por ejemplo: autores que hayan muerto hace más de 70 años.
     */

    public void buscarAutorPorNombre(){
        System.out.println("Ingrese el nombre del autor que desea buscar");
        var nombreAutor = teclado.nextLine();
        autorBuscado = autorRepository.findByNombreContainingIgnoreCase(nombreAutor);
        if(autorBuscado.isPresent()){
            System.out.println(autorBuscado.get());
        }else{
            System.out.println("Autor no encontrado");
        }
    }

    public void top10LibrosEnLaAPI() {
        try {
            String json = consumoAPI.obtenerDatos(URL_BASE + "?sort");

            List<DatosLibro> datosLibros = conversor.obtenerDatosArray(json, DatosLibro.class);
            List<DatosAutor> datosAutor = conversorAutor.obtenerDatosArray(json,DatosAutor.class);

            List<Libro> libros = new ArrayList<>();
            for (int i = 0; i < datosLibros.size(); i++) {
                Autor autor = new Autor(
                        datosAutor.get(i).nombre(),
                        datosAutor.get(i).fechaNacimiento(),
                        datosAutor.get(i).fechaFallecimiento());

                Libro libro = new Libro(
                        datosLibros.get(i).titulo(),
                        autor,
                        datosLibros.get(i).idioma(),
                        datosLibros.get(i).descargas());
                libros.add(libro);
            }

            libros.sort(Comparator.comparingDouble(Libro::getDescargas).reversed());

            List<Libro> top10Libros = libros.subList(0, Math.min(10, libros.size()));

            for (int i = 0; i < top10Libros.size(); i++) {
                System.out.println((i + 1) + ". " + top10Libros.get(i));
            }

        } catch (NullPointerException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }

    public void top5LibrosEnLaDB(){
        try{
            List<Libro> libros = libRepositorio.findAll();
            List<Libro> librosOrdenados = libros.stream()
                    .sorted(Comparator.comparingDouble(Libro::getDescargas).reversed())
                    .collect(Collectors.toList());
            List<Libro> top5Libros = librosOrdenados.subList(0, Math.min(5, librosOrdenados.size()));
            for (int i = 0; i < top5Libros.size(); i++) {
                System.out.println((i + 1) + ". " + top5Libros.get(i));
            }
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            libros = new ArrayList<>();
        }
    }


    public void buscarAutoresFallecidosAntesDeFecha() {
        try {
            System.out.println("Ingrese la fecha (año) para buscar autores que fallecieron antes:");
            int fechaLimite = Integer.parseInt(teclado.nextLine());

            String json = consumoAPI.obtenerDatos(URL_BASE + "?sort");

            List<DatosAutor> datosAutor = conversorAutor.obtenerDatosArray(json, DatosAutor.class);

            Map<String, Autor> autoresMap = new HashMap<>();

            for (DatosAutor datoAutor : datosAutor) {
                String nombre = datoAutor.nombre();
                Autor autor = autoresMap.get(nombre);

                if (autor == null) {
                    autor = new Autor(nombre, datoAutor.fechaNacimiento(), datoAutor.fechaFallecimiento());
                    autoresMap.put(nombre, autor);
                }

                List<Libro> librosArray = new ArrayList<>();
                autor.setLibros(librosArray);
            }

            List<Autor> autoresOrdenados = autoresMap.values().stream()
                    .filter(a -> a.getFechaFallecimiento() < fechaLimite)
                    .collect(Collectors.toList());

            List<Autor> diezAutores = autoresOrdenados.subList(0, Math.min(10, autoresOrdenados.size()));

            if (diezAutores.isEmpty()) {
                System.out.println("No se encontraron autores que fallecieron antes de " + fechaLimite);
            } else {
                System.out.println("Los primeros 10 autores que fallecieron antes de " + fechaLimite + ":");
                for (int i = 0; i < diezAutores.size(); i++) {
                    System.out.println((i + 1) + ". " + diezAutores.get(i).getNombre() + "\n" +
                            "   Año de fallecimiento: " + diezAutores.get(i).getFechaFallecimiento());
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un año válido.");
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarAutoresNacidosDespuesDeFecha() {
        try {
            System.out.println("Ingrese la fecha (año) para buscar autores nacidos después:");
            int fechaLimite = Integer.parseInt(teclado.nextLine());

            String json = consumoAPI.obtenerDatos(URL_BASE + "?sort");

            List<DatosAutor> datosAutor = conversorAutor.obtenerDatosArray(json, DatosAutor.class);

            Map<String, Autor> autoresMap = new HashMap<>();

            for (DatosAutor datoAutor : datosAutor) {
                String nombre = datoAutor.nombre();
                Autor autor = autoresMap.get(nombre);

                if (autor == null) {
                    autor = new Autor(nombre, datoAutor.fechaNacimiento(), datoAutor.fechaFallecimiento());
                    autoresMap.put(nombre, autor);
                }

                List<Libro> librosArray = new ArrayList<>();
                autor.setLibros(librosArray);
            }

            List<Autor> autoresOrdenados = autoresMap.values().stream()
                    .filter(a -> a.getFechaNacimiento() > fechaLimite)
                    .collect(Collectors.toList());

            List<Autor> autoresDespuesDeFecha = autoresOrdenados.subList(0, Math.min(10, autoresOrdenados.size()));

            if (autoresDespuesDeFecha.isEmpty()) {
                System.out.println("No se encontraron autores nacidos después de " + fechaLimite);
            } else {
                System.out.println("Los primeros 10 autores nacidos después de " + fechaLimite + ":");
                for (int i = 0; i < autoresDespuesDeFecha.size(); i++) {
                    System.out.println((i + 1) + ". " + autoresDespuesDeFecha.get(i).getNombre() + "\n" +
                            "   Año de nacimiento: " + autoresDespuesDeFecha.get(i).getFechaNacimiento());
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un año válido.");
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarAutoresPorEdad(int edadMinima, int edadMaxima) {
        try {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);

            int anioMinimo = year - edadMaxima;
            int anioMaximo = year - edadMinima;

            List<Autor> autores = autorRepository.findAll();
            List<Autor> autoresEnRango = autores.stream()
                    .filter(a -> {
                        int anioNacimiento = a.getFechaNacimiento();
                        int edad = year - anioNacimiento;
                        return edad >= edadMinima && edad <= edadMaxima;
                    })
                    .collect(Collectors.toList());

            if (autoresEnRango.isEmpty()) {
                System.out.println("No se encontraron autores en el rango de edad especificado.");
            } else {
                System.out.println("Autores en el rango de edad de " + edadMinima + " a " + edadMaxima + " años:");
                autoresEnRango.forEach(autor -> {
                    int edad = year - autor.getFechaNacimiento();
                    System.out.println(autor.getNombre() + ", Año de nacimiento: " +
                            autor.getFechaNacimiento() + ", Edad: " + edad + " años");
                });
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
//    public void autoresEnDerechoPublico(){
//        try {
//            String json = consumoAPI.obtenerDatos(URL_BASE + "?sort");
//
//            List<DatosAutor> datosAutor = conversorAutor.obtenerDatosArray(json, DatosAutor.class);
//
//            Map<String, Autor> autoresMap = new HashMap<>();
//
//            for (DatosAutor datoAutor : datosAutor) {
//                String nombre = datoAutor.nombre();
//                Autor autor = autoresMap.get(nombre);
//
//                if (autor == null) {
//                    autor = new Autor(nombre, datoAutor.fechaNacimiento(), datoAutor.fechaFallecimiento());
//                    autoresMap.put(nombre, autor);
//                }
//
//                List<Libro> librosArray = new ArrayList<>();
//                autor.setLibros(librosArray);
//            }
//
//            List<Autor> autoresOrdenados = autoresMap.values().stream()
//                    .filter(a -> a.getFechaFallecimiento() < 1954)
//                    .collect(Collectors.toList());
//
//            List<Autor> diezAutores = autoresOrdenados.subList(0, Math.min(10, autoresOrdenados.size()));
//
//            for (int i = 0; i < diezAutores.size(); i++) {
//                System.out.println((i + 1) + ". " + diezAutores.get(i).getNombre()+"/n"+
//                        ", año de fallecimiento: "+diezAutores.get(i).getFechaFallecimiento());
//            }
//
//        } catch (NullPointerException e) {
//            System.out.println("Error occurred: " + e.getMessage());
//        }
//    }

}
