package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Skeleton extends Enemy {

    protected int health = 20;

    protected int attack = 1;

    private int position = 0;

    private boolean moveRight = true;
    private boolean moveLeft;

    private final CellType floorType = CellType.FLOOR;
    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        health = number;
    }

    @Override
    public int getAttackStrength() {
        return attack;
    }

    @Override
    public void moveEnemy() {
        moveFieldChecker(position, floorType);
        makeMove(position);
    }

    @Override
    protected void moveFieldChecker(int position, CellType floorType){
        if(!getCell().getNeighbor(position + 1, 0).getType().equals(floorType)){
            this.moveRight = false;
            this.moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(floorType)){
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

        if(health <= 0){
            return "floor";
        }

        return "skeleton";
    }
}
