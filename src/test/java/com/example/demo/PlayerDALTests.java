package com.example.demo;

import com.example.demo.Backlayer.Player;
import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerDALTests {

    @Test
    void getPlayerTest() {
        //Arrange
        IPlayer iPlayer = new PlayerDAL();
        Player player = new Player("Bob", "BobsPassword");

        //Act && Assert
        try {
            iPlayer.GetPlayer(player);
            assert true;
        }
        catch (Exception exception){
            assert false;
        }
    }

    @Test
    void addPlayerTest() {
        //Arrange
        IPlayer iPlayer = new PlayerDAL();
        Player player = new Player("Bob", "BobsPassword");

        //Act && Assert
        try {
            iPlayer.AddPlayer(player);
            assert true;
        }
        catch (Exception exception){
            assert false;
        }
    }
}
