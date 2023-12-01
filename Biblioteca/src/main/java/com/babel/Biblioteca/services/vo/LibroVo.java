package com.babel.Biblioteca.services.vo;

public class LibroVo {

    private Long id;

    private Long id_libro;
    private String titulo;

    private Integer numeroVolumen;

    private Long id_estante;

    private Integer numeroEstante;

    private Long id_librero;

    private String nombreLibrero;

    private Long id_sala;

    private String nombreSala;

    private String posicion;

    private Boolean estado;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_libro() {
        return id_libro;
    }

    public void setId_libro(Long id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroVolumen() {
        return numeroVolumen;
    }

    public void setNumeroVolumen(Integer numeroVolumen) {
        this.numeroVolumen = numeroVolumen;
    }

    public Long getId_estante() {
        return id_estante;
    }

    public void setId_estante(Long id_estante) {
        this.id_estante = id_estante;
    }

    public Integer getNumeroEstante() {
        return numeroEstante;
    }

    public void setNumeroEstante(Integer numeroEstante) {
        this.numeroEstante = numeroEstante;
    }

    public Long getId_librero() {
        return id_librero;
    }

    public void setId_librero(Long id_librero) {
        this.id_librero = id_librero;
    }

    public String getNombreLibrero() {
        return nombreLibrero;
    }

    public void setNombreLibrero(String nombreLibrero) {
        this.nombreLibrero = nombreLibrero;
    }

    public Long getId_sala() {
        return id_sala;
    }

    public void setId_sala(Long id_sala) {
        this.id_sala = id_sala;
    }

    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
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
