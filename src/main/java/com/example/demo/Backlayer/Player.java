package com.example.demo.Backlayer;

import com.example.demo.Datalayer.PlayerDTO;

import java.util.List;

public class Player {

    public Long ID;
    public String username;
    public String password;
    public int elo;
    public List<String> PlayedGames;

    public Player(String playerUsername, String playerPassword) {
        username = playerUsername;
        password = playerPassword;
    }

    public Player (PlayerDTO playerDTO){
        username = playerDTO.username;
        password = playerDTO.password;
        elo = playerDTO.elo;
        PlayedGames = playerDTO.PlayedGames;
    }
}