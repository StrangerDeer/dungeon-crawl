package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Cheese extends Item{

    public Cheese(Cell cell) {
        super(cell);
    }

    @Override
    public void addEffectToPlayer(Actor actor) {
        actor.addHealthPoints(10);
    }

    @Override
    public String getTileName() {
        return "Cheesy cheese";
    }
}
