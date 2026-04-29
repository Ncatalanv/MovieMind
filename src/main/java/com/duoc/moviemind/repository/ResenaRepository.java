package com.duoc.moviemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.moviemind.model.Resena;

@Repository
public interface ResenaRepository extends JpaRepository <Resena, Integer> {


}
