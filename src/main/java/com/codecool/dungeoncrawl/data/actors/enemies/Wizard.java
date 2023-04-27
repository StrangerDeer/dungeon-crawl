package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;

public class Wizard extends Enemy {
    private static final String ENEMY_NAME = "wizard";

    private static final int ENEMY_HEALTH = 25;


    private static final int ENEMY_ATTACK = 0;
    private int position = 0;
    protected boolean moveUp = true;
    protected boolean moveLeft;
    protected boolean moveDown;
    protected boolean moveRight;

    private final CellType floorType = CellType.FLOOR;
    public Wizard(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK);
    }

    protected Wizard(Cell cell, String name, int health, int attack){
        super(cell, name, health, attack);
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
                Spell spell = new Spell(getCell().getNeighbor(0,1),0,1);
                getCell().addSpell(spell);
            };
            view++;
        }

    }

    private void seeUp(){
        int view = 1;

        while(getCell().getNeighbor(0,- view).getType().equals(floorType)){
            if(checkPlayer(0, -view)){
                Spell spell = new Spell(getCell().getNeighbor(0, -1),0,-1);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private void seeRight(){
        int view = 1;

        while(getCell().getNeighbor(view,0).getType().equals(floorType)){
            if(checkPlayer(view,0)){
                Spell spell = new Spell(getCell().getNeighbor(1,0),1,0);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    private void seeLeft(){
        int view = 1;

        while(getCell().getNeighbor(- view,0).getType().equals(floorType)){
            if(checkPlayer(- view, 0)){
                Spell spell = new Spell(getCell().getNeighbor(-1, 0),-1,0);
                getCell().addSpell(spell);
            };
            view++;
        }
    }

    protected boolean checkPlayer(int x, int y){
        if(getCell().getNeighbor(x,y).getActor() != null &&
                getCell().getNeighbor(x,y).getActor().getTileName().equals("player")&&
                    (y>1 || y<-1 || x>1 || x< -1)){
            return true;
        };
        return false;
    }

    @Override
    public void moveEnemy() {

        moveFieldChecker(position, floorType);
        makeMove(position);
        attackView();

    }

    @Override
    protected void moveFieldChecker(int position, CellType floorType) {
        if(!getCell().getNeighbor(0, position - 1).getType().equals(floorType) &&
                getCell().getNeighbor(position - 1, 0).getType().equals(floorType)){
            moveUp = false;
            moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(floorType) &&
                getCell().getNeighbor(0, position + 1).getType().equals(floorType)){
            moveLeft = false;
            moveDown = true;
        }else if (!getCell().getNeighbor(0, position + 1).getType().equals(floorType) &&
                getCell().getNeighbor(position + 1, 0).getType().equals(floorType)){
            moveDown = false;
            moveRight = true;
        }else if(!getCell().getNeighbor(position + 1, 0).getType().equals(floorType) &&
                getCell().getNeighbor(0, position - 1).getType().equals(floorType)){
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
