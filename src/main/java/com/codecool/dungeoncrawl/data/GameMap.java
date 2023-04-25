package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.enemies.Enemy;
import com.codecool.dungeoncrawl.data.actors.enemies.Giant;
import com.codecool.dungeoncrawl.data.actors.enemies.Skeleton;
import com.codecool.dungeoncrawl.data.actors.enemies.Wizard;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Skeleton skeleton;

    private Giant giant;

    private Wizard wizard;

    private final List<Enemy> enemies = new ArrayList<>();

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

    public Wizard getWizard() {
        return wizard;
    }

    public Player getPlayer() {
        return player;
    }
    public Skeleton getSkeleton(){return skeleton;}

    public Giant getGiant() {
        return giant;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
