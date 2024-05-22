# Open Challenge Backend ONE - LITERATURA
 ***ONE | Fase 3 - Especialización Back-End  G6 Alura - Oracle Next Education***

[![Alura Latam](https://img.shields.io/badge/Alura-Latam-blue?style=flat)](https://www.aluracursos.com/)
[![Static Badge](https://img.shields.io/badge/ONE-Oracle_Next_Education-orange?style=flat&logo=oracle&logoColor=orange)](https://www.oracle.com/co/education/oracle-next-education/) [![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) [![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000) ![Static Badge](https://img.shields.io/badge/Spring_Boot-%236DB33F?logo=Spring&logoColor=white) ![Static Badge](https://img.shields.io/badge/PostgresSQL-%234169E1?style=flat&logo=PostgreSQL&logoColor=white)
[![Static Badge](https://img.shields.io/badge/test-status-%23009929?logo=github)](#)
[![Static Badge](https://img.shields.io/badge/license-MIT-blue)](#)
![Endpoint Badge](https://img.shields.io/endpoint?url=https%3A%2F%2Fhits.dwyl.com%2Fnandojmj%2FAlura_Challenge_Literatura.json&style=flat&logo=github&color=brightgreen)


Este es un desafío de la Especialización __Back-End G6 Alura - Oracle Next Education.__ El proyecto se llama "Alura Literatura" y parece ser una aplicación que permite a los usuarios consultar información sobre libros y autores. Está diseñado para interactuar con una base de datos PostgreSQL para almacenar información sobre libros y autores, y proporciona funcionalidades como búsqueda, listado y consulta de datos relacionados con libros y autores. A continuación, se detallan las clases principales y su funcionalidad:

Los pasos solicitados para completar este desafío:

1.  Configurando el entorno Java
2.	Conociendo la API para traer datos
3.	Importando la biblioteca Gson en IntelliJ IDEA 
4.	Construyendo el Cliente para Solicitudes (HttpClient)
5.	Construyendo la Solicitud (HttpRequest)
6.	Construyendo la la Respuesta (HttpResponse)
7.	Analizando la respuesta en formato JSON
8.	Filtrando las monedas
9.	Convirtiendo Valores
10. Interactuando con el usuario
11. Hacer un Readme.md
12. Extra (Opcional)
    12.1 Historial de Conversiones
    12.2 Soporte para Más Monedas
    12.3 Registros con Marca de Tiempo
    
   
&nbsp;

> [!NOTE]
> En este Challenge se solicita primero crear el repositorio del proyecto en GitHub.  
> El siguiente material te ayudará con esta actividad: [Git - Configurando Git por primera vez](https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Configurando-Git-por-primera-vez) y [Como subir mi proyecto en GitHub](https://www.youtube.com/watch?v=bhKkeOMysuw)  

&nbsp;

### 1. Configurando el entorno Java  

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/JSON--In--Java--20220320-JAR-blue)](*) 
[![Static Badge](https://img.shields.io/badge/Git-Github-blue?style=flat&logo=GitHub)](https://github.com/)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)
[![Static Badge](https://img.shields.io/badge/app-Trello-%231466c3?style=flat&logo=trello)](https://trello.com/)

En esta primera fase, nos piden que se lleve a cabo la instalación y cla configuración del entorno de desarrollo Java para nuestro desafío de construcción del LiterAlura en um proyecto Spring. Asegúrate de contar con los siguientes programas, archivos y versiones:
- IntelliJ IDEA Community Edition
- Java JDK: versión: 17 en adelante
- Maven: versión 4 en adelante
- Spring: versión 3.2.3 - https://start.spring.io/
- Postgres: versión 16 en adelante
- JSON en Java y la librería Gson
- Git y GitHub 
- Postman
- Trello

- Dependencias para agregar al crear el proyecto en Spring Initializr:

- Spring Data JPA
- Postgres Driver

&nbsp;

### 2. Conociendo la API para traer datos
[![Static Badge](https://img.shields.io/badge/Configuracion_del_entorno-%230067ff?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)



La API Gutendex es un catálogo de información de más de 70.000 libros presentes en Project Gutenberg (biblioteca en línea y gratuita).

En este paso crucial, es fundamental comprender mejor la API de los libros, revisar su documentación y aprender cómo realizar las consultas en la API. En este desafío no es necesario obtener una clave de acceso, solo realizar consultas como se describe en el sitio web oficial.

> [!NOTE]
> Para este challenge se utilizo la siguiente API: 
> [Gutendex-API](https://gutendex.com/), y su Repositorio de API*: GitHub - [garethbjohnson/gutendex](https://github.com/garethbjohnson/gutendex): Web API for Project Gutenberg ebook metadata .

Interactuando con la API, encontramos como se realizan las consultas, 


```java
// Setting URL
(https://gutendex.com/books/)
```
al realizar la consulta  en la API nos arroja lo siguiente:
```java
{
"count": 73568,
"next": "https://gutendex.com/books/?page=2",
"previous": null,
"results": [
{
"id": 84,
"title": "Frankenstein; Or, The Modern Prometheus",
"authors": [
{
"name": "Shelley, Mary Wollstonecraft",
"birth_year": 1797,
"death_year": 1851
}
],
// Resto del código omitido...
],
"bookshelves": [
"Gothic Fiction",
"Movie Books",
"Precursors of Science Fiction",
"Science Fiction by Women"
],
"languages": [
"en"
],
// Resto del código omitido...
```
y observamos los key que nos sirven para nuestro proyecto: 
```java
 "title": "Frankenstein; Or, The Modern Prometheus",
 "name": "Shelley, Mary Wollstonecraft",
 "birth_year": 1797,
 "death_year": 1851
 "languages": [ "en"
// Resto del código omitido...
```

&nbsp;

### 3. Construyendo una solicitud de API
#### 3.1 Construyendo el Cliente para Solicitudes (HttpClient)  
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/Http-Client-%23ff1a00?style=flat)](#)

Se utilizo la instancia HttpClient para realizar solicitudes a la API y obtener datos esenciales. El uso de`HttpClient` en Java facilita la conexión y la obtención de respuestas de manera eficiente. Se utiliza para enviar solicitudes HTTP y recibir respuestas HTTP sin la necesidad de bibliotecas externas.


&nbsp;

*En este fragmento de código, de la Class ""Conversion", se crea una instancia de `HttpClient` utilizando el método estático `newHttpClient()`. en YOUR-API-KEY se utiliza la llave solicitada:*
```java
public class ConsumoAPI {
    // Método para obtener datos desde una URL
    public String obtenerDatos(String url){
        // Crear un cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        
         // Resto del código omitido...
```
&nbsp;

#### 3.2 Construyendo la Solicitud (HttpRequest)

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Http-Request-%23f7a40c?style=flat)](#)

El uso de la instancia HttpRequest para configurar y personalizar nuestras solicitudes a la API Literatura. La instancia HttpRequest en Java nos brinda un control detallado sobre los parámetros de nuestras solicitudes.

`HttpRequest` representa una solicitud HTTP y se utiliza para construir la solicitud HTTP que se enviará al servidor.

*En este fragmento de código, de la Class ""Conversion", se crea una instancia de `HttpRequest` utilizando el método `newBuilder()` de la clase `HttpRequest`, al cual se le pasa la URI del recurso solicitado.*
```java
 public String obtenerDatos(String url){
       // Resto del código omitido...

            // Construir la solicitud HTTP con la URL proporcionada
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
       // Resto del código omitido...
```

&nbsp;

#### 3.3 Construyendo la la Respuesta (HttpResponse)

[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/Http-Response-green?style=flat)](#)

En esta parte se solicito el uso de la interfaz HttpResponse para gestionar las respuestas recibidas de la API. 

- `HttpResponse` representa una respuesta HTTP recibida después de enviar una solicitud HTTP al servidor.
- Se utiliza para leer la respuesta del servidor, incluyendo el código de estado, encabezados y el cuerpo de la respuesta.


&nbsp;

*En este código, se declara una instancia de `HttpResponse<String>`, donde `<String>` especifica el tipo de cuerpo esperado en la respuesta, en este caso, una cadena de texto.*
```java
 public String obtenerDatos(String url){
       // Resto del código omitido...

         // Variable para almacenar la respuesta de la solicitud
           try {
            // Enviar la solicitud HTTP y obtener la respuesta
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            // Manejar excepción de E/S
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            // Manejar excepción de interrupción
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
        // Resto del código omitido...
```

&nbsp;

### 4.	Analizando la respuesta en formato JSON
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)
[![Static Badge](https://img.shields.io/badge/Postman-gray?style=flat&logo=Postman&logoColor=orange)](https://www.postman.com/)


En esta parte de  nuestro Challenge se nos solicito el análisis de la respuesta JSON en Java. La manipulación de datos JSON es esencial, ya que la mayoría de las respuestas de las API se presentan en este formato.

→ Para facilitar el análisis de los datos que se obtendrán de la API, recomendamos el uso del sitio de API para realizar consulta de libros o autores.

Con la biblioteca Jackson, puedes realizar el mapeo eficiente de los datos JSON a objetos Java, facilitando así la extracción y manipulación de la información necesaria.

> [!IMPORTANT]
> → No olvides agregar la biblioteca Jackson al proyecto como dependencia del archivo POM.xml - sugerimos usar la versión 2.16.  

*Fragmento de codigo utilizado en la ConvierteDatos.java*
```java
 public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();
    // Método para obtener un objeto de tipo T a partir de un JSON
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Parsea el JSON a un JsonNode
            JsonNode rootNode = objectMapper.readTree(json);

            // Obtiene el array de resultados
            JsonNode resultsArray = rootNode.get("results");

            // Si el array de resultados no es nulo y tiene al menos un elemento
            if (resultsArray != null && resultsArray.size() > 0) {
                // Obtiene el primer objeto en el array de resultados
                JsonNode firstResult = resultsArray.get(0);
                // Convierte el primer resultado a la clase especificada
                return objectMapper.treeToValue(firstResult, clase);
            } else {
                // Maneja el caso donde no se encontraron resultados
                throw new RuntimeException("No se encontraron resultados en el JSON.");
            }
        // Resto del código omitido...
```

&nbsp;

Utilizar ObjectMapper, para acceder a las distintas propiedades de la respuesta JSON.

*Fragmento de codigo utilizado en la ConvierteDatosAutor.java*
```java
public class ConvierteDatosAutor implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    // Método para obtener un objeto de tipo T a partir de un JSON
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            JsonNode rootNode = objectMapper.readTree(json);

            JsonNode resultsArray = rootNode.get("results");

            // Verifica si el array de resultados no es nulo y tiene al menos un elemento
            if (resultsArray != null && resultsArray.size() > 0) {
                // Obtiene el primer autor del primer resultado
                JsonNode firstResult = resultsArray.get(0).get("authors").get(0);
                // Convierte el primer autor a la clase especificada
                return objectMapper.treeToValue(firstResult, clase);

```

&nbsp;

### 5. Convertiendo los datos
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Consumo_de_la_API-%23009929?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/Java_Library-Gson_%2F_Json-blue?style=flat&logo=json)](https://mvnrepository.com/artifact/com.google.code.gson/gson)


En esta etapa, llevaremos a cabo las conversiones con los datos de libros y autores, ahora que contamos con la información en nuestro poder. Se crearon varias clases y paquetes:

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/packageconversion.JPG)(#)


### Clases Principales:
#### Principal (com.alura.literatura.principal.Principal):

- Esta clase parece ser la clase principal de la aplicación. Contiene el método muestraElMenu() que muestra un menú de opciones al usuario y maneja la interacción con el usuario.
- Utiliza instancias de LibroRepository y AutorRepository para acceder a la base de datos y realizar operaciones CRUD en las entidades Libro y Autor.

#### Libro (com.alura.literatura.model.Libro):

- Esta clase representa la entidad "Libro" en el modelo de datos de la aplicación.
- Tiene atributos como id, titulo, autor, idioma y descargas.
- Está mapeada a una tabla llamada "libros" en la base de datos.
- La clase proporciona métodos para acceder y modificar sus atributos, así como un método toString() para imprimir información sobre el libro.

#### Autor (com.alura.literatura.model.Autor):

- Esta clase representa la entidad "Autor" en el modelo de datos de la aplicación.
- Tiene atributos como id, nombre, fechaNacimiento y fechaFallecimiento.
- Está mapeada a una tabla llamada "autores" en la base de datos.
- La clase proporciona métodos para acceder y modificar sus atributos, así como un método toString() para imprimir información sobre el autor.

#### LibroRepository (com.alura.literatura.repository.LibroRepository):

- Esta interfaz proporciona métodos para realizar operaciones CRUD en la entidad Libro.
- Extiende JpaRepository de Spring Data JPA.

#### AutorRepository (com.alura.literatura.repository.AutorRepository):

- Esta interfaz proporciona métodos para realizar operaciones CRUD en la entidad Autor.
- Extiende JpaRepository de Spring Data JPA.

#### LiteraturaApplication (com.alura.literatura.LiteraturaApplication):

- Esta clase es la clase principal de Spring Boot que inicia la aplicación.
- Implementa CommandLineRunner y utiliza instancias de LibroRepository y AutorRepository para iniciar la aplicación y mostrar el menú principal.
  
### Servicios y Utilidades:
#### AutorServicio (com.alura.literatura.service.AutorServicio):

- Este servicio proporciona métodos para obtener información sobre autores.
- Utiliza AutorRepository para acceder a la base de datos y obtener datos sobre autores.

#### LibroServicio (com.alura.literatura.service.LibroServicio):

- Este servicio proporciona métodos para obtener información sobre libros.
- Utiliza LibroRepository para acceder a la base de datos y obtener datos sobre libros.

#### ConvierteDatos (com.alura.literatura.service.ConvierteDatos) y ConvierteDatosAutor (com.alura.literatura.service.ConvierteDatosAutor):

- Estas clases proporcionan métodos para convertir datos de JSON a objetos Java utilizando la biblioteca Jackson ObjectMapper.
- Implementan la interfaz IConvierteDatos.

#### IConvierteDatos (com.alura.literatura.service.IConvierteDatos):

Esta interfaz define métodos para convertir datos de JSON a objetos Java.



&nbsp;

```
            +--------------------------------------------+
            |              LiteraturaApplication         |
            |                    |                       |
            |      +-------------+-------------+         |
            |      |             |             |         |
            | LibroRepository AutorRepository  Principal |
            |      |             |             |         |
            +--------------------------------------------+
                   |
                   |
            +------v------+    +--------------------+
            | LibroServicio|    |  AutorServicio    |
            +------+-------+    +--------+----------+
                   |                     |
                   v                     v
            +------+-------+    +--------+----------+
            |  LibroDTO   |    |     AutorDTO       |
            +------+-------+    +--------+----------+
                   |                     |
                   +-----------+---------+
                               |
                               v
                       +-------+---------+
                       | IConvierteDatos |
                       +-------+---------+
                               |
                     +---------+-----------+
                     | ConvierteDatos      |
                     | ConvierteDatosAutor |
                     +---------------------+


```

Este diagrama muestra la relación entre las principales clases y componentes del proyecto "Alura Literatura". En la parte superior se encuentran las clases principales como LiteraturaApplication y Principal, que actúan como la interfaz de usuario y coordinan las operaciones principales del sistema.

Las interfaces LibroRepository y AutorRepository interactúan directamente con la capa de acceso a datos y proporcionan métodos para realizar operaciones CRUD en libros y autores. Estas interfaces son implementadas por clases específicas de Spring Data JPA que manejan la comunicación con la base de datos PostgreSQL.

Los servicios LibroServicio y AutorServicio encapsulan la lógica de negocio relacionada con la gestión de libros y autores. Estos servicios utilizan los repositorios para acceder a los datos y proporcionan métodos para convertir los datos de las entidades de dominio en DTOs (Data Transfer Objects) que son más adecuados para ser enviados al frontend de la aplicación.

La interfaz IConvierteDatos define los métodos para convertir datos entre diferentes formatos, como JSON y objetos Java. Las implementaciones concretas de esta interfaz, ConvierteDatos y ConvierteDatosAutor, utilizan la biblioteca Jackson ObjectMapper para realizar la conversión de datos.

Finalmente, los DTOs LibroDTO y AutorDTO representan versiones simplificadas de las entidades de dominio Libro y Autor. Estos DTOs se utilizan para transferir datos entre el backend y el frontend de la aplicación, evitando la exposición directa de las entidades de dominio y facilitando la comunicación entre las diferentes capas del sistema.

&nbsp;

*Fragmento de codigo utilizado en la clase `libro.java`:*
```java
@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;
    private Double descargas;

    // Constructor sin argumentos
    public Libro() {}

    // Constructor con argumentos
    public Libro(String titulo, Autor autor, List<String> idiomas, Double descargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idiomas != null && !idiomas.isEmpty() ? String.join(",", idiomas) : null;
        this.descargas = OptionalDouble.of(descargas).orElse(0);
    }
 
 // Resto del código omitido...

```
&nbsp;

&nbsp;

*Fragmento de codigo utilizado en la clase `autor.java`:*
```java
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

    // Constructor sin argumentos
    public Autor() {
    }

    // Constructor con argumentos
    public Autor(String nombre, int fechaNacimiento, int fechaFallecimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
    }
 
 // Resto del código omitido...

```

&nbsp;


### 6. Interactuando con el usuario
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

En esta etapa del desafío, se solicito  la interacción con el usuario, El método Main debe implementar la interfaz CommandLineRunner y su método run() donde deberás llamar un método para exhibir el menu. En este método, debes crear un bucle para presentar a tu usuario las opciones de insercion y consulta. El usuario deberá seleccionar un número que corresponderá a la opcion numérica y proporcionar los datos que la aplicación recibirá, utilizando la clase Scanner para capturar la entrada do usuário.

  &nbsp;


```java
 // Resto del código omitido...
    // Método para mostrar el menú en consola
    private void mostrarMenu() {
        var menu = """
                
                -----------------------------------------------------------------------------
                                 Challenge Literatura Alura-Oracle ONE G6
                -----------------------------------------------------------------------------
                Por favor, seleccione una opción del menú ingresando el número correspondiente:
                1- Consultar y guardar libros desde la API 
                2- Listar libros registrados en la BD
                3- Listar autores registrados en la BD
                4- Buscar autores vivos en un determinado año de la BD
                5- Buscar libros registrados en la BD por idioma
                6- Buscar autores por nombre en la BD
                7- Buscar los 10 libros más descargados de la API
                8- Buscar los 10 libros más descargados en la BD
                9- Búsqueda de autores nacidos después de un año específico en la BD   
                10- Buscar autores fallecidos antes de un año específico en la BD  
                0 - Salir
            """;
        System.out.println(menu);
    }

    // Método para obtener la opción del usuario
    private int obtenerOpcionDelUsuario() {
        System.out.print("Ingrese su opción: ");
        return teclado.nextInt();
    }
 // Resto del código omitido...
```
&nbsp;

### 7. Consultar libros
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

En esta parte del desafio, realizamos la consulta por título del libro en la API para retener el primer resultado obtenido. Un libro debe tener los siguientes atributos:

- Título;
- Autor;
- Idiomas;
- Número de Descargas.

Con esta funcionalidad lista, será posible presentar en la consola un listado de todos los libros que ya fueron buscados.

Además, también debes posibilitar al usuario ver un listado con base en el idioma que uno o más libros fueron escritos, con la ayuda de las derived queries.

En resumen tenemos estas dos funcionalidades obligatorias en el proyecto:

- Búsqueda de libro por título
- Lista de todos los libros

*Fragmento de codigo utilizado en la clase `DatosLibro.java`:*
```java
**
 * Clase que representa los datos de un libro obtenidos de una fuente externa.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    @JsonAlias("title") String titulo,
    @JsonAlias("name") Autor autor,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("download_count") Double descargas){
}

 
 // Resto del código omitido...

```

&nbsp;


  ### 8. Consultar Autores
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

Como podemos ver en el sitio web de la API, cada libro tiene datos relacionados con sus autores, en este caso el cuerpo de json recibe una lista de autores por libro, donde cada autor tiene tres características:

Nombre;
Año de nacimiento;
Año de fallecimiento.

Al guardar los datos de los autores, tendremos la opción de listado de los autores de los libros buscados.

Además, pensando en los años de nacimiento y fallecimiento, es posible incluso realizar una consulta de autores vivos en un determinado año. 

En resumen tenemos estas dos funcionalidades obligatorias relacionadas a los autores:

Lista de autores
Listar autores vivos en determinado año

*Fragmento de codigo utilizado en la clase `DatosLibro.java`:*
```java
/**
 * Clase que representa los datos de un autor obtenidos de una fuente externa.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") int fechaNacimiento,
        @JsonAlias("death_year") int fechaFallecimiento) {
}

 // Resto del código omitido...

```

&nbsp;


  

  ### 9. Persistencia de datos
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000)
![Static Badge](https://img.shields.io/badge/PostgresSQL-%234169E1?style=flat&logo=PostgreSQL&logoColor=white)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

En esta parte se nos solicito enficarnos en construir una base de datos, con tablas y atributos relacionados a nuestros objetos de interés: Libro y Autor.

En este desafío vamos a utilizar la base de datos llamada PostgreSQL, una de las bases de datos open source más utilizadas en el mercado.

Sugerimos la creación de clases de entidad/modelo para Libro y Autor, así como también sus respectivas interfaces de repositorio para manejar inserción y consultas en la base de datos.

→ No olvides usar las anotaciones correctas y de importar JpaRepository, porque estamos trabajando con un proyecto Spring con Spring Data JPA, así que puede manejar las funciones necesarias para nuestro desafío java con persistencia de datos.

Al crear los repositorios de libros y autores, recuerda realizar la conversión de los atributos del libro presentes en el resultado json para un objeto java correspondiente al libro, así quedará más fácil manejar los datos obtenidos en tu proyecto.

[IMPORTANTE] Al insertar un libro en la base también deberás insertar su autor y así mantener una relación entre los dos objetos vía atributo de identificación (o como lo llamamos, el famoso ID).

*Fragmento de codigo utilizado en la clase `LibroRepository.java`:*
```java

/**
 * Repositorio para realizar operaciones relacionadas con la entidad Libro en la base de datos.
 */
public interface LibroRepository extends JpaRepository<Libro,Long> {

    /**
     * Busca un libro por su título, ignorando mayúsculas y minúsculas.
     *
     * @param nombreLibro Título del libro a buscar.
     * @return Una instancia de Libro envuelta en un Optional.
     */

    Optional<Libro> findByTituloContainingIgnoreCase(String nombreLibro);
}

 // Resto del código omitido...

```
&nbsp;

*Fragmento de codigo utilizado en la clase `AutorRepository.java`:*
```java
/**
 * Repositorio para realizar operaciones relacionadas con la entidad Autor en la base de datos.
 */

public interface AutorRepository extends JpaRepository<Autor,Long> {
    /**
     * Busca un autor por su nombre, ignorando mayúsculas y minúsculas.
     *
     * @param nombreAutor Nombre del autor a buscar.
     * @return Una instancia de Autor envuelta en un Optional.
     */
    Optional<Autor> findByNombreContainingIgnoreCase(String nombreAutor);

    /**
     * Busca autores nacidos después de un año específico.
     *
     * @param fecha Año límite de nacimiento.
     * @return Una lista de autores nacidos después del año especificado.
     */
    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento > :fecha")
    List<Autor> findByFechaNacimientoAfter(@Param("fecha") int fecha);
 // Resto del código omitido...

```
&nbsp;

  ### 10. Listando libros por idiomas
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

Se nos solicito que una vez que ya tienes libros y autores guardados en tu base de datos, ¿qué tal exhibir estadísticas sobre ellos a tu usuario? Aprovecha los recursos de Streams de Java y derived queries para brindar tu usuario con estadísticas sobre la cantidad de libros en un determinado idioma en la base de datos.

No es necesario crear opciones para todos los idiomas. Elija como mínimo dos idiomas.

En resumen tenemos esta funcionalidad obligatoria en el proyecto:

Exhibir cantidad de libros en un determinado idioma


*Fragmento de codigo utilizado en la clase `Principal.java`:*
```java

  public void mostrarLibrosPorIdioma() {
        libros = libRepositorio.findAll();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("-------------- Búsqueda de libros registrados en la BD por idioma ----------------");
        System.out.println("----------------------------------------------------------------------------------");
                System.out.println("Ingrese el idioma del que desea buscar los libros: en (english) o es (español)");
        String idiomaBuscado = teclado.nextLine();
        List<Libro> librosBuscados = libros.stream()
                .filter(l -> l.getIdioma().contains(idiomaBuscado))
                .collect(Collectors.toList());
        librosBuscados.forEach(System.out::println);
    }

 // Resto del código omitido...

```
 ### 11. Listando autores vivos en determinado año
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)
![Static Badge](https://img.shields.io/badge/PostgresSQL-%234169E1?style=flat&logo=PostgreSQL&logoColor=white)

Se nos solicito que una vez que ya tienes libros y autores guardados en tu base de datos, cambiar el método para listar los autores vivos en determinado año. Para eso, debes utilizar las derived queries para recuperar todos los autores que estaban vivos en el año que el usuario te informará.

se realizaron varias consultas con las derived queries:

*Fragmento de codigo utilizado en la clase `Principal.java`:*
```java

     */
    Optional<Autor> findByNombreContainingIgnoreCase(String nombreAutor);

    /**
     * Busca autores nacidos después de un año específico.
     *
     * @param fecha Año límite de nacimiento.
     * @return Una lista de autores nacidos después del año especificado.
     */
    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento > :fecha")
    List<Autor> findByFechaNacimientoAfter(@Param("fecha") int fecha);

    /**
     * Busca autores fallecidos antes de un año específico.
     *
     * @param fecha Año límite de fallecimiento.
     * @return Una lista de autores fallecidos antes del año especificado.
     */
    @Query("SELECT a FROM Autor a WHERE a.fechaFallecimiento < :fecha")
    List<Autor> findByFechaFallecimientoBefore(@Param("fecha") int fecha);

 // Resto del código omitido...

```

*Fragmento de codigo utilizado en la clase `Principal.java`:*
```java
 public void mostrarAutoresVivosEnUnDeterminadoAno() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("------------- Búsqueda de autores vivos en un año especifico ---------------------");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.print("Ingrese un año: ");
        int anio = teclado.nextInt();
        List<Autor> autores = autorRepository.findAll();
// Resto del código omitido...

```


### 11. **Hacer un README:** [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Uno de los pasos más importantes al participar en una selección de trabajo es resolver un desafío propuesto por la empresa con la información de la resolución, y generalmente esto debe estar en el README. ¿Y qué es el README? Es un archivo con extensión .md y es un documento con la descripción del proyecto. 
Este mismo archivo que se esta leyendo fue el resultado del README para el Challenge.


### 12.	**Extra (Opcional)**

Se nos propueso nn caso que quiecieramos desafiarnos aún más y proporcionar a los usuarios una experiencia más rica y personalizada, hay diversas funcionalidades interesantes que puedes explorar:

#### 12.1  Historial de Conversiones: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Agregar la capacidad de rastrear y mostrar el historial de las últimas conversiones realizadas, brindando a los usuarios una visión completa de sus actividades.

####  Registro de Historial en Archivo JSON 

En la clase `Conversion`, se mantiene un registro de todas las conversiones realizadas en un archivo JSON llamado "registros_data_time.json". Aquí está cómo se realiza:

1. **Lectura del Historial desde un Archivo JSON**:
   Se lee el historial de conversiones desde el archivo JSON utilizando Gson. Si el archivo no existe, se crea un historial vacío.

    ```java
    RegistroConversion[] historial;
    try (Reader fileReader = new FileReader("registros_data_time.json")) {
        historial = gson.fromJson(fileReader, RegistroConversion[].class);
    } catch (FileNotFoundException e) {
        historial = new RegistroConversion[0];
    }
    ```

2. **Actualización del Historial**: 

   Se agrega el nuevo registro de conversión al final del historial existente.

    ```java
    RegistroConversion[] nuevoHistorial = new RegistroConversion[historial.length + 1];
    System.arraycopy(historial, 0, nuevoHistorial, 0, historial.length);
    nuevoHistorial[historial.length] = registroConversion;
    ```

3. **Escritura del Historial Actualizado en el Archivo JSON**:
   Se escribe el historial actualizado en el archivo JSON para mantener un registro de todas las conversiones realizadas.

    ```java
    try (Writer fileWriter = new FileWriter("registros_data_time.json")) {
        gson.toJson(nuevoHistorial, fileWriter);
    } catch (IOException e) {
        e.printStackTrace();
    }
    ```

De esta manera, cada vez que se realiza una conversión de moneda, se agrega un nuevo registro al historial y se actualiza el archivo JSON con el nuevo historial. Así, se mantiene un registro completo y actualizado de todas las conversiones realizadas.

*Captura de pantalla de la ejecucion del proyecto mostrando resultados de conversion y se observa el contenido en el archivo `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron*

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/json2.png) 

Registro en el archivo `registros_data_time.json`:
```
 {
    "conversion": {
      "Moneda_Origen": "ARS",
      "Moneda_Destino": "USD",
      "Monto_a_Convertir": 100500.0,
      "Resultado": 116.178,
      "Tasa_Conversion": 0.001156
    },
    "timestamp": "2024-04-22 14:15:58"
  },
  {
    "conversion": {
      "Moneda_Origen": "USD",
      "Moneda_Destino": "COP",
      "Monto_a_Convertir": 500.0,
      "Resultado": 1956948.2,
      "Tasa_Conversion": 3913.8964
    },
    "timestamp": "2024-04-22 14:17:03"
  }
```


#### 12.2  Soporte para Más Monedas: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Se amplía la lista de monedas disponibles para la elección, permitiendo a los usuarios convertir entre una variedad aún mayor de opciones monetarias.La API admite las 161 monedas mundiales que circulan habitualmente. Estos cubren el 99% de todos los estados y territorios reconocidos por la ONU.

***Fragmento de codigo utilizado en la Class `MenuHandler.java` para seleccionar otras monedas que se desea convertir. En el menu principal la opcion 7 nos lleva a `7-Elegir otro tipo de monedas a convertir: donde nos mostra 100 codigos currency con sus respectivos paises` cumpliendo con la opcion adicional del challenge de Soporte para Más Monedas ***

```java
// Resto del código omitido...
  public static void mostrarMenu() {
        System.out.println("************************************************************");
        System.out.println("""
                1- Convertir de COP (peso colombiano) a USD (dólar).
                2- Convertir de USD (dólar) a COP (peso colombiano).
                3- Convertir de BRL (real brasileño) a USD (dólar).
                4- Convertir de USD (dólar) a BRL (real brasileño).
                5- Convertir de ARS (peso argentino) a USD (dólar).
                6- Convertir de USD (dólar) a ARS (peso argentino).
                7- Elegir otras monedas para convertir.
                8- Salir

 // Resto del código omitido...

            case 6:
                convertirMoneda("USD", "ARS", conversion, lectura); // Convertir de USD a ARS
                break;
            case 7:
                elegirOtrasMonedas(conversion, lectura); // Llama al método para elegir otras monedas a convertir
                break;
            case 8:
                System.out.println("¡Gracias por usar el convertidor! ¡Hasta luego!"); // Mensaje de despedida
                System.exit(0); // Finaliza el programa

// Resto del código omitido...

           private static void elegirOtrasMonedas(Conversion conversion, Scanner lectura) {
        try {
            System.out.println("""
            Esta lista contiene 100 códigos de moneda y sus respectivos países para facilitar la conversión de moneda:
        
            | 1.  **AED**: United Arab Emirates      | 2.  **AFN**: Afghanistan          | 3.  **ALL**: Albania
            | 4.  **AMD**: Armenia                   | 5.  **ANG**: Netherlands Antilles | 6.  **AOA**: Angola
            | 7.  **ARS**: Argentina                 | 8.  **AUD**: Australia            | 9.  **AWG**: Aruba
            | 10. **AZN**: Azerbaijan                | 11. **BBD**: Barbados             | 12. **BGN**: Bulgaria
            | 13. **BHD**: Bahrain                   | 14. **BRL**: Brazil               | 15. **BSD**: Bahamas
            | 16. **BTN**: Bhutan                    | 17. **BWP**: Botswana             | 18. **BZD**: Belize

// Resto del código omitido...

      | 100. **PLN**: Poland
            Ingrese el código de moneda base:""");

            String monedaBase = lectura.next().toUpperCase(); // Lee el código de moneda base ingresado por el usuario
            System.out.println("Ingrese el código de moneda destino:");
            String monedaDestino = lectura.next().toUpperCase(); // Lee el código de moneda destino ingresado por el usuario
            convertirMoneda(monedaBase, monedaDestino, conversion, lectura); // Realiza la conversión
        } catch (Exception e) {
// Resto del código omitido...
```



&nbsp;

#### 12.3  Registros con Marca de Tiempo: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)

Se creo la clase `LocalDateTimeAdapter`, para cumplir con este adicional del desafio.

La clase `LocalDateTimeAdapter` es una clase utilizada para adaptar la serialización y deserialización de objetos `LocalDateTime` al formato JSON utilizando la biblioteca Gson de Google. Su objetivo es proporcionar la capacidad de convertir objetos `LocalDateTime` a formato JSON y viceversa de manera que puedan ser almacenados y recuperados adecuadamente.

- **Implementación**:
  - La clase implementa las interfaces `JsonSerializer` y `JsonDeserializer` de Gson para personalizar la serialización y deserialización de objetos `LocalDateTime`.
  - Utiliza un objeto `DateTimeFormatter` para definir el formato de fecha y hora deseado ("yyyy-MM-dd HH:mm:ss").
  - Sobrescribe los métodos `serialize` y `deserialize` para convertir entre `LocalDateTime` y JSON.

- **Método `serialize`**:
  - Este método toma un objeto `LocalDateTime` como entrada y devuelve un `JsonElement`, que en este caso es un `JsonPrimitive` que contiene la fecha y hora formateadas según el patrón definido por `DateTimeFormatter`.

- **Método `deserialize`**:
  - Este método toma un `JsonElement` (que se espera que sea un `JsonPrimitive` con una cadena representando una fecha y hora) y lo convierte de nuevo a un objeto `LocalDateTime` utilizando el formato definido por `DateTimeFormatter`.

En resumen, `LocalDateTimeAdapter` es una clase útil para adaptar la serialización y deserialización de objetos `LocalDateTime` al formato JSON, lo que facilita su almacenamiento y recuperación en aplicaciones que utilizan Gson para el manejo de JSON.


*Fragmento de codigo utilizado en la Class `RegistroConversion.java` donde se crea  `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:*
```java
 // Resto del código omitido...

package adapters;

  // Resto del código omitido...
/** Clase interna para adaptar la serialización y deserialización de LocalDateTime. */
public class LocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public JsonElement serialize(LocalDateTime src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(formatter.format(src));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDateTime.parse(json.getAsString(), formatter);
    }
}

  // Resto del código omitido...
    
```


*Fragmento del registro del archivo `registros_data_time.json` en formato json, donde se registran y actualizan las consultas realizadas, incluyendo información sobre qué monedas se convirtieron y en qué fecha para cumplir con la parte adicional de este challenge:*

```
 {
    "conversion": {
      "Moneda_Origen": "ARS",
      "Moneda_Destino": "USD",
      "Monto_a_Convertir": 100500.0,
      "Resultado": 116.178,
      "Tasa_Conversion": 0.001156
    },
    "timestamp": "2024-04-22 14:15:58"
  },
  {
    "conversion": {
      "Moneda_Origen": "USD",
      "Moneda_Destino": "COP",
      "Monto_a_Convertir": 500.0,
      "Resultado": 1956948.2,
      "Tasa_Conversion": 3913.8964
    },
    "timestamp": "2024-04-22 14:17:03"
  }
```
            
### 13. Ejecución del Proyecto
Para ejecutar el proyecto, sigue estos pasos:

* Clona o descarga desde Github el repositorio en tu disco local.
* Importa el proyecto en tu IDE de Java (este proyecto se realizo en IntelliJ IDEA).
* Configura las dependencias y ajusta la configuración según sea necesario.
* Corre la aplicación para interactuar con consola.

Para utilizar el conversor de moneda, ejecuta la clase `Principal`. Se mostrará un menú donde puedes seleccionar las opciones de conversión. Selecciona la opción deseada e ingresa el monto a convertir. El resultado se mostrará en la pantalla.
* Asegúrate de revisar la documentación de la API de Exchange Rate-API para obtener la clave de API necesaria para realizar solicitudes y obtener tasas de cambio actualizadas.

### 14. Video Y Capturas de pantalla

&nbsp;

https://github.com/nandojmj/Alura_Challenge_Conversor_de_Moneda/assets/156966097/5644642c-1cd9-4e2e-b7d3-4719e0f3a117

&nbsp;

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura.png)  

&nbsp;

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura2.png) 

&nbsp;

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura3.png)  

&nbsp;

![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura5.png) 



### Glossary [![Static Badge](https://img.shields.io/badge/status-under%20construction-%2393a8ac)](#)

1. **API (Interfaz de Programación de Aplicaciones):**
   - Un conjunto de métodos y funciones que permite la comunicación entre diferentes componentes de software. En este contexto, se refiere a la API de Exchange Rate-API utilizada para obtener tasas de cambio.

2. **URI (Identificador Uniforme de Recursos):**
   - Una cadena de caracteres que identifica un recurso en la web de manera única. Se utiliza para construir la dirección de la API a la que se enviarán las solicitudes HTTP.

3. **HTTP (Protocolo de Transferencia de Hipertexto):**
   - El protocolo de comunicación utilizado para transferir datos en la web. En este proyecto, se utiliza para enviar solicitudes y recibir respuestas de la API.

4. **JSON (Notación de Objetos JavaScript):**
   - Un formato ligero de intercambio de datos que es fácil de leer y escribir para los humanos, y fácil de parsear y generar para las máquinas. Se utiliza para representar los datos recibidos de la API y realizar la serialización y deserialización de objetos en Java.

5. **Gson:**
   - Una biblioteca de Java que se utiliza para serializar y deserializar objetos Java en formato JSON y viceversa. En este proyecto, se utiliza Gson para manejar la comunicación con la API y convertir los datos recibidos en objetos Java.

6. **HttpClient:**
   - Una clase en Java que proporciona una interfaz para enviar solicitudes HTTP y recibir respuestas. Se utiliza para realizar solicitudes a la API de Exchange Rate-API y obtener tasas de cambio.

7. **InputMismatchException:**
   - Una excepción en Java que se lanza cuando se espera un tipo específico de entrada, pero se recibe un tipo diferente. Se maneja en este proyecto para manejar entradas no válidas del usuario en el menú de opciones.

8. **LocalDateTime:**
   - Una clase en Java que representa una fecha y hora específica sin referencia a una zona horaria. Se utiliza para marcar la fecha y hora en que se realiza una conversión de moneda y para leer y escribir el historial de conversiones.

9. **DateTimeFormatter:**
   - Una clase en Java que permite formatear y analizar fechas y horas en diferentes formatos. Se utiliza para formatear la fecha y hora en el historial de conversiones.

10. **JsonReader:**
    - Una clase en Gson que se utiliza para leer datos JSON de una secuencia de entrada. En este proyecto, se utiliza para leer la respuesta JSON de la API de Exchange Rate-API.

11. **JsonDeserializer y JsonSerializer:**
    - Interfaces en Gson que permiten personalizar la serialización y deserialización de objetos Java a JSON y viceversa. Se utilizan para adaptar la serialización y deserialización de LocalDateTime en este proyecto.

12. **FileNotFoundException:**
    - Una excepción en Java que se lanza cuando se intenta acceder a un archivo que no existe. Se maneja en este proyecto al leer el historial de conversiones desde un archivo JSON.
    - 

### MIT License

```sql

Copyright (c) [2024] [Hernando Muñoz J]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```

```sql

Copyright (c) [2024] [Hernando Muñoz J]

Se concede permiso, de forma gratuita, a cualquier persona que obtenga una copia
de este software y de los archivos de documentación asociados (el "Software"), para tratar
con el Software sin restricciones, incluyendo sin limitación los derechos
para usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender
copias del Software, y para permitir a las personas a las que se les proporcione el Software
para hacerlo, sujeto a las siguientes condiciones:

El aviso de copyright anterior y este aviso de permiso se incluirán en todas las
copias o porciones sustanciales del Software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O
IMPLÍCITA, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIABILIDAD,
IDONEIDAD PARA UN PROPÓSITO PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS
AUTORES O TITULARES DE DERECHOS DE AUTOR SERÁN RESPONSABLES DE CUALQUIER RECLAMO, DAÑOS U OTROS
RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE OTRO MODO, QUE SURJA DE,
FUERA O EN RELACIÓN CON EL SOFTWARE O EL USO U OTROS TRATOS EN EL
SOFTWARE.

```
