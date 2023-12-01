package com.babel.Biblioteca.persistence.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "estante", schema = "babel_db")
public class Estante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "numero_estante")
    private Integer numeroEstante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_librero")
    private Librero idLibrero;

    @OneToMany(mappedBy = "idEstante")
    private Set<VolumenLibro> volumenLibros = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroEstante() {
        return numeroEstante;
    }

    public void setNumeroEstante(Integer numeroEstante) {
        this.numeroEstante = numeroEstante;
    }

    public Librero getIdLibrero() {
        return idLibrero;
    }

    public void setIdLibrero(Librero idLibrero) {
        this.idLibrero = idLibrero;
    }

    public Set<VolumenLibro> getVolumenLibros() {
        return volumenLibros;
    }

    public void setVolumenLibros(Set<VolumenLibro> volumenLibros) {
        this.volumenLibros = volumenLibros;
    }

}