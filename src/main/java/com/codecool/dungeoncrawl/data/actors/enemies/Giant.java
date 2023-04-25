package com.codecool.dungeoncrawl.data.actors.enemies;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.ui.enemiesmove.GiantMove;

public class Giant extends Enemy {
    private boolean moveUp = true;
    private boolean moveDown;


    public Giant(Cell cell) {
        super(cell);
    }

    @Override
    public void moveEnemy(GameMap map, int position) {
        if(!getCell().getNeighbor(0, position + 1).getType().equals(CellType.FLOOR)){
            this.moveUp = false;
            this.moveDown = true;
        }else if (!getCell().getNeighbor(0, position - 1).getType().equals(CellType.FLOOR)){
            this.moveUp = true;
            this.moveDown = false;
        }

        if(moveUp){
            position++;
            move(0,position);
        }else if (moveDown){
            position--;
            move(0, position);
        }
    }

    @Override
    public String getTileName() {
        return "giant";
    }
}
