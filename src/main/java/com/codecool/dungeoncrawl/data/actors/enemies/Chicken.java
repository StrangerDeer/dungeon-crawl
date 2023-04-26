package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Chicken extends Enemy {

    private int health = 200;

    private int attack = 3;
    private boolean moveUp = true;
    private boolean moveDown;


    public Chicken(Cell cell) {
        super(cell);
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
    public void moveEnemy(int position) {
        moveFieldChecker(position);
        makeMove(position);
    }

    @Override
    protected void moveFieldChecker(int position) {

        if (!getCell().getNeighbor(0, position + 1).getType().equals(CellType.GRASS)) {
            this.moveUp = false;
            this.moveDown = true;
        } else if (!getCell().getNeighbor(0, position - 1).getType().equals(CellType.GRASS)) {
            this.moveUp = true;
            this.moveDown = false;
        }
    }

    @Override
    protected void makeMove(int position) {
        if (moveUp) {
            position++;
            move(0, position);
        } else if (moveDown) {
            position--;
            move(0, position);
        }
    }

    @Override
    public String getTileName() {

        if (health <= 0) {
            return "grass";
        }

        return "chicken";
    }
}
