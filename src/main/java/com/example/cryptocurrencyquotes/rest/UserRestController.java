package com.example.cryptocurrencyquotes.rest;

import com.example.cryptocurrencyquotes.dto.CryptocurrencyUserDto;
import com.example.cryptocurrencyquotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;


    @PostMapping("/registration")
    public ResponseEntity<CryptocurrencyUserDto> notify(String username) {
        if(userService.findByUsername(username){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            userService.registration(username);
    }
}
