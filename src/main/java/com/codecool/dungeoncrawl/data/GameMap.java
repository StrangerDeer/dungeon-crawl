package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.enemies.Ghost;
import com.codecool.dungeoncrawl.data.actors.enemies.Skeleton;
import com.codecool.dungeoncrawl.data.actors.enemies.Wizard;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Skeleton skeleton;

    private Ghost ghost;
    private Wizard wizard;

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
    public void setSkeleton(Skeleton skeleton){this.skeleton = skeleton;}

    public void setGhost(Ghost ghost) {
        this.ghost = ghost;
    }

    public Player getPlayer() {
        return player;
    }
    public Skeleton getSkeleton(){return skeleton;}

    public Ghost getGhost() {
        return ghost;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
