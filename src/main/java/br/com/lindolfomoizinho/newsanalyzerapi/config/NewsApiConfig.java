package br.com.lindolfomoizinho.newsanalyzerapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "newsapi")
@Data
public class NewsApiConfig {
    private String baseUrl;
    private String apiKey;
}
