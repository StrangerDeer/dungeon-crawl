package com.codecool.dungeoncrawl.ui.enemiesmove;

import com.codecool.dungeoncrawl.data.GameMap;

public class SkeletonMove implements EnemiesMoves {
    @Override
    public void perform(GameMap map, int step) {

        if(step <= 5){
            step++;
            map.getSkeleton().move(step,0);
        }else{
            step--;
            map.getSkeleton().move(step, 0);
        }
    }
}
