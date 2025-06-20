package com.java.literatua.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer birth_year;
    private Integer death_year;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;



    // Constructor vacío requerido por JPA
    public Autor() {}

    // Opcional: constructor completo
    public Autor(String name) {
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
    }

    // Getters y setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }


    // toString, etc.


    @Override
    public String toString() {
        return "Autor{" +
                ", Nombre='" + name + '\'' +
                ", Año de Nacimiento =" + birth_year +
                ", Año de Muerto =" + death_year +
                '}';
    }
}
