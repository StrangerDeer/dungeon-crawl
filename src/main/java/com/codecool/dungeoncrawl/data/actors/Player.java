package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Player extends Actor {


    private int health;
    public Player(Cell cell) {
        super(cell);
        health = 10;
    }

    public String getTileName() {
        return "player";
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        health = number;
    }

    public void addHealthPoints(int number) {
        health = health + number;
    }
}
