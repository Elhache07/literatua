# 📚 Proyecto de Búsqueda de Libros - Spring Boot

Este es un proyecto de consola desarrollado en Java utilizando **Spring Boot**, que permite buscar libros mediante la API de [Gutendex](https://gutendex.com/) y almacenar los resultados en una base de datos.

## 🚀 Características

- Buscar libros por título desde la consola.
- Mostrar todos los libros previamente buscados y almacenados.
- Persistencia de datos usando Spring Data JPA.
- Consumo de APIs externas.
- Conversión automática de datos JSON a objetos Java.

## 📦 Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- Gutendex API (para búsqueda de libros)
- Jackson (para conversión JSON)
- H2/MySQL/PostgreSQL (puede adaptarse a cualquier base de datos relacional)
- Maven

## 🧠 Arquitectura del Proyecto

- `Principal`: Clase principal con el menú de interacción.
- `ConsumoApi`: Realiza peticiones HTTP a la API externa.
- `ConvierteDatos`: Convierte los datos JSON obtenidos en objetos Java.
- `LibroRepository`: Interfaz de Spring Data JPA para operaciones CRUD.
- `Libro`, `DatosLibro`, `RespuestaAPI`: Clases modelo para representar los datos de los libros.

## 📋 Cómo usarlo

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
Configura la base de datos
Asegúrate de tener configurado application.properties con la URL, usuario y contraseña correctos para tu base de datos.

Ejecuta el proyecto
Puedes ejecutar el proyecto directamente desde tu IDE o con Maven:


mvn spring-boot:run
Interacción desde consola
El programa te mostrará un menú como este:


1 - Búsqueda de libros por título
2 - Buscar libros buscados
0 - Salir
📚 Ejemplo de uso
Al seleccionar la opción 1 e ingresar un título, el sistema buscará el libro en Gutendex y mostrará la información como:


Título: Don Quijote
Autor: Miguel de Cervantes
Idioma: [es]
Descargas: 15324
El libro se guardará automáticamente en la base de datos.

⚠️ Nota
Este proyecto utiliza una API pública (https://gutendex.com) por lo que los resultados pueden variar y la disponibilidad depende del servicio externo.

✅ Pendientes o mejoras futuras
Implementar manejo de errores más robusto.

Crear una interfaz web usando Spring MVC o Thymeleaf.

Agregar pruebas unitarias y de integración.

Paginación en la búsqueda de libros.

Autor: MANUEL HERNANDEZ
Licencia: MIT

