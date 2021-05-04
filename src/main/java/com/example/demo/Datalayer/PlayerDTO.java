package com.example.demo.Datalayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Entity.PlayerEntity;

import java.util.List;

//Data transfer object
public class PlayerDTO {
    public long ID;
    public String username;
    public String password;
    public int elo;
    public List<String> PlayedGames;

    //Constructor voor player
    public PlayerDTO(Player player){
        ID = player.ID;
        username = player.username;
        password = player.password;
        elo = player.elo;
        PlayedGames = player.PlayedGames;
    }

    //Constructor voor player entity
    public PlayerDTO(PlayerEntity player){
        ID = player.getPlayerId();
        username = player.getUsername();
        elo = player.getElo();
        PlayedGames = player.getPlayedGames();
    }
}
