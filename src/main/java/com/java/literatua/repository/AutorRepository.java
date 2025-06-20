package com.java.literatua.repository;

import com.java.literatua.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {



    @Query("SELECT a FROM Autor a WHERE a.birth_year <= :fechaFin AND (a.death_year IS NULL OR a.death_year >= :fechaInicio)")
    List<Autor> listarAutoresPorTiempo(Integer fechaInicio, Integer fechaFin);


}
