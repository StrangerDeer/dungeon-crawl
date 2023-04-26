package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;
import com.codecool.dungeoncrawl.data.items.Item;

import java.util.List;
import java.util.Spliterator;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerAttackStrength() {
        return Integer.toString(map.getPlayer().getAttackStrength());
    }
    public List<Item> getPlayerItems() {
        return map.getPlayer().getItemsFromInventory();
    }


    public GameMap getMap() {
        return map;
    }
}
