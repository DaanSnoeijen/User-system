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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int elo;

    @ElementCollection
    private List<String> playedGames;

    //Constructor voor de player DTO
    public PlayerEntity(PlayerDTO player) {
        this.username = player.username;
        this.password = player.password;
        this.elo = player.elo;
        this.playedGames = player.PlayedGames;
    }

    //Lege constructor
    public PlayerEntity() {}
}
