# Proyecto-API-Asistencia-colegio
Este proyecto es una API RESTful desarrollada con Spring Boot que gestiona un sistema de asistencia para un colegio. Permite la administración de alumnos, profesores, cursos, salones, asignaciones de cursos a salones con profesores, y el registro de asistencias, así como la gestión de usuarios.

#Tecnologías Utilizadas
Spring Boot: Framework principal para el desarrollo de la aplicación.

Java: Lenguaje de programación.

Maven: Herramienta de gestión de dependencias y construcción del proyecto.

Spring Data JPA: Para la persistencia de datos y la interacción con la base de datos.

MySQL: Base de datos relacional.

Spring Web: Para construir APIs RESTful.

#Estructura del Proyecto
El proyecto sigue una arquitectura de capas estándar para aplicaciones Spring Boot:

`rc/main/java/com/isil/edu/pe`: Contiene el código fuente de la aplicación, organizado en paquetes:

`controller`: Clases que exponen los endpoints REST.

`model`: Clases que representan las entidades de la base de datos.

`repository`: Interfaces para el acceso a datos (Spring Data JPA).

`service`: Clases que contienen la lógica de negocio.

`exceptions`: Clases para el manejo de excepciones personalizadas.

`src/main/resources`: Contiene archivos de configuración.

#Configuración
El archivo application.properties (src/main/resources/application.properties) contiene la configuración principal de la aplicación:
```
spring.datasource.url=jdbc:mysql://localhost:3306/AsistenciaDB
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=none
logging.level.root=WARN
logging.level.org.springframework=WARN
logging.level.org.hibernate=WARN
spring.application.name=Proyecto-API-Asistencia-colegio
server.port=8085
server.servlet.context-path=/isil
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

##Detalles de la Configuración:

**Base de Datos**: Se conecta a una base de datos MySQL llamada `AsistenciaDB` en `localhost:3306` con usuario `root` y contraseña `root`.

**Hibernate DDL Auto**: Configurado en `none`, lo que significa que Hibernate no modificará el esquema de la base de datos automáticamente.

**Logging**: El nivel de logging está configurado en `WARN` para las raíces, Spring y Hibernate, para evitar un exceso de mensajes en la consola.

**Nombre de la Aplicación**: `Proyecto-API-Asistencia-colegio`.

**Puerto del Servidor**: La aplicación se ejecutará en el puerto `8085`.

**Context Path**: El path base para todos los endpoints será `/isil`. Por ejemplo, un endpoint `/api/v1/alumno` se accederá a través de `http://localhost:8085/isil/api/v1/alumno`.

**SQL Logging**: `spring.jpa.show-sql=true` y `spring.jpa.properties.hibernate.format_sql=true` activan la visualización y el formato de las sentencias SQL generadas por JPA.

#Modelos (Entidades)

`AlumnoModel`: Representa a un alumno, asociado a un `UsuarioModel`.

`AsistenciaModel`: Registra la asistencia de un usuario a un `CursoSalonModel` en una fecha y hora específicas.

`CursoModel`: Representa un curso con su nombre.

`CursoSalonModel`: Modela la asignación de un curso a un salón con un profesor, incluyendo la fecha de asignación.

`ProfesorModel`: Representa a un profesor, asociado a un `UsuarioModel`.

`SalonModel`: Representa un salón (aula) con su nombre.

`UsuarioModel`: Representa un usuario con su documento de identidad, nombre completo, contraseña y un flag de administrador.

`AlumnoCursoModel`: Modela la relación entre un alumno y un curso.

#Controladores (API Endpoints)

##`AlumnoController`
Gestiona las operaciones CRUD para los alumnos.

`GET /alumno`: Obtiene todos los alumnos.

`GET /alumno/{AlumnoId}`: Obtiene un alumno por su ID.

`POST /alumno`: Crea un nuevo alumno.

`PUT /alumno/{AlumnoId}`: Actualiza un alumno existente.

`DELETE /alumno/{AlumnoId}`: Elimina un alumno por su ID.

##`AlumnoCursoController`
Gestiona las operaciones CRUD para las asignaciones de alumnos a cursos.

`GET /alumnocurso`: Obtiene todas las asignaciones alumno-curso.

`GET /alumnocurso/{id}`: Obtiene una asignación alumno-curso por su ID.

`POST /alumnocurso`: Crea una nueva asignación alumno-curso.

`PUT /alumnocurso/{id}`: Actualiza una asignación alumno-curso existente.

`DELETE /alumnocurso/{id}`: Elimina una asignación alumno-curso por su ID.

##`AsistenciaController`
Gestiona las operaciones CRUD para los registros de asistencia.

`GET /asistencia`: Obtiene todos los registros de asistencia.

`GET /asistencia/{id}`: Obtiene un registro de asistencia por su ID.

`POST /asistencia`: Crea un nuevo registro de asistencia.

`PUT /asistencia/{id}`: Actualiza un registro de asistencia existente.

`DELETE /asistencia/{id}`: Elimina un registro de asistencia por su ID.

##`CursoController`
Gestiona las operaciones CRUD para los cursos.

`GET /curso`: Obtiene todos los cursos.

`GET /curso/{id}`: Obtiene un curso por su ID.

`POST /curso`: Crea un nuevo curso.

`PUT /curso/{id}`: Actualiza un curso existente.

`DELETE /curso/{id}`: Elimina un curso por su ID.

##`CursoSalonController`
Gestiona las operaciones CRUD para las asignaciones de cursos a salones.

`GET /cursosalon`: Obtiene todas las asignaciones curso-salón.

`GET /cursosalon/{id}`: Obtiene una asignación curso-salón por su ID.

`POST /cursosalon`: Crea una nueva asignación curso-salón.

`PUT /cursosalon/{id}`: Actualiza una asignación curso-salón existente.

`DELETE /cursosalon/{id}`: Elimina una asignación curso-salón por su ID.

##`ProfesorController`
Gestiona las operaciones CRUD para los profesores.

`GET /profesor`: Obtiene todos los profesores.

`GET /profesor/{ProfesorId}`: Obtiene un profesor por su ID.

`POST /profesor`: Crea un nuevo profesor.

`PUT /profesor/{ProfesorId}`: Actualiza un profesor existente.

`DELETE /profesor/{ProfesorId}`: Elimina un profesor por su ID.

##`SalonController`
Gestiona las operaciones CRUD para los salones.

`GET /salon`: Obtiene todos los salones.

`GET /salon/{id}`: Obtiene un salón por su ID.

`POST /salon`: Crea un nuevo salón.

`PUT /salon/{id}`: Actualiza un salón existente.

`DELETE /salon/{id}`: Elimina un salón por su ID.

##`UsuarioController`
Gestiona las operaciones CRUD para los usuarios.

`GET /usuario`: Obtiene todos los usuarios.

`GET /usuario/{id}`: Obtiene un usuario por su ID.

`POST /usuario`: Crea un nuevo usuario.

`PUT /usuario/{id}`: Actualiza un usuario existente.

`DELETE /usuario/{id}`: Elimina un usuario por su ID.

#Manejo de Excepciones
La aplicación implementa un manejo de excepciones global a través de `GlobalExceptionHandler`.

`ResourceNotFoundException`: Excepción personalizada que se lanza cuando un recurso no se encuentra (HTTP Status 404 Not Found).

`ErrorDetails`: Clase que define la estructura de los detalles del error devueltos en la respuesta de la API (timestamp, mensaje, detalles).

`GlobalExceptionHandler`: Captura `ResourceNotFoundException` y cualquier otra `Exception` para devolver una respuesta estandarizada con un `HttpStatus.INTERNAL_SERVER_ERROR`.
