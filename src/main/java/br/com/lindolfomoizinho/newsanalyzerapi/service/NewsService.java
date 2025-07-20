package br.com.lindolfomoizinho.newsanalyzerapi.service;

import br.com.lindolfomoizinho.newsanalyzerapi.config.NewsApiConfig;
import br.com.lindolfomoizinho.newsanalyzerapi.dto.ArticleDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class NewsService {
    private final WebClient webClient;
    private final NewsApiConfig config;

    public NewsService(WebClient.Builder builder, NewsApiConfig config) {
        this.config = config;
        this.webClient = builder.baseUrl(config.getBaseUrl()).build();
    }

    public List<ArticleDTO> getNewsByTopic(String topic) {
        NewsApiResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/everything")
                        .queryParam("q", topic)
                        .queryParam("pageSize", 5)
                        .queryParam("apiKey", config.getApiKey())
                        .build())
                .retrieve()
                .bodyToMono(NewsApiResponse.class)
                .block();

        return response.getArticles();
    }
}
