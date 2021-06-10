package com.example.demo.Frontlayer;

import com.example.demo.Backlayer.Player;
import com.example.demo.Backlayer.PlayerLog;
import com.example.demo.Datalayer.IPlayer;
import org.springframework.web.bind.annotation.*;

//Controller voor de connectie met de frontend en backend
@CrossOrigin
@RestController
@RequestMapping("api")
public class PlayerController {
    PlayerLoggIn player;

    PlayerLog playerLog;

    public PlayerController() { playerLog = new PlayerLog(); }

    public PlayerController(IPlayer mockRepo) { playerLog = new PlayerLog(mockRepo); }

    //Post request voor het inloggen van een speler
    @GetMapping(value="/player", consumes = "application/json", produces = "application/json")
    public PlayerLoggIn ReturnPlayer(@RequestBody LogInData logInData){
        Player p = playerLog.LogIn(logInData.getUsername(), logInData.getPassword());

        player = new PlayerLoggIn(p.getUsername(), p.getElo(), p.getPlayedGames());

        return player;
    }

    //Post request voor het opslaan van een speler
    @PostMapping(value="/player", consumes = "application/json")
    public void AddPlayer(@RequestBody LogInData logInData){
        playerLog.Register(logInData.getUsername(), logInData.getPassword());
    }

    //Post request voor het updaten van een speler
    @PutMapping(value="/player", consumes = "application/json")
    public void UpdatePlayer(@RequestBody UpdateData updateData){
        playerLog.Update(updateData.getId(), updateData.getUsername(), updateData.getPassword(), updateData.getElo());
    }

    //Post request voor het deleten van een speler
    @DeleteMapping (value="/player", consumes = "application/json")
    public void DeletePlayer(@RequestBody DeleteData deleteData){
        playerLog.Delete(deleteData.getId());
    }
}
