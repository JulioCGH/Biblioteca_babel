package com.babel.Biblioteca.services.dto;

import com.babel.Biblioteca.services.vo.LibroVo;

import java.util.List;

public class ListAllLibrosResponse {

    List<LibroVo> libroList;

    public List<LibroVo> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<LibroVo> libroList) {
        this.libroList = libroList;
    }
}
