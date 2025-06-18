package com.java.literatua.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ElementCollection;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosLibro {
    @JsonAlias("title")
    private String titulo;



    @JsonAlias("authors")
    private List<Autor> autores;

    @JsonAlias("languages")
    private List<String> idiomas;

    @JsonAlias("download_count")
    private Integer numeroDeDescargas;

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", idiomas=" + idiomas +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';
    }
}
