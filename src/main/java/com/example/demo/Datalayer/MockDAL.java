package com.example.demo.Datalayer;

import java.util.ArrayList;
import java.util.List;

public class MockDAL implements IPlayer {
    private PlayerDTO playerDTO;
    private List<PlayerDTO> mockRepo;

    public MockDAL() { mockRepo = new ArrayList<>(); }

    public PlayerDTO GetPlayer(PlayerDTO player){
        playerDTO = mockRepo.get(mockRepo.indexOf(player)+1);
        return playerDTO;
    }

    public void AddPlayer(PlayerDTO player){
        mockRepo.add(player);
    }
}
