package com.example.demo.Entity;

import com.example.demo.Datalayer.PlayerDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//Player entity voor het mappen van de player data naar een database
@Entity @Getter @Setter
public class PlayerEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long playerId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int elo;

    @ElementCollection
    private List<String> PlayedGames;

    //Constructor voor de player DTO
    public PlayerEntity(PlayerDTO player) {
        username = player.username;
        password = player.password;
        elo = player.elo;
    }

    //Lege constructor
    public PlayerEntity() {}
}
