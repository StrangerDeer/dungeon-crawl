package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Apple extends Item{

    public Apple(Cell cell) {
        super(cell);
    }

    @Override
    public void addEffectToPlayer(Actor actor) {
        actor.addHealthPoints(5);
    }

    @Override
    public String getTileName() {
        return "Red apple";
    }
}

