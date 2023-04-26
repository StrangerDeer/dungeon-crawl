package com.codecool.dungeoncrawl.data.actors.spells;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Spell extends Enemy {

    private int xCoordinate = 0;
    private int yCoordinate = 0;

    public Spell(Cell cell, int x, int y) {
        super(cell);
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    @Override
    public void moveEnemy() {
        makeMove(0);

    }

    @Override
    protected void moveFieldChecker(int position) {

    }

    @Override
    protected void makeMove(int position) {
        if (xCoordinate > 0){
            position++;
            move(position,0);
        }else if(yCoordinate != 0){
            position++;
            move(0,position);
        }
    }

    @Override
    public String getTileName() {
        return "spell";
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
