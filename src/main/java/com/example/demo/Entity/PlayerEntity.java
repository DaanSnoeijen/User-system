package com.example.demo.Entity;

import com.example.demo.Datalayer.PlayerDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    public PlayerEntity(PlayerDTO player) {
        username = player.username;
        password = player.password;
        elo = player.elo;
    }

    public PlayerEntity() {}
}
