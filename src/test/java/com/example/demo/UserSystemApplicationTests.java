package com.example.demo;

import com.example.demo.Backlayer.Player;
import com.example.demo.Backlayer.PlayerLog;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserSystemApplicationTests {

    @Test
    void playerRegisterCorrect() {
        //Arrange
        PlayerLog playerLog = new PlayerLog();
        Player playerCheck = new Player("Bob", "BobsPassword");
        playerCheck.elo = 800;

        //Act
        Player player = playerLog.Register("Bob", "BobsPassword");

        //Assert
        if (player.username == playerCheck.username
            && player.password == playerCheck.password
            && player.elo == playerCheck.elo)
            assert true;
        else assert false;
    }

    @Test
    void playerRegisterFalse() {
        //Arrange
        PlayerLog playerLog = new PlayerLog();
        Player playerCheck = new Player("Jack", "JacksPassword");
        playerCheck.elo = 900;

        //Act
        Player player = playerLog.Register("Bob", "BobsPassword");

        //Assert
        if (player.username != playerCheck.username
                && player.password != playerCheck.password
                && player.elo != playerCheck.elo)
            assert true;
        else assert false;
    }

    @Test
    void PlayerLogCorrect() {
        //Arrange
        PlayerLog playerLog = new PlayerLog();
        
        //Act
        
        //Assert
    }

    @Test
    void PlayerLogFalse() {
        //Arrange
        PlayerLog playerLog = new PlayerLog();

        //Act

        //Assert
    }
}
