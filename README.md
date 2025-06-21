# 📚 Aplicación de Búsqueda de Libros

Esta es una aplicación Java desarrollada con Spring Boot que permite buscar libros mediante una API pública, guardar información relevante en una base de datos y consultar datos sobre libros y autores.

## 🚀 Características

- 🔍 Buscar libros por título utilizando la API de Gutendex.
- 📖 Guardar libros y autores en una base de datos relacional.
- 👨‍💼 Listar todos los autores únicos encontrados.
- ⌛ Filtrar autores vivos en un rango de años específico.
- 🌍 Consultar cantidad de libros por idioma (Español o Inglés).

## 🧰 Tecnologías utilizadas

- Java 17+
- Spring Boot
- JPA / Hibernate
- H2 / PostgreSQL / otro RDBMS
- API pública de libros: [Gutendex](https://gutendex.com/)
- Maven

## 📦 Estructura del Proyecto

com.java.literatua
├── dto
│ └── LibroDTO.java
├── model
│ ├── Autor.java
│ ├── DatosLibro.java
│ ├── Libro.java
│ └── RespuestaAPI.java
├── repository
│ ├── AutorRepository.java
│ └── LibroRepository.java
├── service
│ ├── AutorService.java
│ ├── ConsumoApi.java
│ └── ConvierteDatos.java
└── principal
└── Principal.java

bash
Copiar
Editar

## 🖥️ Ejecución de la aplicación

1. Clona este repositorio:

```bash
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio
Asegúrate de tener configurado Java y Maven en tu entorno.

Compila y ejecuta:

bash
Copiar
Editar
./mvnw spring-boot:run
Al iniciar, verás un menú en consola con las opciones disponibles.

📋 Menú principal
text
Copiar
Editar
1 - Búsqueda de libros por título
2 - Mostrar libros buscados
3 - Lista de autores
4 - Listar autores vivos en determinado año
5 - Libros por idioma
0 - Salir
📡 APIs externas
Gutendex Books API

(Posiblemente planificado) OMDb API (URL incluida pero no utilizada actualmente)

🧪 Recomendaciones
Para persistencia local, puedes utilizar H2 en modo consola para ver la base de datos (http://localhost:8080/h2-console).

Asegúrate de tener una estrategia de inicialización adecuada (spring.jpa.hibernate.ddl-auto=create/update en application.properties).

🤝 Contribuciones
¡Las contribuciones son bienvenidas! Por favor abre un pull request o issue para mejorar el proyecto.

📄 Licencia
Este proyecto está bajo la licencia MIT - ver el archivo LICENSE para más detalles.

yaml
Copiar
Editar

