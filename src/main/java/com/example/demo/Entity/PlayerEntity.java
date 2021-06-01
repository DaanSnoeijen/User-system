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
public class PlayerEntity {
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
    @Column(nullable = false)
    private List<String> playedGames;

    //Constructor voor de player DTO
    public PlayerEntity(PlayerDTO player) {
        this.username = player.getUsername();
        this.password = player.getPassword();
        this.elo = player.getElo();
        //this.playedGames = player.getPlayedGames();
    }

    //Lege constructor
    public PlayerEntity() {}
}
