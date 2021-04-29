package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Backlayer.PlayerLog;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/player")
public class PlayerController {
    PlayerLoggIn player;

    PlayerLog playerLog = new PlayerLog();

    @GetMapping(value="/getPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn ReturnPlayer(@RequestBody LogInData logInData){
        Player p = playerLog.LogIn(logInData.Username, logInData.Password);

        player = new PlayerLoggIn(p.username, p.elo, p.PlayedGames);

        return player;
    }

    @PostMapping(value="/postPlayer", consumes = "application/json")
    public void AddPlayer(@RequestBody LogInData logInData){
        playerLog.Register(logInData.Username, logInData.Password);
    }
}
