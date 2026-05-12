package com.duoc.moviemind.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClienteConfig {

    @Value("${imdb.base-url}")
    private String imdbBaseUrl;

    @Bean
    public WebClient imdbWebClient() {
        return WebClient.builder()
                .baseUrl(imdbBaseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
