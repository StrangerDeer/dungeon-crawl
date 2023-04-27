package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Skeleton extends Enemy {

    private static final String ENEMY_NAME = "skeleton";

    private static final int ENEMY_HEALTH = 20;

    private static final int ENEMY_ATTACK = 1;
    private static final CellType ENEMY_FLOOR_TYPE = CellType.FLOOR;

    private int position = 0;

    private boolean moveRight = true;
    private boolean moveLeft;

    private final CellType typeOfFloor = CellType.FLOOR;
    public Skeleton(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK, ENEMY_FLOOR_TYPE);
    }

    @Override
    public void moveEnemy() {
        moveFieldChecker(position, typeOfFloor);
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
}
