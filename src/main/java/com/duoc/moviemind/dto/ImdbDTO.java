package com.duoc.moviemind.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class ImdbDTO {

    //Que busque la palabra "titles" en el JSON externo
    @JsonProperty("titles")
    private List<PeliculaImdb> peliculas;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PeliculaImdb {
        private String id;
        private String type;
        private String primaryTitle;
        private String plot;
    }
    
}
