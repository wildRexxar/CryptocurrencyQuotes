package com.example.cryptocurrencyquotes.rest;

import com.example.cryptocurrencyquotes.dto.CryptocurrencyUserDto;
import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import com.example.cryptocurrencyquotes.mapped.CryptocurrencyUserMapper;
import com.example.cryptocurrencyquotes.mapped.UserMapper;
import com.example.cryptocurrencyquotes.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final CryptocurrencyUserMapper cryptoCurrencyUserMapper;

    public UserRestController(UserService userService, UserMapper userMapper, CryptocurrencyUserMapper cryptoCurrencyUserMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.cryptoCurrencyUserMapper = cryptoCurrencyUserMapper;
    }

    @PostMapping("/api/user/registration")
    public ResponseEntity<CryptocurrencyUserDto> notify(@RequestBody CryptocurrencyUserDto cryptocurrencyUserDto) throws JsonProcessingException {
        if (userService.findByUsername(cryptocurrencyUserDto.getUserDto().getUsername())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cryptocurrency cryptocurrency = cryptoCurrencyUserMapper.cryptocurrency(cryptocurrencyUserDto);
        cryptocurrency.setUser(userMapper.user(cryptocurrencyUserDto.getUserDto()));
        userService.registration(cryptocurrency);
        return new ResponseEntity<>(cryptocurrencyUserDto, HttpStatus.CREATED);
    }
}