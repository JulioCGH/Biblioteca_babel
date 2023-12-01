package com.babel.Biblioteca.services.controller;

import com.babel.Biblioteca.services.LibroService;
import com.babel.Biblioteca.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class LibroController {

    @Autowired
    LibroService libroService;

    @PostMapping("/")
    public LibroResponse getLibroById(@RequestBody LibroRequest request){
        return libroService.getLibroById(request);
    }

    @GetMapping("/book/{id}")
    public LibroResponse getLibroByIdGet(@PathVariable("id") Long id){
        LibroRequest request = new LibroRequest();
        request.setId(id);
        return libroService.getLibroById(request);
    }

    @GetMapping("/listbooks")
    public ListAllLibrosResponse listAll(){
        return libroService.listAll();
    }

    @PostMapping("/addbook")
    public CreateLibroResponse createLibro(@RequestBody CreateLibroRequest request){
        return libroService.createLibro(request);
    }

    @PostMapping("/findbook")
    public FindVolumenLibroResponse getVolumenLibroById(@RequestBody FindVolumenLibroRequest request){
        return libroService.getVolumenLibroById(request);
    }

    @PostMapping("/findbookbystatus")
    public FindVolumenEstadoResponse getVolumenEstadoById(@RequestBody FindVolumenEstadoRequest request){
        return libroService.getVolumenLibroByEstado(request);

    }

    @PostMapping("/updatebook")
    public UpdateVolumenLibroResponse updateVolumenLibro(@RequestBody UpdateVolumenLibroRequest request){
        return libroService.updateVolumenLibro(request);
    }

    @PostMapping("/deletebook")
    public DeleteVolumenLibroResponse deleteVolumenLibro(@RequestBody DeleteVolumenLibroRequest request){
        return libroService.deleteVolumenLibro(request);
    }

    @GetMapping("/listsalas")
    public ListAllSalasResponse listAllSalas(){
        return libroService.listAllSalas();
    }

    @PostMapping("/listalllibrerosbysala")
    public ListAllLibrerosBySalaResponse listAllLibrerosBySala(@RequestBody ListAllLibrerosBySalaRequest request){
        return libroService.listAllLibrerosBySala(request);
    }

    @PostMapping("/listallestantesbylibrero")
    public ListAllEstantesByLibreroResponse listAllEstantesByLibrero(@RequestBody ListAllEstantesByLibreroRequest request){
        return  libroService.listAllEstantesByLibrero(request);
    }
}

