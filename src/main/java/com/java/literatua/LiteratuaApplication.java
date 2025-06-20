package com.java.literatua;

import com.java.literatua.principal.Principal;
import com.java.literatua.repository.AutorRepository;
import com.java.literatua.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteratuaApplication implements CommandLineRunner {

	@Autowired
	private Principal principal; // ✅ Inyectamos Principal directamente

	public static void main(String[] args) {
		SpringApplication.run(LiteratuaApplication.class, args);
	}

	@Override
	public void run(String... args) {
		principal.muestraElMenu(); // ✅ Spring se encarga de inyectar dependencias internas
	}
}