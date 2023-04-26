package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Skeleton extends Enemy {

    private int health = 20;
    private int attack = 1;

    private boolean moveRight = true;
    private boolean moveLeft;

    public Skeleton(Cell cell) {
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
    public void moveEnemy(int position) {
        moveFieldChecker(position);
        makeMove(position);
    }

    @Override
    protected void moveFieldChecker(int position){
        if(!getCell().getNeighbor(position + 1, 0).getType().equals(CellType.FLOOR)){
            this.moveRight = false;
            this.moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(CellType.FLOOR)){
            this.moveRight = true;
            this.moveLeft = false;
        }
    }

    @Override
    protected void makeMove(int position) {
        if(moveRight){
            position++;
            move(position,0);
        }else if (moveLeft){
            position--;
            move(position, 0);
        }
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
