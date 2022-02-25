package com.example.cryptocurrencyquotes.rest;

import com.example.cryptocurrencyquotes.dto.CryptocurrencyDto;
import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import com.example.cryptocurrencyquotes.mapped.CryptocurrencyMapper;
import com.example.cryptocurrencyquotes.service.CryptocurrencyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CryptoCurrentController {

    private final CryptocurrencyService cryptocurrencyService;
    private final CryptocurrencyMapper cryptocurrencyMapper;

    public CryptoCurrentController(CryptocurrencyService cryptocurrencyService, CryptocurrencyMapper cryptocurrencyMapper) {
        this.cryptocurrencyService = cryptocurrencyService;
        this.cryptocurrencyMapper = cryptocurrencyMapper;
    }

    @GetMapping("/api/cryptocurrency/{title}")
    public ResponseEntity<CryptocurrencyDto> findCryptocurrencyPriceByTitle(@PathVariable String title) {
        Cryptocurrency cryptocurrency = cryptocurrencyService.findByTitle(title);
        if (cryptocurrency != null) {
            return new ResponseEntity<>(cryptocurrencyMapper.cryptoCurrencyDto(cryptocurrency), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
