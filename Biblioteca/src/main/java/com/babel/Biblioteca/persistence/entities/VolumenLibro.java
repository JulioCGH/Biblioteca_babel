package com.babel.Biblioteca.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "volumen_libro", schema = "babel_db")
public class VolumenLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro")
    private Libro idLibro;

    @Column(name = "numero_volumen")
    private Integer numeroVolumen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estante")
    private Estante idEstante;

    @Column(name = "posicion", length = 20)
    private String posicion;

    @Column(name = "estado")
    private Boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }

    public Integer getNumeroVolumen() {
        return numeroVolumen;
    }

    public void setNumeroVolumen(Integer numeroVolumen) {
        this.numeroVolumen = numeroVolumen;
    }

    public Estante getIdEstante() {
        return idEstante;
    }

    public void setIdEstante(Estante idEstante) {
        this.idEstante = idEstante;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}