package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;


public abstract class Enemy extends Actor {
    public Enemy(Cell cell) {
        super(cell);
    }

    public abstract void moveEnemy(GameMap map, int position);

}
