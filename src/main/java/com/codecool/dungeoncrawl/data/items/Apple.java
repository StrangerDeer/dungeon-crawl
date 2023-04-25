package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

public class Apple extends Item{

    public Apple(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "Red apple";
    }
}

