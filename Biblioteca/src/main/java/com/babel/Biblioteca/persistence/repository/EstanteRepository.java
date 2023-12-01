package com.babel.Biblioteca.persistence.repository;

import com.babel.Biblioteca.persistence.entities.Estante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstanteRepository extends JpaRepository<Estante, Long> {

    Estante getEstanteById(Long id);
    List<Estante> getEstanteByIdLibreroId(Long id);
}