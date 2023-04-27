package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Spider extends Enemy {

    private int health = 5;
    private int attack = 0;


    public Spider(Cell cell) {
        super(cell);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        this.health = number;
    }

    @Override
    public int getAttackStrength() {
        return attack;
    }


    @Override
    public void moveEnemy() {
    }

    @Override
    protected void moveFieldChecker(int position, CellType floorType){

    }

    @Override
    protected void makeMove(int position) {

    }

    @Override
    public String getTileName() {

        if(health <= 0){
            return "floor";
        }

        return "spider";
    }
}
