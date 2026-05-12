package com.duoc.moviemind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.moviemind.dto.ImdbDTO;
import com.duoc.moviemind.service.ImdbService;

@RestController
@RequestMapping("/titles")
public class ImdbController {

    @Autowired
    private ImdbService imdbService;

    @GetMapping
    public ResponseEntity<ImdbDTO> pelis() {

        ImdbDTO resultado = imdbService.obtenerPeliculas();
        return ResponseEntity.ok(resultado);
    }

}
