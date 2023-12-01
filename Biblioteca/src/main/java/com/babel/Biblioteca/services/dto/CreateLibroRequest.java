package com.babel.Biblioteca.services.dto;

import com.babel.Biblioteca.services.vo.LibroVo;

public class CreateLibroRequest {

    private LibroVo libroVo;

    public LibroVo getLibroVo() {
        return libroVo;
    }

    public void setLibroVo(LibroVo libroVo) {
        this.libroVo = libroVo;
    }
}
