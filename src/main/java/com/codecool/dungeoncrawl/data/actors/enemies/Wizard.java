package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;

public class Wizard extends Enemy {
    private static final String ENEMY_NAME = "wizard";

    private static final int ENEMY_HEALTH = 25;


    private static final int ENEMY_ATTACK = 0;
    private static final CellType ENEMY_FLOOR_TYPE = CellType.FLOOR;
    private int position = 0;
    protected boolean moveUp = true;
    protected boolean moveLeft;
    protected boolean moveDown;
    protected boolean moveRight;

    protected final CellType typeOfFloor = CellType.FLOOR;;

    public Wizard(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK, ENEMY_FLOOR_TYPE);
    }
    protected Wizard(Cell cell, String name, int health, int attack, CellType floorType){
        super(cell, name, health, attack, floorType);
        this.floorType = floorType;
    }
    @Override
    protected void castSpell(int x, int y){
        Spell spell = new Spell(cell.getNeighbor(x,y),x,y);
        cell.addSpell(spell);
    }

    @Override
    protected void moveFieldChecker(int position, CellType floorType) {
        if(!cell.getNeighbor(0, position - 1).getType().equals(floorType) &&
                cell.getNeighbor(position - 1, 0).getType().equals(floorType)){
            moveUp = false;
            moveLeft = true;
        }else if (!cell.getNeighbor(position - 1, 0).getType().equals(floorType) &&
                cell.getNeighbor(0, position + 1).getType().equals(floorType)){
            moveLeft = false;
            moveDown = true;
        }else if (!cell.getNeighbor(0, position + 1).getType().equals(floorType) &&
                cell.getNeighbor(position + 1, 0).getType().equals(floorType)){
            moveDown = false;
            moveRight = true;
        }else if(!cell.getNeighbor(position + 1, 0).getType().equals(floorType) &&
                cell.getNeighbor(0, position - 1).getType().equals(floorType)){
            moveRight = false;
            moveUp = true;
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
        }else if(moveUp){
            position--;
            move(0, position);
        } else if (moveDown) {
            position++;
            move(0, position);
        }
    }

}
