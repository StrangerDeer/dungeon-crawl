package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Giant extends Enemy {

    private static final String ENEMY_NAME = "giant";
    private static final int ENEMY_HEALTH = 40;

    private static final int ENEMY_ATTACK = 5;

    private static final CellType ENEMY_FLOOR_TYPE = CellType.FLOOR;

    private boolean moveUp = true;
    private boolean moveDown;

    private final CellType floorTypeforMove = CellType.FLOOR;


    public Giant(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK, ENEMY_FLOOR_TYPE);
    }

    @Override
    protected void moveFieldChecker(int position, CellType floorType) {

        if(!getCell().getNeighbor(0, position + 1).getType().equals(floorType)){
            moveUp = false;
            moveDown = true;
        }else if (!getCell().getNeighbor(0, position - 1).getType().equals(floorType)){
            moveUp = true;
            moveDown = false;
        }
    }

    @Override
    protected void makeMove(int position) {
        if(moveUp){
            position++;
            move(0,position);
        }else if (moveDown){
            position--;
            move(0, position);
        }
    }

}
