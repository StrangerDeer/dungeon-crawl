package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.GameMap;

public class SkeletonMove implements EnemiesMoves {
    @Override
    public void perform(GameMap map, int moveDirection) {
        map.getSkeleton().move(moveDirection,0);
    }
}
