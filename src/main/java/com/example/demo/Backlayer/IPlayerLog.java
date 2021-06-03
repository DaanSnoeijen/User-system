package com.example.demo.Backlayer;

public interface IPlayerLog{

    Player Register(String username, String password);

    Player LogIn(String username, String password);
}
