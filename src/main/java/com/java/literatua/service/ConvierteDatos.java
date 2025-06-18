package com.java.literatua.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        if (json == null || json.isEmpty()){
            throw new RuntimeException("El JSON recibido está vacío o nulo. No se puede convertir.");
        }

        try {
            return mapper.readValue(json,clase);
        }catch (JsonProcessingException e){
            throw new RuntimeException("Error al procesar el Json: "+e.getMessage());
        }
    }
}
