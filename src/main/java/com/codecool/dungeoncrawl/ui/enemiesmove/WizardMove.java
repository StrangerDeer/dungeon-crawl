package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.logic.MapLoader;

public class WizardMove implements EnemiesMoves{
    private boolean moveUp = true;
    private boolean moveLeft;
    private boolean moveDown;
    private boolean moveRight;
    @Override
    public void perform(GameMap map, int position) {

        if(!map.getWizard().getCell().getNeighbor(0, position - 1).getType().equals(CellType.FLOOR) &&
                map.getWizard().getCell().getNeighbor(position - 1, 0).getType().equals(CellType.FLOOR)){
            moveUp = false;
            moveLeft = true;
        }else if (!map.getWizard().getCell().getNeighbor(position - 1, 0).getType().equals(CellType.FLOOR) &&
                map.getWizard().getCell().getNeighbor(0, position + 1).getType().equals(CellType.FLOOR)){
            moveLeft = false;
            moveDown = true;
        }else if (!map.getWizard().getCell().getNeighbor(0, position + 1).getType().equals(CellType.FLOOR) &&
                    map.getWizard().getCell().getNeighbor(position + 1, 0).getType().equals(CellType.FLOOR)){
            moveDown = false;
            moveRight = true;
        }else if(!map.getWizard().getCell().getNeighbor(position + 1, 0).getType().equals(CellType.FLOOR) &&
                map.getWizard().getCell().getNeighbor(0, position - 1).getType().equals(CellType.FLOOR)){
            moveRight = false;
            moveUp = true;
        }

        if(moveRight){
            position++;
            map.getWizard().move(position,0);
        }else if (moveLeft){
            position--;
            map.getWizard().move(position, 0);
        }else if(moveUp){
            position--;
            map.getWizard().move(0, position);
        } else if (moveDown) {
            position++;
            map.getWizard().move(0, position);
        }
    }
}
