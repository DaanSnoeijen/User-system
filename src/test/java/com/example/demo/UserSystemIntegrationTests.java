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

        data.Username = "Bob";
        data.Password = "BobsPassword";

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

        data.Username = "Bob";
        data.Password = "BobsPassword";

        //Act
        pc.AddPlayer(data);

        player = pc.ReturnPlayer(data);

        //Assert
        if (player.username.equals("Bob")) assert true;
        else assert false;
    }

    @Test
    void LogInFalse() {
        //Arrange
        PlayerController pc = new PlayerController();
        LogInData data = new LogInData();
        LogInData dataFalse = new LogInData();

        PlayerLoggIn player;

        data.Username = "Bob";
        data.Password = "BobsPassword";

        dataFalse.Username = "Carl";
        dataFalse.Password = "Admin";

        //Act
        pc.AddPlayer(data);

        player = pc.ReturnPlayer(dataFalse);

        //Assert
        if (player.username.equals("Bob")) assert true;
        else assert false;
    }
}
