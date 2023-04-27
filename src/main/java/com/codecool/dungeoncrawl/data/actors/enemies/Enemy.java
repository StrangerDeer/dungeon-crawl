package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;


public abstract class Enemy extends Actor {

    protected String name;

    protected int health;

    protected int attack = 0;
    public Enemy(Cell cell, String name, int health) {

        super(cell);
        this.name = name;
        this.health = health;
    }
    public abstract void moveEnemy();
    protected abstract void moveFieldChecker(int position, CellType floorType);
    protected abstract void makeMove(int position);

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        this.health = number;
    }

    @Override
    public void addHealthPoints(int number) {

    }

    @Override
    public int getAttackStrength() {
        return attack;
    }

    @Override
    public void addAttackStrength(int number) {

    }

    @Override
    public String getTileName() {

        if(health <= 0){
            return "floor";
        }

        return name;
    }

    protected String typeOfActor() {
        return "enemy";
    }
}
