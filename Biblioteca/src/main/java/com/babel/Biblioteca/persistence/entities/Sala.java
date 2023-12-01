package com.babel.Biblioteca.persistence.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sala", schema = "babel_db")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "nombre_sala", length = 400)
    private String nombreSala;

    @OneToMany(mappedBy = "idSala")
    private Set<Librero> libreros = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public Set<Librero> getLibreros() {
        return libreros;
    }

    public void setLibreros(Set<Librero> libreros) {
        this.libreros = libreros;
    }

}