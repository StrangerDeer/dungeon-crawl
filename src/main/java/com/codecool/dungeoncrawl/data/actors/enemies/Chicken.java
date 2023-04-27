package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;

public class Chicken extends Wizard {

    private int health = 200;

    private int attack = 3;
    private boolean moveUp = true;
    private boolean moveLeft;
    private boolean moveDown;
    private boolean moveRight;


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
    public void moveEnemy() {
        moveFieldChecker(0);
        makeMove(0);
    }

    @Override
    protected void moveFieldChecker(int position) {

        if(!getCell().getNeighbor(0, position - 1).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(position - 1, 0).getType().equals(CellType.GRASS)){
            System.out.println("left");
            moveUp = false;
            moveLeft = true;
        }else if (!getCell().getNeighbor(position - 1, 0).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(0, position + 1).getType().equals(CellType.GRASS)){
            System.out.println("down");
            moveLeft = false;
            moveDown = true;
        }else if (!getCell().getNeighbor(0, position + 1).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(position + 1, 0).getType().equals(CellType.GRASS)){
            System.out.println("right");
            moveDown = false;
            moveRight = true;
        }else if(!getCell().getNeighbor(position + 1, 0).getType().equals(CellType.GRASS) &&
                getCell().getNeighbor(0, position - 1).getType().equals(CellType.GRASS)){
            System.out.println("up");
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

    @Override
    public String getTileName() {

        if (health <= 0) {
            return "grass";
        }

        return "chicken";
    }
}
