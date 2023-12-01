package com.babel.Biblioteca.services;

import com.babel.Biblioteca.services.dto.*;

public interface LibroService {
    //Response nombre de la funcion/metodo  (Request/parametros)
    LibroResponse getLibroById(LibroRequest request);

    ListAllLibrosResponse listAll();

    CreateLibroResponse createLibro(CreateLibroRequest request);

    FindVolumenLibroResponse getVolumenLibroById(FindVolumenLibroRequest request);

    FindVolumenEstadoResponse getVolumenLibroByEstado(FindVolumenEstadoRequest request);

    UpdateVolumenLibroResponse updateVolumenLibro(UpdateVolumenLibroRequest request);

    DeleteVolumenLibroResponse deleteVolumenLibro(DeleteVolumenLibroRequest request);

    ListAllSalasResponse listAllSalas();

    ListAllLibrerosBySalaResponse listAllLibrerosBySala(ListAllLibrerosBySalaRequest request);

    ListAllEstantesByLibreroResponse listAllEstantesByLibrero(ListAllEstantesByLibreroRequest request);

}
