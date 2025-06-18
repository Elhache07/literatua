package com.java.literatua.principal;

import com.java.literatua.model.DatosLibro;
import com.java.literatua.model.Libro;
import com.java.literatua.model.RespuestaAPI;
import com.java.literatua.repository.LibroRepository;
import com.java.literatua.service.ConsumoApi;
import com.java.literatua.service.ConvierteDatos;
import jakarta.persistence.ElementCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final  String URL_BASE = "https://www.omdbapi.com/?t=";
    private final  String API_KEY = "&apikey=cea3642b";
    private List<Libro> libros;
    private ConvierteDatos conversor = new ConvierteDatos();


    private  LibroRepository libroRepository;


    public Principal(LibroRepository repository) {
        this.libroRepository = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Busqueda de libros por titulo
                    2 - Buscar libros buscados
                 
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWed();
                    break;
                case 2:
                    mostrarLibroBuscados();
                    break;

                case 0:
                    System.out.println("cerrando programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;


            }
        }


    }
    private void buscarLibroWed(){

        DatosLibro datos= getDatosLibro();
        Libro libro= new Libro(datos);
        libroRepository.save(libro);

        System.out.println(datos);



    }

    private void mostrarLibroBuscados(){


        libros=new ArrayList<>();

        libros=libroRepository.findAll();

        libros.stream()
                .forEach(System.out::println);
    }

    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el nombre del libro a buscar");
        var nombre = teclado.nextLine();
        var json=consumoApi.obtenerDatos("https://gutendex.com/books?search="+ nombre.replace(" ","%20"));
        System.out.println(json);

        RespuestaAPI respuesta=conversor.obtenerDatos(json,RespuestaAPI.class);
        if ( respuesta.getResults().isEmpty()) {
            System.out.println("No se encontro el libro con ese titulo");
            return null;

        }

        DatosLibro datos= respuesta.getResults().get(0);
        System.out.println("Título: " + datos.getTitulo());

        System.out.println("Autor: " + (datos.getAutores().isEmpty() ? "Desconocido" : datos.getAutores().get(0).getName()));
        System.out.println("Idioma: " + datos.getIdiomas());
        System.out.println("Descargas: " + datos.getNumeroDeDescargas());
        return datos;
    }
}
