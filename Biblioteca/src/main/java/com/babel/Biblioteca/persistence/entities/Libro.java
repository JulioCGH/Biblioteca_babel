package com.babel.Biblioteca.persistence.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "libro", schema = "babel_db")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "titulo", length = 400)
    private String titulo;

    @OneToMany(mappedBy = "idLibro")
    private Set<VolumenLibro> volumenLibros = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<VolumenLibro> getVolumenLibros() {
        return volumenLibros;
    }

    public void setVolumenLibros(Set<VolumenLibro> volumenLibros) {
        this.volumenLibros = volumenLibros;
    }

}