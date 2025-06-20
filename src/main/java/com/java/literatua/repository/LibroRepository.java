package com.java.literatua.repository;

import com.java.literatua.model.Autor;
import com.java.literatua.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloContainsIgnoreCase(String nombreLibro);//busqueda del libro


    @Query("SELECT e FROM Libro s JOIN s.titulo e ")
    List<Libro> muestraLosTitulosDeLosLibros(Libro libro);


    @Query("SELECT DISTINCT l FROM Libro l JOIN FETCH l.autor")
    Libro findAllConAutores();



}
