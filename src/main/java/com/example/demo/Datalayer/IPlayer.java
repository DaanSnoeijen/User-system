package com.example.demo.Datalayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Datalayer.PlayerDTO;

public interface IPlayer {
    PlayerDTO GetPlayer(Player player);

    void AddPlayer(Player player);
}
