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
    public PlayerLoggIn ReturnPlayer(@RequestBody String Username, @RequestBody String Password){
        player = new PlayerLoggIn(
                playerLog.LogIn(Username, Password).username,
                playerLog.LogIn(Username, Password).elo,
                playerLog.LogIn(Username, Password).PlayedGames);

        return player;
    }

    @PostMapping(value="/postPlayer", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn AddPlayer(@RequestBody String Username, @RequestBody String Password){
        player = new PlayerLoggIn(
                playerLog.Register(Username, Password).username,
                playerLog.Register(Username, Password).elo,
                playerLog.Register(Username, Password).PlayedGames);

        return player;
    }
}
