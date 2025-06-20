package com.java.literatua.dto;

import com.java.literatua.model.Autor;
import com.java.literatua.model.Libro;

import java.util.List;
import java.util.stream.Collectors;

public class LibroDTO {
    private String titulo;
    private String idiomas;
    private Integer numeroDeDescargas;
    private String nombresAutores;

    public LibroDTO(Libro libro) {
        this.titulo = libro.getTitulo();
        this.idiomas = libro.getIdiomas();
        this.numeroDeDescargas = libro.getNumeroDeDescargas();
        this.nombresAutores = libro.getAutor().getName();
    }

    @Override
    public String toString() {
        return "LibroDTO{" +
                "titulo='" + titulo + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                ", autores=" + nombresAutores +
                '}';
    }
}

