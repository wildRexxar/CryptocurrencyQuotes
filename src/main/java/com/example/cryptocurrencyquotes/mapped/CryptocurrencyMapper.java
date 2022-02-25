package com.example.cryptocurrencyquotes.mapped;

import com.example.cryptocurrencyquotes.dto.CryptocurrencyDto;
import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CryptocurrencyMapper {

    CryptocurrencyDto cryptoCurrencyDto(Cryptocurrency cryptocurrency);
}
