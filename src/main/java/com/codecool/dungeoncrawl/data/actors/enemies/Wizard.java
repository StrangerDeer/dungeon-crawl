package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Wizard extends Enemy {
    private boolean moveUp = true;
    private boolean moveLeft;
    private boolean moveDown;
    private boolean moveRight;
    public Wizard(Cell cell) {
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
        if(!getCell().getNeighbor(0, position - 1).getType().equals(CellType.FLOOR) &&
                getCell().getNeighbor(position - 1, 0).getType().equals(CellType.FLOOR)){
            moveUp = false;
            moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(CellType.FLOOR) &&
                getCell().getNeighbor(0, position + 1).getType().equals(CellType.FLOOR)){
            moveLeft = false;
            moveDown = true;
        }else if (!getCell().getNeighbor(0, position + 1).getType().equals(CellType.FLOOR) &&
                getCell().getNeighbor(position + 1, 0).getType().equals(CellType.FLOOR)){
            moveDown = false;
            moveRight = true;
        }else if(!getCell().getNeighbor(position + 1, 0).getType().equals(CellType.FLOOR) &&
                getCell().getNeighbor(0, position - 1).getType().equals(CellType.FLOOR)){
            moveRight = false;
            moveUp = true;
        }

        if(moveRight){
            position++;
            move(position,0);
        }else if (moveLeft){
            position--;
            move(position, 0);
        }else if(moveUp){
            position--;
            move(0, position);
        } else if (moveDown) {
            position++;
            move(0, position);
        }

    }

    @Override
    public String getTileName() {
        return "wizard";
    }
}
