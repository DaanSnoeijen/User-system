package com.example.demo;

import com.example.demo.Backlayer.IPlayerLog;
import com.example.demo.Backlayer.Player;
import com.example.demo.Backlayer.PlayerLog;
import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.MockDAL;
import org.junit.jupiter.api.Test;

class PlayerLogTests {

    @Test
    void playerRegisterCorrect() {
        //Arrange
        IPlayer mockRepo = new MockDAL();
        IPlayerLog playerLog = new PlayerLog(mockRepo);
        Player playerCheck = new Player("Bob", "BobsPassword");
        playerCheck.setElo(800);

        //Act
        Player player = playerLog.Register("Bob", "BobsPassword");

        //Assert
        if (player.getUsername() == playerCheck.getUsername()
            && player.getPassword() == playerCheck.getPassword()
            && player.getElo() == playerCheck.getElo())
            assert true;
        else assert false;
    }

    @Test
    void playerRegisterFalse() {
        //Arrange
        IPlayer mockRepo = new MockDAL();
        IPlayerLog playerLog = new PlayerLog(mockRepo);
        Player playerCheck = new Player("Jack", "JacksPassword");
        playerCheck.setElo(900);

        //Act
        Player player = playerLog.Register("Bob", "BobsPassword");

        //Assert
        if (player.getUsername() != playerCheck.getUsername()
                && player.getPassword() != playerCheck.getPassword()
                && player.getElo() != playerCheck.getElo())
            assert true;
        else assert false;
    }

    @Test
    void PlayerLogCorrect() {
        //Arrange
        IPlayer mockRepo = new MockDAL();
        IPlayerLog playerLog = new PlayerLog(mockRepo);
        Player player = new Player("Bob", "BobsPassword");

        //Act
        playerLog.Register("Bob", "BobsPassword");
        Player playerCheck = new Player(
                playerLog.LogIn(player.getUsername(), player.getPassword()).getUsername(),
                playerLog.LogIn(player.getUsername(), player.getPassword()).getPassword());

        //Assert
        if (player.getUsername() == playerCheck.getUsername()
                && player.getPassword() == playerCheck.getPassword())
            assert true;
        else assert false;
    }

    @Test
    void PlayerLogFalse() {
        //Arrange
        IPlayer mockRepo = new MockDAL();
        IPlayerLog playerLog = new PlayerLog(mockRepo);
        Player player = new Player("Bob", "BobsPassword");

        //Act
        playerLog.Register("Jack", "JacksPassword");
        Player playerCheck = new Player(
                playerLog.LogIn(player.getUsername(), player.getPassword()).getUsername(),
                playerLog.LogIn(player.getUsername(), player.getPassword()).getPassword());

        //Assert
        if (player.getUsername() != playerCheck.getUsername()
                && player.getPassword() != playerCheck.getPassword())
            assert true;
        else assert false;
    }
}
