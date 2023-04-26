package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;
import com.codecool.dungeoncrawl.data.actors.enemies.Giant;
import com.codecool.dungeoncrawl.data.actors.enemies.Skeleton;
import com.codecool.dungeoncrawl.data.actors.enemies.Wizard;
import com.codecool.dungeoncrawl.data.actors.spells.Spell;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private final List<Enemy> enemies = new ArrayList<>();

    private List<Spell> spells = new ArrayList<>();

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }


    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }

    public List<Enemy> getEnemies(){
        return enemies;
    }

    public void addSpell(Spell spell){
        spells.add(spell);
    };

    public List<Spell> getSpells(){
        return spells;
    }
    public void removeSpell(Spell spell){
        spells.remove(spell);
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
