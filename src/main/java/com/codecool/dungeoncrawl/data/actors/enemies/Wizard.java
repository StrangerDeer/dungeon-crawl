package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Wizard extends Actor {
    public Wizard(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "wizard";
    }
}
