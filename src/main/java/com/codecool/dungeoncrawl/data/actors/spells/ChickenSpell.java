package com.codecool.dungeoncrawl.data.actors.spells;

import com.codecool.dungeoncrawl.data.Cell;

public class ChickenSpell extends Spell{
    public ChickenSpell(Cell cell, int x, int y) {
        super(cell, x, y);
    }

    @Override
    public String getTileName() {

        return "chicken_spell";
    }
}
