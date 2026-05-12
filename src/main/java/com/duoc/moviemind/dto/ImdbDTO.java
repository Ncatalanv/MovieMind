package com.duoc.moviemind.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class ImdbDTO {

    @JsonProperty("peliculas")
    private PeliculasImdb peliculasImdb;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PeliculasImdb {
        private String id;
        private String type;
        private String primaryTitle;
        private String plot;
    }
    
}
