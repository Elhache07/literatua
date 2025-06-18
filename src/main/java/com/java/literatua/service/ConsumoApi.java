package com.java.literatua.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obtenerDatos(String url) {
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(Redirect.NORMAL)  // ⬅️ Importante si alguna vez enfrentas redirecciones
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();

            if (statusCode != 200) {
                throw new RuntimeException("Error al consumir la API. Código de estado HTTP: " + statusCode);
            }

            String json = response.body();
            if (json == null || json.trim().isEmpty()) {
                throw new RuntimeException("La respuesta de la API está vacía.");
            }

            return json;

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
