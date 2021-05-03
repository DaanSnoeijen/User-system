package com.example.demo;

import com.example.demo.Backlayer.Player;
import com.example.demo.Datalayer.IPlayer;
import com.example.demo.Datalayer.PlayerDAL;
import com.example.demo.Datalayer.PlayerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerDALTests {

    @Test
    void getPlayerTest() {
        //Arrange
        IPlayer iPlayer = new PlayerDAL();
        Player player = new Player("Bob", "BobsPassword");
        PlayerDTO playerDTO = new PlayerDTO(player);

        //Act && Assert
        try {
            iPlayer.GetPlayer(playerDTO);
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
        PlayerDTO playerDTO = new PlayerDTO(player);

        //Act && Assert
        try {
            iPlayer.AddPlayer(playerDTO);
            assert true;
        }
        catch (Exception exception){
            assert false;
        }
    }
}
