package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Apple extends Item{

    public Apple(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "Red apple";
    }
}

