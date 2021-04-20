package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.Player;

import java.util.List;

public class PlayerLoggIn {
    String username;
    int elo;
    List<String> PlayedGames;

    public PlayerLoggIn(String Username, int Elo, List<String> playedGames){
        username = Username;
        elo = Elo;
        PlayedGames = playedGames;
    }
}
