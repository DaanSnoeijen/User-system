package com.example.demo.Backlayer;

import org.apache.catalina.User;

import java.util.List;

public class PlayerDTO {
    public String username;
    private String password;
    public int elo;
    public List<String> PlayedGames;

    public PlayerDTO(String Username, String Password){
        username = Username;
        password = Password;
    }
}
