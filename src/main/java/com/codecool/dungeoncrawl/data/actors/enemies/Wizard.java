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

    protected final CellType floorType;

    public Wizard(Cell cell) {
        super(cell, ENEMY_NAME, ENEMY_HEALTH, ENEMY_ATTACK);
        this.floorType = CellType.FLOOR;
    }
    protected Wizard(Cell cell, String name, int health, int attack, CellType floorType){
        super(cell, name, health, attack);
        this.floorType = floorType;
    }

    protected void castSpell(int x, int y){
        Spell spell = new Spell(cell.getNeighbor(x,y),x,y);
        cell.addSpell(spell);
    }

    protected void attackView(){

        seeDown();
        seeUp();
        seeRight();
        seeLeft();

    }

    protected void seeDown(){
        int view = 1;

        while(cell.getNeighbor(0,view).getType().equals(floorType)){
            if(isPlayerInSight(0,view)){
                castSpell(0,1);
            };
            view++;
        }

    }

    protected void seeUp(){
        int view = 1;

        while(cell.getNeighbor(0,- view).getType().equals(floorType)){
            if(isPlayerInSight(0, -view)){
                castSpell(0,-1);
            };
            view++;
        }
    }

    protected void seeRight(){
        int view = 1;

        while(cell.getNeighbor(view,0).getType().equals(floorType)){
            if(isPlayerInSight(view,0)){
                castSpell(1,0);
            };
            view++;
        }
    }

    protected void seeLeft(){
        int view = 1;

        while(cell.getNeighbor(- view,0).getType().equals(floorType)){
            if(isPlayerInSight(- view, 0)){
                castSpell(-1,0);
            };
            view++;
        }
    }

   /* protected boolean checkPlayer(int x, int y){

    }*/

    @Override
    public void moveEnemy() {

        moveFieldChecker(position, floorType);
        makeMove(position);
        attackView();

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
