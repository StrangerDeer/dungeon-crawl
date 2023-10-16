package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;


public abstract class Enemy extends Actor {

    protected String name;
    protected int health;
    protected int attack;
    protected CellType floorType;
    protected boolean moveUp;
    protected boolean moveLeft;
    protected boolean moveDown;
    protected boolean moveRight;

    private int position = 0;
    public Enemy(Cell cell, String name, int health, int attack, CellType floorType) {

        super(cell);
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.floorType = floorType;
    }
    public void moveEnemy(){
        moveFieldChecker(0, floorType);
        makeMove(0);
        attackView();
    };
    protected abstract void moveFieldChecker(int position, CellType floorType);
    protected void makeMove(int position){
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
    };

    protected void castSpell(int x, int y){};

    protected void attackView(){

        if(seeDown(floorType)){
            castSpell(0,1);
        }else if (seeUp(floorType)){
            castSpell(0, -1);
        } else if(seeRight(floorType)){
            castSpell(1,0);
        }else if(seeLeft(floorType)){
            castSpell(-1,0);
        };

    }

    protected boolean seeDown(CellType floorType){
        int view = 1;

        while(cell.getNeighbor(0,view).getType().equals(floorType)){
            if(isPlayerInSight(0,view)){
                return true;
            };
            view++;
        }

        return false;
    }

    protected boolean seeUp(CellType floorType){

        int view = 1;

        while(cell.getNeighbor(0,- view).getType().equals(floorType)){
            if(isPlayerInSight(0, -view)){
                return true;
            };
            view++;
        }

        return false;
    }

    protected boolean seeRight(CellType floorType){

        int view = 1;

        while(cell.getNeighbor(view,0).getType().equals(floorType)){
            if(isPlayerInSight(view,0)){
                return true;
            };
            view++;
        }

        return false;
    }

    protected boolean seeLeft(CellType floorType){
        int view = 1;
        while(cell.getNeighbor(- view,0).getType().equals(floorType)){
            if(isPlayerInSight(- view, 0)){
                return true;
            };
            view++;
        }

        return false;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int number) {
        this.health = number;
    }

    @Override
    public void addHealthPoints(int number) {

    }

    @Override
    public int getAttackStrength() {
        return attack;
    }

    @Override
    public void addAttackStrength(int number) {

    }

    @Override
    public String getTileName() {

        if(health <= 0){
            return "floor";
        }

        return name;
    }

    protected String typeOfActor() {
        return "enemy";
    }
}
