package com.java.literatua.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaAPI {
    private List<DatosLibro> results;

    public List<DatosLibro> getResults() {
        return results;
    }

    public void setResults(List<DatosLibro> results) {
        this.results = results;
    }
}
