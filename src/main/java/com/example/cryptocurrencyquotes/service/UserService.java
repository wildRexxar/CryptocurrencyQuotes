package com.example.cryptocurrencyquotes.service;

import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import com.example.cryptocurrencyquotes.entity.CryptocurrencyId;
import com.example.cryptocurrencyquotes.repo.CryptocurrencyRepo;
import com.example.cryptocurrencyquotes.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final CryptocurrencyRepo cryptocurrencyRepo;
    private final RestTemplate restTemplate;

    public UserService(UserRepo userRepo, CryptocurrencyRepo cryptocurrencyRepo, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.cryptocurrencyRepo = cryptocurrencyRepo;
        this.restTemplate = restTemplate;
    }

    public boolean findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public void registration(Cryptocurrency cryptocurrency) throws JsonProcessingException {
        long id = 0;
        for(CryptocurrencyId cryptocurrencyId : CryptocurrencyId.values()) {
            if(cryptocurrencyId.name().equals(cryptocurrency.getTitle())){
                id = cryptocurrencyId.getId();
            }
        }
        ResponseEntity<String> response;
        response = restTemplate
                .getForEntity("https://api.coinlore.net/api/ticker/?id=" + id, String.class);
        JsonNode jsonNode = new ObjectMapper().readTree(response.getBody());
        String price = jsonNode.findPath("price").asText();

        cryptocurrency.setPrice(Double.parseDouble(price));
        userRepo.save(cryptocurrency.getUser());
        cryptocurrencyRepo.save(cryptocurrency);
    }
}
