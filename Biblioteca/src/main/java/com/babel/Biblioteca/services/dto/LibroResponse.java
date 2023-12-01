package com.babel.Biblioteca.services.dto;

import com.babel.Biblioteca.services.vo.LibroVo;

public class LibroResponse {

    private LibroVo libro;

    public LibroVo getLibro() {
        return libro;
    }

    public void setLibro(LibroVo libro) {
        this.libro = libro;
    }
}
