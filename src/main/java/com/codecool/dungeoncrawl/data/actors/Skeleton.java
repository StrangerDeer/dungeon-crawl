package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Skeleton extends Actor {
    public Skeleton(Cell cell) {
        super(cell);
    }

    @Override
    public int getHealth() {
        //...
        return 0;
    }

    @Override
    public void setHealth(int number) {
        //...
    }

    @Override
    public void addHealthPoints(int number) {

    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
