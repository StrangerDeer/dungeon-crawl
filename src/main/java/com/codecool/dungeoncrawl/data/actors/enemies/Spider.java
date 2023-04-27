package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Spider extends Enemy {
    private static final String ENEMY_NAME = "spider";
    private static final int ENEMY_HEALTH = 5;
    private static final int ENEMY_ATTACK = 0;
    private static final CellType ENEMY_FLOOR_TYPE = CellType.FLOOR;


    public Spider(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK, ENEMY_FLOOR_TYPE);
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
}
