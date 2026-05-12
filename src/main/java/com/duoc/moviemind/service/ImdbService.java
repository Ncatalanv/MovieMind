package com.duoc.moviemind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.duoc.moviemind.dto.ImdbDTO;

@Service
public class ImdbService {

    @Autowired
    @Qualifier("imdbWebClient")
    private WebClient imdbWebClient;

    public ImdbDTO obtenerPeliculas() {
        return imdbWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/titles")
                        .queryParam("current_weather", true)
                        .build())
                .retrieve()
                .bodyToMono(ImdbDTO.class)
                .block();
    }
    
}
