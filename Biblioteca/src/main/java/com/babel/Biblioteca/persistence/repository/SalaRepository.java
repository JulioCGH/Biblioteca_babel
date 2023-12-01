package com.babel.Biblioteca.persistence.repository;

import com.babel.Biblioteca.persistence.entities.Libro;
import com.babel.Biblioteca.persistence.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findAll();

    Sala getSalaById(Long id);

}