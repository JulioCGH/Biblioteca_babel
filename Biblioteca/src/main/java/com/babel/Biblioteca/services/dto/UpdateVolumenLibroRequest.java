package com.babel.Biblioteca.services.dto;

import com.babel.Biblioteca.services.vo.LibroVo;

public class UpdateVolumenLibroRequest {

    private LibroVo libroVo;

    public LibroVo getLibroVo() {
        return libroVo;
    }

    public void setLibroVo(LibroVo libroVo) {
        this.libroVo = libroVo;
    }
}
