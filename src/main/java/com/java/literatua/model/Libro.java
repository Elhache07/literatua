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


    private String autores;


    private String idiomas;

    @Column(name = "numero_de_descargas")
    private Integer numeroDeDescargas;

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.getTitulo();
        this.autores = datosLibro.getAutores()
                .stream()
                .map(Autor::getName)
                .collect(Collectors.joining(";"));

        this.idiomas = String.join(",", datosLibro.getIdiomas());
        this.numeroDeDescargas = datosLibro.getNumeroDeDescargas();
    }


    public Libro() {

    }


    @Override
    public String toString() {
        return "Libro{" +

                ", titulo='" + titulo +
                ", autores='" + autores +
                ", idiomas='" + idiomas +
                ", NumeroDeDescarga=" + numeroDeDescargas +
                '}';
    }
}
