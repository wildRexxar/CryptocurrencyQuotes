package com.example.cryptocurrencyquotes.dto;

public class CryptocurrencyUserDto {
    private UserDto userDto;
    private String title;

    public CryptocurrencyUserDto() {
    }

    public CryptocurrencyUserDto(UserDto userDto, String title) {
        this.userDto = userDto;
        this.title = title;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
