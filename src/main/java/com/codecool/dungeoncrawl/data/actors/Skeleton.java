package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor {

    private int health;
    private int attackStrength;
    public Skeleton(Cell cell) {
        super(cell);
        health = 10;
        attackStrength = 2;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        //...
    }

    @Override
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

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
