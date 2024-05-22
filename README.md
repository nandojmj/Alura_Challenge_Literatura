# Open Challenge Backend ONE - LITERATURA
 ***ONE | Fase 3 - Especialización Back-End  G6 Alura - Oracle Next Education***

[![Alura Latam](https://img.shields.io/badge/Alura-Latam-blue?style=flat)](https://www.aluracursos.com/)
[![Static Badge](https://img.shields.io/badge/ONE-Oracle_Next_Education-orange?style=flat&logo=oracle&logoColor=orange)](https://www.oracle.com/co/education/oracle-next-education/) [![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) [![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
![Static Badge](https://img.shields.io/badge/API-Gutendex-%23e90000) ![Static Badge](https://img.shields.io/badge/Spring_Boot-%236DB33F?logo=Spring&logoColor=white) ![Static Badge](https://img.shields.io/badge/PostgresSQL-%234169E1?style=flat&logo=PostgreSQL&logoColor=white)
[![Static Badge](https://img.shields.io/badge/test-status-%23009929?logo=github)](#)
[![Static Badge](https://img.shields.io/badge/license-MIT-blue)](#)
![Endpoint Badge](https://img.shields.io/endpoint?url=https%3A%2F%2Fhits.dwyl.com%2Fnandojmj%2FAlura_Challenge_Literatura.json&style=flat&logo=github&color=brightgreen)


Este es un desafío de la Especialización __Back-End G6 Alura - Oracle Next Education.__ El proyecto se llama "Alura Literatura" y es una aplicación que permite a los usuarios consultar información sobre libros y autores, un catálogo de libros. Está diseñado para interactuar con una base de datos PostgreSQL para almacenar información sobre libros y autores, y proporciona funcionalidades como búsqueda, listado y consulta de datos relacionados con libros y autores. A continuación, se detallan las clases principales y su funcionalidad:

Los pasos solicitados para completar este desafío:

1.  Configurando el entorno Java y Spring
2.	Conociendo la API para traer datos
3.	Construyendo una solicitud de API
3.1	Construyendo el Cliente para Solicitudes (HttpClient)
3.2	Construyendo la Solicitud (HttpRequest)
3.3	Construyendo la la Respuesta (HttpResponse)
4.	Analizando la respuesta en formato JSON
5.	Convertiendo los datos
6.	Interactuando con el usuario
7.	Consultando Libros
8.	Consultando Autores
9.	Persistencia de datos
10. Listando libros por idiomas
11.  Listando autores vivos en determinado año
12. Hacer un Readme.md
13. Extra (Opcional)
    12.1 Generando estadísticas
    12.2 Top 10 libros más descargados
    12.3 Buscar autor por nombre
    12.3 Listar autores con otras consultas
    
   
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

En esta primera fase, nos piden que se lleve a cabo la instalación y la configuración del entorno de desarrollo Java para nuestro desafío de construcción del desafio Literatura en un proyecto Spring. Asegúrate de contar con los siguientes programas, archivos y versiones:
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

*En este fragmento de código, de la Class "ConsumoAPI", se crea una instancia de `HttpClient` utilizando el método estático `newHttpClient()`:*
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

*En este fragmento de código, de la Class"ConsumoAPI", se crea una instancia de `HttpRequest` utilizando el método `newBuilder()` de la clase `HttpRequest`, al cual se le pasa la URI del recurso solicitado.*
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

*En este código, se declara una instancia de `HttpResponse.BodyHandlers.ofString())`, donde `<String>` especifica el tipo de cuerpo esperado en la respuesta, en este caso, una cadena de texto.*
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


![estructura](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/209bfe4a-e020-4468-b105-17a75de28d44)

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

  &nbsp

```java
 // Resto del código omitido...
   **
 * Clase principal de la aplicación Spring Boot.
 */

@SpringBootApplication
public class LiteraturaApplication implements CommandLineRunner {
	@Autowired
	private LibroRepository libRepository;

	@Autowired
	private AutorRepository autRepository;

	/**
	 * Método principal para iniciar la aplicación Spring Boot.
	 * @param args Argumentos de la línea de comandos.
	 */

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	/**
	 * Método para ejecutar la aplicación una vez iniciada.
	 * @param args Argumentos de la línea de comandos.
	 * @throws Exception Excepción que puede ocurrir durante la ejecución.
	 */
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libRepository, autRepository);
		principal.muestraElMenu();

	}
 // Resto del código omitido...
```
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
 // Resto del código omitido...
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
 // Resto del código omitido...

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

En esta parte se nos solicito enfocarnos en construir una base de datos, con tablas y atributos relacionados a nuestros objetos de interés: Libro y Autor.

En este desafío vamos a utilizar una base de datos en PostgreSQL, llamada "alura_Literatura", un gestor de bases de datos open source más utilizadas en el mercado.

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


  ### 10. Listando libros por idiomas
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)

Se nos solicito que una vez que ya tienes libros y autores guardados en tu base de datos, aprovechar los recursos de Streams de Java y derived queries para brindar tu usuario con estadísticas sobre la cantidad de libros en un determinado idioma en la base de datos.

No es necesario crear opciones para todos los idiomas. Elija como mínimo dos idiomas.

En resumen tenemos esta funcionalidad obligatoria en el proyecto:

Exhibir cantidad de libros en un determinado idioma

&nbsp;

*Fragmento de codigo utilizado en la clase `Principal.java`:*
```java

  public void mostrarLibrosPorIdioma() {
        libros = libRepositorio.findAll();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("-------------- Búsqueda de libros registrados en la BD por idioma ----------------");
        System.out.println("----------------------------------------------------------------------------------");
                System.out.println("Ingrese el idioma del que desea buscar los libros: en (english), es (español), fr (frances)");
        String idiomaBuscado = teclado.nextLine();
        List<Libro> librosBuscados = libros.stream()
                .filter(l -> l.getIdioma().contains(idiomaBuscado))
                .collect(Collectors.toList());
        librosBuscados.forEach(System.out::println);
    }

 // Resto del código omitido...

```
&nbsp;
 ### 11. Listando autores vivos en determinado año
[![Static Badge](https://img.shields.io/badge/IDE-IntelliJ_IDEA-%23ff0534?style=flat&logo=IntelliJ%20IDEA&logoColor=%232196f3)](https://www.jetbrains.com/es-es/idea/) 
[![Static Badge](https://img.shields.io/badge/Language-Java-%23ff0000?style=flat)](#)
[![Static Badge](https://img.shields.io/badge/Pruebas_finales-%2340a5ff?style=flat)](#)
![Static Badge](https://img.shields.io/badge/PostgresSQL-%234169E1?style=flat&logo=PostgreSQL&logoColor=white)

Se nos solicito que una vez que ya tienes libros y autores guardados en tu base de datos, cambiar el método para listar los autores vivos en determinado año. Para eso, debes utilizar las derived queries para recuperar todos los autores que estaban vivos en el año que el usuario te informará.

Se realizaron varias consultas con las derived queries:

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
&nbsp;

### 12. **Hacer un README:** [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Uno de los pasos más importantes al participar en una selección de trabajo es resolver un desafío propuesto por la empresa con la información de la resolución, y generalmente esto debe estar en el README. ¿Y qué es el README? Es un archivo con extensión .md y es un documento con la descripción del proyecto. 
Este mismo archivo que se esta leyendo fue el resultado del README para el Challenge.


### 13.	**Extra (Opcional)**

Se nos propueso nn caso que quiecieramos desafiarnos aún más y proporcionar a los usuarios una experiencia más rica y personalizada, hay diversas funcionalidades interesantes que puedes explorar:

#### 13.1  Generando estadísticas: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)
Funcionalidades opcionales, obtener datos estadísticos de un objeto Java. Es posible obtener dichos datos ya sea de consultas de la API o base de datos.

Presentar los datos de los 10 libros más descargados en la base de datos.

```java
    // Método para buscar los 10 libros más descargados registrados en la base de datos
    public void buscarLibrosTop10EnLaDB() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("----------- Top 10 de libros más descargados registrados en  la BD ---------------");
        System.out.println("----------------------------------------------------------------------------------");
        try {
            List<Libro> libros = libRepositorio.findAll();
            List<Libro> librosOrdenados = libros.stream()
                    .sorted(Comparator.comparingDouble(Libro::getDescargas).reversed())
                    .collect(Collectors.toList());
            List<Libro> topLibros = librosOrdenados.subList(0, Math.min(10, librosOrdenados.size()));
            for (int i = 0; i < topLibros.size(); i++) {
                System.out.println((i + 1) + ". " + topLibros.get(i));
            }
        } catch (NullPointerException e) {
            System.out.println("Error al buscar los libros en la base de datos: " + e.getMessage());
            libros = new ArrayList<>();
    // Resto del código omitido...

```

####  13.2  Top 10 de libros más descargados de la API: [![Static Badge](https://img.shields.io/badge/status-OK-gree)](#)

Presentar los datos de los 10 libros más descargados, siendo una consulta directamente hecha en la API.

```java
    // Método para buscar los 10 libros más descargados de la API
    public void buscarLibrosTop10EnAPI() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("---------------- Top 10 de libros más descargados de la API ----------------------");
        System.out.println("----------------------------------------------------------------------------------");
        try {
            String json = consumoAPI.obtenerDatos(URL_BASE + "?sort");

            List<DatosLibro> datosLibros = conversor.obtenerDatosArray(json, DatosLibro.class);
            List<DatosAutor> datosAutor = conversorAutor.obtenerDatosArray(json, DatosAutor.class);

            List<Libro> libros = new ArrayList<>();
            for (int i = 0; i < datosLibros.size(); i++) {
                Autor autor = new Autor(
                        datosAutor.get(i).nombre(),
                        datosAutor.get(i).fechaNacimiento(),
                        datosAutor.get(i).fechaFallecimiento());
// Resto del código omitido...
```

#### 13.3 Buscar autor por nombre: 

   Si has echado un vistazo al sitio de la API es posible realizar la búsqueda de libro o autor con la consulta hecha con search? - sin embargo, en este caso te desafiamos a realizar la consulta por nombre de autor en la base de datos creada para nuestro proyecto.

```java
   public interface AutorRepository extends JpaRepository<Autor,Long> {
    /**
     * Busca un autor por su nombre, ignorando mayúsculas y minúsculas.
     *
     * @param nombreAutor Nombre del autor a buscar.
     * @return Una instancia de Autor envuelta en un Optional.
     */
    Optional<Autor> findByNombreContainingIgnoreCase(String nombreAutor);
// Resto del código omitido...

```


```java
// Método para mostrar libros por idioma desde la base de datos
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
```
&nbsp;

#### 13.4. **Listar autores con otras consultas**:

  Implementar otras consultas con los atributos de año de nacimiento y fallecimiento de los autores. Siéntete libre de explorar e implementar estas características adicionales.
  
```java
    
    // Método para buscar autores nacidos después de una fecha en la base de datos
    public void buscarAutoresNacidosDespuesDeFecha() {
        try {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println("------------ Búsqueda de autores nacidos después de un año específico ------------");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("Ingrese el año para buscar autores nacidos después de: ");
            int fechaLimite = Integer.parseInt(teclado.nextLine());

            List<Autor> autores = autorRepository.findByFechaNacimientoAfter(fechaLimite);

            if (autores.isEmpty()) {
```
    
&nbsp;
 
### 14. Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

* Clona o descarga desde Github el repositorio en tu disco local.
* Importa el proyecto en tu IDE de Java (este proyecto se realizo en IntelliJ IDEA).
* Configura las dependencias y ajusta la configuración según sea necesario.
* Corre la aplicación para interactuar con consola.


### 14. Video Y Capturas de pantalla

&nbsp;
![gutendexgeneral](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/51186fd4-403d-466f-9baf-6c8a12ddb378)
&nbsp;

![Captura](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/5c211392-b33f-49c2-a588-36cafdf82f12)

&nbsp;
![consultaliteraturapostgresql](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/4432d9d9-4227-4e17-b202-2b198a29d7d9)

&nbsp;


![ ](https://github.com/nandojmj/conversor_prueba/blob/main/recursos/images/Captura.png)  

&nbsp;


![Literatura_postman_ingles](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/7ecfd3be-a9c2-4162-8837-a732b538f4ca)

&nbsp;
![gutendexflow3](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/c8b69f59-933a-459a-afe4-bee38c48d157)


&nbsp;

![Literatura_postman_Español](https://github.com/nandojmj/Alura_Challenge_Literatura/assets/156966097/af2e8e92-517d-4bc9-a9bd-3b020c64ce46)




### Glossary [![Static Badge](https://img.shields.io/badge/status-under%20construction-%2393a8ac)](#)

- **DTO (Data Transfer Object)**: Objetos utilizados para transferir datos entre el backend y el frontend.
- **JPA (Java Persistence API)**: API estándar de Java para mapear objetos a una base de datos relacional.
- **Hibernate**: Framework de mapeo objeto-relacional para Java.
- **API (Application Programming Interface)**: Conjunto de reglas y definiciones que permite a las aplicaciones interactuar entre sí.
- **DTO (Data Transfer Object)**: Patrón de diseño que se utiliza para transferir datos entre subsistemas de un software. En este contexto, se utilizan para transferir datos entre el backend y el frontend de la aplicación.
- **JPA (Java Persistence API)**: API estándar de Java para el mapeo objeto-relacional. Permite mapear objetos de dominio a tablas de base de datos y viceversa.
- **Hibernate**: Framework de mapeo objeto-relacional para Java. Facilita el trabajo con JPA y proporciona funcionalidades adicionales para interactuar con la base de datos.
- **Spring Boot**: Framework de desarrollo de aplicaciones Java que facilita la creación de aplicaciones basadas en Spring con una configuración mínima. Proporciona un conjunto de bibliotecas y herramientas que simplifican el desarrollo de aplicaciones empresariales.
- **PostgreSQL**: Sistema de gestión de bases de datos relacional de código abierto y potente. Se utiliza en este proyecto como el motor de base de datos para almacenar los libros y autores.
- **Maven**: Herramienta de gestión de proyectos de software que se utiliza para construir y gestionar proyectos Java. Facilita la gestión de dependencias, la compilación y la ejecución de pruebas, entre otras tareas.
- **DataSource**: Configuración que define la conexión a la base de datos, incluyendo la URL, el nombre de usuario y la contraseña.
- **Hibernate Dialect**: Configuración que especifica el dialecto SQL que Hibernate debe utilizar para interactuar con la base de datos. En este caso, se utiliza el dialecto de HSQL.
- **Spring Data JPA**: Parte del ecosistema de Spring que simplifica el acceso a datos en aplicaciones basadas en Spring. Proporciona una abstracción sobre JPA y facilita la implementación de repositorios de datos.
- **CascadeType**: Enumeración que define las operaciones de cascada que deben aplicarse a las relaciones entre entidades. Por ejemplo, si se elimina un autor, las operaciones en cascada pueden eliminar automáticamente los libros asociados a ese autor.
- **FetchType**: Enumeración que define cómo se cargan los datos asociados a una relación entre entidades. FetchType.EAGER indica que los datos deben cargarse de forma inmediata, mientras que FetchType.LAZY indica que los datos deben cargarse solo cuando sean necesarios.
- **Principal**: En el contexto de este proyecto, se refiere a la clase principal que coordina las operaciones principales de la aplicación, como la consulta y el almacenamiento de datos.
- **Estructura del Proyecto**: Organización y disposición de los archivos y paquetes que componen el proyecto. Una estructura de proyecto bien definida facilita la comprensión y el mantenimiento del código.
- **Diagrama de Estructura del Proyecto**: Representación visual de la estructura del proyecto, que muestra cómo se relacionan los diferentes componentes y cómo fluye la información a través de ellos. Ayuda a comprender la arquitectura y el diseño del proyecto.


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
