package com.example.demo.Datalayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Entity.PlayerEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Data transfer object
@Getter @Setter
public class PlayerDTO {
    private String username;
    private String password;
    private int elo;
    private List<String> PlayedGames;

    //Constructor voor player
    public PlayerDTO(Player player){
        username = player.getUsername();
        password = player.getPassword();
        elo = player.getElo();
        PlayedGames = player.getPlayedGames();
    }

    public PlayerDTO(PlayerEntity player){
        username = player.getUsername();
        password = player.getPassword();
        elo = player.getElo();
        PlayedGames = player.getPlayedGames();
    }
}
