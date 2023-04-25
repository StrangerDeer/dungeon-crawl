package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.actors.Actor;

public class Sword extends Item {

    public Sword(Cell cell) {
        super(cell);
    }

    @Override
    public void addEffectToPlayer(Actor actor) {
        actor.addAttackStrength(3);
    }

    @Override
    public String getTileName() {
        return "Longsword";
    }
}
