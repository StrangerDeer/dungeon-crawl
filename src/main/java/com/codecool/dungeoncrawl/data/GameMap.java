package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.enemies.Giant;
import com.codecool.dungeoncrawl.data.actors.enemies.Skeleton;
import com.codecool.dungeoncrawl.data.actors.enemies.Wizard;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    private Skeleton skeleton;

    private Giant giant;

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

    public void setGiant(Giant giant) {
        this.giant = giant;
    }
    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
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
