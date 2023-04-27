package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class Giant extends Enemy {

    private static final String ENEMY_NAME = "giant";
    private static final int ENEMY_HEALTH = 40;

    private int attack = 5;

    private int position = 0;
    private boolean moveUp = true;
    private boolean moveDown;

    private CellType floorType = CellType.FLOOR;


    public Giant(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH);
    }

    @Override
    public int getAttackStrength() {
        return attack;
    }

    @Override
    public void addAttackStrength(int number) {

    }

    @Override
    public void moveEnemy() {

        moveFieldChecker(position, floorType);
        makeMove(position);
    }
    @Override
    protected void moveFieldChecker(int position, CellType floorType) {

        if(!getCell().getNeighbor(0, position + 1).getType().equals(floorType)){
            this.moveUp = false;
            this.moveDown = true;
        }else if (!getCell().getNeighbor(0, position - 1).getType().equals(floorType)){
            this.moveUp = true;
            this.moveDown = false;
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
