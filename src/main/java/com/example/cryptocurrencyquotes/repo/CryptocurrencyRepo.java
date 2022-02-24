package com.example.cryptocurrencyquotes.repo;

import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CryptocurrencyRepo extends JpaRepository<Cryptocurrency, Long> {
    Optional<Cryptocurrency> findByTitle(String title);

    List<Cryptocurrency> getAllTitle();

    boolean savePrice(String title, double price);

}
