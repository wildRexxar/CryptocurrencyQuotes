package com.example.cryptocurrencyquotes.mapped;

import com.example.cryptocurrencyquotes.dto.UserDto;
import com.example.cryptocurrencyquotes.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User user(UserDto userDto);
}
