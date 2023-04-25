package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class SkeletonMove implements EnemiesMoves {
    private boolean moveRight = true;
    private boolean moveLeft = false;
    @Override
    public void perform(GameMap map, int step) {

        if(!map.getSkeleton().getCell().getNeighbor(step + 1, 0).getType().equals(CellType.FLOOR)){
            this.moveRight = false;
            this.moveLeft = true;
        }else if (!map.getSkeleton().getCell().getNeighbor(step - 1, 0).getType().equals(CellType.FLOOR)){
            this.moveRight = true;
            this.moveLeft = false;
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
