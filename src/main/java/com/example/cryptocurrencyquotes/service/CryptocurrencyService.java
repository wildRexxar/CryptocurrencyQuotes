package com.example.cryptocurrencyquotes.service;

import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import com.example.cryptocurrencyquotes.repo.CryptocurrencyRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class CryptocurrencyService {

    private final static String TICKER_URL_ALL = "https://api.coinlore.net/api/tickers/?limit=3";

    private final CryptocurrencyRepo cryptocurrencyRepo;
    private final RestTemplate restTemplate;

    public CryptocurrencyService(CryptocurrencyRepo cryptocurrencyRepo, RestTemplate restTemplate) {
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.restTemplate = restTemplate;
    }

    public Cryptocurrency findByTitle(String title) {
        Cryptocurrency byTitle = cryptocurrencyRepo.getAllTitle().stream()
                .findFirst()
                .orElse(null);
        return byTitle;
    }

    @Transactional
    public void getCurrentPrice() throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(TICKER_URL_ALL, String.class);
        JsonNode root = new ObjectMapper().readTree(response.getBody());
        List<String> titles;
        titles = root.findParent("data").findValuesAsText("title");
        int order = 0;

        for (String title : titles) {
            List<Cryptocurrency> cryptocurrencies = cryptocurrencyRepo.getAllTitle();
            schedule(root, cryptocurrencies, title, order);
            order++;
        }
    }

    private void schedule(JsonNode root, List<Cryptocurrency> cryptocurrencies, String title, int order){
        double price_usd = Double
                .parseDouble(root.findParent("data")
                .findValuesAsText("price_usd")
                .get(order));

        for (Cryptocurrency cryptocurrency : cryptocurrencies) {
            double percent = percent(cryptocurrency.getPrice(), price_usd);

            cryptocurrencyRepo.savePrice(title, price_usd);
        }
    }

    private double percent(double price1, double price2){
        double percent;
        if (price1 > price2){
            percent = (price1 - price2) / price2 * 100;
        }else {
            percent = (price2 - price1) / price1 * 100;
        }
        return percent;
    }

}
