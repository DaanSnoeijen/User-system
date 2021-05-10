package com.example.demo.Entity;

import com.example.demo.Datalayer.PlayerDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

//Player entity voor het mappen van de player data naar een database
@Entity @Getter @Setter
public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private int elo;

    @ElementCollection
    private Collection<String> PlayedGames;

    //Constructor voor de player DTO
    public PlayerEntity(PlayerDTO player) {
        username = player.username;
        password = player.password;
        elo = player.elo;
    }

    //Lege constructor
    public PlayerEntity() {}
}
