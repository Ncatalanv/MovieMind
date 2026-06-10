package com.duoc.moviemind.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import com.duoc.moviemind.model.Actor;
import com.duoc.moviemind.model.Genero;
import com.duoc.moviemind.model.Pelicula;
import com.duoc.moviemind.service.PeliculaService;


@ExtendWith(MockitoExtension.class)
class PeliculaControllerTest {
  @Mock
  private PeliculaService peliculaService;

  @InjectMocks
  private PeliculaController peliculaController;

  @Test
  void crearPelicula_retorna201_cuandoExisteActorGenero (){

    //Verificar que el método agregarPelicula del controlador funciona correctamente
    //Para ellos crearemos una pelicula con actor y género válido y simular el comportamiento del servicio
    Actor actor = new Actor(1, "Alvaro Maurelia", 28, "Peruana", new ArrayList<>());
    Genero genero = new Genero (1, "Romance", new ArrayList<>());
    Pelicula pelicula = new Pelicula(1, "El Titanic", "Narra el historico y tragico hundimiento del RMS titanic en 1912 a traves de una intensa y prohibida historia de amor", genero, 292922, 120, actor, 9, 7, new ArrayList<>());

    //Simular el comportamiento del servicio(mock)
    //Así evitamos acceder a la base de datos en una prueba unitaria
    //Cuando el servicio intente guardar la pelicula, le diremos que devuelva la misma pelicula creada
    //Cuando el controlador invoque el savePelicula con esa pelicula, Mockito devolverá esa misma pelicula al instante, sin guardar nada
    when(peliculaService.savePelicula(pelicula)).thenReturn(pelicula);

    //Llamar al método del controlador que queremos probar
    //El resultado de un ResponseEntity<Pelicula> que devolverá HTTP y cuerpo
    var respuesta = peliculaController.agregarPelicula(pelicula);

    //Para que el test sea completo, hay que verificar varios aspectos de la respuesta

    //Que no sea null
    assertNotNull(respuesta);

    //Que el HTTP esperado sea 201 (CREATED)
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

    //Debe existir cuerpo de la respuesta
    var body = respuesta.getBody();
    assertNotNull(body);

    //Validar un dato clave para confirmar que devolvió la película correcta
    assertEquals("El Titanic", body.getTitulo());




  }



}