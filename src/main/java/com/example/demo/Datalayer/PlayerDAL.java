package com.example.demo.Datalayer;

import com.example.demo.Entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public class PlayerDAL implements IPlayer {

    private PlayerDTO playerDTO;
    PlayerRepo repo;

    public PlayerDTO GetPlayer(PlayerDTO player){
        PlayerEntity playerEntity = repo.FindByUserNameAndPassword(player.username, player.password);

        playerDTO = new PlayerDTO(playerEntity);

        return playerDTO;
    }

    public void AddPlayer(PlayerDTO player){
        PlayerEntity playerEntity = new PlayerEntity(player);

        repo.save(playerEntity);
    }
}
