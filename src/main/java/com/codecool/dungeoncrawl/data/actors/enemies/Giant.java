package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Giant extends Actor {
    public Giant(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "giant";
    }
}
