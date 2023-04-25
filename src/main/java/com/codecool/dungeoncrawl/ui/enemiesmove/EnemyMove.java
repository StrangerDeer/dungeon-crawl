package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;

public interface EnemyMove {

    void perform(GameMap map, int position, Enemy enemy);
}
