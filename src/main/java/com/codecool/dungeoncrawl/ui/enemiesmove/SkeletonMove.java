package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class SkeletonMove implements EnemiesMoves {
    @Override
    public void perform(GameMap map, int step) {
        boolean moveRight = true;
        boolean moveLeft = false;

        if(!map.getSkeleton().getCell().getNeighbor(step + 1, 0).getType().equals(CellType.FLOOR)){
            moveRight = false;
            moveLeft = true;
        }

        if(moveRight){
            step++;
            map.getSkeleton().move(step,0);
        }else if (moveLeft){
            step--;
            map.getSkeleton().move(step, 0);
        }
    }
}
