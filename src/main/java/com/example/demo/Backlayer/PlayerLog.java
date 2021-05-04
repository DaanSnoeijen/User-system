package com.example.demo.Backlayer;

import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;
import com.example.demo.Datalayer.PlayerDTO;
import com.example.demo.Datalayer.PlayerRepo;

import java.util.ArrayList;

public class PlayerLog {
    private Player player;
    IPlayer iPlayer;

    //Constructor voor het aanmaken van de benodigde classes
    public PlayerLog(){
        iPlayer = new PlayerDAL();
    }

    //Nieuwe spelers aanmaken van een preset ELO
    public Player Register(String username, String password){
        player = new Player(username, password);
        player.elo = 800;
        player.PlayedGames = new ArrayList<String>();

        PlayerDTO playerDTO = new PlayerDTO(player);

        iPlayer.AddPlayer(playerDTO);

        return player;
    }

    //Een speler inloggen
    public Player LogIn(String username, String password){
        Player getPlayer = new Player(username, password);
        PlayerDTO playerDTO = new PlayerDTO(getPlayer);

        player = new Player(iPlayer.GetPlayer(playerDTO));

        return player;
    }
}
