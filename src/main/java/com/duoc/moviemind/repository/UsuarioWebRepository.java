package com.duoc.moviemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.moviemind.model.UsuarioWeb;

@Repository
public interface UsuarioWebRepository extends JpaRepository<UsuarioWeb, Integer> {

}
