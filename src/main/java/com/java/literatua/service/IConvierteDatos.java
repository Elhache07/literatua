package com.java.literatua.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}
