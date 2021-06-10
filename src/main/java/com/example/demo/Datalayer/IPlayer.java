package com.example.demo.Datalayer;

public interface IPlayer {
    //Interface methode voor spelers ophalen uit de database
    PlayerDTO GetPlayer(PlayerDTO player);

    //Interface methode voor spelers opslaan in een database
    void AddPlayer(PlayerDTO player);

    //Interface methode voor spelers updaten (admin functie)
    void UpdatePlayer(int ID, PlayerDTO player);

    //Interface methode voor spelers verwijderen (admin functie)
    void DeletePlayer(int ID);
}
