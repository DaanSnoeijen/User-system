package com.example.demo.Datalayer;

import com.example.demo.Backlayer.Player;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
