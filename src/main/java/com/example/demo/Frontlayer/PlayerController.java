package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Backlayer.PlayerLog;
import org.springframework.web.bind.annotation.*;

//Controller voor de connectie met de frontend en backend
@CrossOrigin
@RestController
@RequestMapping("api/player")
public class PlayerController {
    PlayerLoggIn player;

    PlayerLog playerLog = new PlayerLog();

    //Get request voor het inloggen van een speler
    @PostMapping(value="/getPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn ReturnPlayer(@RequestBody LogInData logInData){
        Player p = playerLog.LogIn(logInData.Username, logInData.Password);

        player = new PlayerLoggIn(p.username, p.elo, p.PlayedGames);

        return player;
    }

    //Post request voor het opslaan van een speler
    @PostMapping(value="/postPlayer", consumes = "application/json")
    public void AddPlayer(@RequestBody LogInData logInData){
        playerLog.Register(logInData.Username, logInData.Password);
    }
}
