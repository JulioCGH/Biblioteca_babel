package com.babel.Biblioteca.services.dto;

import com.babel.Biblioteca.services.vo.LibroVo;

import java.util.List;

public class FindVolumenEstadoResponse {

    private List<LibroVo> libroVolist;

    public List<LibroVo> getLibroVolist() {
        return libroVolist;
    }

    public void setLibroVolist(List<LibroVo> libroVolist) {
        this.libroVolist = libroVolist;
    }
}
