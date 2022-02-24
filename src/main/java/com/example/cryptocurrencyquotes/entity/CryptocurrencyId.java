package com.example.cryptocurrencyquotes.entity;

public enum CryptocurrencyId {

    BTC (90),
    ETH (80),
    SOL (48543);

    private long id;

    CryptocurrencyId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
