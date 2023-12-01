package com.babel.Biblioteca.services.dto;

import com.babel.Biblioteca.services.vo.LibroVo;

import java.util.List;

public class ListAllSalasResponse {

    List<LibroVo> libroVoList;

    public List<LibroVo> getLibroVoList() {
        return libroVoList;
    }

    public void setLibroVoList(List<LibroVo> libroVoList) {
        this.libroVoList = libroVoList;
    }
}
