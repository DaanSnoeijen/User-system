package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Backlayer.PlayerLog;
import com.example.demo.Datalayer.IPlayer;
import org.springframework.web.bind.annotation.*;

//Controller voor de connectie met de frontend en backend
@CrossOrigin
@RestController
@RequestMapping("api/player")
public class PlayerController {
    PlayerLoggIn player;

    PlayerLog playerLog;

    public PlayerController() { playerLog = new PlayerLog(); }

    public PlayerController(IPlayer mockRepo) { playerLog = new PlayerLog(mockRepo); }

    //Get request voor het inloggen van een speler
    @PostMapping(value="/getPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn ReturnPlayer(@RequestBody LogInData logInData){
        Player p = playerLog.LogIn(logInData.getUsername(), logInData.getPassword());

        player = new PlayerLoggIn(p.getUsername(), p.getElo(), p.getPlayedGames());

        return player;
    }

    //Post request voor het opslaan van een speler
    @PostMapping(value="/postPlayer", consumes = "application/json")
    public void AddPlayer(@RequestBody LogInData logInData){
        playerLog.Register(logInData.getUsername(), logInData.getPassword());
    }
}
