package com.example.demo.Backlayer;

import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;
import com.example.demo.Datalayer.PlayerDTO;

import java.util.ArrayList;

public class PlayerLog implements IPlayerLog {
    private Player player;
    IPlayer iPlayer;

    //Constructor voor het aanmaken van de benodigde classes
    public PlayerLog(){
        iPlayer = new PlayerDAL();
    }

    public PlayerLog(IPlayer iplayer) { iPlayer = iplayer; }

    //Nieuwe spelers aanmaken van een preset ELO
    public Player Register(String username, String password){
        ArrayList<String> list = new ArrayList<>();
        list.add("Test");

        player = new Player(username, password);
        player.setElo(800);
        player.setPlayedGames(list);

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

    //Speler updaten
    public void Update(int id, String username, String password, int elo){
        Player player = new Player(username, password);
        player.setElo(elo);

        PlayerDTO playerDTO = new PlayerDTO(player);

        iPlayer.UpdatePlayer(id, playerDTO);
    }

    //Speler verwijderen
    public void Delete(int id){ iPlayer.DeletePlayer(id); }
}
