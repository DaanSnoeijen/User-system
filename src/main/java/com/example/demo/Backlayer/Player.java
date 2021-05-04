package com.example.demo.Backlayer;

import com.example.demo.Datalayer.PlayerDTO;

import java.util.List;

public class Player {

    public Long ID = 0L;
    public String username;
    public String password;
    public int elo;
    public List<String> PlayedGames;

    //Constructor voor inloggen
    public Player(String playerUsername, String playerPassword) {
        username = playerUsername;
        password = playerPassword;
    }

    //Constructor voor DTO
    public Player (PlayerDTO playerDTO){
        ID = playerDTO.ID;
        username = playerDTO.username;
        password = playerDTO.password;
        elo = playerDTO.elo;
        PlayedGames = playerDTO.PlayedGames;
    }
}