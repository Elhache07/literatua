package com.java.literatua.principal;

import com.java.literatua.dto.LibroDTO;
import com.java.literatua.model.Autor;
import com.java.literatua.model.DatosLibro;
import com.java.literatua.model.Libro;
import com.java.literatua.model.RespuestaAPI;
import com.java.literatua.repository.AutorRepository;
import com.java.literatua.repository.LibroRepository;
import com.java.literatua.service.AutorService;
import com.java.literatua.service.ConsumoApi;
import com.java.literatua.service.ConvierteDatos;
import jakarta.persistence.ElementCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final  String URL_BASE = "https://www.omdbapi.com/?t=";
    private final  String API_KEY = "&apikey=cea3642b";
    private Libro libros;
    private Autor autor;
    private List<Autor> autores;
    private ConvierteDatos conversor = new ConvierteDatos();


    private  LibroRepository libroRepository;
    private AutorRepository autorRepository;

    private AutorService autorService;


    @Autowired
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository, AutorService autorService) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.autorService = autorService;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    
                    //////////////////////////////////////////////
                    
                    
                    1 - Busqueda de libros por titulo
                    2 - Mostrar libros buscados
                    3 - Lista de autores
                    4 - Listar autores vivos en determinado año
                 
                    
                    0 - Salir
                    
                    /////////////////////////////////////////////
                    
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
                    case 3:
                        ListaDeAutores();
                        break;
                        case 4:
                            listarDeAutoresPorTiempoVivido();
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

    private void listarDeAutoresPorTiempoVivido() {
    }

    private void ListaDeAutores() {
        List<Autor> autores = autorService.listarTodosLosAutores();

        // Usamos un Set para evitar nombres repetidos
        Set<String> nombresUnicos = new HashSet<>();

        for (Autor autor : autores) {
            if (nombresUnicos.add(autor.getName())) {  // Solo muestra si no se ha agregado antes
                System.out.println("Autor: " + autor.getName() + " (Nacido: " + autor.getBirth_year() + ")");
            }
        }
    }

    private void buscarLibroWed(){

        DatosLibro datos= getDatosLibro();
        Libro libro= new Libro(datos);
        libroRepository.save(libro);

        System.out.println(datos);



    }

    private void mostrarLibroBuscados() {
        libros = libroRepository.findAllConAutores();
         System.out.println(new LibroDTO(libros));
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

        System.out.println("Autor: " + datos.getAutores().get(0));
        System.out.println("Idioma: " + datos.getIdiomas());
        System.out.println("Descargas: " + datos.getNumeroDeDescargas());
        return datos;
    }
}
