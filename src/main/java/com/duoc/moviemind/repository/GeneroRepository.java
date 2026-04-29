package com.duoc.moviemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.moviemind.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository <Genero, Integer>  {


}
