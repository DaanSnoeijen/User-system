package com.example.demo.Backlayer;

import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;

import java.util.ArrayList;

public class PlayerLog {
    private Player player;

    private IPlayer iPlayer = new PlayerDAL();

    public Player Register(String username, String password){
        player = new Player(username, password);
        player.elo = 800;
        player.PlayedGames = new ArrayList<String>();

        iPlayer.AddPlayer(player);

        return player;
    }

    public Player LogIn(String username, String password){
        Player getPlayer = new Player(username, password);

        player = new Player(iPlayer.GetPlayer(getPlayer).username, iPlayer.GetPlayer(getPlayer).password);

        return player;
    }
}
