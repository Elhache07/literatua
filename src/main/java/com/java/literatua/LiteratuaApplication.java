package com.java.literatua;

import com.java.literatua.principal.Principal;
import com.java.literatua.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteratuaApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LiteratuaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal(repository);
		principal.muestraElMenu();


	}
}