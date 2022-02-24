package com.example.cryptocurrencyquotes.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

}
