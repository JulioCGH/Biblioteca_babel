package com.babel.Biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {

		SpringApplication.run(BibliotecaApplication.class, args);
		System.out.println("Ejecucion de la aplicacion exitosa");
	}

}