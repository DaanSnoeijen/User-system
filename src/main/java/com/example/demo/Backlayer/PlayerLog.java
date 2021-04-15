package com.example.demo.Backlayer;

import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;

public class PlayerLog {
    private Player player;

    private IPlayer iPlayer = new PlayerDAL();

    public Player Register(String username, String password){
        player = new Player(username, password);
        player.elo = 800;

        iPlayer.AddPlayer(player);

        return player;
    }

    public Player LogIn(String username, String password){
        player = new Player(username, password);

        iPlayer.GetPlayer(player);

        return player;
    }
}
