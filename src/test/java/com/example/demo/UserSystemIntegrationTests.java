package com.example.demo;

import com.example.demo.Frontlayer.LogInData;
import com.example.demo.Frontlayer.PlayerController;
import com.example.demo.Frontlayer.PlayerLoggIn;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSystemIntegrationTests {

    @Test
    void Register() {
        //Arrange
        PlayerController pc = new PlayerController();
        LogInData data = new LogInData();

        data.setPassword("Bob");
        data.setPassword("BobsPassword");

        //Act
        try {
            pc.AddPlayer(data);

            //Assert
            assert true;
        }
        catch (Exception e){
            //Assert
            assert false;
        }
    }

    @Test
    void LogInCorrect() {
        //Arrange
        PlayerController pc = new PlayerController();
        LogInData data = new LogInData();

        PlayerLoggIn player;

        data.setPassword("Bob");
        data.setPassword("BobsPassword");

        //Act
        pc.AddPlayer(data);

        player = pc.ReturnPlayer(data);

        //Assert
        if (player.getUsername().equals("Bob")) assert true;
        else assert false;
    }

    @Test
    void LogInFalse() {
        //Arrange
        PlayerController pc = new PlayerController();
        LogInData data = new LogInData();
        LogInData dataFalse = new LogInData();

        PlayerLoggIn player;

        data.setPassword("Bob");
        data.setPassword("BobsPassword");

        dataFalse.setUsername("Carl");
        dataFalse.setPassword("Admin");

        //Act
        pc.AddPlayer(data);

        player = pc.ReturnPlayer(dataFalse);

        //Assert
        if (player.getUsername().equals("Bob")) assert true;
        else assert false;
    }
}
