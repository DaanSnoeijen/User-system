package com.example.demo.Entity;

import com.example.demo.Datalayer.PlayerDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

//Player entity voor het mappen van de player data naar een database
@Entity @Getter @Setter
public class PlayerEntity {

    @Id
    @GeneratedValue
    public Long ID;
    @Column
    public String username;
    @Column
    public String password;
    @Column
    public int elo;
    @ElementCollection
    public List<String> PlayedGames;

    //Constructor voor de player DTO
    public PlayerEntity(PlayerDTO player) {
        username = player.username;
        password = player.password;
        elo = player.elo;
    }

    //Lege constructor
    public PlayerEntity() {}
}
