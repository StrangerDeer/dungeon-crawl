package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class Skeleton extends Enemy {

    private boolean moveRight = true;
    private boolean moveLeft;

    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public void setHealth(int number) {

    }

    @Override
    public void addHealthPoints(int number) {

    }

    @Override
    public int getAttackStrength() {
        return 0;
    }

    @Override
    public void addAttackStrength(int number) {

    }


    @Override
    public void moveEnemy(GameMap map, int position) {
        if(!getCell().getNeighbor(position + 1, 0).getType().equals(CellType.FLOOR)){
            this.moveRight = false;
            this.moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(CellType.FLOOR)){
            this.moveRight = true;
            this.moveLeft = false;
        }

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
