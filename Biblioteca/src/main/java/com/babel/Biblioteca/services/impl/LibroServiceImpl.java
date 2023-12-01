package com.babel.Biblioteca.services.impl;

import com.babel.Biblioteca.persistence.entities.*;
import com.babel.Biblioteca.persistence.repository.*;
import com.babel.Biblioteca.services.LibroService;
import com.babel.Biblioteca.services.dto.*;
import com.babel.Biblioteca.services.vo.LibroVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Autowired
    EstanteRepository estanteRepository;
    @Autowired
    VolumenLibroRepository volumenLibroRepository;
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private LibreroRepository libreroRepository;

    @Override
    public LibroResponse getLibroById(LibroRequest request) {

        Libro libro = libroRepository.getLibroById(request.getId());
        LibroVo librovo = new LibroVo();
        librovo.setId(libro.getId());
        librovo.setTitulo(libro.getTitulo());

        LibroResponse libroresponse = new LibroResponse();
        libroresponse.setLibro(librovo);

        return libroresponse;
    }

    @Override
    public ListAllLibrosResponse listAll() {
        List<Libro> libroList = libroRepository.findAll();

        List<LibroVo> libroVoList = new ArrayList<>();
        libroList.forEach(libro -> {
            LibroVo librovo = new LibroVo();
            librovo.setId(libro.getId());
            librovo.setTitulo(libro.getTitulo());

            libroVoList.add(librovo);
        });

        ListAllLibrosResponse response = new ListAllLibrosResponse();
        response.setLibroList(libroVoList);

        return response;
    }

    @Override
    public CreateLibroResponse createLibro(CreateLibroRequest request) {

        Libro libro = libroRepository.getLibroById(request.getLibroVo().getId_libro());
        Estante estante = estanteRepository.getEstanteById(request.getLibroVo().getId_estante());

        VolumenLibro volumenLibro = new VolumenLibro();
        volumenLibro.setIdLibro(libro);
        volumenLibro.setNumeroVolumen(request.getLibroVo().getNumeroVolumen());
        volumenLibro.setIdEstante(estante);
        volumenLibro.setPosicion(request.getLibroVo().getPosicion());
        volumenLibro.setEstado(true);

        volumenLibroRepository.save(volumenLibro);

        LibroVo libroVo = request.getLibroVo();
        libroVo.setId(volumenLibro.getId());

        CreateLibroResponse response = new CreateLibroResponse();
        response.setLibroVo(libroVo);

        return response;
    }

    @Override
    public FindVolumenLibroResponse getVolumenLibroById(FindVolumenLibroRequest request) {

        VolumenLibro vLibro = volumenLibroRepository.getVolumenLibroById(request.getId());

        Estante estante = vLibro.getIdEstante();
        Libro libro = vLibro.getIdLibro();
        Librero librero = vLibro.getIdEstante().getIdLibrero();

        LibroVo libroVo = new LibroVo();
        libroVo.setId(vLibro.getId());
        libroVo.setId_libro(libro.getId());
        libroVo.setTitulo(libro.getTitulo());
        libroVo.setNumeroVolumen(vLibro.getNumeroVolumen());
        libroVo.setId_estante(estante.getId());
        libroVo.setNombreSala(librero.getIdSala().getNombreSala());
        libroVo.setNombreLibrero(estante.getIdLibrero().getNombreLibrero());
        libroVo.setNumeroEstante(estante.getNumeroEstante());
        libroVo.setPosicion(vLibro.getPosicion());
        libroVo.setEstado(vLibro.getEstado());

        FindVolumenLibroResponse volumenLibroResponse = new FindVolumenLibroResponse();
        volumenLibroResponse.setlVo(libroVo);

        return volumenLibroResponse;
    }

    @Override
    public FindVolumenEstadoResponse getVolumenLibroByEstado(FindVolumenEstadoRequest request) {

        List<VolumenLibro> volumenLibrolist = volumenLibroRepository.getVolumenLibroByEstado(request.getEstado());

        List<LibroVo> libroVoList = new ArrayList<>();
        volumenLibrolist.forEach(volumenLibro -> {

            Estante estante = volumenLibro.getIdEstante();
            Libro libro = volumenLibro.getIdLibro();
            Librero librero = volumenLibro.getIdEstante().getIdLibrero();

            LibroVo libroVo = new LibroVo();
            libroVo.setId(volumenLibro.getId());
            libroVo.setId_libro(libro.getId());
            libroVo.setTitulo(libro.getTitulo());
            libroVo.setNumeroVolumen(volumenLibro.getNumeroVolumen());
            libroVo.setId_estante(estante.getId());
            libroVo.setNombreSala(librero.getIdSala().getNombreSala());
            libroVo.setNombreLibrero(estante.getIdLibrero().getNombreLibrero());
            libroVo.setNumeroEstante(estante.getNumeroEstante());
            libroVo.setPosicion(volumenLibro.getPosicion());
            libroVo.setEstado(volumenLibro.getEstado());

            libroVoList.add(libroVo);
        });

        FindVolumenEstadoResponse volumenestadoResponse = new FindVolumenEstadoResponse();
        volumenestadoResponse.setLibroVolist(libroVoList);

        return  volumenestadoResponse;

    }

    @Override
    public UpdateVolumenLibroResponse updateVolumenLibro(UpdateVolumenLibroRequest request) {

        VolumenLibro vLibro = volumenLibroRepository.getVolumenLibroById(request.getLibroVo().getId());

        Libro libro = libroRepository.getLibroById(request.getLibroVo().getId_libro());
        Estante estante = estanteRepository.getEstanteById(request.getLibroVo().getId_estante());

        vLibro.setIdLibro(libro);
        vLibro.setNumeroVolumen(request.getLibroVo().getNumeroVolumen());
        vLibro.setIdEstante(estante);
        vLibro.setPosicion(request.getLibroVo().getPosicion());
        vLibro.setEstado(request.getLibroVo().getEstado());

        System.out.println(vLibro.getIdLibro());
        System.out.println(vLibro.getNumeroVolumen());
        System.out.println(vLibro.getIdEstante());
        System.out.println(vLibro.getPosicion());


        volumenLibroRepository.save(vLibro);

        LibroVo libroVo = request.getLibroVo();
        libroVo.setId(vLibro.getId());

        UpdateVolumenLibroResponse updateVolumenLibroResponse = new UpdateVolumenLibroResponse();
        updateVolumenLibroResponse.setLibroVo(libroVo);

        return updateVolumenLibroResponse;

    }

    @Override
    public DeleteVolumenLibroResponse deleteVolumenLibro(DeleteVolumenLibroRequest request) {
        VolumenLibro vLibro = volumenLibroRepository.getVolumenLibroById(request.getLibroVo().getId());
        vLibro.setEstado(false);
        volumenLibroRepository.save(vLibro);

        LibroVo libroVo = request.getLibroVo();

        DeleteVolumenLibroResponse deleteVolumenLibroResponse = new DeleteVolumenLibroResponse();
        deleteVolumenLibroResponse.setLibroVo(libroVo);

        return deleteVolumenLibroResponse;
    }

    @Override
    public ListAllSalasResponse listAllSalas() {
        List<Sala> salaList = salaRepository.findAll();

        List<LibroVo> libroVoList = new ArrayList<>();
        salaList.forEach(sala -> {
            LibroVo librovo = new LibroVo();
            librovo.setId(sala.getId());
            librovo.setNombreSala(sala.getNombreSala());

            libroVoList.add(librovo);
        });

        ListAllSalasResponse response = new ListAllSalasResponse();
        response.setLibroVoList(libroVoList);
        return response;

    }

    @Override
    public ListAllLibrerosBySalaResponse listAllLibrerosBySala(ListAllLibrerosBySalaRequest request) {

        Sala sala = salaRepository.getSalaById(request.getId());

        List<Librero> librerolist = libreroRepository.getLibreroByIdSala(sala);

        List<LibroVo> libroVoList = new ArrayList<>();

        librerolist.forEach(librero -> {

            LibroVo libroVo = new LibroVo();

            libroVo.setId_librero(librero.getId());
            libroVo.setNombreLibrero(librero.getNombreLibrero());

            libroVoList.add(libroVo);

        });

        ListAllLibrerosBySalaResponse listAllLibrerosBySalaResponse = new ListAllLibrerosBySalaResponse();
        listAllLibrerosBySalaResponse.setLibroVoList(libroVoList);

        return listAllLibrerosBySalaResponse;
    }

    @Override
    public ListAllEstantesByLibreroResponse listAllEstantesByLibrero(ListAllEstantesByLibreroRequest request) {

        List<Estante> estanteList = estanteRepository.getEstanteByIdLibreroId(request.getId());

        List<LibroVo> libroVoList = new ArrayList<>();

        estanteList.forEach(estante -> {

            LibroVo libroVo = new LibroVo();

            libroVo.setId_estante(estante.getId());
            libroVo.setNumeroEstante(estante.getNumeroEstante());

            libroVoList.add(libroVo);
        });

        ListAllEstantesByLibreroResponse listAllEstantesByLibreroResponse = new ListAllEstantesByLibreroResponse();
        listAllEstantesByLibreroResponse.setLibroVoList(libroVoList);

        return listAllEstantesByLibreroResponse;
    }

}
