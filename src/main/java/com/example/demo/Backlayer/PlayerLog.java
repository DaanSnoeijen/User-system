package com.example.demo.Backlayer;

import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;
import com.example.demo.Datalayer.PlayerDTO;
import com.example.demo.Datalayer.PlayerRepo;

import java.util.ArrayList;

public class PlayerLog {
    private Player player;
    IPlayer iPlayer;

    public PlayerLog(){
        iPlayer = new PlayerDAL();
    }

    public Player Register(String username, String password){
        player = new Player(username, password);
        player.elo = 800;
        player.PlayedGames = new ArrayList<String>();

        PlayerDTO playerDTO = new PlayerDTO(player);

        iPlayer.AddPlayer(playerDTO);

        return player;
    }

    public Player LogIn(String username, String password){
        Player getPlayer = new Player(username, password);
        PlayerDTO playerDTO = new PlayerDTO(getPlayer);

        player = new Player(iPlayer.GetPlayer(playerDTO));

        return player;
    }
}
