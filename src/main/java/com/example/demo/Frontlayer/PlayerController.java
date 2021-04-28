package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.PlayerLog;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/player")
public class PlayerController {
    PlayerLoggIn player;

    PlayerLog playerLog = new PlayerLog();

    @GetMapping(value="/getPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn ReturnPlayer(@RequestBody LogInData LogInData){
        player = new PlayerLoggIn(
                playerLog.LogIn(LogInData.Username, LogInData.Password).username,
                playerLog.LogIn(LogInData.Username, LogInData.Password).elo,
                playerLog.LogIn(LogInData.Username, LogInData.Password).PlayedGames);

        return player;
    }

    @PostMapping(value="/postPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn AddPlayer(@RequestBody LogInData LogInData){
        player = new PlayerLoggIn(
                playerLog.Register(LogInData.Username, LogInData.Password).username,
                playerLog.Register(LogInData.Username, LogInData.Password).elo,
                playerLog.Register(LogInData.Username, LogInData.Password).PlayedGames);

        return player;
    }
}
