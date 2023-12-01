$(document).ready(function(){


    $('#formulario').hide();
    var valorSeleccionado = 0;
    var valorSeleccionado2 = 0;

    $("#selectsala").on('change', function() {
        // Obtén el valor seleccionado
        var opcionSeleccionada = $(this).val();
        console.log(opcionSeleccionada);
        buscarlibrero(opcionSeleccionada);

    });

    $("#selectlibrero").on('change', function() {
        // Obtén el valor seleccionado
        var opcionSeleccionada2 = $(this).val();
        console.log(opcionSeleccionada2);
        buscarestante(opcionSeleccionada2);

    });



    var estado = 1;


    $.ajax({

        url: 'http://localhost:8080/Babel/book/findbookbystatus',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "estado" : estado
        }),

        success: function (data) {
            var libros = data.libroVolist;



            $.each(libros, function (index, element){
                var button = "<button type='button' class='btn btn-primary' onclick='modificar("+element.id+")'>Modificar</button>";

                var button2 = "<button type='button' class='btn btn-danger' onclick='eliminardatos("+element.id+")'>Eliminar</button>";

                $("#tabledata").append("<tr>"+
                "<td>"+element.id+"</td>"+
                "<td>"+element.titulo+"</td>"+
                "<td>"+element.numeroVolumen+"</td>"+
                "<td>"+element.nombreSala+"</td>"+
                "<td>"+element.nombreLibrero+"</td>"+
                "<td>"+element.numeroEstante+"</td>"+
                "<td>"+element.posicion+"</td>"+
                "<td>"+element.estado+"</td>"+
                "<td>"+button+"&nbsp"+button2+"</td>"
                +"</tr>"
                );


            });

            var boton = "<button type='button' class='btn btn-dark btn-lg mt-2' onClick='crear()'>Agregar registro</button>"

            $("#tablaregistros").append(boton)


        },

        error: function (){
            console.log("Error");
        }
    })

});

function modificar(id){

    var libros = {};
    var salas = {};

    $('#tablaregistros').hide();
    $('#formmod').trigger("reset");
    $('#formulario').show();
    $('#Registrotext').hide();

    $.ajax({

        url: 'http://localhost:8080/Babel/book/listbooks',
        contentType: "application/json",
        type: "GET",

        success: function (data) {
            libros = data.libroList;
            console.log(libros);
        },
    })

    $.ajax({

        url: 'http://localhost:8080/Babel/book/listsalas',
        contentType: "application/json",
        type: "GET",

        success: function (data) {
            salas = data.libroVoList;
            console.log(salas);
        },
    })

    $.ajax({

        url: 'http://localhost:8080/Babel/book/findbook',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "id" : id
        }),

        success: function (data) {
            var volumenlibro = data.lVo;
            $("#inputvolumen").val(volumenlibro.numeroVolumen);
            $("#inputposicion").val(volumenlibro.posicion);
            var selectlibro = $("#selectlibro");
            var optlibros = "";
            var selectsala = $("#selectsala");
            var optsalas = "";

            $.each(libros, function (index, element){

                if(element.id == id){
                    optlibros = optlibros + "<option value= '"+element.id+"' selected>" + element.titulo + "</option>";
                }
                else{
                    optlibros = optlibros + "<option value= '"+element.id+"'>" + element.titulo + "</option>";
                }


            });

            selectlibro.html(optlibros);


            $.each(salas, function (index2, element2){

                if(element2.id == id){
                    optsalas= optsalas + "<option value= '"+element2.id+"' selected>" + element2.nombreSala + "</option>";
                }
                else{
                    optsalas = optsalas + "<option value= '"+element2.id+"'>" + element2.nombreSala + "</option>";
                }


            });

            selectsala.html(optsalas);



        },

    })

    var boton = "<button type='button' class='btn btn-success btn-lg mt-2' onClick='vacios("+id+")'>Modificar</button>&nbsp&nbsp&nbsp<button type='button' class='btn btn-secondary btn-lg mt-2 ' onClick='regresar()'>Regresar</button>"


    $("#formmod").append(boton)

}

function buscarlibrero(id_sala){

    console.log("Funcion buscar librero"+id_sala);

    $.ajax({
        url: 'http://localhost:8080/Babel/book/listalllibrerosbysala',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "id" : id_sala
        }),

        success: function (data) {
            console.log("Entro al success");
            var selectlibrero = $("#selectlibrero");
            var optlibreros = "";
            console.log(data)
            libreros = data.libroVoList;

            $.each(libreros, function (index3, element3){
                console.log("Entro al each");
                if(element3.id_sala == id_sala){
                    optlibreros= optlibreros + "<option value= '"+element3.id_librero+"' selected>" + element3.nombreLibrero+ "</option>";
                }
                    optlibreros = optlibreros + "<option value= '"+element3.id_librero+"'>" + element3.nombreLibrero + "</option>";

            });

            selectlibrero.html(optlibreros);


        },

        error: function (){
            console.log("Error");
        }
    })

}

function buscarestante(id_librero){



    $.ajax({

        url: 'http://localhost:8080/Babel/book/listallestantesbylibrero',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "id" : id_librero
        }),

        success: function (data) {
            estantes = data.libroVoList;
            console.log("Entro al success");
            var selectestante = $("#selectestante");
            var optestantes = "";
            console.log(data)


            $.each(estantes, function (index3, element3){
                console.log("Entro al each");
                if(element3.id_librero == id_librero){
                    optestantes= optestantes + "<option value= '"+element3.id_estante+"' selected>" + element3.numeroEstante+ "</option>";
                }
                optestantes = optestantes + "<option value= '"+element3.id_estante+"'>" + element3.numeroEstante + "</option>";

            });

            selectestante.html(optestantes);

        },

        error: function (){
            console.log("Error");
        }
    })

}

function modificardatos(id){
    var id_libro = $("#selectlibro").val();
    var numero_volumen = $("#inputvolumen").val();
    var id_estante = $("#selectestante").val();
    var posicion = $("#inputposicion").val();
    var estado = 1;


    $.ajax({

        url: 'http://localhost:8080/Babel/book/updatebook',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "libroVo" : {"id":id, "id_libro":id_libro, "numeroVolumen":numero_volumen, "id_estante": id_estante, "posicion":posicion, "estado":estado }
        }),
        success: function (data) {
            alert("Se modifico correctamente el regisro.")
            $('#formulario').hide();
            $('#tablaregistros').show();
            document.location.href = 'index';
        },

        error: function (){
            console.log("Error");
        }


    })

}

function eliminardatos(id){

    var estado = 0;
    $.ajax({


        url: 'http://localhost:8080/Babel/book/deletebook',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "libroVo" : {"id":id, "estado":estado }
        }),
        success: function (data) {
            alert("Se modifico correctamente el regisro.")

            document.location.href = 'index';

        },

        error: function (){
            console.log("Error");
        }


    })

}

function crear(){
    var libros = {};
    var salas = {};

    $('#tablaregistros').hide();
    $('#formulario').show();
    $('#Editartext').hide();

    $.ajax({

        url: 'http://localhost:8080/Babel/book/listbooks',
        contentType: "application/json",
        type: "GET",

        success: function (data) {
            libros = data.libroList;
            var selectlibro = $("#selectlibro");
            var optlibros = "";



            $.each(libros, function (index, element){

                optlibros = optlibros + "<option value= '"+element.id+"'>" + element.titulo + "</option>";

            });
            selectlibro.html(optlibros);
        },
    })

    $.ajax({

        url: 'http://localhost:8080/Babel/book/listsalas',
        contentType: "application/json",
        type: "GET",

        success: function (data) {
            salas = data.libroVoList;
            var selectsala = $("#selectsala");
            var optsalas = "";

            $.each(salas, function (index2, element2){

                optsalas = optsalas + "<option value= '"+element2.id+"'>" + element2.nombreSala + "</option>";

            });

            selectsala.html(optsalas);


        },
        error: function (){
            console.log("Error");
        }
    })

    var boton = "<button type='button' class='btn btn-success btn-lg mt-2 ' onClick='vacios_crear()'>Crear</button>&nbsp&nbsp&nbsp<button type='button' class='btn btn-secondary btn-lg mt-2 ' onClick='regresar()'>Regresar</button>"


    $("#formmod").append(boton)

}

function crearresgitro(){

    $('#tablaregistros').hide();
    $('#formulario').show();
    $('#Editartext').hide();
    $('#Registrotext').show();

    var id_libro = $("#selectlibro").val();
    var numero_volumen = $("#inputvolumen").val();
    var id_estante = $("#selectestante").val();
    var posicion = $("#inputposicion").val();
    var estado = 1;


    $.ajax({

        url: 'http://localhost:8080/Babel/book/addbook',
        contentType: "application/json",
        type: "POST",
        data: JSON.stringify({
            "libroVo" : {"id_libro":id_libro, "numeroVolumen":numero_volumen, "id_estante": id_estante, "posicion":posicion, "estado":estado }
        }),
        success: function (data) {
            alert("Se agrego correctamente el regisro.")
            $('#formulario').hide();
            $('#tablaregistros').show();
            document.location.href = 'index';
        },

        error: function (){
            console.log("Error");
        }


    })


}

function regresar(){
    document.location.href = 'index';
}
function vacios(id){
    var form = $('#formmod').serialize();
    var involumen = $('#inputvolumen').val();
    var inposicion = $('#inputposicion').val();
    var sellibro = $('#selectlibro');
    var selsala = $('#selectsala');
    var sellibrero = $('#selectlibrero');
    var selestante = $('#selectestante');

    if (involumen.length == 0 ||  inposicion == 0 || !sellibrero.val() || !selsala.val() || !selestante.val()) {
        alert('Alerta: algunos campos estan vacios');

    }
    else{
        modificardatos(id)
    }

}
function vacios_crear(){
    var form = $('#formmod').serialize();
    var involumen = $('#inputvolumen').val();
    var inposicion = $('#inputposicion').val();
    var sellibro = $('#selectlibro');
    var selsala = $('#selectsala');
    var sellibrero = $('#selectlibrero');
    var selestante = $('#selectestante');

    if (involumen.length == 0 ||  inposicion == 0 || !sellibrero.val() || !selsala.val() || !selestante.val()) {
        alert('Alerta: algunos campos estan vacios');

    }
    else{
        crearresgitro()
    }

}