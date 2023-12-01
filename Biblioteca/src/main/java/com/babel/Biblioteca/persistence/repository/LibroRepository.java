package com.babel.Biblioteca.persistence.repository;

import com.babel.Biblioteca.persistence.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro getLibroById(Long id);
    List<Libro> findAll();

}