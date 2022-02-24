package com.example.cryptocurrencyquotes.dto;

public class CryptocurrencyDto {
    private long id;
    private String title;
    private double price;

    public CryptocurrencyDto() {
    }

    public CryptocurrencyDto(long id, String title, double price) {
        this.id = id;
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
}
