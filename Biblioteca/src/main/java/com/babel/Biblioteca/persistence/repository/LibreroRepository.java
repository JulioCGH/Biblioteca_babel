package com.babel.Biblioteca.persistence.repository;

import com.babel.Biblioteca.persistence.entities.Librero;
import com.babel.Biblioteca.persistence.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibreroRepository extends JpaRepository<Librero, Long> {

    List<Librero> getLibreroByIdSala(Sala sala);

}