# MovieMind

Trabajo de full-stack que se basa en crear una plataforma de gestión y recomendación de películas, en la cual los usuarios pueden consultar películas, ver reseñas y explorar el catálogo de actores.

## 1) Requisitos

- Java 21
- Maven (opcional si usas mvnw)
- MySQL corriendo en localhost:3306 (usuario root, sin contraseña)
- IDE recomendado: VS Code / IntelliJ / Eclipse
- Postman (opcional para probar la API)
- Git

Hibernate crea automáticamente las tablas peliculas, actores, resenas y usuarios al iniciar la aplicación (ddl-auto=update). No es necesario crearlas manualmente.

---

## 2) Configuración de base de datos

El archivo src/main/resources/application.properties contiene la conexión:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/moviemind?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


- createDatabaseIfNotExist=true → crea la base de datos moviemind si no existe.
- ddl-auto=update → Hibernate actualiza el esquema automáticamente según las entidades Pelicula, Actor, Resena y Usuario.
- show-sql=true → muestra las consultas SQL generadas en la consola.

---

## 3) ¿Cómo ejecutar el proyecto?

*1-* Clonar el repositorio con el siguiente comando:

bash
git clone <url-del-repositorio>


*2-* Ejecutar el proyecto desde un editor de código como VS Code o IntelliJ.

*3-* Probar el correcto funcionamiento con Postman.

---

## 4) URL base de la API

Por defecto Spring Boot levanta en el puerto 8080:


http://localhost:8080


Base path de los controladores:


/api/v1/peliculas
/api/v1/actores
/api/v1/resenas
/api/v1/usuarios


---

## 5) Endpoints disponibles

### 5.1 Listar Películas

- *Método:* GET
- *URL:* /api/v1/peliculas
- *Descripción:* retorna todas las películas almacenadas en la base de datos.

### 5.2 Mostrar Película según el ID

- *Método:* GET
- *URL:* /api/v1/peliculas/{ID}
- *Descripción:* retorna una película según el ID.

### 5.3 Crear una Película

- *Método:* POST
- *URL:* /api/v1/peliculas
- *Descripción:* crea una película en la base de datos.
- *Body JSON ejemplo:*

json
{
    "titulo": "Saw",
    "descripcion": "pelicula buena",
    "generoPrincipal": {
        "idGenero": 1
    },
    "anoLanzamiento":  1232112,
    "duracion": 300,
    "actorPrincipal": {
        "idActor": 1
    },
    "valoracion": 10,
    "popularidad": 9
}


### 5.4 Eliminar una Película

- *Método:* DELETE
- *URL:* /api/v1/peliculas/{ID}
- *Descripción:* elimina una película de la base de datos según el ID.

### 5.5 Actualizar una Película

- *Método:* PUT
- *URL:* /api/v1/peliculas/{ID}
- *Descripción:* actualiza los datos de una película en la base de datos según el ID.
- *Body JSON ejemplo:*

json
{
    "titulo": "Saw",
    "descripcion": "pelicula buena",
    "generoPrincipal": {
        "idGenero": 1
    },
    "anoLanzamiento":  1232112,
    "duracion": 300,
    "actorPrincipal": {
        "idActor": 1
    },
    "valoracion": 10,
    "popularidad": 9
}


---

## 6) Estructura del proyecto y explicación por capas


src/main/java/com/duoc/moviemind/
├── controller/
├── dto/
├── service/
├── repository/
└── model/


### 6.1 controller (presentación / API REST)

En esta carpeta están PeliculaController, ActorController, ResenaController y UsuarioController, que reciben las peticiones HTTP.

*Anotaciones importantes:*

- @RestController → Le dice a Spring que esta clase es un controlador REST. Los métodos retornan datos (JSON) directamente.
- @RequestMapping("/api/v1/pelicula") → Define la ruta base para todos los endpoints de este controlador.
- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping → Asocian cada método Java con un verbo HTTP.
- @PathVariable → Obtiene valores de la URL, por ejemplo {id}.
- @RequestBody → Convierte automáticamente el JSON del request a un objeto Java (ej: Pelicula).
- @Autowired → Inyección de dependencias automática. Spring inyecta una instancia del Service correspondiente.

---

### 6.2 service (lógica de negocio)

En esta carpeta están PeliculaService, ActorService, ResenaService y UsuarioService.

*Responsabilidades:*

- Centralizar reglas y flujo de negocio.
- Evitar que el controlador tenga lógica compleja.
- Coordinar el acceso al repositorio.

*Anotación clave:*

- @Service → Marca la clase como componente de la capa de servicio. Spring la detecta y la gestiona como bean.

También usa @Autowired para inyectar el Repository correspondiente.

---

### 6.3 repository (acceso a datos)

En esta carpeta están PeliculaRepository, ActorRepository, ResenaRepository y UsuarioRepository.

Son interfaces que extienden JpaRepository<..., Integer>:

java
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> { }


Al extender JpaRepository, Spring Data JPA genera automáticamente la implementación con todos los métodos CRUD:

| Método JPA | Descripción |
|---|---|
| findAll() | Obtiene todos los registros |
| findById(id) | Busca por id, retorna Optional<Pelicula> |
| save(Pelicula) | Inserta o actualiza |
| existsById(id) | Verifica si existe |
| deleteById(id) | Elimina por id |

Los datos se persisten en MySQL y sobreviven al reinicio de la aplicación.

*Anotación clave:*

- @Repository → Indica que esta interfaz pertenece a la capa de acceso a datos.

---

### 6.4 model (entidades / estructura de datos)

En esta carpeta están Pelicula, Actor, Resena y Usuario, que representan las tablas de la base de datos.

*Campos de Pelicula:*

id_pelicula, tipo, titulo, descripcion, genero, añoLanzamiento, duracion, protagonista, valoracion, popularidad

*Anotaciones de validación y persistencia usadas:*

- @Entity → Indica que la clase es una entidad JPA mapeada a una tabla.
- @Table(name = "peliculas") → Define el nombre de la tabla en la base de datos.
- @Id → Marca el identificador único de la entidad.
- @GeneratedValue(strategy = GenerationType.IDENTITY) → El valor del ID lo genera automáticamente la base de datos.
- @NotNull → Exige que el valor no sea null. Se usa en campos numéricos como añoLanzamiento, duracion, valoracion y popularidad.
- @NotBlank → Exige que el texto no sea null, no esté vacío y no tenga solo espacios. Se usa en tipo, titulo, descripcion, genero y protagonista.

*Anotaciones de Lombok usadas:*

- @Data → Genera automáticamente getters, setters, toString(), equals() y hashCode().
- @AllArgsConstructor → Genera un constructor con todos los atributos.
- @NoArgsConstructor → Genera un constructor vacío (sin parámetros).

Esto evita escribir mucho código repetitivo (boilerplate).

---

## 7) Autor

*lulilulita*
- Cargo: Estudiante
- Correo personal: -
- Correo Institucional: -
