package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.PlayerLog;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/player")
@CrossOrigin
public class PlayerController {
    PlayerLoggIn player;

    PlayerLog playerLog = new PlayerLog();

    @GetMapping(value="/getPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn ReturnPlayer(@RequestBody bs bs){
        player = new PlayerLoggIn(
                playerLog.LogIn(bs.Username, bs.Password).username,
                playerLog.LogIn(bs.Username, bs.Password).elo,
                playerLog.LogIn(bs.Username, bs.Password).PlayedGames);

        return player;
    }

    @PostMapping(value="/postPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn AddPlayer(@RequestBody bs bs){
        player = new PlayerLoggIn(
                playerLog.Register(bs.Username, bs.Password).username,
                playerLog.Register(bs.Username, bs.Password).elo,
                playerLog.Register(bs.Username, bs.Password).PlayedGames);

        return player;
    }
}
