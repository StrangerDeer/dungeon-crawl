package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;

public class GiantMove implements  EnemiesMoves{

    private boolean moveUp = true;
    private boolean moveDown;
    @Override
    public void perform(GameMap map, int position) {
        if(!map.getGiant().getCell().getNeighbor(0, position + 1).getType().equals(CellType.FLOOR)){
            this.moveUp = false;
            this.moveDown = true;
        }else if (!map.getGiant().getCell().getNeighbor(0, position - 1).getType().equals(CellType.FLOOR)){
            this.moveUp = true;
            this.moveDown = false;
        }

        if(moveUp){
            position++;
            map.getGiant().move(0,position);
        }else if (moveDown){
            position--;
            map.getGiant().move(0, position);
        }
    }
}
