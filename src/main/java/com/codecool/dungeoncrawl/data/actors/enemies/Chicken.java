package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.spells.ChickenSpell;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;

public class Chicken extends Wizard {
    private static final String ENEMY_NAME = "chicken";
    private static final int ENEMY_HEALTH = 200;
    protected int attack = 3;

    private final CellType floorType = CellType.GRASS;


    public Chicken(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH);
    }

    private void attackView(){

        seeDown();
        seeUp();
        seeRight();
        seeLeft();

    }

    private void seeDown(){
        int view = 1;

        while(getCell().getNeighbor(0,view).getType().equals(floorType)){
            if(checkPlayer(0,view)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(0,1),0,1);
                getCell().addSpell(spell);
            };
            view++;
        }

    }

    private void seeUp(){
        int view = 1;

        while(getCell().getNeighbor(0,- view).getType().equals(floorType)){
            if(checkPlayer(0, -view)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(0, -1),0,-1);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private void seeRight(){
        int view = 1;

        while(getCell().getNeighbor(view,0).getType().equals(floorType)){
            if(checkPlayer(view,0)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(1,0),1,0);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private void seeLeft(){
        int view = 1;

        while(getCell().getNeighbor(- view,0).getType().equals(floorType)){
            if(checkPlayer(- view, 0)){
                ChickenSpell spell = new ChickenSpell(getCell().getNeighbor(-1, 0),-1,0);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    @Override
    public int getAttackStrength() {
        return attack;
    }

    @Override
    public void moveEnemy() {
        moveFieldChecker(0, floorType);
        makeMove(0);
        attackView();
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
