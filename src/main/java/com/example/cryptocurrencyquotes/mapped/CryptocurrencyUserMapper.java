package com.example.cryptocurrencyquotes.mapped;

import com.example.cryptocurrencyquotes.dto.CryptocurrencyUserDto;
import com.example.cryptocurrencyquotes.entity.Cryptocurrency;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CryptocurrencyUserMapper {
    Cryptocurrency cryptocurrency(CryptocurrencyUserDto cryptoCurrencyUserDto);
}
