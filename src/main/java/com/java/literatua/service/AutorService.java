package com.java.literatua.service;

import com.java.literatua.model.Autor;
import com.java.literatua.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarTodosLosAutores() {
        return autorRepository.findAll();
    }
}

