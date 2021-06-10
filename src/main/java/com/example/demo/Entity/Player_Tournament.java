package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity @Getter @Setter
public class Player_Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private PlayerEntity player;

    @ManyToOne
    private TournamentEntity tournament;

    @Column(nullable = false)
    private int ScoredPoints;

    public Player_Tournament() { };
}
