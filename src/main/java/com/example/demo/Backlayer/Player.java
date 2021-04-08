package com.example.demo.Backlayer;

import java.util.List;

public class Player {

    public String username;
    public String password;
    public int elo;
    public List<String> PlayedGames;

    public Player(String playerUsername, String playerPassword) {
        username = playerUsername;
        password = playerPassword;
    }
}