package com.duoc.moviemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.moviemind.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

    


}
