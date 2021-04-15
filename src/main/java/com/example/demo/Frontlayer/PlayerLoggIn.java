package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.Player;

import java.util.List;

public class PlayerLoggIn {
    String username;
    int elo;
    List<String> PlayedGames;

    public PlayerLoggIn(Player player){
        username = player.username;
        elo = player.elo;
    }

    public List<String> ReturnPlayedGames(Player player){
        PlayedGames = player.PlayedGames;

        return PlayedGames;
    }
}
