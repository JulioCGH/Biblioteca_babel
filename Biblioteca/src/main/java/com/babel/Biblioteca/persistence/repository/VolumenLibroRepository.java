package com.babel.Biblioteca.persistence.repository;

import com.babel.Biblioteca.persistence.entities.VolumenLibro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VolumenLibroRepository extends JpaRepository<VolumenLibro, Long> {
    VolumenLibro getVolumenLibroById(Long Id);

    List<VolumenLibro> getVolumenLibroByEstado(Boolean Estado);


}