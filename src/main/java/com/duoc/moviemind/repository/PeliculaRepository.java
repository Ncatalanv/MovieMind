package com.duoc.moviemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.moviemind.model.Pelicula;

//(pelicula)-> entidad/tabla con la que trabaja, (integer)-> tipo de dato del ID de esa entidad
//al extender JpaRepository se heredan los metodos(consultas CRUD) listos para ser utilizados (findAll, findById, save, deleteById, count)

@Repository                                               
public interface PeliculaRepository  extends JpaRepository <Pelicula, Integer>   {  
}

