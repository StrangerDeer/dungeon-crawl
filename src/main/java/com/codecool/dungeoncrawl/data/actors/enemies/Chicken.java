package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.spells.ChickenSpell;

public class Chicken extends Wizard {
    private static final String ENEMY_NAME = "chicken";
    private static final int ENEMY_HEALTH = 200;
    private static final int ENEMY_ATTACK = 3;

    private static final CellType ENEMY_FLOOR_TYPE = CellType.GRASS;


    public Chicken(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK, ENEMY_FLOOR_TYPE);
    }

    @Override
    protected void castSpell(int x, int y){
        ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(x,y),x,y);
        getCell().addSpell(spell);
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
