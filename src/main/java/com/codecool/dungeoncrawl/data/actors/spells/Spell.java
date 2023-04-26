package com.codecool.dungeoncrawl.data.actors.spells;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Spell extends Enemy {

    private int xCoordinate = 0;
    private int yCoordinate = 0;

    private boolean exist;

    private boolean moveRight;
    private boolean moveLeft;
    private boolean moveDown;

    private boolean moveUp;

    private int damage = 1;

    public Spell(Cell cell, int x, int y) {
        super(cell);

        if(x > 0){
            this.moveRight = true;
            this.exist = true;
        }else if(x < 0){
            this.moveLeft = true;
            this.exist = true;
        }else if(y > 0){
            this.moveDown = true;
            this.exist = true;
        }else if(y < 0){
            this.moveUp = true;
            this.exist = true;
        }
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    private void dealPlayerDamage(int position){
        if(moveRight &&
                getCell().getNeighbor(position + 1, 0).getActor() != null &&
                getCell().getNeighbor(position + 1, 0).getActor().getTileName().equals("player") ){
            getCell().getNeighbor(position + 1, 0).getActor().setHealth(
                    getCell().getNeighbor(position + 1, 0).getActor().getHealth() - damage);
            this.exist = false;
        }else if((moveDown &&
                getCell().getNeighbor(0, position + 1).getActor() != null &&
                getCell().getNeighbor(0, position + 1).getActor().getTileName().equals("player") )){
            getCell().getNeighbor(0, position + 1).getActor().setHealth(
                    getCell().getNeighbor(0, position + 1).getActor().getHealth() - damage);
            this.exist = false;
        }else if(moveUp &&
                getCell().getNeighbor(0, position - 1).getActor() != null &&
                getCell().getNeighbor(0, position - 1).getActor().getTileName().equals("player")){
            getCell().getNeighbor(0, position - 1).getActor().setHealth(
                    getCell().getNeighbor(0, position - 1).getActor().getHealth() - damage);
            this.exist = false;
        }
    }

    @Override
    public void moveEnemy() {
        moveFieldChecker(0);
        makeMove(0);

    }

    @Override
    protected void moveFieldChecker(int position) {
        if (moveRight &&
                getCell().getNeighbor(position + 1, 0).getType().equals(CellType.WALL)){
            this.exist = false;
        }else if(moveDown &&
                getCell().getNeighbor(0, position + 1).getType().equals(CellType.WALL)){
            this.exist = false;
        }else if(moveUp &&
                getCell().getNeighbor(0, position - 1).getType().equals(CellType.WALL)){
            this.exist = false;
        }else if(moveLeft &&
                getCell().getNeighbor(position - 1, 0).getType().equals(CellType.WALL)){
            this.exist = false;
        }

        dealPlayerDamage(position);
    }

    @Override
    protected void makeMove(int position) {
        if (moveRight){
            position++;
            move(position,0);
        }else if(moveDown){
            position++;
            move(0,position);
        }else if(moveUp){
            position--;
            move(0,position);
        }else if(moveLeft){
            position--;
            move(position, 0);
        }
    }

    @Override
    public String getTileName() {

        if(exist){
            return "spell";
        }

        return "floor";
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
    protected String typeOfActor() {
        return "spell";
    }
}
