package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Uzi extends Item {

    public Uzi(Cell cell) {
        super(cell);
    }

    @Override
    public void addEffectToPlayer(Actor actor) {
        actor.addAttackStrength(10);
    }

    @Override
    public String getTileName() {
        return "Uzi";
    }
}