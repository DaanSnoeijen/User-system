package com.example.demo.Backlayer;

import com.example.demo.Datalayer.PlayerDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Player {

    private String username;
    private String password;
    private int elo;
    private List<String> PlayedGames;

    //Constructor voor inloggen
    public Player(String playerUsername, String playerPassword) {
        username = playerUsername;
        password = playerPassword;
    }

    //Constructor voor DTO
    public Player (PlayerDTO playerDTO){
        username = playerDTO.getUsername();
        password = playerDTO.getPassword();
        elo = playerDTO.getElo();
        //PlayedGames = playerDTO.getPlayedGames();
    }
}