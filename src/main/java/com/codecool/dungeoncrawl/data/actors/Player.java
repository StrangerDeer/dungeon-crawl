package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Player extends Actor {


    private int health;
    private int attackStrength;
    public Player(Cell cell) {
        super(cell);
        health = 10;
        attackStrength = 5;
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
        health += number;
    }

    @Override
    public int getAttackStrength() {
        return attackStrength;
    }

    @Override
    public void addAttackStrength(int number) {
        attackStrength += number;
    }
}
