package com.java.literatua.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


@Entity
@Table(name = "libros")
public class Libro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String titulo;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "autor_id")// nombre de la columna en la tabla `libro`
    private Autor autor;



    private String idiomas;

    @Column(name = "numero_de_descargas")
    private Integer numeroDeDescargas;

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.getTitulo();
        if (datosLibro.getAutores() != null && !datosLibro.getAutores().isEmpty()) {
            this.autor = datosLibro.getAutores().get(0); // Selecciona el primero
        }
        this.idiomas = String.join(",", datosLibro.getIdiomas());
        this.numeroDeDescargas = datosLibro.getNumeroDeDescargas();
    }


    public Libro() {

    }


    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';  // NO accedemos a autores aquí
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
