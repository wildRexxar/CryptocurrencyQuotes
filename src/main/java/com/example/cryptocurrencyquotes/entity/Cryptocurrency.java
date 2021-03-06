package com.example.cryptocurrencyquotes.entity;

import javax.persistence.*;

@Entity
public class Cryptocurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private double price;

    @ManyToOne
    private User user;

    public Cryptocurrency() {
    }

    public Cryptocurrency(User user, String title, double price) {
        this.user = user;
        this.title = title;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
