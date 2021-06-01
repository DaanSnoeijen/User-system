package com.example.demo.Frontlayer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Player viewmodel voor data van backend naar frontend
@Getter @Setter
public class PlayerLoggIn {
    private String username;
    private int elo;
    private List<String> PlayedGames;

    public PlayerLoggIn(String Username, int Elo, List<String> playedGames){
        username = Username;
        elo = Elo;
        //PlayedGames = playedGames;
    }
}
