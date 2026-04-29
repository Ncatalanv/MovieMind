package com.duoc.moviemind.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duoc.moviemind.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>  {

    


}
