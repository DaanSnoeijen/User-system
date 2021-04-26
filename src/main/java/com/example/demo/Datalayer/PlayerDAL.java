package com.example.demo.Datalayer;

import com.example.demo.Backlayer.Player;

import javax.persistence.EntityManager;

public class PlayerDAL implements IPlayer {
    private PlayerDTO playerDTO;

    public PlayerDTO GetPlayer(Player player){
        playerDTO = new PlayerDTO(player.username, player.password);

        return playerDTO;
    }

    public void AddPlayer(Player player){
        playerDTO = new PlayerDTO(player.username, player.password);
        playerDTO.elo = player.elo;

    }
}
