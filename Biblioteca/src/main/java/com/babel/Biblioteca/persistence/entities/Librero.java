package com.babel.Biblioteca.persistence.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "librero", schema = "babel_db")
public class Librero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "nombre_librero", length = 10)
    private String nombreLibrero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sala")
    private Sala idSala;

    @OneToMany(mappedBy = "idLibrero")
    private Set<Estante> estantes = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreLibrero() {
        return nombreLibrero;
    }

    public void setNombreLibrero(String nombreLibrero) {
        this.nombreLibrero = nombreLibrero;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
    }

    public Set<Estante> getEstantes() {
        return estantes;
    }

    public void setEstantes(Set<Estante> estantes) {
        this.estantes = estantes;
    }

}